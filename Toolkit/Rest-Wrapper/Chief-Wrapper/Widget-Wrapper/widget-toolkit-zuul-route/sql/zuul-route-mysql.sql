
SET GLOBAL INNODB_LARGE_PREFIX = ON;
SET GLOBAL innodb_file_format = BARRACUDA;

DROP TABLE IF EXISTS `zuul_white_list`;
CREATE TABLE `zuul_white_list`(
  `path` VARCHAR(64) NOT NULL COMMENT '白名单路径',
  `status` INT DEFAULT 1 COMMENT '白名单状态 1:新增，0：默认',
  `create_time` TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP COMMENT '更新时间',
  CONSTRAINT `PK_ZUUL_WHITE_LIST_PATH` PRIMARY KEY (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '白名单表';

DROP TABLE IF EXISTS `zuul_route_list`;
CREATE TABLE `zuul_route_list`(
  `path` VARCHAR(64) NOT NULL COMMENT '路由路径',
  `location` VARCHAR(128) NOT NULL COMMENT '路由位置',
  `name` VARCHAR(64) COMMENT '路由名称',
  `status` INT DEFAULT 1 COMMENT '路由状态 1:新增，0：默认',
  `create_time` TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP COMMENT '更新时间',
  CONSTRAINT `PK_ZUUL_ROUTE_LIST_PATH` PRIMARY KEY (`path`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '路由表';

CREATE INDEX `IDX_ZUUL_ROUTE_LIST_NAME` ON `zuul_route_list`(`name`);
