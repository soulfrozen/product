create table t_sys_dict(
id varchar(32) primary key,
create_dttm datetime,
create_user varchar(100),
update_dttm datetime,
update_user varchar(100),
code varchar(50),
label varchar(100),
description varchar(200)
);

create table t_sys_dict_item(
dict_code varchar(50),
code varchar(50),
label varchar(100),
description varchar(200),
sort Integer
);

create table t_product_category(

id varchar(32) primary key,
            create_dttm datetime,
            create_user varchar(100),
            update_dttm datetime,
            update_user varchar(100),
            name varchar(50),
            category varchar(50),
            description varchar(100),
            tenant_id varchar(32)
);

create table t_product_category_feature(
id varchar(32) primary key,
            create_dttm datetime,
            create_user varchar(100),
            update_dttm datetime,
            update_user varchar(100),
            name varchar(50),
            category varchar(50),
            description varchar(100),
            value_type varchar(4),
            clazz varchar(100),
            dict_code varchar(20),
            check_rule varchar(200)

);

create table t_product_category_type(
            category varchar(50),
            busi_type varchar(50),
            description varchar(100)

);

create table t_product_text(
text_id varchar(32),
product_code varchar(32),
value text
);