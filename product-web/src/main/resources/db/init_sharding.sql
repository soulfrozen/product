
CREATE SCHEMA if not exists `product_sharding_1` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

use product_sharding_1;

CREATE TABLE if not exists `t_product_0` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品名称',
  `product_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品编号',
  `category` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品分类 如资产类产品， 资金类产品',
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenant_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '租户id， 渠道分离实现逻辑可用该字段',
  `status` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `busi_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '业务类型   类型资产类产品分： 房抵贷，房信贷， 信用贷， 消费贷 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_code_UNIQUE` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_1` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品名称',
  `product_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品编号',
  `category` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品分类 如资产类产品， 资金类产品',
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenant_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '租户id， 渠道分离实现逻辑可用该字段',
  `status` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `busi_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '业务类型   类型资产类产品分： 房抵贷，房信贷， 信用贷， 消费贷 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_code_UNIQUE` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_category` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenant_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_UNIQUE` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_category_feature` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_type` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clazz` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dict_code` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `check_rule` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `optional` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_t_product_category_feature1` (`category`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_category_type` (
  `category` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `busi_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  KEY `idx_t_product_category_type1` (`category`,`busi_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_feature_0` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `min_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clazz` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dict_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_type` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_t_product_feature1` (`product_code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_feature_1` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `min_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clazz` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dict_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_type` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_t_product_feature1` (`product_code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_text` (
  `text_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` text COLLATE utf8_unicode_ci,
  KEY `idx_t_product_text1` (`product_code`,`text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_text_0` (
  `text_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` text COLLATE utf8_unicode_ci,
  KEY `idx_t_product_text1` (`product_code`,`text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_text_1` (
  `text_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` text COLLATE utf8_unicode_ci,
  KEY `idx_t_product_text1` (`product_code`,`text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_sys_dict` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `label` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_sys_dict_item` (
  `dict_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `label` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  KEY `idx_t_sys_dict_item1` (`dict_code`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


insert into t_sys_dict(id, code, label) values('1', '001', '还款方式');

insert into t_sys_dict_item(dict_code, code, label) values('001', '1', '等额本息');
insert into t_sys_dict_item(dict_code, code, label) values('001', '2', '先息后本');



CREATE SCHEMA if not exists `product_sharding_2` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

use product_sharding_2;


CREATE TABLE if not exists `t_product_0` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品名称',
  `product_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品编号',
  `category` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品分类 如资产类产品， 资金类产品',
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenant_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '租户id， 渠道分离实现逻辑可用该字段',
  `status` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `busi_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '业务类型   类型资产类产品分： 房抵贷，房信贷， 信用贷， 消费贷 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_code_UNIQUE` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_1` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品名称',
  `product_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品编号',
  `category` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品分类 如资产类产品， 资金类产品',
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenant_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '租户id， 渠道分离实现逻辑可用该字段',
  `status` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `busi_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '业务类型   类型资产类产品分： 房抵贷，房信贷， 信用贷， 消费贷 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_code_UNIQUE` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_category` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenant_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_UNIQUE` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_category_feature` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_type` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clazz` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dict_code` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `check_rule` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `optional` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_t_product_category_feature1` (`category`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_category_type` (
  `category` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `busi_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  KEY `idx_t_product_category_type1` (`category`,`busi_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_feature_0` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `min_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clazz` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dict_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_type` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_t_product_feature1` (`product_code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_feature_1` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `min_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clazz` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dict_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_type` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_t_product_feature1` (`product_code`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_text` (
  `text_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` text COLLATE utf8_unicode_ci,
  KEY `idx_t_product_text1` (`product_code`,`text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_text_0` (
  `text_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` text COLLATE utf8_unicode_ci,
  KEY `idx_t_product_text1` (`product_code`,`text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_product_text_1` (
  `text_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `product_code` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` text COLLATE utf8_unicode_ci,
  KEY `idx_t_product_text1` (`product_code`,`text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_sys_dict` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `label` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE if not exists `t_sys_dict_item` (
  `dict_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `label` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  KEY `idx_t_sys_dict_item1` (`dict_code`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


insert into t_sys_dict(id, code, label) values('1', '001', '还款方式');

insert into t_sys_dict_item(dict_code, code, label) values('001', '1', '等额本息');
insert into t_sys_dict_item(dict_code, code, label) values('001', '2', '先息后本');