CREATE TABLE `cms_help` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint DEFAULT NULL,
  `title` varchar(64) NOT NULL DEFAULT '' COMMENT '标题',
  `show_status` tinyint(1) DEFAULT 1 COMMENT '0不展示 1展示',
  `icon` varchar(512) DEFAULT NULL COMMENT '图标',
  `read_count` int NOT NULL DEFAULT 0 COMMENT '阅读数量',
  `content` text,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='帮助表';

