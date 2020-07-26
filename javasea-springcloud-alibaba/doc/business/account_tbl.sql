/*
Navicat MariaDB Data Transfer

Source Server         : 36
Source Server Version : 100322
Source Host           : 192.168.0.36:3308
Source Database       : db_account

Target Server Type    : MariaDB
Target Server Version : 100322
File Encoding         : 65001

Date: 2020-05-14 13:01:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_tbl
-- ----------------------------
DROP TABLE IF EXISTS `account_tbl`;
CREATE TABLE `account_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `money` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of account_tbl
-- ----------------------------
INSERT INTO `account_tbl` VALUES ('1', '1001', '1000');
INSERT INTO `account_tbl` VALUES ('2', '1002', '2000');
