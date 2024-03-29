USE `pig`;

# 镜像管理
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (21100, 20000, '/operator/image/index', '', 'icon-wenjianjiawenjianguanli', 21100,
        '0', '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '镜像管理模块');

insert into `sys_menu`(`parent_id`, `menu_id`, `permission`, `type`, `path`,
                       `icon`, `del_flag`, `create_time`, `sort_order`, `update_time`, `name`)
values (21100, 21101, 'image_manage_get', '1', null,
        '1', '0', '2023-03-01 10:00:00', 0, '2023-03-01 10:00:00', '镜像表查看'),
       (21100, 21102, 'image_manage_add', '1', null,
        '1', '0', '2023-03-01 10:00:00', 1, '2023-03-01 10:00:00', '镜像表新增'),
       (21100, 21103, 'image_manage_edit', '1', null,
        '1', '0', '2023-03-01 10:00:00', 2, '2023-03-01 10:00:00', '镜像表修改'),
       (21100, 21104, 'image_manage_del', '1', null,
        '1', '0', '2023-03-01 10:00:00', 3, '2023-03-01 10:00:00', '镜像表删除');

# 训练管理
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (21300, 20000, '/operator/training/index', '', 'icon-shuaxin1', 21300,
        '0', '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '训练管理模块');

insert into `sys_menu`(`parent_id`, `menu_id`, `permission`, `type`, `path`,
                       `icon`, `del_flag`, `create_time`, `sort_order`, `update_time`, `name`)
values (21300, 21301, 'training_manage_get', '1', null,
        '1', '0', '2023-03-01 10:00:00', 0, '2023-03-01 10:00:00', '训练表查看'),
       (21300, 21302, 'training_manage_add', '1', null,
        '1', '0', '2023-03-01 10:00:00', 1, '2023-03-01 10:00:00', '训练表新增'),
       (21300, 21303, 'training_manage_edit', '1', null,
        '1', '0', '2023-03-01 10:00:00', 2, '2023-03-01 10:00:00', '训练表修改'),
       (21300, 21304, 'training_manage_del', '1', null,
        '1', '0', '2023-03-01 10:00:00', 3, '2023-03-01 10:00:00', '训练表删除');

# 项目管理
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (21500, 20000, '/operator/project/index', '', 'icon-shuaxin1', 21500,
        '0', '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '项目管理模块');

insert into `sys_menu`(`parent_id`, `menu_id`, `permission`, `type`, `path`,
                       `icon`, `del_flag`, `create_time`, `sort_order`, `update_time`, `name`)
values (21500, 21501, 'project_manage_get', '1', null,
        '1', '0', '2023-03-01 10:00:00', 0, '2023-03-01 10:00:00', '项目表查看'),
       (21500, 21502, 'project_manage_add', '1', null,
        '1', '0', '2023-03-01 10:00:00', 1, '2023-03-01 10:00:00', '项目表新增'),
       (21500, 21503, 'project_manage_edit', '1', null,
        '1', '0', '2023-03-01 10:00:00', 2, '2023-03-01 10:00:00', '项目表修改'),
       (21500, 21504, 'project_manage_del', '1', null,
        '1', '0', '2023-03-01 10:00:00', 3, '2023-03-01 10:00:00', '项目表删除');


USE `operator_orchestration`;

-- ----------------------------
-- Table structure for docker_image
-- ----------------------------
DROP TABLE IF EXISTS `docker_image`;
CREATE TABLE `docker_image`
(
    `id`             bigint                       NOT NULL,
    `image_id`       varchar(71) COLLATE utf8_bin NOT NULL COMMENT '镜像ID',
    `tag`            varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '镜像TAG',
    `size`           bigint                       DEFAULT NULL COMMENT '镜像SIZE',
    `python_version` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'Python版本',
    `cuda_version`   varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'CUDA版本',
    `framework`      varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '深度学习框架',
    `parameters`     varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '其他参数',
    `create_time`    datetime                     DEFAULT NULL COMMENT '创建时间',
    `create_by`      varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
    `update_time`    datetime                     DEFAULT NULL COMMENT '修改时间',
    `update_by`      varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`),
    KEY `docker_image_idx1_image_id` (`image_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = DYNAMIC COMMENT ='DOCKER镜像表';

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
    `user_id`            bigint                       NOT NULL COMMENT '用户ID',
    `project_id`         bigint                       NOT NULL COMMENT '训练项目ID',
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

-- ----------------------------
-- Table structure for training_project
-- ----------------------------
DROP TABLE IF EXISTS `training_project`;
CREATE TABLE `training_project`
(
    `projectId`    bigint                       NOT NULL COMMENT '项目ID',
    `project_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '项目名称',
    `project_data` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '项目数据',
    `create_time`  datetime                     DEFAULT NULL COMMENT '创建时间',
    `create_by`    varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
    `update_time`  datetime                     DEFAULT NULL COMMENT '修改时间',
    `update_by`    varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`projectId`),
    KEY `training_project_idx1_project_name` (`project_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = DYNAMIC COMMENT ='训练项目表';