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

 Date: 08/05/2020 17:59:00
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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inner_admin_role
-- ----------------------------
INSERT INTO `inner_admin_role` VALUES (1, 1, 35);
INSERT INTO `inner_admin_role` VALUES (2, 1, 44);
INSERT INTO `inner_admin_role` VALUES (3, 1, 10);
INSERT INTO `inner_admin_role` VALUES (4, 1, 11);
INSERT INTO `inner_admin_role` VALUES (5, 1, 12);

-- ----------------------------
-- Table structure for inner_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `inner_role_auth`;
CREATE TABLE `inner_role_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `auth_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inner_role_auth
-- ----------------------------
INSERT INTO `inner_role_auth` VALUES (8, 2, 1);
INSERT INTO `inner_role_auth` VALUES (9, 2, 2);
INSERT INTO `inner_role_auth` VALUES (10, 2, 3);
INSERT INTO `inner_role_auth` VALUES (11, 2, 4);
INSERT INTO `inner_role_auth` VALUES (12, 2, 6);

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
) ENGINE = InnoDB AUTO_INCREMENT = 284 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员账户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'Admin', 'test_mapper', '2020-04-15 11:54:20');
INSERT INTO `t_admin` VALUES (8, 'Acct4', '1234564', 'username4', '4email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (9, 'Acct5', '1234565', 'username5', '5email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (10, 'Acct6', '1234566', 'username6', '6email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (11, 'Acct7', '1234567', 'username7', '7email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (13, 'Acct9', '1234569', 'username9', '9email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (14, 'Acct10', '12345610', 'username10', '10email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (15, 'Acct11', '12345611', 'username11', '11email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (16, 'Acct12', '12345612', 'username12', '12email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (17, 'Acct13', '12345613', 'username13', '13email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (18, 'Acct14', '12345614', 'username14', '14email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (19, 'Acct15', '12345615', 'username15', '15email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (20, 'Acct16', '12345616', 'username16', '16email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (21, 'Acct17', '12345617', 'username17', '17email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (22, 'Acct18', '12345618', 'username18', '18email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (23, 'Acct19', '12345619', 'username19', '19email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (24, 'Acct20', '12345620', 'username20', '20email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (25, 'Acct21', '12345621', 'username21', '21email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (26, 'Acct22', '12345622', 'username22', '22email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (27, 'Acct23', '12345623', 'username23', '23email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (28, 'Acct24', '12345624', 'username24', '24email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (29, 'Acct25', '12345625', 'username25', '25email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (30, 'Acct26', '12345626', 'username26', '26email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (31, 'Acct27', '12345627', 'username27', '27email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (32, 'Acct28', '12345628', 'username28', '28email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (33, 'Acct29', '12345629', 'username29', '29email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (34, 'Acct30', '12345630', 'username30', '30email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (35, 'Acct31', '12345631', 'username31', '31email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (36, 'Acct32', '12345632', 'username32', '32email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (37, 'Acct33', '12345633', 'username33', '33email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (38, 'Acct34', '12345634', 'username34', '34email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (39, 'Acct35', '12345635', 'username35', '35email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (40, 'Acct36', '12345636', 'username36', '36email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (41, 'Acct37', '12345637', 'username37', '37email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (42, 'Acct38', '12345638', 'username38', '38email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (43, 'Acct39', '12345639', 'username39', '39email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (44, 'Acct40', '12345640', 'username40', '40email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (45, 'Acct41', '12345641', 'username41', '41email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (46, 'Acct42', '12345642', 'username42', '42email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (47, 'Acct43', '12345643', 'username43', '43email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (48, 'Acct44', '12345644', 'username44', '44email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (49, 'Acct45', '12345645', 'username45', '45email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (50, 'Acct46', '12345646', 'username46', '46email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (51, 'Acct47', '12345647', 'username47', '47email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (52, 'Acct48', '12345648', 'username48', '48email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (53, 'Acct49', '12345649', 'username49', '49email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (54, 'Acct50', '12345650', 'username50', '50email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (55, 'Acct51', '12345651', 'username51', '51email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (56, 'Acct52', '12345652', 'username52', '52email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (57, 'Acct53', '12345653', 'username53', '53email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (58, 'Acct54', '12345654', 'username54', '54email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (59, 'Acct55', '12345655', 'username55', '55email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (60, 'Acct56', '12345656', 'username56', '56email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (61, 'Acct57', '12345657', 'username57', '57email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (62, 'Acct58', '12345658', 'username58', '58email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (63, 'Acct59', '12345659', 'username59', '59email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (64, 'Acct60', '12345660', 'username60', '60email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (65, 'Acct61', '12345661', 'username61', '61email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (66, 'Acct62', '12345662', 'username62', '62email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (67, 'Acct63', '12345663', 'username63', '63email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (68, 'Acct64', '12345664', 'username64', '64email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (69, 'Acct65', '12345665', 'username65', '65email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (70, 'Acct66', '12345666', 'username66', '66email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (71, 'Acct67', '12345667', 'username67', '67email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (72, 'Acct68', '12345668', 'username68', '68email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (73, 'Acct69', '12345669', 'username69', '69email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (74, 'Acct70', '12345670', 'username70', '70email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (75, 'Acct71', '12345671', 'username71', '71email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (76, 'Acct72', '12345672', 'username72', '72email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (77, 'Acct73', '12345673', 'username73', '73email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (78, 'Acct74', '12345674', 'username74', '74email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (79, 'Acct75', '12345675', 'username75', '75email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (80, 'Acct76', '12345676', 'username76', '76email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (81, 'Acct77', '12345677', 'username77', '77email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (82, 'Acct78', '12345678', 'username78', '78email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (83, 'Acct79', '12345679', 'username79', '79email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (84, 'Acct80', '12345680', 'username80', '80email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (85, 'Acct81', '12345681', 'username81', '81email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (86, 'Acct82', '12345682', 'username82', '82email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (87, 'Acct83', '12345683', 'username83_modify', '', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (88, 'Acct84', '12345684', 'username84', '84email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (89, 'Acct85', '12345685', 'username85', '85email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (90, 'Acct86', '12345686', 'username86', '86email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (91, 'Acct87', '12345687', 'username87', '87email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (92, 'Acct88', '12345688', 'username88', '88email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (93, 'Acct89', '12345689', 'username89', '89email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (94, 'Acct90', '12345690', 'username90', '90email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (95, 'Acct91', '12345691', 'username91', '91email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (96, 'Acct92', '12345692', 'username92', '92email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (97, 'Acct93', '12345693', 'username93', '93email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (98, 'Acct94', '12345694', 'username94', '94email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (99, 'Acct95', '12345695', 'username95', '95email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (100, 'Acct96', '12345696', 'username96', '96email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (101, 'Acct97', '12345697', 'username97', '97email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (102, 'Acct98', '12345698', 'username98', '98email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (103, 'Acct99', '12345699', 'username99', '99email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (104, 'Acct100', '123456100', 'username100', '100email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (105, 'Acct101', '123456101', 'username101', '101email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (106, 'Acct102', '123456102', 'username102', '102email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (107, 'Acct103', '123456103', 'username103', '103email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (108, 'Acct104', '123456104', 'username104', '104email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (109, 'Acct105', '123456105', 'username105', '105email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (110, 'Acct106', '123456106', 'username106', '106email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (111, 'Acct107', '123456107', 'username107', '107email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (112, 'Acct108', '123456108', 'username108', '108email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (113, 'Acct109', '123456109', 'username109', '109email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (114, 'Acct110', '123456110', 'username110', '110email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (115, 'Acct111', '123456111', 'username111', '111email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (116, 'Acct112', '123456112', 'username112', '112email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (117, 'Acct113', '123456113', 'username113', '113email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (118, 'Acct114', '123456114', 'username114', '114email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (119, 'Acct115', '123456115', 'username115', '115email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (120, 'Acct116', '123456116', 'username116', '116email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (121, 'Acct117', '123456117', 'username117', '117email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (122, 'Acct118', '123456118', 'username118', '118email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (123, 'Acct119', '123456119', 'username119', '119email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (124, 'Acct120', '123456120', 'username120', '120email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (125, 'Acct121', '123456121', 'username121', '121email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (126, 'Acct122', '123456122', 'username122', '122email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (127, 'Acct123', '123456123', 'username123', '123email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (128, 'Acct124', '123456124', 'username124', '124email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (129, 'Acct125', '123456125', 'username125', '125email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (130, 'Acct126', '123456126', 'username126', '126email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (131, 'Acct127', '123456127', 'username127', '127email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (132, 'Acct128', '123456128', 'username128', '128email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (133, 'Acct129', '123456129', 'username129', '129email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (134, 'Acct130', '123456130', 'username130', '130email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (135, 'Acct131', '123456131', 'username131', '131email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (136, 'Acct132', '123456132', 'username132', '132email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (137, 'Acct133', '123456133', 'username133', '133email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (138, 'Acct134', '123456134', 'username134', '134email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (139, 'Acct135', '123456135', 'username135', '135email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (140, 'Acct136', '123456136', 'username136', '136email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (141, 'Acct137', '123456137', 'username137', '137email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (142, 'Acct138', '123456138', 'username138', '138email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (143, 'Acct139', '123456139', 'username139', '139email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (144, 'Acct140', '123456140', 'username140', '140email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (145, 'Acct141', '123456141', 'username141', '141email@gmail.com', '2020-04-22 10:08:08');
INSERT INTO `t_admin` VALUES (146, 'Acct142', '123456142', 'username142', '142email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (147, 'Acct143', '123456143', 'username143', '143email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (148, 'Acct144', '123456144', 'username144', '144email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (149, 'Acct145', '123456145', 'username145', '145email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (150, 'Acct146', '123456146', 'username146', '146email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (151, 'Acct147', '123456147', 'username147', '147email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (152, 'Acct148', '123456148', 'username148', '148email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (153, 'Acct149', '123456149', 'username149', '149email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (154, 'Acct150', '123456150', 'username150', '150email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (155, 'Acct151', '123456151', 'username151', '151email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (156, 'Acct152', '123456152', 'username152', '152email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (157, 'Acct153', '123456153', 'username153', '153email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (158, 'Acct154', '123456154', 'username154', '154email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (159, 'Acct155', '123456155', 'username155', '155email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (160, 'Acct156', '123456156', 'username156', '156email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (161, 'Acct157', '123456157', 'username157', '157email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (162, 'Acct158', '123456158', 'username158', '158email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (163, 'Acct159', '123456159', 'username159', '159email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (164, 'Acct160', '123456160', 'username160', '160email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (165, 'Acct161', '123456161', 'username161', '161email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (166, 'Acct162', '123456162', 'username162', '162email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (167, 'Acct163', '123456163', 'username163', '163email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (168, 'Acct164', '123456164', 'username164', '164email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (169, 'Acct165', '123456165', 'username165', '165email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (170, 'Acct166', '123456166', 'username166', '166email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (171, 'Acct167', '123456167', 'username167', '167email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (172, 'Acct168', '123456168', 'username168', '168email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (173, 'Acct169', '123456169', 'username169', '169email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (174, 'Acct170', '123456170', 'username170', '170email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (175, 'Acct171', '123456171', 'username171', '171email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (176, 'Acct172', '123456172', 'username172', '172email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (177, 'Acct173', '123456173', 'username173', '173email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (178, 'Acct174', '123456174', 'username174', '174email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (179, 'Acct175', '123456175', 'username175', '175email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (180, 'Acct176', '123456176', 'username176', '176email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (181, 'Acct177', '123456177', 'username177', '177email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (182, 'Acct178', '123456178', 'username178', '178email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (183, 'Acct179', '123456179', 'username179', '179email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (184, 'Acct180', '123456180', 'username180', '180email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (185, 'Acct181', '123456181', 'username181', '181email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (186, 'Acct182', '123456182', 'username182', '182email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (187, 'Acct183', '123456183', 'username183', '183email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (188, 'Acct184', '123456184', 'username184', '184email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (189, 'Acct185', '123456185', 'username185', '185email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (190, 'Acct186', '123456186', 'username186', '186email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (191, 'Acct187', '123456187', 'username187', '187email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (192, 'Acct188', '123456188', 'username188', '188email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (193, 'Acct189', '123456189', 'username189', '189email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (194, 'Acct190', '123456190', 'username190', '190email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (195, 'Acct191', '123456191', 'username191', '191email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (196, 'Acct192', '123456192', 'username192', '192email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (197, 'Acct193', '123456193', 'username193', '193email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (198, 'Acct194', '123456194', 'username194', '194email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (199, 'Acct195', '123456195', 'username195', '195email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (200, 'Acct196', '123456196', 'username196', '196email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (201, 'Acct197', '123456197', 'username197', '197email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (202, 'Acct198', '123456198', 'username198', '198email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (203, 'Acct199', '123456199', 'username199', '199email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (204, 'Acct200', '123456200', 'username200', '200email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (205, 'Acct201', '123456201', 'username201', '201email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (206, 'Acct202', '123456202', 'username202', '202email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (207, 'Acct203', '123456203', 'username203', '203email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (208, 'Acct204', '123456204', 'username204', '204email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (209, 'Acct205', '123456205', 'username205', '205email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (210, 'Acct206', '123456206', 'username206', '206email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (211, 'Acct207', '123456207', 'username207', '207email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (212, 'Acct208', '123456208', 'username208', '208email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (213, 'Acct209', '123456209', 'username209', '209email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (214, 'Acct210', '123456210', 'username210', '210email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (215, 'Acct211', '123456211', 'username211', '211email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (216, 'Acct212', '123456212', 'username212', '212email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (217, 'Acct213', '123456213', 'username213', '213email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (218, 'Acct214', '123456214', 'username214', '214email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (219, 'Acct215', '123456215', 'username215', '215email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (220, 'Acct216', '123456216', 'username216', '216email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (221, 'Acct217', '123456217', 'username217', '217email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (222, 'Acct218', '123456218', 'username218', '218email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (223, 'Acct219', '123456219', 'username219', '219email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (224, 'Acct220', '123456220', 'username220', '220email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (225, 'Acct221', '123456221', 'username221', '221email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (226, 'Acct222', '123456222', 'username222', '222email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (227, 'Acct223', '123456223', 'username223', '223email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (228, 'Acct224', '123456224', 'username224', '224email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (229, 'Acct225', '123456225', 'username225', '225email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (230, 'Acct226', '123456226', 'username226', '226email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (231, 'Acct227', '123456227', 'username227', '227email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (232, 'Acct228', '123456228', 'username228', '228email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (233, 'Acct229', '123456229', 'username229', '229email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (234, 'Acct230', '123456230', 'username230', '230email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (235, 'Acct231', '123456231', 'username231', '231email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (236, 'Acct232', '123456232', 'username232', '232email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (237, 'Acct233', '123456233', 'username233', '233email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (238, 'Acct234', '123456234', 'username234', '234email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (239, 'Acct235', '123456235', 'username235', '235email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (240, 'Acct236', '123456236', 'username236', '236email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (241, 'Acct237', '123456237', 'username237', '237email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (242, 'Acct238', '123456238', 'username238', '238email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (243, 'Acct239', '123456239', 'username239', '239email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (244, 'Acct240', '123456240', 'username240', '240email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (245, 'Acct241', '123456241', 'username241', '241email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (246, 'Acct242', '123456242', 'username242', '242email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (247, 'Acct243', '123456243', 'username243', '243email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (248, 'Acct244', '123456244', 'username244', '244email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (249, 'Acct245', '123456245', 'username245', '245email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (250, 'Acct246', '123456246', 'username246', '246email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (251, 'Acct247', '123456247', 'username247', '247email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (252, 'Acct248', '123456248', 'username248', '248email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (253, 'Acct249', '123456249', 'username249', '249email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (254, 'Acct250', '123456250', 'username250', '250email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (255, 'Acct251', '123456251', 'username251', '251email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (256, 'Acct252', '123456252', 'username252', '252email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (257, 'Acct253', '123456253', 'username253', '253email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (258, 'Acct254', '123456254', 'username254', '254email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (259, 'Acct255', '123456255', 'username255', '255email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (260, 'Acct256', '123456256', 'username256', '256email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (261, 'Acct257', '123456257', 'username257', '257email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (262, 'Acct258', '123456258', 'username258', '258email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (263, 'Acct259', '123456259', 'username259', '259email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (264, 'Acct260', '123456260', 'username260', '260email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (265, 'Acct261', '123456261', 'username261', '261email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (266, 'Acct262', '123456262', 'username262', '262email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (267, 'Acct263', '123456263', 'username263', '263email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (268, 'Acct264', '123456264', 'username264', '264email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (269, 'Acct265', '123456265', 'username265', '265email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (270, 'Acct266', '123456266', 'username266', '266email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (271, 'Acct267', '123456267', 'username267', '267email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (272, 'Acct268', '123456268', 'username268', '268email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (273, 'Acct269', '123456269', 'username269', '269email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (274, 'Acct270', '123456270', 'username270', '270email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (275, 'Acct271', '123456271', 'username271', '271email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (276, 'Acct272', '123456272', 'username272', '272email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (277, 'Acct273', '123456273', 'username273', '273email@gmail.com', '2020-04-22 10:08:09');
INSERT INTO `t_admin` VALUES (278, 'test_add', '1aa5a57473c7e59677b298d654f88e35', 'test_add', 'zyc199777@gmail.com', '2020-04-22 16:05:40');

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (35, 'asd');
INSERT INTO `t_role` VALUES (44, 'asd1');
INSERT INTO `t_role` VALUES (10, 'TEST_ADD_10');
INSERT INTO `t_role` VALUES (11, 'TEST_ADD_11');
INSERT INTO `t_role` VALUES (12, 'TEST_ADD_12');
INSERT INTO `t_role` VALUES (13, 'TEST_ADD_13');
INSERT INTO `t_role` VALUES (14, 'TEST_ADD_14');
INSERT INTO `t_role` VALUES (15, 'TEST_ADD_15');
INSERT INTO `t_role` VALUES (16, 'TEST_ADD_16');
INSERT INTO `t_role` VALUES (17, 'TEST_ADD_17');
INSERT INTO `t_role` VALUES (18, 'TEST_ADD_18');
INSERT INTO `t_role` VALUES (19, 'TEST_ADD_19');
INSERT INTO `t_role` VALUES (2, 'TEST_ADD_2');
INSERT INTO `t_role` VALUES (20, 'TEST_ADD_20');
INSERT INTO `t_role` VALUES (21, 'TEST_ADD_21');
INSERT INTO `t_role` VALUES (22, 'TEST_ADD_22');
INSERT INTO `t_role` VALUES (23, 'TEST_ADD_23');
INSERT INTO `t_role` VALUES (24, 'TEST_ADD_24');
INSERT INTO `t_role` VALUES (25, 'TEST_ADD_25');
INSERT INTO `t_role` VALUES (26, 'TEST_ADD_26');
INSERT INTO `t_role` VALUES (27, 'TEST_ADD_27');
INSERT INTO `t_role` VALUES (3, 'TEST_ADD_3');
INSERT INTO `t_role` VALUES (4, 'TEST_ADD_4');
INSERT INTO `t_role` VALUES (5, 'TEST_ADD_5');
INSERT INTO `t_role` VALUES (6, 'TEST_ADD_6');
INSERT INTO `t_role` VALUES (7, 'TEST_ADD_7');
INSERT INTO `t_role` VALUES (8, 'TEST_ADD_8');
INSERT INTO `t_role` VALUES (9, 'TEST_ADD_9');

SET FOREIGN_KEY_CHECKS = 1;
