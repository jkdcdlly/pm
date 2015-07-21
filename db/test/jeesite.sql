SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX test_data_del_flag ON test_data;
DROP INDEX test_data_child_del_flag ON test_data_child;
DROP INDEX test_data_main_del_flag ON test_data_main;
DROP INDEX test_tree_del_flag ON test_tree;
DROP INDEX test_data_parent_id ON test_tree;
DROP INDEX test_data_parent_ids ON test_tree;



/* Drop Triggers */

DROP TRIGGER IF EXISTS TRI_concurrence_id;



/* Drop Tables */

DROP TABLE IF EXISTS concurrence;
DROP TABLE IF EXISTS test_data;
DROP TABLE IF EXISTS test_data_child;
DROP TABLE IF EXISTS test_data_main;
DROP TABLE IF EXISTS test_tree;




/* Create Tables */

CREATE TABLE concurrence
(
	id bigint NOT NULL AUTO_INCREMENT,
	-- 时间
	time varchar(64) COMMENT '时间',
	-- 次数
	num blob COMMENT '次数',
	-- 日期
	in_date date COMMENT '日期',
	PRIMARY KEY (id)
);


-- 业务数据表
CREATE TABLE test_data
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 归属用户
	user_id varchar(64) COMMENT '归属用户',
	-- 归属部门
	office_id varchar(64) COMMENT '归属部门',
	-- 归属区域
	area_id varchar(64) COMMENT '归属区域',
	-- 名称
	name varchar(100) COMMENT '名称',
	-- 性别（字典类型：sex）
	sex char(1) COMMENT '性别（字典类型：sex）',
	-- 加入日期
	in_date date COMMENT '加入日期',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '业务数据表';


-- 业务数据子表
CREATE TABLE test_data_child
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 业务主表ID
	test_data_main_id varchar(64) COMMENT '业务主表ID',
	-- 名称
	name varchar(100) COMMENT '名称',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '业务数据子表';


-- 业务数据表
CREATE TABLE test_data_main
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 归属用户
	user_id varchar(64) COMMENT '归属用户',
	-- 归属部门
	office_id varchar(64) COMMENT '归属部门',
	-- 归属区域
	area_id varchar(64) COMMENT '归属区域',
	-- 名称
	name varchar(100) COMMENT '名称',
	-- 性别（字典类型：sex）
	sex char(1) COMMENT '性别（字典类型：sex）',
	-- 加入日期
	in_date date COMMENT '加入日期',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '业务数据表';


-- 树结构表
CREATE TABLE test_tree
(
	-- 编号
	id varchar(64) NOT NULL COMMENT '编号',
	-- 父级编号
	parent_id varchar(64) NOT NULL COMMENT '父级编号',
	-- 所有父级编号
	parent_ids varchar(2000) NOT NULL COMMENT '所有父级编号',
	-- 名称
	name varchar(100) NOT NULL COMMENT '名称',
	-- 排序
	sort decimal(10,0) NOT NULL COMMENT '排序',
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '树结构表';



/* Create Foreign Keys */

ALTER TABLE test_data_child
	ADD FOREIGN KEY (test_data_main_id)
	REFERENCES test_data_main (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Triggers */

CREATE TRIGGER TRI_concurrence_id BEFORE INSERT ON concurrence
FOR EACH ROW
BEGIN
	SELECT SEQ_concurrence_id.nextval
	INTO :new.id
	FROM dual;
END;



/* Create Indexes */

CREATE INDEX test_data_del_flag ON test_data ();
CREATE INDEX test_data_child_del_flag ON test_data_child ();
CREATE INDEX test_data_main_del_flag ON test_data_main ();
CREATE INDEX test_tree_del_flag ON test_tree ();
CREATE INDEX test_data_parent_id ON test_tree ();
CREATE INDEX test_data_parent_ids ON test_tree ();


