/*
Navicat MariaDB Data Transfer

Source Server         : 36
Source Server Version : 100322
Source Host           : 192.168.0.36:3308
Source Database       : db_order

Target Server Type    : MariaDB
Target Server Version : 100322
File Encoding         : 65001

Date: 2020-05-14 13:01:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_tbl
-- ----------------------------
DROP TABLE IF EXISTS `order_tbl`;
CREATE TABLE `order_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `commodity_code` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT 0,
  `money` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4;



