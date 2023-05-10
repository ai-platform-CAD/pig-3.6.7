# 记录新增和修改的部分，以及一些说明

1.算子编排模块-后端

新增
```text
db/initdb.sh
db/operator/

新增数据源

operator/

```

修改
```text
db/Dockerfile

```

```shell
docker run -itd --name pig-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:8.0.31
```

配置网关路由`nacos/pig-gateway-dev.yml`

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