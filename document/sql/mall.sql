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


DROP TABLE IF EXISTS `ums_user`;
CREATE TABLE `ums_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `icon` varchar(256) DEFAULT NULL COMMENT '头像',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(64) NOT NULL DEFAULT '' COMMENT '昵称',
  `status` tinyint(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  `note` varchar(256) DEFAULT NULL COMMENT '备注信息',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台用户表';


DROP TABLE IF EXISTS `ums_user_login_log`;
CREATE TABLE `ums_user_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `ip` varchar(64) DEFAULT NULL  COMMENT '登录ip地址',
  `user_agent` varchar(128) DEFAULT NULL COMMENT '浏览器类型',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台用户登录日志表';

DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名称',
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `user_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台用户角色表';

INSERT INTO `ums_role` VALUES ('1', '商品管理员', '1','0', '0','只能查看及操作商品','2020-02-03 16:50:37','2020-02-03 16:50:37');
INSERT INTO `ums_role` VALUES ('2', '订单管理员', '1','0', '0','只能查看及操作订单','2020-02-03 16:50:37','2020-02-03 16:50:37');
INSERT INTO `ums_role` VALUES ('5', '超级管理员', '1','0', '0','拥有所有查看和操作功能','2020-02-03 16:50:37','2020-02-03 16:50:37');


DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='后台用户权限表';

INSERT INTO `ums_permission` VALUES ('1', '0', '商品', null, null, '0', null, '1', '0', '2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('2', '1', '商品列表', 'pms:product:read', null, '1', '/pms/product/index', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('3', '1', '添加商品', 'pms:product:create', null, '1', '/pms/product/add', '1',  '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('4', '1', '商品分类', 'pms:productCategory:read', null, '1', '/pms/productCate/index', '1','0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('5', '1', '商品类型', 'pms:productAttribute:read', null, '1', '/pms/productAttr/index', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('6', '1', '品牌管理', 'pms:brand:read', null, '1', '/pms/brand/index', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('7', '2', '编辑商品', 'pms:product:update', null, '2', '/pms/product/updateProduct', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('8', '2', '删除商品', 'pms:product:delete', null, '2', '/pms/product/delete', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('9', '4', '添加商品分类', 'pms:productCategory:create', null, '2', '/pms/productCate/create', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('10', '4', '修改商品分类', 'pms:productCategory:update', null, '2', '/pms/productCate/update', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('11', '4', '删除商品分类', 'pms:productCategory:delete', null, '2', '/pms/productAttr/delete', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('12', '5', '添加商品类型', 'pms:productAttribute:create', null, '2', '/pms/productAttr/create', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('13', '5', '修改商品类型', 'pms:productAttribute:update', null, '2', '/pms/productAttr/update', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('14', '5', '删除商品类型', 'pms:productAttribute:delete', null, '2', '/pms/productAttr/delete', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('15', '6', '添加品牌', 'pms:brand:create', null, '2', '/pms/brand/add', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('16', '6', '修改品牌', 'pms:brand:update', null, '2', '/pms/brand/update', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('17', '6', '删除品牌', 'pms:brand:delete', null, '2', '/pms/brand/delete', '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');
INSERT INTO `ums_permission` VALUES ('18', '0', '首页', null, null, '0', null, '1', '0','2018-09-29 16:15:14','2018-09-29 16:15:14');


DROP TABLE IF EXISTS `ums_user_role_relation`;
CREATE TABLE `ums_user_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台用户和角色关系表';


DROP TABLE IF EXISTS `ums_menu`;
CREATE TABLE `ums_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `title` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `level` int(4) DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(64) DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(128) DEFAULT NULL COMMENT '前端图标',
  `hidden` tinyint DEFAULT 0 COMMENT '前端隐藏 0:不隐藏 1:隐藏',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台菜单表';


INSERT INTO `ums_menu` VALUES ('1', '0', '商品', '0', '0', 'pms', 'product', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('2', '1', '商品列表', '1', '0', 'product', 'product-list', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('3', '1', '添加商品', '1', '0', 'addProduct', 'product-add', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('4', '1', '商品分类', '1', '0', 'productCate', 'product-cate', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('5', '1', '商品类型', '1', '0', 'productAttr', 'product-attr', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('6', '1', '品牌管理', '1', '0', 'brand', 'product-brand', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('7', '0', '订单', '0', '0', 'oms', 'order', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('8', '7', '订单列表', '1', '0', 'order', 'product-list', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('9', '7', '订单设置', '1', '0', 'orderSetting', 'order-setting', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('10', '7', '退货申请处理', '1', '0', 'returnApply', 'order-return', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('11', '7', '退货原因设置', '1', '0', 'returnReason', 'order-return-reason', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('12', '0', '营销', '0', '0', 'sms', 'sms', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('13', '12', '秒杀活动列表', '1', '0', 'flash', 'sms-flash', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('14', '12', '优惠券列表', '1', '0', 'coupon', 'sms-coupon', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('16', '12', '品牌推荐', '1', '0', 'homeBrand', 'product-brand', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('17', '12', '新品推荐', '1', '0', 'homeNew', 'sms-new', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('18', '12', '人气推荐', '1', '0', 'homeHot', 'sms-hot', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('19', '12', '专题推荐', '1', '0', 'homeSubject', 'sms-subject', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('20', '12', '广告列表', '1', '0', 'homeAdvertise', 'sms-ad', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('21', '0', '权限', '0', '0', 'ums', 'ums', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('22', '21', '用户列表', '1', '0', 'admin', 'ums-admin', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('23', '21', '角色列表', '1', '0', 'role', 'ums-role', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('24', '21', '菜单列表', '1', '0', 'menu', 'ums-menu', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_menu` VALUES ('25', '21', '资源列表', '1', '0', 'resource', 'ums-resource', '0','2020-02-02 14:50:36','2020-02-02 14:50:36');


