/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : ezs_v3

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-03-24 19:46:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ezs_accessory`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_accessory`;
CREATE TABLE `ezs_accessory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `ext` varchar(255) DEFAULT NULL,
  `height` int(11) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` float NOT NULL,
  `width` int(11) NOT NULL,
  `album_id` bigint(20) DEFAULT NULL,
  `config_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKD046F671DFFE5DA7` (`config_id`),
  KEY `FKD046F6716758EBDA` (`user_id`),
  KEY `FKD046F671EDD6555A` (`album_id`),
  KEY `FKD046F67117AB1439` (`config_id`),
  KEY `FKD046F671F734E208` (`user_id`),
  KEY `FKD046F671597924EC` (`album_id`),
  CONSTRAINT `FKD046F671597924EC` FOREIGN KEY (`album_id`) REFERENCES `ezs_album` (`id`),
  CONSTRAINT `FKD046F67117AB1439` FOREIGN KEY (`config_id`) REFERENCES `ezs_sysconfig` (`id`),
  CONSTRAINT `FKD046F6716758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKD046F671DFFE5DA7` FOREIGN KEY (`config_id`) REFERENCES `ezs_sysconfig` (`id`),
  CONSTRAINT `FKD046F671EDD6555A` FOREIGN KEY (`album_id`) REFERENCES `ezs_album` (`id`),
  CONSTRAINT `FKD046F671F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_accessory
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_address`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_address`;
CREATE TABLE `ezs_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `area_info` varchar(255) DEFAULT NULL,
  `bestow` bit(1) DEFAULT b'0',
  `mobile` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `trueName` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKC1F8F1343969C9A` (`area_id`),
  KEY `FKC1F8F136758EBDA` (`user_id`),
  KEY `FKC1F8F13D37292C8` (`area_id`),
  KEY `FKC1F8F13F734E208` (`user_id`),
  CONSTRAINT `FKC1F8F13F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKC1F8F1343969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FKC1F8F136758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKC1F8F13D37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_address
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_album`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_album`;
CREATE TABLE `ezs_album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `alblum_info` longtext,
  `album_default` bit(1) NOT NULL,
  `album_name` varchar(255) DEFAULT NULL,
  `album_sequence` int(11) NOT NULL,
  `album_cover_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6B61AD4E6758EBDA` (`user_id`),
  KEY `FK6B61AD4EC82D6B85` (`album_cover_id`),
  KEY `FK6B61AD4EF734E208` (`user_id`),
  KEY `FK6B61AD4EFFDA2217` (`album_cover_id`),
  CONSTRAINT `FK6B61AD4EFFDA2217` FOREIGN KEY (`album_cover_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6B61AD4E6758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK6B61AD4EC82D6B85` FOREIGN KEY (`album_cover_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6B61AD4EF734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_album
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_area`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_area`;
CREATE TABLE `ezs_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `areaName` varchar(255) DEFAULT NULL,
  `common` bit(1) DEFAULT b'0',
  `level` int(11) NOT NULL,
  `sequence` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKFB34C9CEEB7B935D` (`parent_id`),
  KEY `FKFB34C9CE7B57898B` (`parent_id`),
  CONSTRAINT `FKFB34C9CE7B57898B` FOREIGN KEY (`parent_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FKFB34C9CEEB7B935D` FOREIGN KEY (`parent_id`) REFERENCES `ezs_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_area
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_card_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_card_dict`;
CREATE TABLE `ezs_card_dict` (
  `store_id` bigint(20) NOT NULL,
  `accessory_id` bigint(20) NOT NULL,
  KEY `FK3FB55AE449476E7A` (`accessory_id`),
  KEY `FK3FB55AE4F9DFE81A` (`store_id`),
  KEY `FK3FB55AE480F4250C` (`accessory_id`),
  KEY `FK3FB55AE46582B7AC` (`store_id`),
  CONSTRAINT `FK3FB55AE46582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FK3FB55AE449476E7A` FOREIGN KEY (`accessory_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK3FB55AE480F4250C` FOREIGN KEY (`accessory_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK3FB55AE4F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_card_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_contact`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_contact`;
CREATE TABLE `ezs_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `depart` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK893F173F43969C9A` (`area_id`),
  KEY `FK893F173FD37292C8` (`area_id`),
  CONSTRAINT `FK893F173FD37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK893F173F43969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_customer`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_customer`;
CREATE TABLE `ezs_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `admin_status` int(11) NOT NULL,
  `bill` bit(1) NOT NULL,
  `clean_ability` varchar(255) DEFAULT NULL,
  `clean_num` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `crusher_ability` varchar(255) DEFAULT NULL,
  `crusher_num` varchar(255) DEFAULT NULL,
  `cus_status` int(11) NOT NULL,
  `enable` bit(1) NOT NULL,
  `granulation_ability` varchar(255) DEFAULT NULL,
  `granulation_num` varchar(255) DEFAULT NULL,
  `haveDevice` varchar(255) DEFAULT NULL,
  `hz_truck_ability` varchar(255) DEFAULT NULL,
  `hz_truck_ability1` varchar(255) DEFAULT NULL,
  `hz_truck_lxr` varchar(255) DEFAULT NULL,
  `hz_truck_lxr1` varchar(255) DEFAULT NULL,
  `hz_truck_tel` varchar(255) DEFAULT NULL,
  `hz_truck_tel1` varchar(255) DEFAULT NULL,
  `importDate` datetime DEFAULT NULL,
  `mainDody` int(11) NOT NULL,
  `mianIndustry` varchar(255) DEFAULT NULL,
  `mold_ability` varchar(255) DEFAULT NULL,
  `mold_num` varchar(255) DEFAULT NULL,
  `point` double NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `sewage` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `testDevice` varchar(255) DEFAULT NULL,
  `truck_load` varchar(255) DEFAULT NULL,
  `truck_num` varchar(255) DEFAULT NULL,
  `truck_uninstall` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `level_id` bigint(20) DEFAULT NULL,
  `paper_id` bigint(20) DEFAULT NULL,
  `source_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKE497F09F77BF49DA` (`source_id`),
  KEY `FKE497F09F43969C9A` (`area_id`),
  KEY `FKE497F09FB2B98264` (`paper_id`),
  KEY `FKE497F09FB10A9B5A` (`group_id`),
  KEY `FKE497F09F140EC13A` (`level_id`),
  KEY `FKE497F09F80766C88` (`source_id`),
  KEY `FKE497F09FD37292C8` (`area_id`),
  KEY `FKE497F09F42957892` (`paper_id`),
  KEY `FKE497F09F1CAD6AEC` (`group_id`),
  KEY `FKE497F09F7FB190CC` (`level_id`),
  CONSTRAINT `FKE497F09F7FB190CC` FOREIGN KEY (`level_id`) REFERENCES `ezs_level` (`id`),
  CONSTRAINT `FKE497F09F140EC13A` FOREIGN KEY (`level_id`) REFERENCES `ezs_level` (`id`),
  CONSTRAINT `FKE497F09F1CAD6AEC` FOREIGN KEY (`group_id`) REFERENCES `ezs_group` (`id`),
  CONSTRAINT `FKE497F09F42957892` FOREIGN KEY (`paper_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKE497F09F43969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FKE497F09F77BF49DA` FOREIGN KEY (`source_id`) REFERENCES `ezs_source` (`id`),
  CONSTRAINT `FKE497F09F80766C88` FOREIGN KEY (`source_id`) REFERENCES `ezs_source` (`id`),
  CONSTRAINT `FKE497F09FB10A9B5A` FOREIGN KEY (`group_id`) REFERENCES `ezs_group` (`id`),
  CONSTRAINT `FKE497F09FB2B98264` FOREIGN KEY (`paper_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKE497F09FD37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_customer_paper`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_customer_paper`;
CREATE TABLE `ezs_customer_paper` (
  `cus_id` bigint(20) NOT NULL,
  `paper_id` bigint(20) NOT NULL,
  KEY `FK325731ECF5C5CDB7` (`cus_id`),
  KEY `FK325731ECD5F6A43A` (`paper_id`),
  KEY `FK325731ECAD3EFCE5` (`cus_id`),
  KEY `FK325731EC419973CC` (`paper_id`),
  CONSTRAINT `FK325731EC419973CC` FOREIGN KEY (`paper_id`) REFERENCES `ezs_paper` (`id`),
  CONSTRAINT `FK325731ECAD3EFCE5` FOREIGN KEY (`cus_id`) REFERENCES `ezs_customer` (`id`),
  CONSTRAINT `FK325731ECD5F6A43A` FOREIGN KEY (`paper_id`) REFERENCES `ezs_paper` (`id`),
  CONSTRAINT `FK325731ECF5C5CDB7` FOREIGN KEY (`cus_id`) REFERENCES `ezs_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_customer_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_depart`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_depart`;
CREATE TABLE `ezs_depart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK595F4F53E398AC4` (`parent_id`),
  KEY `FK595F4F5F9DFE81A` (`store_id`),
  KEY `FK595F4F546F0AD72` (`parent_id`),
  KEY `FK595F4F56582B7AC` (`store_id`),
  CONSTRAINT `FK595F4F56582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FK595F4F53E398AC4` FOREIGN KEY (`parent_id`) REFERENCES `ezs_depart` (`id`),
  CONSTRAINT `FK595F4F546F0AD72` FOREIGN KEY (`parent_id`) REFERENCES `ezs_depart` (`id`),
  CONSTRAINT `FK595F4F5F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_depart
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_dict`;
CREATE TABLE `ezs_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKFB3604F7EB7CCE86` (`parent_id`),
  KEY `FKFB3604F77B58C4B4` (`parent_id`),
  CONSTRAINT `FKFB3604F77B58C4B4` FOREIGN KEY (`parent_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKFB3604F7EB7CCE86` FOREIGN KEY (`parent_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_goods`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goods`;
CREATE TABLE `ezs_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `addess` varchar(255) DEFAULT NULL,
  `ash` varchar(255) DEFAULT NULL,
  `bending` varchar(255) DEFAULT NULL,
  `burning` varchar(255) DEFAULT NULL,
  `cantilever` varchar(255) DEFAULT NULL,
  `click` int(11) NOT NULL,
  `cncl_num` double NOT NULL,
  `collect` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `crack` varchar(255) DEFAULT NULL,
  `density` varchar(255) DEFAULT NULL,
  `flexural` varchar(255) DEFAULT NULL,
  `freely` varchar(255) DEFAULT NULL,
  `good_no` varchar(255) DEFAULT NULL,
  `goods_salenum` int(11) NOT NULL,
  `inventory` double NOT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `lipolysis` varchar(255) DEFAULT NULL,
  `memberLook` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `protection` bit(1) NOT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `recommend` bit(1) NOT NULL,
  `recommend_time` datetime DEFAULT NULL,
  `seo_description` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `tensile` varchar(255) DEFAULT NULL,
  `validity` int(11) NOT NULL,
  `water` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `color_id` bigint(20) DEFAULT NULL,
  `form_id` bigint(20) DEFAULT NULL,
  `goodClass_id` bigint(20) DEFAULT NULL,
  `goods_main_photo_id` bigint(20) DEFAULT NULL,
  `logistics_id` bigint(20) DEFAULT NULL,
  `quality_id` bigint(20) DEFAULT NULL,
  `region_id` bigint(20) DEFAULT NULL,
  `supply_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `util_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6BB7C63543969C9A` (`area_id`),
  KEY `FK6BB7C635B31F187D` (`logistics_id`),
  KEY `FK6BB7C6351CD911F7` (`goods_main_photo_id`),
  KEY `FK6BB7C63560A50B5A` (`quality_id`),
  KEY `FK6BB7C63547B51C2C` (`form_id`),
  KEY `FK6BB7C635693B882E` (`util_id`),
  KEY `FK6BB7C6356758EBDA` (`user_id`),
  KEY `FK6BB7C63517B67DBA` (`goodClass_id`),
  KEY `FK6BB7C635748358D3` (`region_id`),
  KEY `FK6BB7C6354A9B012D` (`color_id`),
  KEY `FK6BB7C6356EC08C21` (`supply_id`),
  KEY `FK6BB7C635D37292C8` (`area_id`),
  KEY `FK6BB7C63542FB0EAB` (`logistics_id`),
  KEY `FK6BB7C6355485C889` (`goods_main_photo_id`),
  KEY `FK6BB7C6356ED23E6C` (`quality_id`),
  KEY `FK6BB7C635D791125A` (`form_id`),
  KEY `FK6BB7C635F9177E5C` (`util_id`),
  KEY `FK6BB7C635F734E208` (`user_id`),
  KEY `FK6BB7C6354F63344C` (`goodClass_id`),
  KEY `FK6BB7C63545F4F01` (`region_id`),
  KEY `FK6BB7C635DA76F75B` (`color_id`),
  KEY `FK6BB7C635FE9C824F` (`supply_id`),
  CONSTRAINT `FK6BB7C635FE9C824F` FOREIGN KEY (`supply_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C63517B67DBA` FOREIGN KEY (`goodClass_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK6BB7C6351CD911F7` FOREIGN KEY (`goods_main_photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6BB7C63542FB0EAB` FOREIGN KEY (`logistics_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C63543969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6BB7C63545F4F01` FOREIGN KEY (`region_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6BB7C63547B51C2C` FOREIGN KEY (`form_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C6354A9B012D` FOREIGN KEY (`color_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C6354F63344C` FOREIGN KEY (`goodClass_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK6BB7C6355485C889` FOREIGN KEY (`goods_main_photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6BB7C63560A50B5A` FOREIGN KEY (`quality_id`) REFERENCES `ezs_quality` (`id`),
  CONSTRAINT `FK6BB7C6356758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK6BB7C635693B882E` FOREIGN KEY (`util_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C6356EC08C21` FOREIGN KEY (`supply_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C6356ED23E6C` FOREIGN KEY (`quality_id`) REFERENCES `ezs_quality` (`id`),
  CONSTRAINT `FK6BB7C635748358D3` FOREIGN KEY (`region_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6BB7C635B31F187D` FOREIGN KEY (`logistics_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C635D37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6BB7C635D791125A` FOREIGN KEY (`form_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C635DA76F75B` FOREIGN KEY (`color_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6BB7C635F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK6BB7C635F9177E5C` FOREIGN KEY (`util_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_goodscart`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goodscart`;
CREATE TABLE `ezs_goodscart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `cart_type` varchar(255) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `of_id` bigint(20) DEFAULT NULL,
  `sc_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKA17E1ED5116857FA` (`goods_id`),
  KEY `FKA17E1ED58B08BF0B` (`sc_id`),
  KEY `FKA17E1ED5EA2DFB5` (`of_id`),
  KEY `FKA17E1ED57D0B278C` (`goods_id`),
  KEY `FKA17E1ED5C2B5759D` (`sc_id`),
  KEY `FKA17E1ED5464F9647` (`of_id`),
  CONSTRAINT `FKA17E1ED5464F9647` FOREIGN KEY (`of_id`) REFERENCES `ezs_orderform` (`id`),
  CONSTRAINT `FKA17E1ED5116857FA` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`),
  CONSTRAINT `FKA17E1ED57D0B278C` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`),
  CONSTRAINT `FKA17E1ED58B08BF0B` FOREIGN KEY (`sc_id`) REFERENCES `ezs_storecart` (`id`),
  CONSTRAINT `FKA17E1ED5C2B5759D` FOREIGN KEY (`sc_id`) REFERENCES `ezs_storecart` (`id`),
  CONSTRAINT `FKA17E1ED5EA2DFB5` FOREIGN KEY (`of_id`) REFERENCES `ezs_orderform` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goodscart
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_goods_class`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goods_class`;
CREATE TABLE `ezs_goods_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK33B796EEEBA1058B` (`parent_id`),
  KEY `FK33B796EE55AFAB5A` (`photo_id`),
  KEY `FK33B796EE234DBC1D` (`parent_id`),
  KEY `FK33B796EE8D5C61EC` (`photo_id`),
  CONSTRAINT `FK33B796EE8D5C61EC` FOREIGN KEY (`photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK33B796EE234DBC1D` FOREIGN KEY (`parent_id`) REFERENCES `ezs_goods_class` (`id`),
  CONSTRAINT `FK33B796EE55AFAB5A` FOREIGN KEY (`photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK33B796EEEBA1058B` FOREIGN KEY (`parent_id`) REFERENCES `ezs_goods_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goods_class
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_goods_photo`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_goods_photo`;
CREATE TABLE `ezs_goods_photo` (
  `goods_id` bigint(20) NOT NULL,
  `photo_id` bigint(20) NOT NULL,
  KEY `FK346D2BA8116857FA` (`goods_id`),
  KEY `FK346D2BA855AFAB5A` (`photo_id`),
  KEY `FK346D2BA87D0B278C` (`goods_id`),
  KEY `FK346D2BA88D5C61EC` (`photo_id`),
  CONSTRAINT `FK346D2BA88D5C61EC` FOREIGN KEY (`photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK346D2BA8116857FA` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`),
  CONSTRAINT `FK346D2BA855AFAB5A` FOREIGN KEY (`photo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK346D2BA87D0B278C` FOREIGN KEY (`goods_id`) REFERENCES `ezs_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_goods_photo
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_group`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_group`;
CREATE TABLE `ezs_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `cus_status` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_group
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_idcard_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_idcard_dict`;
CREATE TABLE `ezs_idcard_dict` (
  `store_id` bigint(20) NOT NULL,
  `accessory_id` bigint(20) NOT NULL,
  KEY `FK86E6806949476E7A` (`accessory_id`),
  KEY `FK86E68069F9DFE81A` (`store_id`),
  KEY `FK86E6806980F4250C` (`accessory_id`),
  KEY `FK86E680696582B7AC` (`store_id`),
  CONSTRAINT `FK86E680696582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FK86E6806949476E7A` FOREIGN KEY (`accessory_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK86E6806980F4250C` FOREIGN KEY (`accessory_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK86E68069F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_idcard_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_invoice`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_invoice`;
CREATE TABLE `ezs_invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `express_name` varchar(255) DEFAULT NULL,
  `express_no` varchar(255) DEFAULT NULL,
  `express_time` datetime DEFAULT NULL,
  `invoice_status` int(11) NOT NULL,
  `receipt_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKC55E364CADCEB194` (`receipt_id`),
  KEY `FKC55E364C6758EBDA` (`user_id`),
  KEY `FKC55E364CE57B6826` (`receipt_id`),
  KEY `FKC55E364CF734E208` (`user_id`),
  CONSTRAINT `FKC55E364CF734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKC55E364C6758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKC55E364CADCEB194` FOREIGN KEY (`receipt_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FKC55E364CE57B6826` FOREIGN KEY (`receipt_id`) REFERENCES `ezs_accessory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_invoice
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_level`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_level`;
CREATE TABLE `ezs_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `enable` bit(1) NOT NULL,
  `initial` bit(1) NOT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `cus_status_id` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6A36DA433F8AC1C0` (`cus_status_id`),
  KEY `FK6A36DA43756C2C39` (`grade_id`),
  KEY `FK6A36DA43CF66B7EE` (`cus_status_id`),
  KEY `FK6A36DA435482267` (`grade_id`),
  CONSTRAINT `FK6A36DA435482267` FOREIGN KEY (`grade_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6A36DA433F8AC1C0` FOREIGN KEY (`cus_status_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6A36DA43756C2C39` FOREIGN KEY (`grade_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6A36DA43CF66B7EE` FOREIGN KEY (`cus_status_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_level
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_logistics`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_logistics`;
CREATE TABLE `ezs_logistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `car_no` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `logistics_name` varchar(255) DEFAULT NULL,
  `logistics_no` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `proples` varchar(255) DEFAULT NULL,
  `service_time` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `total_price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_logistics
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_orderform`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_orderform`;
CREATE TABLE `ezs_orderform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `cart_session_id` varchar(255) DEFAULT NULL,
  `end_price` decimal(19,2) DEFAULT NULL,
  `finishtime` datetime DEFAULT NULL,
  `first_price` decimal(19,2) DEFAULT NULL,
  `goods_amount` decimal(12,2) DEFAULT NULL,
  `msg` longtext,
  `order_no` varchar(255) DEFAULT NULL,
  `order_status` int(11) NOT NULL,
  `order_type` varchar(255) DEFAULT NULL,
  `pact_no` varchar(255) DEFAULT NULL,
  `pact_status` int(11) NOT NULL,
  `pay_mode` int(11) NOT NULL,
  `sc_status` int(11) DEFAULT '0',
  `total_price` decimal(19,2) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `bill_id` bigint(20) DEFAULT NULL,
  `invoice_id` bigint(20) DEFAULT NULL,
  `logistics_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK3708E471FC9802DA` (`logistics_id`),
  KEY `FK3708E47121B2B49A` (`invoice_id`),
  KEY `FK3708E471466E2B3A` (`address_id`),
  KEY `FK3708E4716758EBDA` (`user_id`),
  KEY `FK3708E4719B177965` (`bill_id`),
  KEY `FK3708E4713444B96C` (`logistics_id`),
  KEY `FK3708E4712FDFE7AC` (`invoice_id`),
  KEY `FK3708E471549B5E4C` (`address_id`),
  KEY `FK3708E471F734E208` (`user_id`),
  KEY `FK3708E471D2C42FF7` (`bill_id`),
  CONSTRAINT `FK3708E471D2C42FF7` FOREIGN KEY (`bill_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK3708E47121B2B49A` FOREIGN KEY (`invoice_id`) REFERENCES `ezs_invoice` (`id`),
  CONSTRAINT `FK3708E4712FDFE7AC` FOREIGN KEY (`invoice_id`) REFERENCES `ezs_invoice` (`id`),
  CONSTRAINT `FK3708E4713444B96C` FOREIGN KEY (`logistics_id`) REFERENCES `ezs_logistics` (`id`),
  CONSTRAINT `FK3708E471466E2B3A` FOREIGN KEY (`address_id`) REFERENCES `ezs_address` (`id`),
  CONSTRAINT `FK3708E471549B5E4C` FOREIGN KEY (`address_id`) REFERENCES `ezs_address` (`id`),
  CONSTRAINT `FK3708E4716758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK3708E4719B177965` FOREIGN KEY (`bill_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK3708E471F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK3708E471FC9802DA` FOREIGN KEY (`logistics_id`) REFERENCES `ezs_logistics` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_orderform
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_order_pact`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_order_pact`;
CREATE TABLE `ezs_order_pact` (
  `order_id` bigint(20) NOT NULL,
  `pact_id` bigint(20) NOT NULL,
  KEY `FKA9B138F451E8DEDE` (`order_id`),
  KEY `FKA9B138F4718CC16A` (`pact_id`),
  KEY `FKA9B138F489959570` (`order_id`),
  KEY `FKA9B138F4A93977FC` (`pact_id`),
  CONSTRAINT `FKA9B138F4A93977FC` FOREIGN KEY (`pact_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FKA9B138F451E8DEDE` FOREIGN KEY (`order_id`) REFERENCES `ezs_orderform` (`id`),
  CONSTRAINT `FKA9B138F4718CC16A` FOREIGN KEY (`pact_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FKA9B138F489959570` FOREIGN KEY (`order_id`) REFERENCES `ezs_orderform` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_order_pact
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_paper`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_paper`;
CREATE TABLE `ezs_paper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `validDate` datetime DEFAULT NULL,
  `certificate_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6C30406BFAB6B1D5` (`certificate_id`),
  KEY `FK6C30406B32636867` (`certificate_id`),
  CONSTRAINT `FK6C30406B32636867` FOREIGN KEY (`certificate_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK6C30406BFAB6B1D5` FOREIGN KEY (`certificate_id`) REFERENCES `ezs_accessory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_position`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_position`;
CREATE TABLE `ezs_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKED0909EAF9DFE81A` (`store_id`),
  KEY `FKED0909EA6582B7AC` (`store_id`),
  CONSTRAINT `FKED0909EA6582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FKED0909EAF9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_position
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_quality`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_quality`;
CREATE TABLE `ezs_quality` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `quality_no` varchar(255) DEFAULT NULL,
  `report` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_quality
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_readjust`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_readjust`;
CREATE TABLE `ezs_readjust` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `cause_id` bigint(20) DEFAULT NULL,
  `orderForm_id` bigint(20) DEFAULT NULL,
  `proof_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK8CCB04437591D667` (`cause_id`),
  KEY `FK8CCB044366636F08` (`proof_id`),
  KEY `FK8CCB0443B1CA229A` (`orderForm_id`),
  KEY `FK8CCB044356DCC95` (`cause_id`),
  KEY `FK8CCB04439E10259A` (`proof_id`),
  KEY `FK8CCB0443E976D92C` (`orderForm_id`),
  CONSTRAINT `FK8CCB0443E976D92C` FOREIGN KEY (`orderForm_id`) REFERENCES `ezs_orderform` (`id`),
  CONSTRAINT `FK8CCB044356DCC95` FOREIGN KEY (`cause_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK8CCB044366636F08` FOREIGN KEY (`proof_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK8CCB04437591D667` FOREIGN KEY (`cause_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK8CCB04439E10259A` FOREIGN KEY (`proof_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK8CCB0443B1CA229A` FOREIGN KEY (`orderForm_id`) REFERENCES `ezs_orderform` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_readjust
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_res`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_res`;
CREATE TABLE `ezs_res` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `resName` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_res
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_role`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_role`;
CREATE TABLE `ezs_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `display` bit(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `roleCode` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `roleGroup_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKFB3C79B7DAD7AEFA` (`roleGroup_id`),
  KEY `FKFB3C79B71284658C` (`roleGroup_id`),
  CONSTRAINT `FKFB3C79B71284658C` FOREIGN KEY (`roleGroup_id`) REFERENCES `ezs_role_group` (`id`),
  CONSTRAINT `FKFB3C79B7DAD7AEFA` FOREIGN KEY (`roleGroup_id`) REFERENCES `ezs_role_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_role
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_role_group`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_role_group`;
CREATE TABLE `ezs_role_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_role_group
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_role_res`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_role_res`;
CREATE TABLE `ezs_role_res` (
  `role_id` bigint(20) NOT NULL,
  `res_id` bigint(20) NOT NULL,
  KEY `FKB097AE18163DDBBA` (`res_id`),
  KEY `FKB097AE18C22E27FA` (`role_id`),
  KEY `FKB097AE18E11367CC` (`res_id`),
  KEY `FKB097AE18520A1E28` (`role_id`),
  CONSTRAINT `FKB097AE18520A1E28` FOREIGN KEY (`role_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FKB097AE18163DDBBA` FOREIGN KEY (`res_id`) REFERENCES `ezs_res` (`id`),
  CONSTRAINT `FKB097AE18C22E27FA` FOREIGN KEY (`role_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FKB097AE18E11367CC` FOREIGN KEY (`res_id`) REFERENCES `ezs_res` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_role_res
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_source`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_source`;
CREATE TABLE `ezs_source` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `enable` bit(1) NOT NULL,
  `identifying` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_source
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_store`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_store`;
CREATE TABLE `ezs_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `assets` double NOT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `covered` double NOT NULL,
  `device_num` int(11) NOT NULL,
  `employee_num` int(11) NOT NULL,
  `fixed_assets` double NOT NULL,
  `location` tinyblob,
  `location_detail` varchar(255) DEFAULT NULL,
  `obtainYear` int(11) NOT NULL,
  `openBankNo` varchar(255) DEFAULT NULL,
  `open_bank_name` varchar(255) DEFAULT NULL,
  `open_branch_name` varchar(255) DEFAULT NULL,
  `open_branch_no` varchar(255) DEFAULT NULL,
  `registerDate` datetime DEFAULT NULL,
  `rent` bit(1) NOT NULL,
  `status` int(11) NOT NULL,
  `yTurnover` double NOT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `cardType_id` bigint(20) DEFAULT NULL,
  `mianIndustry_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK6C6327C043969C9A` (`area_id`),
  KEY `FK6C6327C02530E69` (`mianIndustry_id`),
  KEY `FK6C6327C0FBF0F0E6` (`cardType_id`),
  KEY `FK6C6327C0D37292C8` (`area_id`),
  KEY `FK6C6327C0922F0497` (`mianIndustry_id`),
  KEY `FK6C6327C08BCCE714` (`cardType_id`),
  CONSTRAINT `FK6C6327C08BCCE714` FOREIGN KEY (`cardType_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6C6327C02530E69` FOREIGN KEY (`mianIndustry_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6C6327C043969C9A` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6C6327C0922F0497` FOREIGN KEY (`mianIndustry_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FK6C6327C0D37292C8` FOREIGN KEY (`area_id`) REFERENCES `ezs_area` (`id`),
  CONSTRAINT `FK6C6327C0FBF0F0E6` FOREIGN KEY (`cardType_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_store
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_storecart`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_storecart`;
CREATE TABLE `ezs_storecart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `cart_session_id` varchar(255) DEFAULT NULL,
  `sc_status` int(11) DEFAULT '0',
  `total_price` decimal(19,2) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKB32937006758EBDA` (`user_id`),
  KEY `FKB3293700F9DFE81A` (`store_id`),
  KEY `FKB3293700F734E208` (`user_id`),
  KEY `FKB32937006582B7AC` (`store_id`),
  CONSTRAINT `FKB32937006582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FKB32937006758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKB3293700F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKB3293700F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_storecart
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_store_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_store_dict`;
CREATE TABLE `ezs_store_dict` (
  `store_id` bigint(20) NOT NULL,
  `dict_id` bigint(20) NOT NULL,
  KEY `FKB38974D5D2E1D4BA` (`dict_id`),
  KEY `FKB38974D5F9DFE81A` (`store_id`),
  KEY `FKB38974D562BDCAE8` (`dict_id`),
  KEY `FKB38974D56582B7AC` (`store_id`),
  CONSTRAINT `FKB38974D56582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FKB38974D562BDCAE8` FOREIGN KEY (`dict_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FKB38974D5D2E1D4BA` FOREIGN KEY (`dict_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FKB38974D5F9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_store_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_store_stat`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_store_stat`;
CREATE TABLE `ezs_store_stat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `all_goods` int(11) NOT NULL,
  `all_store` int(11) NOT NULL,
  `all_user` int(11) NOT NULL,
  `next_time` datetime DEFAULT NULL,
  `order_amount` decimal(12,2) DEFAULT NULL,
  `store_update` int(11) NOT NULL,
  `week_complaint` int(11) NOT NULL,
  `week_goods` int(11) NOT NULL,
  `week_order` int(11) NOT NULL,
  `week_report` int(11) NOT NULL,
  `week_store` int(11) NOT NULL,
  `week_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_store_stat
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_sysconfig`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_sysconfig`;
CREATE TABLE `ezs_sysconfig` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `alipay_fenrun` int(11) DEFAULT '0',
  `auto_order_confirm` int(11) DEFAULT '7',
  `auto_order_evaluate` int(11) DEFAULT '7',
  `auto_order_notice` int(11) DEFAULT '3',
  `auto_order_return` int(11) DEFAULT '7',
  `balance_fenrun` int(11) DEFAULT '0',
  `bargain_maximum` int(11) DEFAULT '0',
  `bargain_rebate` decimal(3,2) DEFAULT NULL,
  `bargain_state` longtext,
  `bargain_status` int(11) DEFAULT '0',
  `bargain_title` varchar(255) DEFAULT NULL,
  `bargain_validity` int(11) DEFAULT '3',
  `bigHeight` int(11) NOT NULL,
  `bigWidth` int(11) NOT NULL,
  `closeReason` longtext,
  `codeStat` longtext,
  `combin_amount` int(11) DEFAULT '50',
  `combin_count` int(11) DEFAULT '3',
  `complaint_time` int(11) NOT NULL,
  `config_payment_type` int(11) DEFAULT '0',
  `consumptionRatio` int(11) NOT NULL,
  `copyRight` varchar(255) DEFAULT NULL,
  `creditrule` longtext,
  `currency_code` varchar(255) DEFAULT '￥',
  `delivery_amount` int(11) DEFAULT '50',
  `delivery_status` int(11) DEFAULT '0',
  `delivery_title` varchar(255) DEFAULT NULL,
  `deposit` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `domain_allow_count` int(11) DEFAULT '0',
  `emailEnable` bit(1) NOT NULL,
  `emailHost` varchar(255) DEFAULT NULL,
  `emailPort` int(11) NOT NULL,
  `emailPws` varchar(255) DEFAULT NULL,
  `emailTest` varchar(255) DEFAULT NULL,
  `emailUser` varchar(255) DEFAULT NULL,
  `emailUserName` varchar(255) DEFAULT NULL,
  `everyIndentLimit` int(11) NOT NULL,
  `gold` bit(1) NOT NULL,
  `goldMarketValue` int(11) NOT NULL,
  `groupBuy` bit(1) NOT NULL,
  `hotSearch` varchar(255) DEFAULT NULL,
  `imageFilesize` int(11) NOT NULL,
  `imageSaveType` varchar(255) DEFAULT NULL,
  `imageSuffix` varchar(255) DEFAULT NULL,
  `imageWebServer` varchar(255) DEFAULT NULL,
  `indentComment` int(11) NOT NULL,
  `integral` bit(1) NOT NULL,
  `integralRate` int(11) NOT NULL,
  `integralStore` bit(1) NOT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `kuaidi_id` longtext,
  `lucene_update` datetime DEFAULT NULL,
  `memberDayLogin` int(11) NOT NULL,
  `memberRegister` int(11) NOT NULL,
  `middleHeight` int(11) NOT NULL,
  `middleWidth` int(11) NOT NULL,
  `qq_domain_code` longtext,
  `qq_login` bit(1) DEFAULT b'0',
  `qq_login_id` varchar(255) DEFAULT NULL,
  `qq_login_key` varchar(255) DEFAULT NULL,
  `second_domain_open` bit(1) DEFAULT b'0',
  `securityCodeConsult` bit(1) NOT NULL,
  `securityCodeLogin` bit(1) NOT NULL,
  `securityCodeRegister` bit(1) NOT NULL,
  `securityCodeType` varchar(255) DEFAULT NULL,
  `service_qq_list` longtext,
  `service_telphone_list` longtext,
  `share_code` longtext,
  `sina_domain_code` longtext,
  `sina_login` bit(1) DEFAULT b'0',
  `sina_login_id` varchar(255) DEFAULT NULL,
  `sina_login_key` varchar(255) DEFAULT NULL,
  `site_url` varchar(255) DEFAULT NULL,
  `smallHeight` int(11) NOT NULL,
  `smallWidth` int(11) NOT NULL,
  `smsEnbale` bit(1) NOT NULL,
  `smsPassword` varchar(255) DEFAULT NULL,
  `smsTest` varchar(255) DEFAULT NULL,
  `smsURL` varchar(255) DEFAULT NULL,
  `smsUserName` varchar(255) DEFAULT NULL,
  `store_allow` bit(1) NOT NULL,
  `store_payment` longtext,
  `sysLanguage` varchar(255) DEFAULT NULL,
  `sys_domain` longtext,
  `templates` longtext,
  `title` varchar(255) DEFAULT NULL,
  `uc_api` varchar(255) DEFAULT NULL,
  `uc_appid` varchar(255) DEFAULT NULL,
  `uc_bbs` bit(1) DEFAULT b'0',
  `uc_database` varchar(255) DEFAULT NULL,
  `uc_database_port` varchar(255) DEFAULT NULL,
  `uc_database_pws` varchar(255) DEFAULT NULL,
  `uc_database_url` varchar(255) DEFAULT NULL,
  `uc_database_username` varchar(255) DEFAULT NULL,
  `uc_ip` varchar(255) DEFAULT NULL,
  `uc_key` varchar(255) DEFAULT NULL,
  `uc_table_preffix` varchar(255) DEFAULT NULL,
  `uploadFilePath` varchar(255) DEFAULT NULL,
  `user_creditrule` longtext,
  `visitorConsult` bit(1) NOT NULL,
  `voucher` bit(1) NOT NULL,
  `websiteCss` varchar(255) DEFAULT 'blue',
  `websiteName` varchar(255) DEFAULT NULL,
  `websiteState` bit(1) NOT NULL,
  `weixin_account` varchar(255) DEFAULT NULL,
  `weixin_amount` int(11) DEFAULT '50',
  `weixin_appId` varchar(255) DEFAULT NULL,
  `weixin_appSecret` varchar(255) DEFAULT NULL,
  `weixin_store` bit(1) DEFAULT b'0',
  `weixin_token` varchar(255) DEFAULT NULL,
  `weixin_welecome_content` longtext,
  `ztc_goods_view` int(11) DEFAULT '0',
  `ztc_price` int(11) NOT NULL,
  `ztc_status` bit(1) NOT NULL,
  `goodsImage_id` bigint(20) DEFAULT NULL,
  `memberIcon_id` bigint(20) DEFAULT NULL,
  `storeImage_id` bigint(20) DEFAULT NULL,
  `store_weixin_logo_id` bigint(20) DEFAULT NULL,
  `websiteLogo_id` bigint(20) DEFAULT NULL,
  `weixin_qr_img_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKB6F9BA32373AC6D8` (`websiteLogo_id`),
  KEY `FKB6F9BA321E4C4204` (`storeImage_id`),
  KEY `FKB6F9BA3271BCB4FC` (`weixin_qr_img_id`),
  KEY `FKB6F9BA327CA11E6B` (`memberIcon_id`),
  KEY `FKB6F9BA3229729A14` (`store_weixin_logo_id`),
  KEY `FKB6F9BA3289699B79` (`goodsImage_id`),
  KEY `FK752FDBAEFF8E1046` (`websiteLogo_id`),
  KEY `FK752FDBAE3A0FFE6A` (`weixin_qr_img_id`),
  KEY `FK752FDBAEF1C5E382` (`store_weixin_logo_id`),
  KEY `FK752FDBAE373AC6D8` (`websiteLogo_id`),
  KEY `FK752FDBAE71BCB4FC` (`weixin_qr_img_id`),
  KEY `FK752FDBAE29729A14` (`store_weixin_logo_id`),
  CONSTRAINT `FK752FDBAE29729A14` FOREIGN KEY (`store_weixin_logo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAE373AC6D8` FOREIGN KEY (`websiteLogo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAE3A0FFE6A` FOREIGN KEY (`weixin_qr_img_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAE71BCB4FC` FOREIGN KEY (`weixin_qr_img_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAEF1C5E382` FOREIGN KEY (`store_weixin_logo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FK752FDBAEFF8E1046` FOREIGN KEY (`websiteLogo_id`) REFERENCES `ezs_accessory` (`id`),
  CONSTRAINT `FKB6F9BA321E4C4204` FOREIGN KEY (`storeImage_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA3229729A14` FOREIGN KEY (`store_weixin_logo_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA32373AC6D8` FOREIGN KEY (`websiteLogo_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA3271BCB4FC` FOREIGN KEY (`weixin_qr_img_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA327CA11E6B` FOREIGN KEY (`memberIcon_id`) REFERENCES `wemall_accessory` (`id`),
  CONSTRAINT `FKB6F9BA3289699B79` FOREIGN KEY (`goodsImage_id`) REFERENCES `wemall_accessory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_sysconfig
-- ----------------------------
INSERT INTO `ezs_sysconfig` VALUES ('1', '2018-02-28 17:23:44', '', ' ', '0', '7', '7', '3', '7', '0', '0', null, null, '0', null, '3', '1024', '1024', '系统维护中...', '', '50', '3', '30', '0', '0', null, '{\"creditrule29\":1500,\"creditrule28\":1401,\"creditrule27\":1400,\"creditrule26\":1301,\"creditrule25\":1300,\"creditrule24\":1201,\"creditrule23\":1200,\"creditrule22\":1101,\"creditrule21\":1100,\"creditrule20\":1001,\"creditrule2\":101,\"creditrule1\":100,\"creditrule4\":201,\"creditrule3\":200,\"creditrule0\":1,\"creditrule19\":1000,\"creditrule18\":901,\"creditrule9\":500,\"creditrule7\":400,\"creditrule15\":800,\"creditrule8\":401,\"creditrule14\":701,\"creditrule5\":300,\"creditrule17\":900,\"creditrule6\":301,\"creditrule16\":801,\"creditrule11\":600,\"creditrule10\":501,\"creditrule13\":700,\"creditrule12\":601}', '￥', '50', '0', null, '', '易再生商城', '0', '', null, '0', null, null, null, null, '0', '', '0', '', 'GPPS,ABS,PET,PEEK,PET', '1024', 'sidYearMonthDayImg', 'gif|jpg|jpeg|bmp|png', '', '0', '', '0', '', null, null, '2018-03-18 00:00:02', '0', '0', '300', '300', '', '', '', '', '', '', '', '', 'normal', '', '', '', '', '', '', '', null, '160', '160', '', null, null, null, null, '', '{\"payafter\":true,\"outline\":true}', 'zh_cn', null, null, '易再生多用户商城系统V2.0版', null, null, '', null, null, null, null, null, null, null, null, 'upload', '{\"creditrule29\":800,\"creditrule28\":751,\"creditrule27\":750,\"creditrule26\":701,\"creditrule25\":700,\"creditrule24\":651,\"creditrule23\":650,\"creditrule22\":601,\"creditrule21\":550,\"creditrule20\":501,\"creditrule2\":51,\"creditrule1\":50,\"creditrule4\":101,\"creditrule3\":100,\"creditrule0\":1,\"creditrule19\":500,\"creditrule18\":451,\"creditrule9\":250,\"creditrule7\":200,\"creditrule15\":400,\"creditrule8\":201,\"creditrule14\":351,\"creditrule5\":150,\"creditrule17\":450,\"creditrule6\":151,\"creditrule16\":401,\"creditrule11\":300,\"creditrule10\":251,\"creditrule13\":350,\"creditrule12\":301}', '', '', 'blue', '易再生资源交易平台', '', null, '50', null, null, '', null, null, '0', '0', '', '1', '2', '3', null, null, null);

-- ----------------------------
-- Table structure for `ezs_syslog`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_syslog`;
CREATE TABLE `ezs_syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `content` longtext,
  `ip` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK204A02586758EBDA` (`user_id`),
  KEY `FK204A0258F734E208` (`user_id`),
  CONSTRAINT `FK204A0258F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK204A02586758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_syslog
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_user`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_user`;
CREATE TABLE `ezs_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `lastLoginDate` datetime DEFAULT NULL,
  `lastLoginIp` varchar(255) DEFAULT NULL,
  `loginCount` int(11) NOT NULL,
  `loginDate` datetime DEFAULT NULL,
  `loginIp` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `trueName` varchar(255) DEFAULT NULL,
  `userRole` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  `userInfo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKFB3DE50C10E4E93A` (`userInfo_id`),
  KEY `FKFB3DE50CEB84AE9B` (`parent_id`),
  KEY `FKFB3DE50CF9DFE81A` (`store_id`),
  KEY `FKFB3DE50CC85E1868` (`userInfo_id`),
  KEY `FKFB3DE50C7B60A4C9` (`parent_id`),
  KEY `FKFB3DE50C6582B7AC` (`store_id`),
  CONSTRAINT `FKFB3DE50C6582B7AC` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`),
  CONSTRAINT `FKFB3DE50C10E4E93A` FOREIGN KEY (`userInfo_id`) REFERENCES `ezs_userinfo` (`id`),
  CONSTRAINT `FKFB3DE50C7B60A4C9` FOREIGN KEY (`parent_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKFB3DE50CC85E1868` FOREIGN KEY (`userInfo_id`) REFERENCES `ezs_userinfo` (`id`),
  CONSTRAINT `FKFB3DE50CEB84AE9B` FOREIGN KEY (`parent_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKFB3DE50CF9DFE81A` FOREIGN KEY (`store_id`) REFERENCES `ezs_store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_user
-- ----------------------------
INSERT INTO `ezs_user` VALUES ('1', null, '', null, null, '1', '2018-03-24 03:54:03', '0:0:0:0:0:0:0:1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', null, 'ADMIN', null, null, '1');

-- ----------------------------
-- Table structure for `ezs_userconfig`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_userconfig`;
CREATE TABLE `ezs_userconfig` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKF6886F4E6758EBDA` (`user_id`),
  KEY `FKF6886F4EF734E208` (`user_id`),
  CONSTRAINT `FKF6886F4EF734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FKF6886F4E6758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_userconfig
-- ----------------------------

-- ----------------------------
-- Table structure for `ezs_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_userinfo`;
CREATE TABLE `ezs_userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable` bit(1) DEFAULT b'0',
  `entryTime` datetime DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `depart_id` bigint(20) DEFAULT NULL,
  `position_id` bigint(20) DEFAULT NULL,
  `sex_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKB09DE3BA7A218F3A` (`depart_id`),
  KEY `FKB09DE3BA3A1AB14A` (`sex_id`),
  KEY `FKB09DE3BA466F871A` (`position_id`),
  KEY `FKB09DE3BA82D8B1E8` (`depart_id`),
  KEY `FKB09DE3BAC9F6A778` (`sex_id`),
  KEY `FKB09DE3BAFDE8B648` (`position_id`),
  CONSTRAINT `FKB09DE3BAFDE8B648` FOREIGN KEY (`position_id`) REFERENCES `ezs_position` (`id`),
  CONSTRAINT `FKB09DE3BA3A1AB14A` FOREIGN KEY (`sex_id`) REFERENCES `ezs_dict` (`id`),
  CONSTRAINT `FKB09DE3BA466F871A` FOREIGN KEY (`position_id`) REFERENCES `ezs_position` (`id`),
  CONSTRAINT `FKB09DE3BA7A218F3A` FOREIGN KEY (`depart_id`) REFERENCES `ezs_depart` (`id`),
  CONSTRAINT `FKB09DE3BA82D8B1E8` FOREIGN KEY (`depart_id`) REFERENCES `ezs_depart` (`id`),
  CONSTRAINT `FKB09DE3BAC9F6A778` FOREIGN KEY (`sex_id`) REFERENCES `ezs_dict` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_userinfo
-- ----------------------------
INSERT INTO `ezs_userinfo` VALUES ('1', null, '', null, '', null, null, '0', null, null, null);

-- ----------------------------
-- Table structure for `ezs_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `ezs_user_role`;
CREATE TABLE `ezs_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK62939BC9C22E27FA` (`role_id`),
  KEY `FK62939BC96758EBDA` (`user_id`),
  KEY `FK62939BC9520A1E28` (`role_id`),
  KEY `FK62939BC9F734E208` (`user_id`),
  CONSTRAINT `FK62939BC9F734E208` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK62939BC9520A1E28` FOREIGN KEY (`role_id`) REFERENCES `ezs_role` (`id`),
  CONSTRAINT `FK62939BC96758EBDA` FOREIGN KEY (`user_id`) REFERENCES `ezs_user` (`id`),
  CONSTRAINT `FK62939BC9C22E27FA` FOREIGN KEY (`role_id`) REFERENCES `ezs_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ezs_user_role
-- ----------------------------
