/*
Navicat MySQL Data Transfer

Source Server         : 115.159.31.229
Source Server Version : 50720
Source Host           : 115.159.31.229:3306
Source Database       : cloud_mall

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-01 20:47:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------

-- ----------------------------
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info (
  ID varchar(64) NOT NULL,
  USER_NAME varchar(50) DEFAULT NULL,
  PASSWORD varchar(200) DEFAULT NULL,
  NAME varchar(25) DEFAULT NULL COMMENT '姓名',
  SEX varchar(1) DEFAULT '1' COMMENT '0:女',
  STATUS char(2) DEFAULT '00' COMMENT '00-正常 01-禁用',
  ORG_ID varchar(32) DEFAULT NULL COMMENT '部门ID',
  EMAIL varchar(100) DEFAULT NULL,
  ID_CARD varchar(25) DEFAULT NULL COMMENT '身份证号',
  IS_ADMIN varchar(1) DEFAULT '0' COMMENT '是否是管理员',
  MOBILE varchar(15) DEFAULT NULL,
  LOGIN_TOKEN varchar(64) DEFAULT NULL,
  CREATE_AT datetime DEFAULT NULL,
  UPDATE_AT datetime DEFAULT NULL,
  CREATE_BY varchar(40) DEFAULT 'system',
  UPDATE_BY varchar(40) DEFAULT 'system',
  APP_ID varchar(36) DEFAULT NULL,
  PRIMARY KEY (ID),
  KEY usernameindex (USER_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS role_info;
CREATE TABLE role_info (
  ID varchar(64) NOT NULL,
  ROLE_NAME varchar(100) DEFAULT NULL,
  APP_ID varchar(64) DEFAULT NULL,
  ROLE_TYPE varchar(2) DEFAULT NULL COMMENT '00-管理员  01-普通用户',
  ROLE_DESCRIBE varchar(1000) DEFAULT NULL,
  CREATE_AT datetime DEFAULT NULL COMMENT '创建时间',
  CREATE_BY varchar(40) DEFAULT 'SYSTEM' COMMENT '创建人',
  UPDATE_AT datetime DEFAULT NULL COMMENT '更新时间',
  UPDATE_BY varchar(40) DEFAULT 'SYSTEM' COMMENT '更新人',
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;