DROP TABLE IF EXISTS `ums_role_menu_relation`;
CREATE TABLE `ums_role_menu_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台角色菜单关系表';

INSERT INTO `ums_role_menu_relation` VALUES ('33', '1', '1','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('34', '1', '2','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('35', '1', '3','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('36', '1', '4','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('37', '1', '5','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('38', '1', '6','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('53', '2', '7','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('54', '2', '8','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('55', '2', '9','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('56', '2', '10','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('57', '2', '11','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('72', '5', '1','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('73', '5', '2','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('74', '5', '3','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('75', '5', '4','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('76', '5', '5','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('77', '5', '6','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('78', '5', '7','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('79', '5', '8','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('80', '5', '9','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('81', '5', '10','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('82', '5', '11','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('83', '5', '12','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('84', '5', '13','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('85', '5', '14','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('86', '5', '16','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('87', '5', '17','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('88', '5', '18','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('89', '5', '19','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('90', '5', '20','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('91', '5', '21','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('92', '5', '22','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('93', '5', '23','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('94', '5', '24','2020-02-02 14:50:36','2020-02-02 14:50:36');
INSERT INTO `ums_role_menu_relation` VALUES ('95', '5', '25','2020-02-02 14:50:36','2020-02-02 14:50:36');


DROP TABLE IF EXISTS `ums_user_permission_relation`;
CREATE TABLE `ums_user_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限主键',
  `type` int(1) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';


DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `category_id` bigint(20) DEFAULT NULL COMMENT '资源分类ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台资源表';

INSERT INTO `ums_resource` VALUES ('1', '商品品牌管理', '/brand/**', null, '1', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('2', '商品属性分类管理', '/productAttribute/**', null, '1', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('3',  '商品属性管理', '/productAttribute/**', null, '1', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('4', '商品分类管理', '/productCategory/**', null, '1', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('5',  '商品管理', '/product/**', null, '1', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('6',  '商品库存管理', '/sku/**', null, '1', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('8',  '订单管理', '/order/**', '', '2', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('9',  ' 订单退货申请管理', '/returnApply/**', '', '2', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('10',  '退货原因管理', '/returnReason/**', '', '2', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('11',  '订单设置管理', '/orderSetting/**', '', '2', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('12',  '收货地址管理', '/companyAddress/**', '', '2', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('13',  '优惠券管理', '/coupon/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('14',  '优惠券领取记录管理', '/couponHistory/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('15',  '限时购活动管理', '/flash/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('16', '限时购商品关系管理', '/flashProductRelation/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('17',  '限时购场次管理', '/flashSession/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('18',  '首页轮播广告管理', '/home/advertise/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('19',  '首页品牌管理', '/home/brand/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('20', '首页新品管理', '/home/newProduct/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('21',  '首页人气推荐管理', '/home/recommendProduct/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('22',  '首页专题推荐管理', '/home/recommendSubject/**', '', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('23',  ' 商品优选管理', '/prefrenceArea/**', '', '5', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('24', '商品专题管理', '/subject/**', '', '5', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('25',  '后台用户管理', '/admin/**', '', '4', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('26',  '后台用户角色管理', '/role/**', '', '4', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('27',  '后台菜单管理', '/menu/**', '', '4', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('28',  '后台资源分类管理', '/resourceCategory/**', '', '4', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_resource` VALUES ('29',  '后台资源管理', '/resource/**', '', '4', '2020-02-04 17:04:55', '2020-02-04 17:04:55');


DROP TABLE IF EXISTS `ums_role_resource_relation`;
CREATE TABLE `ums_role_resource_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='后台角色资源关系表';


INSERT INTO `ums_role_resource_relation` VALUES ('103', '2', '8', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('104', '2', '9', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('105', '2', '10', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('106', '2', '11', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('107', '2', '12', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('142', '5', '1', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('143', '5', '2', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('144', '5', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('145', '5', '4', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('146', '5', '5', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('147', '5', '6', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('148', '5', '8', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('149', '5', '9', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('150', '5', '10', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('151', '5', '11', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('152', '5', '12', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('153', '5', '13', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('154', '5', '14', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('155', '5', '15', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('156', '5', '16', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('157', '5', '17', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('158', '5', '18', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('159', '5', '19', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('160', '5', '20', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('161', '5', '21', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('162', '5', '22', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('163', '5', '23', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('164', '5', '24', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('165', '5', '25', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('166', '5', '26', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('167', '5', '27', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('168', '5', '28', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('169', '5', '29', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('170', '1', '1', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('171', '1', '2', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('172', '1', '3', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('173', '1', '4', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('174', '1', '5', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('175', '1', '6', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('176', '1', '23', '2020-02-04 17:04:55', '2020-02-04 17:04:55');
INSERT INTO `ums_role_resource_relation` VALUES ('177', '1', '24', '2020-02-04 17:04:55', '2020-02-04 17:04:55');









