/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3307
Source Database       : db2

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-07-07 14:32:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域主键',
  `name` varchar(45) DEFAULT NULL COMMENT '区域名称',
  `store` int(11) NOT NULL COMMENT '店铺id',
  `state` char(1) DEFAULT '1' COMMENT '状态',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '描述',
  `upper_level_id` int(11) DEFAULT NULL COMMENT '上一级id',
  `current_level` int(11) DEFAULT NULL COMMENT '当前级id',
  PRIMARY KEY (`id`),
  KEY `store_idwqwqd_idx` (`store`),
  CONSTRAINT `fk_area_store` FOREIGN KEY (`store`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '店内', '1', '1', '柜台部分', '0', '1');
INSERT INTO `area` VALUES ('2', '仓库', '1', '1', '仓库部分', '0', '1');

-- ----------------------------
-- Table structure for combination_products
-- ----------------------------
DROP TABLE IF EXISTS `combination_products`;
CREATE TABLE `combination_products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '组合商品名',
  `db_desc` text COMMENT '描述',
  `price` double DEFAULT NULL COMMENT '价格，被设定的价格',
  `privilege_price` double DEFAULT NULL COMMENT '活动价格',
  `sum_price` double DEFAULT NULL COMMENT '组合价格，多个商品原价直接相加的价格',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_combination_products_store` (`store_id`),
  CONSTRAINT `fk_combination_products_store` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组合商品表';

-- ----------------------------
-- Records of combination_products
-- ----------------------------

