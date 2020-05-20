/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.199
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 192.168.0.199:3306
 Source Schema         : project_crowd

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 20/05/2020 16:43:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inner_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `inner_admin_role`;
CREATE TABLE `inner_admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inner_admin_role
-- ----------------------------
INSERT INTO `inner_admin_role` VALUES (1, 3, 1);
INSERT INTO `inner_admin_role` VALUES (2, 3, 2);
INSERT INTO `inner_admin_role` VALUES (3, 4, 3);
INSERT INTO `inner_admin_role` VALUES (4, 4, 4);

-- ----------------------------
-- Table structure for inner_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `inner_role_auth`;
CREATE TABLE `inner_role_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `auth_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inner_role_auth
-- ----------------------------
INSERT INTO `inner_role_auth` VALUES (1, 2, 8);
INSERT INTO `inner_role_auth` VALUES (2, 4, 5);
INSERT INTO `inner_role_auth` VALUES (3, 3, 3);

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `receive_name` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收件人',
  `phone_num` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` char(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES (1, '张三', '13456789012', '北京', 2);

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_acct` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户',
  `user_pswd` char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `login_acct`(`login_acct`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员账户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', '$2a$10$7XEAi40CG2KBei2E6vLOWeSoXLv5ERKXRm48cb/B0TlYp6U5WYx2K', 'Admin', 'admin@email.com', '2020-04-15 11:54:20');
INSERT INTO `t_admin` VALUES (2, 'tom', '$2a$10$7XEAi40CG2KBei2E6vLOWeSoXLv5ERKXRm48cb/B0TlYp6U5WYx2K', 'Tom', 'tom@email.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (3, 'adminOperator', '$2a$10$eqDTFw4yf72aN9QU.grqkezIn00hK3hC4/3PV1oaOr.IGOTwr36Tq', 'Admin', 'adminOperator@email.com', '2020-05-12 15:23:20');
INSERT INTO `t_admin` VALUES (4, 'roleOperator', '$2a$10$lCeot5td4.KClUlQGAYhhejO1GmDjBZU7UKhIOdCkWWm302WcuCBy', 'Role', 'roleOperator@email.com', '2020-05-12 15:24:40');
INSERT INTO `t_admin` VALUES (5, 'test', '$2a$10$D4W6OA3ON03gDs2jkWuTE.T2/9ms/UrFjYSGuB8Yh75trb3XQ38Em', 'Test', 'test@email.com', '2020-05-12 16:34:31');

-- ----------------------------
-- Table structure for t_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_auth
-- ----------------------------
INSERT INTO `t_auth` VALUES (1, '', '用户模块', NULL);
INSERT INTO `t_auth` VALUES (2, 'user:delete', '删除', 1);
INSERT INTO `t_auth` VALUES (3, 'user:get', '查询', 1);
INSERT INTO `t_auth` VALUES (4, '', '角色模块', NULL);
INSERT INTO `t_auth` VALUES (5, 'role:delete', '删除', 4);
INSERT INTO `t_auth` VALUES (6, 'role:get', '查询', 4);
INSERT INTO `t_auth` VALUES (7, 'role:add', '新增', 4);
INSERT INTO `t_auth` VALUES (8, 'user:add', '添加', 1);

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginacct` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `userpswd` char(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authstatus` int(4) NULL DEFAULT NULL COMMENT '实名认证状态0 - 未实名认证， 1 - 实名认证申\r\n请中， 2 - 已实名认证',
  `usertype` int(4) NULL DEFAULT NULL COMMENT ' 0 - 个人， 1 - 企业',
  `realname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cardnum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `accttype` int(4) NULL DEFAULT NULL COMMENT '0 - 企业， 1 - 个体， 2 - 个人， 3 - 政府',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `loginacct`(`loginacct`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES (1, 'jack', '$2a$10$D9c86qQUN.FOmp1SXN/7PuBnOkMd3K0AELcJurJzRY0vWzMcDIFZu', ' 杰克', 'jack@qq.com', 1, 1, '杰克', '123123', 2);
INSERT INTO `t_member` VALUES (2, 'harry', '$2a$10$f9/WP4HdDQWUePlC2E8N8OiMfwQoXIOOLEfi2SPtHILlTTn9jC.wu', 'acct001', 'zyc199777@gmail.com', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_member_confirm_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_confirm_info`;
CREATE TABLE `t_member_confirm_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `paynum` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '易付宝企业账号',
  `cardnum` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '法人身份证号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_member_confirm_info
-- ----------------------------
INSERT INTO `t_member_confirm_info` VALUES (1, 2, '132456', '100200199304056789');

-- ----------------------------
-- Table structure for t_member_launch_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_launch_info`;
CREATE TABLE `t_member_launch_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `description_simple` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简单介绍',
  `description_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细介绍',
  `phone_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `service_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客服电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_member_launch_info
-- ----------------------------
INSERT INTO `t_member_launch_info` VALUES (3, 2, 'i am mao', '我是猫哥', '123456', '654321');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, NULL, '系统权限菜单', NULL, 'glyphicon\r\nglyphicon-th-list');
INSERT INTO `t_menu` VALUES (2, 1, ' 控制面板', 'main.htm', 'glyphicon\r\nglyphicon-dashboard');
INSERT INTO `t_menu` VALUES (3, 1, '权限管理', NULL, 'glyphicon glyphicon\r\nglyphicon-tasks');
INSERT INTO `t_menu` VALUES (4, 3, ' 用户维护', 'user/index.htm', 'glyphicon\r\nglyphicon-user');
INSERT INTO `t_menu` VALUES (5, 3, ' 角色维护', 'role/index.htm', 'glyphicon\r\nglyphicon-king');
INSERT INTO `t_menu` VALUES (6, 3, ' 菜单维护', 'permission/index.htm', 'glyphicon\r\nglyphicon-lock');
INSERT INTO `t_menu` VALUES (7, 1, ' 业务审核', NULL, 'glyphicon\r\nglyphicon-ok');
INSERT INTO `t_menu` VALUES (8, 7, ' 实名认证审核', 'auth_cert/index.htm', 'glyphicon\r\nglyphicon-check');
INSERT INTO `t_menu` VALUES (9, 7, ' 广告审核', 'auth_adv/index.htm', 'glyphicon\r\nglyphicon-check');
INSERT INTO `t_menu` VALUES (10, 7, ' 项目审核', 'auth_project/index.htm', 'glyphicon\r\nglyphicon-check');
INSERT INTO `t_menu` VALUES (11, 1, ' 业务管理', NULL, 'glyphicon\r\nglyphicon-th-large');
INSERT INTO `t_menu` VALUES (12, 11, ' 资质维护', 'cert/index.htm', 'glyphicon\r\nglyphicon-picture');
INSERT INTO `t_menu` VALUES (13, 11, ' 分类管理', 'certtype/index.htm', 'glyphicon\r\nglyphicon-equalizer');
INSERT INTO `t_menu` VALUES (14, 11, ' 流程管理', 'process/index.htm', 'glyphicon\r\nglyphicon-random');
INSERT INTO `t_menu` VALUES (15, 11, ' 广告管理', 'advert/index.htm', 'glyphicon\r\nglyphicon-hdd');
INSERT INTO `t_menu` VALUES (16, 11, ' 消息模板', 'message/index.htm', 'glyphicon\r\nglyphicon-comment');
INSERT INTO `t_menu` VALUES (17, 11, ' 项目分类', 'projectType/index.htm', 'glyphicon\r\nglyphicon-list');
INSERT INTO `t_menu` VALUES (18, 11, ' 项目标签', 'tag/index.htm', 'glyphicon\r\nglyphicon-tags');
INSERT INTO `t_menu` VALUES (19, 1, ' 参数管理', 'param/index.htm', 'glyphicon\r\nglyphicon-list-alt');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_num` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `pay_order_num` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝流水号',
  `order_amount` double(10, 5) NULL DEFAULT NULL COMMENT '订单金额',
  `invoice` int(11) NULL DEFAULT NULL COMMENT '是否开发票（0 不开，1 开）',
  `invoice_title` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发票抬头',
  `order_remark` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  `address_id` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货地址id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, '2020052016175363675F74855645099937AAFCBCEA4D5E', '2020052022001452500501050399', 50.00000, 0, '', '无', '1');
INSERT INTO `t_order` VALUES (2, '20200520162518EB47D00189464DF68B05C677F2B4BDD1', '2020052022001452500501050692', 50.00000, 0, '', '', '1');

-- ----------------------------
-- Table structure for t_order_project
-- ----------------------------
DROP TABLE IF EXISTS `t_order_project`;
CREATE TABLE `t_order_project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_name` char(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `launch_name` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发起人',
  `return_content` char(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回报内容',
  `return_count` int(11) NULL DEFAULT NULL COMMENT '回报数量',
  `support_price` int(11) NULL DEFAULT NULL COMMENT '支持单价',
  `freight` int(11) NULL DEFAULT NULL COMMENT '配送费用',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '订单表的主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_project
-- ----------------------------
INSERT INTO `t_order_project` VALUES (1, 'brotherMao', 'i am mao', '以身相许', 5, 10, 0, 1);
INSERT INTO `t_order_project` VALUES (2, 'brotherMao', 'i am mao', '以身相许', 5, 10, 0, 2);

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `project_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  `money` bigint(11) NULL DEFAULT NULL COMMENT '筹集金额',
  `day` int(11) NULL DEFAULT NULL COMMENT '筹集天数',
  `status` int(4) NULL DEFAULT NULL COMMENT '0-即将开始，1-众筹中，2-众筹成功，3-众筹失败\r\n',
  `deploydate` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目发起时间',
  `supportmoney` bigint(11) NULL DEFAULT NULL COMMENT '已筹集到的金额',
  `supporter` int(11) NULL DEFAULT NULL COMMENT '支持人数',
  `completion` int(3) NULL DEFAULT NULL COMMENT '百分比完成度',
  `memberid` int(11) NULL DEFAULT NULL COMMENT '发起人的会员id',
  `createdate` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目创建时间',
  `follower` int(11) NULL DEFAULT NULL COMMENT '关注人数',
  `header_picture_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头图路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES (3, 'brotherMao', '就是帅！', NULL, 30, 0, '2020-05-19', NULL, NULL, NULL, 2, '2020-05-19', NULL, 'https://atguigu-crowd-zhuyc.oss-cn-beijing.aliyuncs.com/2020-5-19/e876a3ce-503d-4b63-858f-661575170b40.jpg');

-- ----------------------------
-- Table structure for t_project_item_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_project_item_pic`;
CREATE TABLE `t_project_item_pic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) NULL DEFAULT NULL,
  `item_pic_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project_item_pic
-- ----------------------------
INSERT INTO `t_project_item_pic` VALUES (5, 3, 'https://atguigu-crowd-zhuyc.oss-cn-beijing.aliyuncs.com/2020-5-19/1e754d0f-beb5-4293-a468-f18e49ccfba6.jpg');
INSERT INTO `t_project_item_pic` VALUES (6, 3, 'https://atguigu-crowd-zhuyc.oss-cn-beijing.aliyuncs.com/2020-5-19/928334cf-33ee-4102-8e54-f7f71e583f39.jpg');

-- ----------------------------
-- Table structure for t_project_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_project_tag`;
CREATE TABLE `t_project_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) NULL DEFAULT NULL,
  `tagid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project_tag
-- ----------------------------
INSERT INTO `t_project_tag` VALUES (5, 3, 4);
INSERT INTO `t_project_tag` VALUES (6, 3, 8);

-- ----------------------------
-- Table structure for t_project_type
-- ----------------------------
DROP TABLE IF EXISTS `t_project_type`;
CREATE TABLE `t_project_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) NULL DEFAULT NULL,
  `typeid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project_type
-- ----------------------------
INSERT INTO `t_project_type` VALUES (5, 3, 1);
INSERT INTO `t_project_type` VALUES (6, 3, 2);
INSERT INTO `t_project_type` VALUES (7, 3, 4);

-- ----------------------------
-- Table structure for t_return
-- ----------------------------
DROP TABLE IF EXISTS `t_return`;
CREATE TABLE `t_return`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) NULL DEFAULT NULL,
  `type` int(4) NULL DEFAULT NULL COMMENT '0 - 实物回报， 1 虚拟物品回报',
  `supportmoney` int(11) NULL DEFAULT NULL COMMENT '支持金额',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回报内容',
  `count` int(11) NULL DEFAULT NULL COMMENT '回报产品限额，“0”为不限回报数量',
  `signalpurchase` int(11) NULL DEFAULT NULL COMMENT '是否设置单笔限购',
  `purchase` int(11) NULL DEFAULT NULL COMMENT '具体限购数量',
  `freight` int(11) NULL DEFAULT NULL COMMENT '运费，“0”为包邮',
  `invoice` int(4) NULL DEFAULT NULL COMMENT '0 - 不开发票， 1 - 开发票',
  `returndate` int(11) NULL DEFAULT NULL COMMENT '项目结束后多少天向支持者发送回报',
  `describ_pic_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '说明图片路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_return
-- ----------------------------
INSERT INTO `t_return` VALUES (1, 3, 0, 10, '以身相许', 5, 0, 8, 0, 0, 15, '\r\nhttps://atguigu-crowd-zhuyc.oss-cn-beijing.aliyuncs.com/2020-5-19/c1ff3d72-baea-4697-a28d-8aa15af380b0.jpg');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '经理');
INSERT INTO `t_role` VALUES (2, '经理操作者');
INSERT INTO `t_role` VALUES (3, '部长');
INSERT INTO `t_role` VALUES (4, '部长操作者');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, 0, '手机');
INSERT INTO `t_tag` VALUES (2, 0, '数码');
INSERT INTO `t_tag` VALUES (3, 0, '电脑');
INSERT INTO `t_tag` VALUES (4, 1, '大屏');
INSERT INTO `t_tag` VALUES (5, 1, '美颜');
INSERT INTO `t_tag` VALUES (6, 1, '续航');
INSERT INTO `t_tag` VALUES (7, 2, '高解析度');
INSERT INTO `t_tag` VALUES (8, 2, '高清');
INSERT INTO `t_tag` VALUES (9, 3, '大内存');
INSERT INTO `t_tag` VALUES (10, 3, '固态');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (1, '科技', '科技');
INSERT INTO `t_type` VALUES (2, '设计', '设计');
INSERT INTO `t_type` VALUES (3, '公益', '公益');
INSERT INTO `t_type` VALUES (4, '农业', '农业');

SET FOREIGN_KEY_CHECKS = 1;
