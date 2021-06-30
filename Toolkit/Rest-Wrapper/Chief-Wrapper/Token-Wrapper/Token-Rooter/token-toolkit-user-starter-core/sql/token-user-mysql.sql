
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

SET GLOBAL INNODB_LARGE_PREFIX = ON;
SET GLOBAL innodb_file_format = BARRACUDA;

DROP TABLE IF EXISTS `token_user_list`;
CREATE TABLE `token_user_list`(
  `id` LONG NOT NULL COMMENT 'id主键',
  `account` VARCHAR(64) NOT NULL COMMENT '账号',
  `nickname` VARCHAR(32) NOT NULL COMMENT '昵称',
  `avatar` VARCHAR(512) NOT NULL COMMENT '头像',
  `role` INT DEFAULT 1 COMMENT '角色',
  `authority` INT DEFAULT 1 COMMENT '权限',
  `status` INT DEFAULT 1 COMMENT '状态',
  `level` INT DEFAULT 1 COMMENT '级别',
  `password` VARCHAR(64) NOT NULL COMMENT '密码',
  `mobile` VARCHAR(32) COMMENT '电话',
  `address` VARCHAR(128) COMMENT '地址',
  `signature` VARCHAR(256) COMMENT '签名',
  `description` VARCHAR(512) COMMENT '简介',
  `registime` TIMESTAMP COMMENT '注册时间',
  `activatime` TIMESTAMP COMMENT '激活时间',
  `create_time` TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP COMMENT '更新时间',
  CONSTRAINT `PK_TOKEN_USER_LIST_ID` PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '用户表';

CREATE INDEX `IDX_TOKEN_USER_LIST_NAME` ON `token_user_list`(`account`);

CREATE INDEX `IDX_TOKEN_USER_LIST_NICKNAME` ON `token_user_list`(`nickname`);

CREATE INDEX `IDX_TOKEN_USER_LIST_ROLE` ON `token_user_list`(`role`);

CREATE INDEX `IDX_TOKEN_USER_LIST_AUTHORITY` ON `token_user_list`(`authority`);

CREATE INDEX `IDX_TOKEN_USER_LIST_STATUS` ON `token_user_list`(`status`);

