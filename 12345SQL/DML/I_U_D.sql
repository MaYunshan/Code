#DML语言
/*
数据操作语言
插入：insert
修改：update
删除：delete

*/

#1.插入语句【支持多行一次性插入】【支持子查询】
/*
语法：
	insert into 表名(列名,...) value(值1,...)
*/

#1.1 插入的值得类型要和列的类型一致或兼容
INSERT INTO beauty(id,NAME,sex,borndate,phone,photo,boyfriend_id)
VALUE(13,'唐艺昕','女','1990-4-23','18845612365',NULL,2);
SELECT * FROM beauty;

#1.2 不可以为空的列必须插入值，可以为null的列如何插入值
#方式一：
INSERT INTO beauty(id,NAME,sex,borndate,phone,photo,boyfriend_id)
VALUE(13,'唐艺昕','女','1990-4-23','18845612365',NULL,2);
#方式二：列名和值都不要
INSERT INTO beauty(id,NAME,sex,borndate,phone,boyfriend_id)
VALUE(13,'唐艺昕','女','1990-4-23','18845612365',2);

#1.3 列的顺序是否可以调换
INSERT INTO beauty(NAME,sex,id,phone)
VALUE('刘涛','女',14,'15456987412');
SELECT * FROM beauty;

#1.4 列数和值必须一致

#1.5 可以省略列名，默认所有列，而且列的顺序和表中的顺序一致


#2.插入语句
/*
语法：
	insert into 表名
	set 列名=值，列名=值...

*/


#3.修改语句
/*
a.修改单表的记录
语法：
	update 表名
	set 列=新值，列=新值...
	where 筛选条件;

b.修改多表的记录
语法：
	【sql92】
	update 表1 别名,表2 别名
	set 列=值...
	where 连接条件
	and 筛选条件;
	
	【sql99】
	update 表1 别名
	inner|left|right join 表2 别名
	on 连接条件
	set 列=值...
	where 筛选条件
	
*/

#3.1 修改单表的记录
#3.1.1 修改beauty中唐艺昕的电话号码
UPDATE beauty SET phone='1232121112' WHERE NAME LIKE '唐艺昕';
SELECT * FROM beauty;

#3.1.2 修改2号男生的姓名
UPDATE boys SET boyName='张飞',usercp=10 WHERE id=2;
SELECT * FROM boys;

#3.2 修改多表的记录
#3.2.1 修改张无忌的女朋友的电话号码为123456789456
UPDATE beauty be
INNER JOIN boys bo
ON be.`boyfriend_id`=bo.`id`
SET phone='123456789'
WHERE bo.`boyName`='张无忌';
SELECT * FROM beauty;

#3.2.2 修改没有男朋友的女生的男朋友编号都为2号
UPDATE beauty be
LEFT OUTER JOIN boys bo
ON be.`boyfriend_id`=bo.`id`
SET be.`boyfriend_id`=2
WHERE bo.`id` IS NULL;
SELECT * FROM beauty;

#左外连接
SELECT * 
FROM beauty be
LEFT OUTER JOIN boys bo
ON be.`boyfriend_id`=bo.`id`;


#4.删除语句
/*
方式一: delete
	语法：
		单表删除
		delete from 表名 where 筛选条件
		多表删除
		
方式二：
	truncate 
	语法：truncate table 表名

*/

#4.1 删除手机尾号为9的女生信息
DELETE FROM beauty WHERE phone LIKE '%9';
SELECT * FROM beauty;

#4.2 多表的删除 删除张无忌的女朋友
/*
delete 表1的别名，表2的别名
from 表1 别名
inner|left|right join 表2 别名
on 连接条件
where 筛选条件
*/
DELETE be
FROM beauty  be
INNER JOIN boys bo
ON be.`boyfriend_id`=bo.`id`
WHERE bo.`boyName`='黄晓明';





#运行脚本创建两个表
USE myemployees;
CREATE TABLE my_employees(
	ID INT(10),
	first_name VARCHAR(10),
	last_name VARCHAR(10),
	userID VARCHAR(10),
	salary DOUBLE(10,2)
);

CREATE TABLE users(
	id INT,
	userID VARCHAR(10),
	department_id INT
);

#显示my_employees的表结构
DESC my_employees;

#向my_employees中插入数据
INSERT INTO my_employees
VALUE(1,'patel','Ralph','Rpatel',895),
(2,'Dancs','Betty','Bdancs',860),
(3,'Biri','Ben','Bbiri',1100),
(4,'Newman','Chad','Cnewman',750),
(5,'Ropeburn','Audrey','Aropebur',1550);

#向user表中插入数据
INSERT INTO users
VALUE(1,'Rpatel',10),(2,'Bdancs',10),(3,'Bbiri',20),(4,'Cnewman',30),(5,'Aroperbur',40);

#将3号员工的last_name修改为‘drelxer’
UPDATE my_employees
SET last_name='drelxer'
WHERE id=3;
SELECT * FROM my_employees;

#将所有工资少于900的员工的工资修改为1000
UPDATE my_employees
SET salary=1000
WHERE salary<900;
SELECT * FROM my_employees;

#将userID为Bbiri的user表和my_employees表的记录全部删除
DELETE my,u
FROM my_employees my
INNER JOIN users u
ON my.`userID`=u.`userID`
WHERE my.`userID`='Bbiri';
SELECT * FROM my_employees;
SELECT * FROM users;

#删除所有数据
DELETE FROM users;
DELETE FROM my_employees;

#清空my_employees表
TRUNCATE TABLE my_employees;









