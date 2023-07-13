# 算子编排数据库
DROP DATABASE IF EXISTS `operator_orchestration`;

CREATE DATABASE `operator_orchestration` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE 'pig';

-- 菜单SQL
insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
                        `del_flag`, `create_time`, `update_time`, `name`)
values (20000, -1, '/operator', '', 'icon-didaima', 20000, '0',
        '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '算子模块');

# -- 菜单SQL
# insert into `sys_menu` (`menu_id`, `parent_id`, `path`, `permission`, `icon`, `sort_order`, `type`,
#                         `del_flag`, `create_time`, `update_time`, `name`)
# values (21000, -1, '/operator', '', 'icon-didaima', 21000,
#         '0', '0', '2023-03-01 10:00:00', '2023-03-01 10:00:00', '训练模块');