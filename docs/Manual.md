# 个人使用的技术文档

### 1 下载pig后端项目

```shell
# git clone后端项目
git clone git@github.com:ai-platform-CAD/pig-3.6.7.git

# 进入pig项目根目录
cd pig-3.6.7
```

### 2.1 Docker部署后端

```shell
# 在pig项目根目录下
mvn clean install -Dmaven.test.skip=true

# 构建镜像
docker-compose build

# 启动容器 （-d 后台启动，建议第一次不要加，方便看错误）
docker-compose up -d
```

### 3.1 创建docker container `pig-mysql`

```shell
# 在pig项目根目录下
cd ./db
docker rmi -f pig-mysql
docker build -t pig-mysql . -f ./Dockerfile
docker rm -f pig-mysql
docker run -itd --name pig-mysql --restart=always -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root pig-mysql

```

### 3.2 创建docker container `pig-redis`

```shell
docker rm -f pig-redis
docker run -itd --name pig-redis --restart=always -p 6379:6379 redis:7.0.0

```

### 运行pig后端项目通用业务

```shell
# 在pig项目根目录下
mvn clean install -Dmaven.test.skip=true

# 构建镜像
docker-compose build
# 查看构建的镜像
docker images

# pig-register
docker rm -f pig-register
docker run -itd --restart=always -p 8848:8848 --name pig-register --hostname pig-register pig-register
# pig-gateway
docker rm -f pig-gateway
docker run -itd --restart=always -p 9999:9999 --name pig-gateway --hostname pig-gateway pig-gateway
# pig-auth
docker rm -f pig-auth
docker run -itd --restart=always --name pig-auth --hostname pig-auth pig-auth
# pig-upms
docker rm -f pig-upms
docker run -itd --restart=always --name pig-upms --hostname pig-upms pig-upms
```

### 下面的平时可以不启动

```shell
# pig-monitor
docker rm -f pig-monitor
docker run -itd --restart=always -p 5001:5001 --name pig-monitor --hostname pig-monitor pig-monitor

# pig-sentinel
docker rm -f pig-sentinel
docker run -itd --restart=always -p 5003:5003 --name pig-sentinel --hostname pig-sentinel pig-sentinel

# pig-codegen
docker rm -f pig-codegen
docker run -itd --restart=always --name pig-codegen --hostname pig-codegen pig-codegen

# pig-job
docker rm -f pig-job
docker run -itd --restart=always -p 5004:5004 --name pig-job --hostname pig-job pig-job
```

### 使用命令启动基本服务

```shell
java -jar ./pig-register/target/pig-register.jar
java -jar ./pig-register/target/pig-register.jar
```

## 配置网关路由`nacos/pig-gateway-dev.yml`

```yaml
spring:
  cloud:
    gateway:
      routes:
        # operator模块
        - id: operator
          uri: lb://operator-biz
          predicates:
            - Path=/operator/**
```

## 配置SwaggerUI `nacos/application-dev.yml`

```yaml
# swagger 配置
swagger:
  enabled: true
  title: Pig Swagger API
  gateway: http://${GATEWAY_HOST:pig-gateway}:${GATEWAY-PORT:9999}
  token-url: ${swagger.gateway}/auth/oauth2/token
  scope: server
  services:
    pig-upms-biz: admin
    pig-codegen: gen
    operator-biz: operator
```

## 停止所有docker容器

```shell
# 停止所有docker容器
docker stop $(docker ps -q)

# 删除所有已停止docker容器
docker rm $(docker ps -a -q)

# 删除所有docker镜像（对应容器已停止）
docker rmi $(docker images -a -q)
```

# docker-compse
默认情况下docker-compose会建立一个默认的网络，
名称为docker-compose.yml所在目录名称小写形式加上“_default”
本项目为`pig-367_default`，模式为`bridge`

docker-compose创建的网络网段会改变，导致jdbc无法连接上mysql
解决：
1. 使用`docker network inspect pig-367_default | grep pig-mysql -A 5`查看`IPv4`地址
2. jdbc的`host`填上该地址