#DDL语言，数据定义语言
/*
涉及库和表的管理

1.库的管理
	创建、修改、删除
2.表的管理
	创建、修改、删除
创建：create
修改：alter
删除：drop


*/
#一，库的管理
#1.库的创建
/*
语法：create datebase 库名;
*/
#1.1创建图书books库[带容错处理的库的创建]
CREATE DATABASE IF NOT EXISTS Books;

#2.库的修改
#2.1更改字符集
ALTER DATABASE books CHARACTER SET gbk;

#3.库的删除
DROP DATABASE IF EXISTS books;


#二，表的管理
#1.表的创建
CREATE TABLE book(
	ID INT,
	bname VARCHAR(20),
	price DOUBLE,
	authorID INT,
	publishDate DATETIME
);

CREATE TABLE author(
	ID INT,
	au_name VARCHAR(20),
	nation VARCHAR(10)
);

#2.表的修改
/*
alter table 表名 add|drop|modify|change column 列名 【列的类型，约束】

*/
#2.1 修改列名
ALTER TABLE book CHANGE COLUMN pub_DAte pub_date DATETIME;

#2.2 修改列的类型或约束
ALTER TABLE book MODIFY COLUMN pub_date TIMESTAMP;

#2.3 添加新列
ALTER TABLE book ADD COLUMN annual DOUBLE;

#2.4 删除列
ALTER TABLE book DROP COLUMN annual;
DESC book;

#2.5 修改表名
ALTER TABLE author RENAME TO book_author;

#3.表的删除
DROP TABLE IF EXISTS book_author;
SHOW TABLES;

#4.表的复制
INSERT INTO author
VALUE(1,'村上春树','日本'),(2,'莫言','中国'),(3,'冯唐','中国'),(4,'金庸','中国');
SELECT * FROM author;

#4.1 仅仅复制表的结构
CREATE TABLE copy LIKE author;

#4.2 复制表的结构和数据
CREATE TABLE copy2 
SELECT * FROM author;
SELECT * FROM copy2;

#4.3 复制部分数据
CREATE TABLE copy3
SELECT id,au_name FROM author WHERE nation='中国';
SELECT * FROM copy3;

#4.4 仅仅复制某些字段
CREATE TABLE copy4
SELECT id,au_name FROM author WHERE 1=2;
SELECT * FROM copy4;


#三，常见约束
/*
含义：一种限制，用于限制表中的数据，为了保证表中数据的准确和可靠性

分类：六大约束
	NOT NULL : 非空约束,用于保证该字段的值不能为空
	DEFAULT : 默认，保证该字段有默认值 
	PRIMARY KEY : 主键，用于保证该字段的值具有唯一性，并且非空
	UNIQUE : 唯一，用于保证该字段的值具有唯一性，可以为空
	CHECK : 检查约束【mysql中不支持】
	FOREIGH KEY : 外键，用于限制两个表的关系，用于保证该字段的值必须来自于主表的关联列的值
		在从表添加外键约束，用于引用主表中某列的值

约束的添加分类
	列级约束：
		外键约束没有效果
	表级约束
		除了非空和默认，其它都支持
	
	create table 表名(
		字段名 字段类型 列级约束，
		字段名 字段类型，
		表级约束
	);
	
主键和唯一

*/

CREATE DATABASE students;
#1.创建表时添加约束
USE students;
CREATE TABLE stuinfo(
	id INT PRIMARY KEY,   					 #主键
	stu_name VARCHAR(20) NOT NULL,				 #非空
	gender CHAR(1) CHECK(gender='男' OR gender='女'),	 #检查【不起作用】
	seat INT UNIQUE,					 #唯一
	age INT DEFAULT 18,					 #默认
	majorID INT REFERENCES major(id)			 #外键【不起作用】
);
CREATE TABLE major(
	id INT PRIMARY KEY,
	major_name VARCHAR(20)
);
#查看stuinfo表中所有的索引
SHOW INDEX FROM stuinfo;

#1.1 添加表级约束
/*
语法：在各个字段的最下面
	【constraint 约束名】 约束类型
*/
DROP TABLE IF EXISTS stuinfo;
CREATE TABLE stuinfo(
	id INT,
	stu_name VARCHAR(20), 
	gender CHAR(1), 
	seat INT, 
	age INT, 
	majorID INT,
	
	CONSTRAINT pk PRIMARY KEY(id),
	CONSTRAINT uq UNIQUE KEY(seat),
	CONSTRAINT ck CHECK(gender='男' OR gender='男''女'),
	CONSTRAINT fk_stuinfo_major FOREIGN KEY(majorID) REFERENCES major(id) 
);
SHOW INDEX FROM stuinfo;

#通用的写法
CREATE TABLE stuinfo(
	id INT PRIMARY KEY,   							 #主键
	stu_name VARCHAR(20) NOT NULL,						 #非空
	gender CHAR(1) CHECK(gender='男' OR gender='女'),			 #检查【不起作用】
	seat INT UNIQUE,							 #唯一
	age INT DEFAULT 18,							 #默认
	majorID INT 
	CONSTRAINT fk_stuinfo_major FOREIGN KEY(majorID) REFERENCES major(id)	 #外键
);


#2.修改表时添加约束
/*
1.添加列级约束
	alter table 表名 modify column 字段名 字段类型 新约束
2.添加表级约束
	alter table 表名 add 【constraint 约束名】 约束类型(字段名) 【外键的引用】;

*/
DROP TABLE IF EXISTS stuinfo;
CREATE TABLE stuinfo(
	id INT,
	stu_name VARCHAR(20), 
	gender CHAR(1), 
	seat INT, 
	age INT, 
	majorID INT
);
#2.1添加非空约束
ALTER TABLE stuinfo MODIFY COLUMN stu_name VARCHAR(20) NOT NULL;
DESC stuinfo;

#2.2添加默认约束
ALTER TABLE stuinfo MODIFY COLUMN age INT DEFAULT 18;
DESC stuinfo;

#2.3添加主键约束
ALTER TABLE stuinfo MODIFY COLUMN id INT PRIMARY KEY;
ALTER TABLE stuinfo ADD PRIMARY KEY(id);
SHOW INDEX FROM stuinfo;

#2.4添加唯一键
ALTER TABLE stuinfo MODIFY COLUMN seat INT UNIQUE;

#2.5添加外键
ALTER TABLE stuinfo ADD FOREIGN KEY(majorID) REFERENCES major(id);
SHOW INDEX FROM stuinfo;


#标识列
/*
又称自增长列

特点：
	标识列必须和key搭配使用；
	标识列只能有一个，
	标识列只能是数值型，
	标识列可以通过set_increment_increment设置步长

*/
#1.创建表时设置标识列
DROP TABLE IF EXISTS tab_identity;
CREATE TABLE tab_identity(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);

INSERT INTO tab_identity VALUES(NULL,'mys'),(NULL,'zlf');
SELECT * FROM tab_identity;




