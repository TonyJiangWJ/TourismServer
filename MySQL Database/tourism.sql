/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : tourism

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-03-26 10:08:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_password` varchar(32) NOT NULL,
  `_created_time` datetime NOT NULL,
  `_last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`_username`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `t_knowledge`;
CREATE TABLE `t_knowledge` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_nlg_name` varchar(20) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_content` text NOT NULL,
  PRIMARY KEY (`_nlg_name`),
  UNIQUE KEY `_id` (`_id`),
  UNIQUE KEY `_id_2` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_nlg_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_nlg_comment`;
CREATE TABLE `t_nlg_comment` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_nlg_name` varchar(20) NOT NULL,
  `_to_user` varchar(20) NOT NULL,
  UNIQUE KEY `_id` (`_id`),
  KEY `_username` (`_username`),
  KEY `_nlg_name` (`_nlg_name`),
  CONSTRAINT `t_nlg_comment_ibfk_1` FOREIGN KEY (`_username`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_nlg_comment_ibfk_2` FOREIGN KEY (`_nlg_name`) REFERENCES `t_knowledge` (`_nlg_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_plan`;
CREATE TABLE `t_plan` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_pl_name` varchar(20) NOT NULL,
  `_destination` varchar(20) NOT NULL,
  `_price` decimal(10,0) NOT NULL DEFAULT '0',
  `_people_num` int(11) NOT NULL DEFAULT '0',
  `_content` text NOT NULL,
  `_created_time` datetime NOT NULL,
  `_start_time` datetime DEFAULT NULL,
  `_end_time` datetime DEFAULT NULL,
  `_active_time` datetime NOT NULL,
  PRIMARY KEY (`_pl_name`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_tel
-- ----------------------------
DROP TABLE IF EXISTS `t_tel`;
CREATE TABLE `t_tel` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_owner` varchar(20) NOT NULL,
  `_friend_name` varchar(20) NOT NULL,
  UNIQUE KEY `_id` (`_id`),
  KEY `_owner` (`_owner`),
  KEY `_friend_name` (`_friend_name`),
  CONSTRAINT `t_tel_ibfk_1` FOREIGN KEY (`_owner`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_tel_ibfk_2` FOREIGN KEY (`_friend_name`) REFERENCES `t_user` (`_username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_tpc_name` varchar(20) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_content` text NOT NULL,
  `_people_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`_tpc_name`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_topic_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_topic_comment`;
CREATE TABLE `t_topic_comment` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_tpc_name` varchar(20) NOT NULL,
  `_to_user` varchar(20) NOT NULL,
  UNIQUE KEY `_id` (`_id`),
  KEY `_username` (`_username`),
  KEY `_tpc_name` (`_tpc_name`),
  CONSTRAINT `t_topic_comment_ibfk_1` FOREIGN KEY (`_username`) REFERENCES `t_user` (`_username`),
  CONSTRAINT `t_topic_comment_ibfk_2` FOREIGN KEY (`_tpc_name`) REFERENCES `t_topic` (`_tpc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_username` varchar(20) NOT NULL,
  `_password` varchar(32) NOT NULL,
  `_name` varchar(20) DEFAULT NULL,
  `_nickname` varchar(20) NOT NULL,
  `_created_time` datetime NOT NULL,
  `_last_login` datetime DEFAULT NULL,
  `_image` varchar(32) NOT NULL,
  `_sex` varchar(5) DEFAULT NULL,
  `_phone` varchar(11) NOT NULL,
  PRIMARY KEY (`_username`),
  UNIQUE KEY `_id` (`_id`),
  UNIQUE KEY `_phone` (`_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
