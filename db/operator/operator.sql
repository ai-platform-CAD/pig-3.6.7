USE `pig`;

-- 菜单SQL
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (20000, -1, '/operator', '', 'icon-didaima', 20000, '0',
        '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '算子模块');

# 算子管理
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (20100, 20000, '/operator/manage/index', '', 'icon-caidan1', 20100,
        '0', '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '算子管理模块');

insert into `sys_menu`(`parent_id`, `menu_id`, `permission`, `type`, `path`,
                       `icon`, `del_flag`, `create_time`, `sort_order`, `update_time`, `name`)
values (20100, 20101, 'operator_manage_get', '1', null,
        '1', '0', '2023-03-01 10:00:00', 0, '2023-03-01 10:00:00', '算子表查看'),
       (20100, 20102, 'operator_manage_add', '1', null,
        '1', '0', '2023-03-01 10:00:00', 1, '2023-03-01 10:00:00', '算子表新增'),
       (20100, 20103, 'operator_manage_edit', '1', null,
        '1', '0', '2023-03-01 10:00:00', 2, '2023-03-01 10:00:00', '算子表修改'),
       (20100, 20104, 'operator_manage_del', '1', null,
        '1', '0', '2023-03-01 10:00:00', 3, '2023-03-01 10:00:00', '算子表删除');

# 算子编排
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (20200, 20000, '/operator/orchestration/index', 'icon-web-icon-', '', 20200, '0',
        '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '算子编排模块');

insert into `sys_menu`(`parent_id`, `menu_id`, `permission`, `type`, `path`,
                       `icon`, `del_flag`, `create_time`, `sort_order`, `update_time`, `name`)
values (20200, 20201, 'operator_orchestration_get', '1', null,
        '1', '0', '2023-03-01 10:00:00', 0, '2023-03-01 10:00:00', '算子编排表查看'),
       (20200, 20202, 'operator_orchestration_add', '1', null,
        '1', '0', '2023-03-01 10:00:00', 1, '2023-03-01 10:00:00', '算子编排表新增'),
       (20200, 20203, 'operator_orchestration_edit', '1', null,
        '1', '0', '2023-03-01 10:00:00', 2, '2023-03-01 10:00:00', '算子编排表修改'),
       (20200, 20204, 'operator_orchestration_del', '1', null,
        '1', '0', '2023-03-01 10:00:00', 3, '2023-03-01 10:00:00', '算子编排表删除');

# 工作流管理
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (20300, 20000, '/operator/workflow/index', '', 'icon-caidan1', 20300,
        '0', '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '工作流管理模块');

insert into `sys_menu`(`parent_id`, `menu_id`, `permission`, `type`, `path`,
                       `icon`, `del_flag`, `create_time`, `sort_order`, `update_time`, `name`)
values (20300, 20301, 'workflow_manage_get', '1', null,
        '1', '0', '2023-03-01 10:00:00', 0, '2023-03-01 10:00:00', '工作流表查看'),
       (20300, 20302, 'workflow_manage_add', '1', null,
        '1', '0', '2023-03-01 10:00:00', 1, '2023-03-01 10:00:00', '工作流表新增'),
       (20300, 20303, 'workflow_manage_edit', '1', null,
        '1', '0', '2023-03-01 10:00:00', 2, '2023-03-01 10:00:00', '工作流表修改'),
       (20300, 20304, 'workflow_manage_del', '1', null,
        '1', '0', '2023-03-01 10:00:00', 3, '2023-03-01 10:00:00', '工作流表删除');

# 训练管理
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (20400, 20000, '/operator/training/index', '', 'icon-caidan1', 20400,
        '0', '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '训练管理模块');

insert into `sys_menu`(`parent_id`, `menu_id`, `permission`, `type`, `path`,
                       `icon`, `del_flag`, `create_time`, `sort_order`, `update_time`, `name`)
values (20400, 20401, 'training_manage_get', '1', null,
        '1', '0', '2023-03-01 10:00:00', 0, '2023-03-01 10:00:00', '训练表查看'),
       (20400, 20402, 'training_manage_add', '1', null,
        '1', '0', '2023-03-01 10:00:00', 1, '2023-03-01 10:00:00', '训练表新增'),
       (20400, 20403, 'training_manage_edit', '1', null,
        '1', '0', '2023-03-01 10:00:00', 2, '2023-03-01 10:00:00', '训练表修改'),
       (20400, 20404, 'training_manage_del', '1', null,
        '1', '0', '2023-03-01 10:00:00', 3, '2023-03-01 10:00:00', '训练表删除');


# 算子编排数据库
DROP DATABASE IF EXISTS `operator_orchestration`;

CREATE DATABASE `operator_orchestration` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE `operator_orchestration`;

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator`
(
    `operator_id`   bigint                       NOT NULL,
    `operator_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '算子名称',
    `json_content`  longtext COLLATE utf8_bin    NOT NULL COMMENT 'JSON内容',
    `create_time`   datetime                     DEFAULT NULL COMMENT '创建时间',
    `create_by`     varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
    `update_time`   datetime                     DEFAULT NULL COMMENT '修改时间',
    `update_by`     varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`operator_id`),
    KEY `operator_idx1_operator_name` (`operator_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = DYNAMIC COMMENT ='算子表';

-- ----------------------------
-- Table structure for sys_user_operator
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_operator`;
CREATE TABLE `sys_user_operator`
(
    `user_id`     bigint NOT NULL,
    `operator_id` bigint NOT NULL,
    PRIMARY KEY (`user_id`, `operator_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = DYNAMIC COMMENT ='用户算子表';

SET FOREIGN_KEY_CHECKS = 1;


-- ----------------------------
-- Table structure for workflow
-- ----------------------------
DROP TABLE IF EXISTS `workflow`;
CREATE TABLE `workflow`
(
    `workflow_id`   bigint                       NOT NULL,
    `workflow_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '工作流名称',
    `data`          longtext COLLATE utf8_bin    NOT NULL COMMENT 'DATA数据',
    `user_id`       bigint                       NOT NULL,
    `create_time`   datetime                     DEFAULT NULL COMMENT '创建时间',
    `create_by`     varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
    `update_time`   datetime                     DEFAULT NULL COMMENT '修改时间',
    `update_by`     varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`workflow_id`),
    KEY `workflow_idx1_workflow_name` (`workflow_name`),
    FOREIGN KEY (user_id) REFERENCES pig.sys_user (user_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = DYNAMIC COMMENT ='工作流表';

-- ----------------------------
-- Table structure for training
-- ----------------------------
DROP TABLE IF EXISTS `training`;
CREATE TABLE `training`
(
    `training_id`        bigint                       NOT NULL,
    `training_name`      varchar(50) COLLATE utf8_bin NOT NULL COMMENT '训练名称',
    `training_container` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '训练容器',
    `training_script`    varchar(50) COLLATE utf8_bin NOT NULL COMMENT '训练脚本',
    `training_command`   varchar(50) COLLATE utf8_bin NOT NULL COMMENT '训练指令',
    `training_output`    varchar(50) COLLATE utf8_bin NOT NULL COMMENT '训练输出',
    `user_id`            bigint                       NOT NULL,
    `create_time`        datetime                     DEFAULT NULL COMMENT '创建时间',
    `create_by`          varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
    `update_time`        datetime                     DEFAULT NULL COMMENT '修改时间',
    `update_by`          varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`training_id`),
    KEY `training_idx1_training_name` (`training_name`),
    FOREIGN KEY (user_id) REFERENCES pig.sys_user (user_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = DYNAMIC COMMENT ='训练表';