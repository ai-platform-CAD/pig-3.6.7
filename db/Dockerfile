FROM mysql:8.0.31

MAINTAINER group-cadAI <cad-aiplatform@outlook.com>

#定义timezone
ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#定义工作目录
ENV WORK_PATH /usr/local/work

#定义会被容器自动执行的目录
ENV AUTO_RUN_DIR /docker-entrypoint-initdb.d

#创建文件夹
RUN mkdir -p $WORK_PATH

#把数据库初始化数据的文件复制到工作目录下
COPY ./pig.sql $WORK_PATH/
COPY ./pig_config.sql $WORK_PATH/
COPY ./pig_codegen.sql $WORK_PATH/
COPY ./pig_job.sql $WORK_PATH/
# 算子编排模块sql
COPY ./operator/operator.sql $WORK_PATH/operator/

#定义shell文件名
ENV INSTALL_DB_SHELL initdb.sh

#把要执行的shell文件放到/docker-entrypoint-initdb.d/目录下，容器会自动执行这个shell
COPY ./$INSTALL_DB_SHELL $AUTO_RUN_DIR/

#给执行文件增加可执行权限
RUN chmod a+x $AUTO_RUN_DIR/$INSTALL_DB_SHELL