-- ----------------------------
-- Table structure for combination_products_record
-- ----------------------------
DROP TABLE IF EXISTS `combination_products_record`;
CREATE TABLE `combination_products_record` (
  `id` int(11) NOT NULL,
  `combination_products_id` int(11) DEFAULT NULL,
  `store_producte_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_combination_products_store_producte_to_store` (`store_producte_id`),
  KEY `fk_combination_products_store_producte_combination_products` (`combination_products_id`),
  CONSTRAINT `fk_combination_products_store_producte_combination_products` FOREIGN KEY (`combination_products_id`) REFERENCES `combination_products` (`id`),
  CONSTRAINT `fk_combination_products_store_producte_to_store` FOREIGN KEY (`store_producte_id`) REFERENCES `store_producte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组合商品表与商店产品表的中间表';

-- ----------------------------
-- Records of combination_products_record
-- ----------------------------

-- ----------------------------
-- Table structure for counter
-- ----------------------------
DROP TABLE IF EXISTS `counter`;
CREATE TABLE `counter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `db_desc` text,
  `type` int(11) DEFAULT NULL,
  `store` int(11) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL COMMENT '占用柜台的订单',
  PRIMARY KEY (`id`),
  KEY `fk_area` (`area`),
  KEY `fk_type` (`type`),
  KEY `fk_counter_store` (`store`),
  KEY `fk_counter_order` (`order_id`),
  CONSTRAINT `fk_area` FOREIGN KEY (`area`) REFERENCES `area` (`id`),
  CONSTRAINT `fk_counter_order` FOREIGN KEY (`order_id`) REFERENCES `db_order` (`id`),
  CONSTRAINT `fk_counter_store` FOREIGN KEY (`store`) REFERENCES `store` (`id`),
  CONSTRAINT `fk_type` FOREIGN KEY (`type`) REFERENCES `counter_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='柜台与订单是多对一';

-- ----------------------------
-- Records of counter
-- ----------------------------

-- ----------------------------
-- Table structure for counter_type
-- ----------------------------
DROP TABLE IF EXISTS `counter_type`;
CREATE TABLE `counter_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '柜台类型id',
  `name` varchar(45) DEFAULT NULL COMMENT '柜台类别名称',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '柜台类别描述',
  `state` char(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of counter_type
-- ----------------------------
INSERT INTO `counter_type` VALUES ('1', '珠宝首饰', '金大福', '1');
INSERT INTO `counter_type` VALUES ('2', '化妆品', '香奈儿', '1');
INSERT INTO `counter_type` VALUES ('3', '无类型', '默认，或者特定柜台类型被删除后', '1');

-- ----------------------------
-- Table structure for counter_work_station_record
-- ----------------------------
DROP TABLE IF EXISTS `counter_work_station_record`;
CREATE TABLE `counter_work_station_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `counter_id` int(11) DEFAULT NULL,
  `work_station_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_record_counter` (`counter_id`),
  KEY `fk_record_work_station` (`work_station_id`),
  CONSTRAINT `fk_record_counter` FOREIGN KEY (`counter_id`) REFERENCES `counter` (`id`),
  CONSTRAINT `fk_record_work_station` FOREIGN KEY (`work_station_id`) REFERENCES `work_station` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中间表，用于描述，岗位与柜台多对多的关系';

-- ----------------------------
-- Records of counter_work_station_record
-- ----------------------------

-- ----------------------------
-- Table structure for db_order
-- ----------------------------
DROP TABLE IF EXISTS `db_order`;
CREATE TABLE `db_order` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL COMMENT '编号',
  `type_id` int(11) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `checkout_time` datetime DEFAULT NULL COMMENT '买单时间',
  `receivables` double DEFAULT NULL COMMENT '应收账款',
  `paidin_account` double DEFAULT NULL COMMENT '实收账款',
  `reminder_number` int(11) DEFAULT NULL COMMENT '催单次数',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人，下单人id',
  `vip_id` int(11) DEFAULT NULL COMMENT '会员id',
  `one_bill_for_all_id` int(11) DEFAULT NULL COMMENT '合单',
  `store_number` varchar(255) DEFAULT NULL,
  `time_manage_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL COMMENT '序号',
  `start_counter_time` datetime DEFAULT NULL COMMENT '开台时间',
  `stop_counter_time` datetime DEFAULT NULL COMMENT '撤台时间',
  `one_for_all_time` datetime DEFAULT NULL COMMENT '合单时间',
  `merge_counter_time` datetime DEFAULT NULL COMMENT '合台时间',
  `merge_counter_sign` varchar(255) DEFAULT '0' COMMENT '合台标识，0为无，1为有',
  `merge_counter_id` int(11) DEFAULT NULL COMMENT '合台的id，最终柜台',
  `state` varchar(255) DEFAULT NULL COMMENT '订单状态：1.未确认订单2.确认订单3.确认后变化订单4.正在准备订单5.准备完成订单6.取消订单7.已结算未准备完成订单8.已结算且准备完成',
  `sequence` varchar(255) DEFAULT NULL COMMENT '排序号，预选订单使用',
  PRIMARY KEY (`id`,`number`),
  KEY `fk_order_time_manage` (`time_manage_id`),
  KEY `fk_order_time_order_type` (`type_id`),
  KEY `id` (`id`),
  KEY `fk_order_vip` (`vip_id`),
  CONSTRAINT `fk_order_time_manage` FOREIGN KEY (`time_manage_id`) REFERENCES `time_manage` (`id`),
  CONSTRAINT `fk_order_time_order_type` FOREIGN KEY (`type_id`) REFERENCES `order_type` (`id`),
  CONSTRAINT `fk_order_vip` FOREIGN KEY (`vip_id`) REFERENCES `vip` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_order
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL,
  `db_desc` text,
  `store_id` int(11) DEFAULT NULL,
  `department_grade` varchar(255) DEFAULT NULL COMMENT '部门等级',
  PRIMARY KEY (`id`),
  KEY `fk_department_store` (`store_id`),
  CONSTRAINT `fk_department_store` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='部门表，描述一个店面分为几部分';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '1', '店内', '门店范围', '1', '1');

-- ----------------------------
-- Table structure for duty
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职务',
  `name` varchar(45) DEFAULT NULL COMMENT '职务名称',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '职务描述',
  `grade_id` int(11) NOT NULL COMMENT '等级id',
  `store_id` int(11) NOT NULL COMMENT '店铺id',
  `state` char(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `grade_idsasa_idx` (`grade_id`),
  KEY `store_idddssds_idx` (`store_id`),
  CONSTRAINT `store_idddssds` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duty
-- ----------------------------
INSERT INTO `duty` VALUES ('2', 'ceo', '管理层', '1', '1', '1');
INSERT INTO `duty` VALUES ('3', '项目经理', '管理项目', '1', '1', '1');

-- ----------------------------
-- Table structure for duty_record
-- ----------------------------
DROP TABLE IF EXISTS `duty_record`;
CREATE TABLE `duty_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职务',
  `name` varchar(45) DEFAULT NULL COMMENT '职务名称',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '职务描述',
  `grade_id` int(11) NOT NULL COMMENT '等级id',
  `state` char(1) DEFAULT '1' COMMENT '状态',
  `official_userInformation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `grade_idsasa_idx` (`grade_id`) USING BTREE,
  KEY `fk_duty_record_user_information` (`official_userInformation`),
  CONSTRAINT `fk_duty_record_user_information` FOREIGN KEY (`official_userInformation`) REFERENCES `official_user_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='官方用户信息，职务履历表';

-- ----------------------------
-- Records of duty_record
-- ----------------------------
INSERT INTO `duty_record` VALUES ('2', 'ceo', '管理层', '1', '1', null);
INSERT INTO `duty_record` VALUES ('3', '项目经理', '管理项目', '1', '1', null);

-- ----------------------------
-- Table structure for function
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '功能表',
  `function_name` varchar(45) DEFAULT NULL COMMENT '功能名称',
  `upper_level_id` int(11) DEFAULT '0' COMMENT '上一级id',
  `current_level` int(11) DEFAULT '1' COMMENT '当前层',
  `icon` varchar(255) DEFAULT NULL COMMENT '功能图标',
  `group_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL COMMENT '用于描述功能显示顺序',
  `urls` varchar(255) DEFAULT NULL COMMENT '如果为0是特殊权限',
  PRIMARY KEY (`id`),
  KEY `fk_function_groups` (`group_id`),
  CONSTRAINT `fk_function_groups` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='要求：一级要按照顺序，依次递减\r\n二级节点的Order_id的排序在每个父节点下独立存在，例如：1下有2个子节点，则两个子节点的order_id分别是1，2，在有一个节点2下有一个子节点，则子节点的order_id为1';

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('1', '人事管理', '0', '1', 'am-icon-user', null, '7', '#/personnel');
INSERT INTO `function` VALUES ('2', '岗位管理', '0', '1', 'am-icon-suitcase', null, '5', '#/workstation');
INSERT INTO `function` VALUES ('3', '店面管理', '0', '1', 'am-icon-briefcase', null, '1', '#');
INSERT INTO `function` VALUES ('4', '店铺柜台管理', '3', '2', 'am-icon-archive', null, '2', '#/counter');
INSERT INTO `function` VALUES ('5', '店铺区域管理', '3', '2', 'am-icon-map', null, '3', '#/area');
INSERT INTO `function` VALUES ('6', '部门管理', '0', '1', 'am-icon-university', null, '4', '#/department');
INSERT INTO `function` VALUES ('7', '职务管理', '0', '1', 'am-icon-black-tie', null, '6', '#/duty');
INSERT INTO `function` VALUES ('8', '系统管理', '0', '1', 'am-icon-th-large', null, '8', '#');
INSERT INTO `function` VALUES ('9', '店铺基本信息管理', '3', '2', 'am', null, '1', '#/store');
INSERT INTO `function` VALUES ('10', '店面信息记录', '3', '2', 'am', null, '4', '#/storeRecord');
INSERT INTO `function` VALUES ('11', '向单店添加用户', '0', '1', null, null, null, '0');
INSERT INTO `function` VALUES ('12', '向组织下的店添加用户', '0', '1', null, null, null, '0');
INSERT INTO `function` VALUES ('13', '向所有店添加用户', '0', '1', null, null, null, '0');
INSERT INTO `function` VALUES ('14', '用户管理', '8', '2', 'am-icon-angle-right', null, '1', '#/user');
INSERT INTO `function` VALUES ('15', '角色管理', '8', '2', 'am-icon-angle-right\"', null, '2', '#/role');

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '群组id',
  `group_name` varchar(255) DEFAULT NULL COMMENT '群组名字',
  `db_desc` text COMMENT '群组描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群组概念，声明一些用户属于一个群组，群组中的成员都具有，群组的权限';

-- ----------------------------
-- Records of groups
-- ----------------------------

-- ----------------------------
-- Table structure for group_members
-- ----------------------------
DROP TABLE IF EXISTS `group_members`;
CREATE TABLE `group_members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '成员用户名',
  `user_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_member_user` (`user_id`),
  KEY `fk_member_groups` (`group_id`),
  CONSTRAINT `fk_member_groups` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `fk_member_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群组的成员表';

-- ----------------------------
-- Records of group_members
-- ----------------------------

-- ----------------------------
-- Table structure for official_producte_speciality
-- ----------------------------
DROP TABLE IF EXISTS `official_producte_speciality`;
CREATE TABLE `official_producte_speciality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `db_desc` varchar(255) DEFAULT NULL,
  `store_producte` int(11) DEFAULT NULL,
  `official_producte` int(11) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL COMMENT '程度',
  PRIMARY KEY (`id`),
  KEY `fk_producte_type_store_producte` (`store_producte`),
  KEY `fk_producte_type_official_trade` (`official_producte`),
  CONSTRAINT `official_producte_speciality_ibfk_1` FOREIGN KEY (`official_producte`) REFERENCES `official_trade` (`id`),
  CONSTRAINT `official_producte_speciality_ibfk_2` FOREIGN KEY (`store_producte`) REFERENCES `store_producte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品特性表';

-- ----------------------------
-- Records of official_producte_speciality
-- ----------------------------

-- ----------------------------
-- Table structure for official_trade
-- ----------------------------
DROP TABLE IF EXISTS `official_trade`;
CREATE TABLE `official_trade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL COMMENT '编号',
  `official_name` varchar(255) NOT NULL COMMENT '官方名称-CADN中国药品通用名称',
  `product_name` varchar(255) DEFAULT NULL COMMENT '商品名',
  `alias` varchar(255) DEFAULT NULL COMMENT '别名',
  `official_type` int(11) DEFAULT NULL COMMENT '官方分类',
  `former_name` varchar(255) DEFAULT NULL COMMENT '曾用名',
  `db_desc` text,
  `official_price` double DEFAULT NULL COMMENT '官方定价',
  `icon` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `video` varchar(255) DEFAULT NULL COMMENT '商品影像资料',
  `statistical_categories` int(11) DEFAULT NULL COMMENT '用于统计某些信息的分类',
  `raw_material` text COMMENT '商品原料',
  PRIMARY KEY (`id`,`number`),
  KEY `official_trade_id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用于存储所有商品的表，每个店的商品表一定程度上依赖此表';

-- ----------------------------
-- Records of official_trade
-- ----------------------------

-- ----------------------------
-- Table structure for official_user_information
-- ----------------------------
DROP TABLE IF EXISTS `official_user_information`;
CREATE TABLE `official_user_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户',
  `realname` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `id_number` varchar(45) NOT NULL COMMENT '身份证号，一定不能相同',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '描述',
  `sex` varchar(45) DEFAULT NULL COMMENT '性别',
  `icon` varchar(45) DEFAULT NULL COMMENT '照片',
  `address` varchar(45) DEFAULT NULL COMMENT '地址',
  `qq` varchar(45) DEFAULT NULL COMMENT 'qq',
  `wechat` varchar(45) DEFAULT NULL COMMENT '微信',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `state` char(1) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`,`id_number`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='官方用户信息表';

-- ----------------------------
-- Records of official_user_information
-- ----------------------------
INSERT INTO `official_user_information` VALUES ('1', '韩励智', '23212619902251412', '18204614870', '描述', '男', null, '黑龙江省哈尔滨市', '1430261583', '18204614870', '18204614870@163.com', '0');
INSERT INTO `official_user_information` VALUES ('2', '121', '111111111111111112', '12', '1', '男', null, '1', '1', '1', '1@qq.com', '0');
INSERT INTO `official_user_information` VALUES ('8', '111', '232126199502250000', '1212', '123', '男', null, '123', '1', '1', '1@q.com', '0');

-- ----------------------------
-- Table structure for order_producte
-- ----------------------------
DROP TABLE IF EXISTS `order_producte`;
CREATE TABLE `order_producte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  `producte_id` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL COMMENT '数量，单项物品的数量',
  `price` double DEFAULT NULL COMMENT '单项价格',
  `service_id` int(11) DEFAULT NULL,
  `note` text COMMENT '备注',
  `ready_finish_time` datetime DEFAULT NULL COMMENT '准备完成时间',
  `make_finish_time` datetime DEFAULT NULL COMMENT '制作完成时间',
  `send_finish_time` datetime DEFAULT NULL COMMENT '送达时间',
  `reminder_number` int(11) DEFAULT NULL COMMENT '催单次数',
  `version` int(11) DEFAULT NULL COMMENT '记录多次变化，第一次录入为1，第二次为2以此类推',
  PRIMARY KEY (`id`),
  KEY `fk_order_for_producte` (`producte_id`),
  KEY `fk_order_for_order` (`order_id`),
  KEY `fk_order_for_service` (`service_id`),
  CONSTRAINT `fk_order_for_order` FOREIGN KEY (`order_id`) REFERENCES `db_order` (`id`),
  CONSTRAINT `fk_order_for_producte` FOREIGN KEY (`producte_id`) REFERENCES `store_producte` (`id`),
  CONSTRAINT `fk_order_for_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单与商品、服务的中间表，多对多关系\r\n有送达时间，则说明完成标记';

-- ----------------------------
-- Records of order_producte
-- ----------------------------

-- ----------------------------
-- Table structure for order_type
-- ----------------------------
DROP TABLE IF EXISTS `order_type`;
CREATE TABLE `order_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单分类id 主键',
  `number` varchar(20) DEFAULT NULL COMMENT '订单分类编号',
  `name` varchar(20) DEFAULT NULL COMMENT '订单分类名称',
  `db_desc` text COMMENT '订单分类描述',
  `store_number` varchar(255) DEFAULT NULL COMMENT '所属店面id   外键',
  `state` varchar(2) DEFAULT NULL COMMENT '状态.0正在进行，1完成，2取消，3删除',
  PRIMARY KEY (`id`),
  KEY `pk_storeid_ordertype` (`store_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_type
-- ----------------------------

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `upper_level_id` int(11) DEFAULT '1',
  `current_level` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用于描述店铺之上的概念，比如连锁机构';

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', '宏凯公司', '0', '1');
INSERT INTO `organization` VALUES ('2', '宏凯医药', '1', '2');

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL COMMENT '编号',
  `db_desc` text,
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL,
  `store_number` varchar(255) DEFAULT NULL COMMENT '店铺的编号',
  `priority` varchar(255) DEFAULT NULL COMMENT '优先级，多个活动时的结账顺序',
  PRIMARY KEY (`id`,`number`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠活动表';

-- ----------------------------
-- Records of privilege
-- ----------------------------

-- ----------------------------
-- Table structure for privilege_producte
-- ----------------------------
DROP TABLE IF EXISTS `privilege_producte`;
CREATE TABLE `privilege_producte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producte_id` int(11) DEFAULT NULL,
  `privilege_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_privilege_producte` (`producte_id`),
  KEY `fk_privilege_record` (`privilege_id`),
  CONSTRAINT `fk_privilege_producte` FOREIGN KEY (`producte_id`) REFERENCES `store_producte` (`id`),
  CONSTRAINT `fk_privilege_record` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠与产品中间表，多对多关系';

-- ----------------------------
-- Records of privilege_producte
-- ----------------------------

-- ----------------------------
-- Table structure for producte_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `producte_evaluation`;
CREATE TABLE `producte_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `evaluation_rank` int(11) DEFAULT NULL COMMENT '评价等级，1-5星',
  `evaluation_content` text COMMENT '评语',
  `evaluation_time` datetime DEFAULT NULL,
  `evaluation_people` varchar(255) DEFAULT NULL,
  `evaluation_people_contact_way` varchar(255) DEFAULT NULL,
  `producte_id` int(11) DEFAULT NULL COMMENT '对店的评价',
  PRIMARY KEY (`id`),
  KEY `fk_store_evaluation_producte` (`producte_id`),
  CONSTRAINT `fk_store_evaluation_producte` FOREIGN KEY (`producte_id`) REFERENCES `store_producte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商店评价表';

-- ----------------------------
-- Records of producte_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for producte_speciality
-- ----------------------------
DROP TABLE IF EXISTS `producte_speciality`;
CREATE TABLE `producte_speciality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `db_desc` varchar(255) DEFAULT NULL,
  `store_number` varchar(255) DEFAULT NULL COMMENT '0为官方分类，其他的是店的自定义分类',
  `store_producte` int(11) DEFAULT NULL,
  `official_producte` int(11) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL COMMENT '程度',
  `official_special` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_store_roducte_Store` (`store_number`),
  KEY `fk_producte_type_store_producte` (`store_producte`),
  KEY `fk_producte_type_official_trade` (`official_producte`),
  KEY `fk_producte_speciality_official_speciality` (`official_special`),
  CONSTRAINT `fk_producte_speciality_official_speciality` FOREIGN KEY (`official_special`) REFERENCES `official_producte_speciality` (`id`),
  CONSTRAINT `fk_producte_type_official_trade` FOREIGN KEY (`official_producte`) REFERENCES `official_trade` (`id`),
  CONSTRAINT `fk_producte_type_store_producte` FOREIGN KEY (`store_producte`) REFERENCES `store_producte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品特性表';

-- ----------------------------
-- Records of producte_speciality
-- ----------------------------

-- ----------------------------
-- Table structure for producte_type
-- ----------------------------
DROP TABLE IF EXISTS `producte_type`;
CREATE TABLE `producte_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `db_desc` varchar(255) DEFAULT NULL,
  `store_number` varchar(255) DEFAULT NULL COMMENT '0为官方分类，其他的是店的自定义分类',
  PRIMARY KEY (`id`),
  KEY `fk_store_roducte_Store` (`store_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品特性表';

-- ----------------------------
-- Records of producte_type
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '描述',
  `icon` varchar(45) DEFAULT NULL COMMENT '图标',
  `state` char(1) DEFAULT '0' COMMENT '状态，默认0为启用，1为未启用',
  `store_id` int(11) NOT NULL COMMENT '店面id',
  PRIMARY KEY (`id`),
  KEY `store_iddsdd3_idx` (`store_id`),
  CONSTRAINT `fk_store` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '高级管理员', null, '0', '1');
INSERT INTO `role` VALUES ('2', '无权限', '没有权限，用户初始的默认权限', null, '0', '1');

-- ----------------------------
-- Table structure for role_power
-- ----------------------------
DROP TABLE IF EXISTS `role_power`;
CREATE TABLE `role_power` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户权限',
  `function_name` varchar(45) DEFAULT NULL COMMENT '功能名称',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `function_id` int(11) NOT NULL COMMENT '功能表的id作为外键',
  PRIMARY KEY (`id`),
  KEY `role_idkujyhgtr_idx` (`role_id`),
  KEY `function_idasasaa_idx` (`function_id`),
  CONSTRAINT `function_idasasaa` FOREIGN KEY (`function_id`) REFERENCES `function` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_idkujyhgtr` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='需要在这个表中写出所有功能，包括子功能，也需要在这个表中写出来';

-- ----------------------------
-- Records of role_power
-- ----------------------------
INSERT INTO `role_power` VALUES ('1', '人事管理', '1', '1');
INSERT INTO `role_power` VALUES ('2', '店面管理', '1', '3');
INSERT INTO `role_power` VALUES ('3', '店铺柜台管理', '1', '4');
INSERT INTO `role_power` VALUES ('4', '店铺区域管理', '1', '5');
INSERT INTO `role_power` VALUES ('5', '店铺基本信息管理', '1', '9');
INSERT INTO `role_power` VALUES ('6', '店面信息记录', '1', '10');

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL,
  `db_desc` text,
  `price` double DEFAULT NULL,
  `store_number` varchar(255) NOT NULL COMMENT '店铺编号',
  `state` int(11) DEFAULT NULL,
  `service_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`number`),
  KEY `fk_service_type` (`service_type`),
  CONSTRAINT `fk_service_type` FOREIGN KEY (`service_type`) REFERENCES `service_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------

-- ----------------------------
-- Table structure for service_type
-- ----------------------------
DROP TABLE IF EXISTS `service_type`;
CREATE TABLE `service_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `db_desc` text,
  `state` int(11) DEFAULT NULL COMMENT '服务分类状态',
  `store_number` varchar(255) NOT NULL COMMENT '商店编号',
  PRIMARY KEY (`id`,`number`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service_type
-- ----------------------------

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '店面',
  `name` varchar(45) DEFAULT NULL COMMENT '店面名称',
  `store_type_id` int(11) NOT NULL COMMENT '店面类型id',
  `address` varchar(45) DEFAULT NULL COMMENT '地址',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `legal_name` varchar(45) DEFAULT NULL COMMENT '法人姓名',
  `legal_name_phone` varchar(45) DEFAULT NULL COMMENT '法人联系方式',
  `state` char(1) DEFAULT '0' COMMENT '状态',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '描述',
  `organization_id` int(11) DEFAULT NULL COMMENT '属于哪一组织',
  `number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`number`),
  KEY `number` (`number`),
  KEY `id` (`id`),
  KEY `store_type_iddsds_idx` (`store_type_id`) USING BTREE,
  CONSTRAINT `store_type_iddsds` FOREIGN KEY (`store_type_id`) REFERENCES `store_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '男鞋女装', '1', '北京', '13498746523', '张鑫博', '123456798', '0', '我是法人', '0', '1');
INSERT INTO `store` VALUES ('2', '电脑专卖店', '2', '上海', '987654147', '韩励志', '888888888', '0', '数码产品', '0', '2');

-- ----------------------------
-- Table structure for store_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `store_evaluation`;
CREATE TABLE `store_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `evaluation_rank` int(11) DEFAULT NULL COMMENT '评价等级，1-5星',
  `evaluation_content` text COMMENT '评语',
  `evaluation_time` datetime DEFAULT NULL,
  `evaluation_people` varchar(255) DEFAULT NULL,
  `evaluation_people_contact_way` varchar(255) DEFAULT NULL,
  `store_number` varchar(255) DEFAULT NULL COMMENT '对店的评价',
  PRIMARY KEY (`id`),
  KEY `fk_store_evaluation_store` (`store_number`),
  CONSTRAINT `fk_store_evaluation_store` FOREIGN KEY (`store_number`) REFERENCES `store` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商店评价表';

-- ----------------------------
-- Records of store_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for store_producte
-- ----------------------------
DROP TABLE IF EXISTS `store_producte`;
CREATE TABLE `store_producte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '店铺特有名字',
  `db_desc` text COMMENT '商品介绍',
  `video` varchar(255) DEFAULT NULL COMMENT '商品影像资料',
  `raw_material` text COMMENT '商品原料',
  `price` double DEFAULT NULL COMMENT '店铺商品价格',
  `privilege` int(11) DEFAULT NULL COMMENT '每个商品的优惠活动',
  `official_trade` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '商店独有类型',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_store_official_producte` (`official_trade`),
  KEY `fk_store_producte_store` (`store_id`),
  KEY `fk_store_producte_producte_type` (`type`),
  CONSTRAINT `fk_store_official_producte` FOREIGN KEY (`official_trade`) REFERENCES `official_trade` (`id`),
  CONSTRAINT `fk_store_producte_producte_type` FOREIGN KEY (`type`) REFERENCES `producte_type` (`id`),
  CONSTRAINT `fk_store_producte_store` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用于存储所有商品的表，每个店的商品表一定程度上依赖此表';

-- ----------------------------
-- Records of store_producte
-- ----------------------------

-- ----------------------------
-- Table structure for store_type
-- ----------------------------
DROP TABLE IF EXISTS `store_type`;
CREATE TABLE `store_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '删除店面类型时设置拥有该类型的店面类型为空(触发器)',
  `store_type_name` varchar(45) DEFAULT NULL COMMENT '店面类型名称',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  `db_explain` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_type
-- ----------------------------
INSERT INTO `store_type` VALUES ('1', '市场型', '1', '店铺类型');
INSERT INTO `store_type` VALUES ('2', '商业型', '1', '店铺类型');
INSERT INTO `store_type` VALUES ('3', '社区型', '1', '店铺类型');
INSERT INTO `store_type` VALUES ('4', '住宅型', '1', '店铺类型');
INSERT INTO `store_type` VALUES ('5', 'd', 'd', 'd');
INSERT INTO `store_type` VALUES ('6', 'test', '1', 'test');

-- ----------------------------
-- Table structure for sys_code_rule
-- ----------------------------
DROP TABLE IF EXISTS `sys_code_rule`;
CREATE TABLE `sys_code_rule` (
  `id` int(11) NOT NULL COMMENT '编号',
  `areaPrefix` varchar(255) DEFAULT NULL COMMENT '编码前缀(可变)',
  `areaTime` varchar(255) DEFAULT NULL COMMENT '日期位(可变)----》编码中缀',
  `glideBit` int(11) DEFAULT NULL COMMENT '流水位(可变)',
  `currentCode` varchar(255) DEFAULT NULL COMMENT '预览(显示的提供看的)',
  `nextseq` varchar(255) DEFAULT NULL COMMENT '下次产生的序号----》流水号后缀   ',
  `curDate` varchar(255) DEFAULT NULL COMMENT '序号对应的日期(yyyyMMdd) ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_code_rule
-- ----------------------------
INSERT INTO `sys_code_rule` VALUES ('1', 'HRB', 'yyyyMMdd', '5', 'HRB-20170622-00016', '00017', '20170622');

-- ----------------------------
-- Table structure for time_manage
-- ----------------------------
DROP TABLE IF EXISTS `time_manage`;
CREATE TABLE `time_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '时间管理id',
  `start_time` time DEFAULT NULL COMMENT '开始时间',
  `end_time` time DEFAULT NULL COMMENT '结束时间',
  `name` varchar(45) DEFAULT NULL COMMENT '名称',
  `store_id` int(11) NOT NULL COMMENT '店面id',
  `state` char(1) DEFAULT '1' COMMENT '状态',
  `db_desc` text COMMENT '描述',
  PRIMARY KEY (`id`),
  KEY `store_idfgds423_idx` (`store_id`),
  CONSTRAINT `store_idfgds423` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='																									aaaaa																											a  ';

-- ----------------------------
-- Records of time_manage
-- ----------------------------
INSERT INTO `time_manage` VALUES ('1', '11:20:52', '06:20:00', '时间管理', '2', '1', '不要迟到哦');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11) NOT NULL COMMENT '用户和角色是一一对应的',
  `store` varchar(255) DEFAULT NULL COMMENT '店铺的编号',
  `user_information` int(11) DEFAULT NULL,
  `enabled` varchar(255) DEFAULT '0' COMMENT '0为开启，1为关闭',
  PRIMARY KEY (`id`,`role_id`,`username`),
  KEY `fk_role` (`role_id`),
  KEY `fk_user_user_infromation` (`user_information`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_user_infromation` FOREIGN KEY (`user_information`) REFERENCES `user_information` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='存在不能登录，但有员工基本信息的情况\r\n如果这个人可以登录，则他一定有员工基本信息，\r\n讲外键设置在users表中';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'q', 'q', '1', '1', '1', '0');
INSERT INTO `users` VALUES ('2', 'w', 'w', '2', '2', '2', '0');
INSERT INTO `users` VALUES ('3', 'z', 'z', '1', '1', '8', '0');

-- ----------------------------
-- Table structure for user_change
-- ----------------------------
DROP TABLE IF EXISTS `user_change`;
CREATE TABLE `user_change` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户异动表',
  `realname` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(45) DEFAULT NULL COMMENT '昵称',
  `id_number` varchar(45) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '描述',
  `sex` varchar(45) DEFAULT NULL COMMENT '性别',
  `icon` varchar(45) DEFAULT NULL COMMENT '照片',
  `address` varchar(45) DEFAULT NULL COMMENT '地址',
  `qq` varchar(45) DEFAULT NULL COMMENT 'qq',
  `wechat` varchar(45) DEFAULT NULL COMMENT '微信',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `operator` varchar(45) DEFAULT NULL COMMENT '操作者',
  `new_realname` varchar(45) DEFAULT NULL COMMENT '新真实姓名',
  `new_nickname` varchar(45) DEFAULT NULL COMMENT '新昵称',
  `new_id_number` varchar(45) DEFAULT NULL COMMENT '新身份证号',
  `new_icon` varchar(45) DEFAULT NULL COMMENT '新手机号',
  `new_password` varchar(45) DEFAULT NULL COMMENT '新密码',
  `new_desc` varchar(45) DEFAULT NULL COMMENT '新描述',
  `new_sex` varchar(45) DEFAULT NULL COMMENT '新性别',
  `new_address` varchar(45) DEFAULT NULL COMMENT '新地址',
  `new_qq` varchar(45) DEFAULT NULL COMMENT '新qq',
  `new_wechat` varchar(45) DEFAULT NULL COMMENT '新微信',
  `new_email` varchar(45) DEFAULT NULL COMMENT '新邮箱',
  `role` varchar(255) DEFAULT NULL COMMENT '旧角色名',
  `new_role` varchar(255) DEFAULT NULL COMMENT '新角色名',
  `duty` varchar(255) DEFAULT NULL COMMENT '旧的职务',
  `new_duty` varchar(255) DEFAULT NULL COMMENT '新的职务',
  `department` varchar(255) DEFAULT NULL COMMENT '旧的部门',
  `new_department` varchar(255) DEFAULT NULL COMMENT '新的部门',
  `counter` varchar(255) DEFAULT NULL COMMENT '旧柜台',
  `new_counter` varchar(255) DEFAULT NULL COMMENT '新柜台',
  `store` varchar(255) DEFAULT NULL,
  `new_store` varchar(255) DEFAULT NULL,
  `number` varchar(255) NOT NULL COMMENT '编号，用于能大概描述这个变动记录的编号，例如时间，日期',
  PRIMARY KEY (`id`,`number`),
  KEY `user_idsdsds43_idx` (`user_id`),
  CONSTRAINT `user_idsdsds43` FOREIGN KEY (`user_id`) REFERENCES `user_information` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_change
-- ----------------------------

-- ----------------------------
-- Table structure for user_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `user_evaluation`;
CREATE TABLE `user_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `evaluation_rank` int(11) DEFAULT NULL COMMENT '评价等级，1-5星',
  `evaluation_content` text COMMENT '评语',
  `evaluation_time` datetime DEFAULT NULL,
  `evaluation_people` varchar(255) DEFAULT NULL,
  `evaluation_people_contact_way` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '对店的评价',
  PRIMARY KEY (`id`),
  KEY `fk_store_evaluation_producte` (`user_id`) USING BTREE,
  CONSTRAINT `fk_evaluation_user_information` FOREIGN KEY (`user_id`) REFERENCES `user_information` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商店评价表';

-- ----------------------------
-- Records of user_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for user_information
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户',
  `realname` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `id_number` varchar(45) NOT NULL COMMENT '身份证号，一定不能相同',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `db_desc` varchar(45) DEFAULT NULL COMMENT '描述',
  `sex` varchar(45) DEFAULT NULL COMMENT '性别',
  `icon` varchar(45) DEFAULT NULL COMMENT '照片',
  `address` varchar(45) DEFAULT NULL COMMENT '地址',
  `qq` varchar(45) DEFAULT NULL COMMENT 'qq',
  `wechat` varchar(45) DEFAULT NULL COMMENT '微信',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `duty_id` int(11) NOT NULL COMMENT '职务id',
  `department_id` int(11) NOT NULL COMMENT '部门id',
  `state` char(1) DEFAULT '0' COMMENT '状态',
  `store_id` int(11) NOT NULL COMMENT '店面id',
  PRIMARY KEY (`id`,`id_number`),
  KEY `duty_iddsdsd43_idx` (`duty_id`),
  KEY `group_idfdsds4332_idx` (`department_id`),
  KEY `store_idsasffhg43_idx` (`store_id`),
  CONSTRAINT `duty_iddsdsd43` FOREIGN KEY (`duty_id`) REFERENCES `duty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `store_idsasffhg43` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES ('1', '韩励智', '23212619902251412', '18204614870', '描述', '男', null, '黑龙江省哈尔滨市', '1430261583', '18204614870', '18204614870@163.com', '2', '1', '0', '1');
INSERT INTO `user_information` VALUES ('2', '121', '111111111111111112', '12', '1', '男', null, '1', '1', '1', '1@qq.com', '3', '1', '0', '1');
INSERT INTO `user_information` VALUES ('8', '111', '232126199502250000', '1212', '123', '男', null, '123', '1', '1', '1@q.com', '3', '1', '0', '1');

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(20) DEFAULT NULL COMMENT '会员编号',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `vip_type_id` int(11) DEFAULT NULL COMMENT '会员分类id   外键',
  `name` varchar(20) DEFAULT NULL COMMENT '会员姓名',
  `telephone` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `gender` varchar(4) DEFAULT NULL,
  `QQ` varchar(12) DEFAULT NULL COMMENT 'QQ',
  `WeChat` varchar(20) DEFAULT NULL COMMENT '微信',
  `email` varchar(20) DEFAULT NULL COMMENT '电子邮箱',
  `personalized_signature` varchar(50) DEFAULT NULL COMMENT '个性签名',
  `store_id` int(11) DEFAULT NULL COMMENT '所属店面编号   外键',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `type` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL COMMENT '会员积分',
  PRIMARY KEY (`id`),
  KEY `viptypeid_pk` (`vip_type_id`),
  KEY `storeid_pksss` (`store_id`),
  CONSTRAINT `storeid_pksss` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`),
  CONSTRAINT `viptypeid_pk` FOREIGN KEY (`vip_type_id`) REFERENCES `vip_goups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------

-- ----------------------------
-- Table structure for vip_goups
-- ----------------------------
DROP TABLE IF EXISTS `vip_goups`;
CREATE TABLE `vip_goups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员分类   id 主键',
  `number` varchar(20) NOT NULL COMMENT '会员分类编号',
  `name` varchar(20) DEFAULT NULL COMMENT '会员分类名称',
  `db_desc` text,
  `discount` int(2) DEFAULT NULL COMMENT '折扣',
  `store_number` int(11) DEFAULT NULL COMMENT '所属店面编号   外键',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`,`number`),
  KEY `storeid_pk` (`store_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员组，用于设定一组会员享受的优惠';

-- ----------------------------
-- Records of vip_goups
-- ----------------------------

-- ----------------------------
-- Table structure for workstation_record
-- ----------------------------
DROP TABLE IF EXISTS `workstation_record`;
CREATE TABLE `workstation_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位管理',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名称',
  `user_phone` varchar(45) DEFAULT NULL COMMENT '用户联系方式',
  `go_work_time` time DEFAULT NULL COMMENT '上班时间',
  `leave_work_time` time DEFAULT NULL COMMENT '下班时间',
  `counter_id` int(11) DEFAULT NULL COMMENT '柜台id',
  `son_area_id` int(11) DEFAULT NULL COMMENT '子区域id',
  `work_day` date DEFAULT NULL COMMENT '岗位在那一天的记录',
  `store_id` int(11) DEFAULT NULL COMMENT '店面id',
  `work_station_id` int(11) NOT NULL,
  `number` varchar(255) NOT NULL COMMENT '编号，字符串或数字的编号',
  PRIMARY KEY (`id`,`number`),
  KEY `staff_idsada323_idx` (`user_id`),
  KEY `counter_iddsdsd434_idx` (`counter_id`),
  KEY `son_area_idsasa23232_idx` (`son_area_id`),
  KEY `store_idfdddf42432_idx` (`store_id`),
  KEY `work_station_idjhgfd_idx` (`work_station_id`),
  CONSTRAINT `work_station_idjhgfd` FOREIGN KEY (`work_station_id`) REFERENCES `work_station` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workstation_record
-- ----------------------------

-- ----------------------------
-- Table structure for work_station
-- ----------------------------
DROP TABLE IF EXISTS `work_station`;
CREATE TABLE `work_station` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位',
  `name` varchar(45) DEFAULT NULL COMMENT '岗位名称',
  `user_id` int(11) DEFAULT NULL COMMENT '规定的员工，唯一存在',
  `go_work_time` time DEFAULT NULL COMMENT '上班时间',
  `leave_work_time` time DEFAULT NULL COMMENT '下班时间',
  `department_id` int(11) DEFAULT NULL COMMENT '岗位属于那一个部门',
  PRIMARY KEY (`id`),
  KEY `user_iddsds4332_idx` (`user_id`),
  KEY `fk_work_station_departemnt` (`department_id`),
  CONSTRAINT `fk_work_station_departemnt` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `user_iddsds4332` FOREIGN KEY (`user_id`) REFERENCES `user_information` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='岗位与人员信息是一一对应关系，岗位与部门是多对一关系';

-- ----------------------------
-- Records of work_station
-- ----------------------------
INSERT INTO `work_station` VALUES ('1', '服务员', '8', '08:42:04', '17:42:15', '1');
