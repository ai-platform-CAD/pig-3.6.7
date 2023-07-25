#!/bin/bash
mysql -uroot -p$MYSQL_ROOT_PASSWORD << EOF
source $WORK_PATH/pig.sql
source $WORK_PATH/pig_config.sql
source $WORK_PATH/pig_codegen.sql
source $WORK_PATH/pig_job.sql

source $WORK_PATH/operator/init.sql
source $WORK_PATH/operator/operator.sql
source $WORK_PATH/operator/training.sql