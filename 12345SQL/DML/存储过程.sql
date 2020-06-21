#变量
/*
系统变量：变量是由系统提供的，不是用户定义，属于服务器层面。系统变量分为全局系统变量（global）和会话系统变量（session）
	全局变量
	会话变量
		1.每一个客户机成功连接服务器后，都会产生与之对应的会话。会话期间，服务实例会在服务器内存中生成与该会话对应的会话系统变量。这些会话系统变量的初始值就是全局系统变量值的复制。
		为了标记不同的会话，会话系统又新增了一些变量，这些变量是全局系统变量没有的。所以，会话系统变量包括全局系统变量，并且会话系统变量多于全局系统变量。
		2.会话系统的特点在于，它仅仅用于定义当前会话的属性，会话期间对某个会话系统变量值的修改，不会影响到其他会话同一个会话系统变量的值。
		3.全局系统变量的特点在于，它是用于定义MySQL服务实例的属性、特点。当某个会话对某个全局系统变量值的修改会导致其他会话中同一全局系统变量值的修改。
	使用方法：
		1.查看所有的系统的变量
			show global|session variables;
		2.查看满足条件的部分系统变量
			show global|session variables like '';
		3.查看指定的某个系统变量的值
			select @@系统变量名;|select @@golbal.系统变量名;
		4.为某个指定的系统变量赋值
			set global|session 系统变量名=值;
			set @@global|session.系统变量名=值;
	注意：
		如果是全局变量，则需要加global，如果是会话级别，需要加session，如果不加，默认是session



自定义变量：
	用户变量
	局部变量

*/

#一.全局变量
/*
作用域：服务器每次启动将为所有的全局变量赋初识值，针对于所有的会话(连接)有效，但不能跨重启
*/
#1.查看所有的全局变量
SHOW GLOBAL VARIABLES;

#2.查看部分全局变量
SHOW VARIABLES LIKE '%char%';

#3.查看指定的全局变量
SELECT @@global.autocommit;
SELECT @@transaction_isolation;

#4.为某个指定的全局变量赋值
SET @@global.autocommit=0;
SET GLOBAL autocommit=1;


#会话变量
/*
作用域：仅仅针对于当前的会话有效

*/

#1.查看所有的会话变量
SHOW SESSION VARIABLES;
SHOW VARIABLES;

#2.查看部分会话变量
SHOW VARIABLES LIKE '%char%';
SHOW SESSION VARIABLES LIKE '%char%';

#3.查看指定的会话变量
SELECT @@session.autocommit;
SELECT @@transaction_isolation;

#4.为某个指定的会话变量赋值
SET @@session.autocommit=0;
SET SESSION autocommit=1;


#二.自定义变量
/*
声明、赋值、使用

*/
#1.用户变量
/*
作用域：针对于当前会话有效，等同于会话变量的作用域

1.声明并初始化：【=或者：=】
	set @用户变量名=值;
	set @用户变量名：=值;
	select @用户变量名：=值;

2.赋值（更新用户变量名的值）
	a.通过set或者select
		set 用户变量名=值;
		set 用户变量名：=值;
		select @用户变量名：=值;
	
	b.通过select查询语句
		select 字段 into 变量名 from 表;

3.使用
	select @用户变量名;
*/

#1.
SELECT COUNT(*) INTO @cout FROM employees;
SELECT @cout;


#局部变量
/*
作用域：仅仅在定义它的begin end中有效

1.声明
	declare 变量名 类型
	declare 变量名 类型 default 值;
2.赋值
	a.通过set或者select
		set 用户变量名=值;
		set 用户变量名：=值;
		select @用户变量名：=值;
	
	b.通过select查询语句
		select 字段 into 变量名 from 表;
		
3.使用
*/

#三.存储过程和函数
/*
存储过程和函数：类似于java中的方法

存储过程：
	定义：一组预先编译好的sql语句的集合，类似于批处理语句

*/


/*
#1.创建语法
	CREATE PROCEDURE 存储过程名(参数列表)
	BEGIN
		存储过程语句
	END
	
	参数列表
		参数模式
			in：该参数可以作为输入，即该参数需要调用方传入值
			out：该参数可以作为输出，该参数可以作为返回值
			inout：即可以作为输入又可以作为输出，既需要传入值，又可以返回值
		参数名
		参数类型

	注意
		如果存储过程仅仅只有一句话，begin end 可以省略
		存储过程中的每条sql语句的结尾要求必须加分号
		存储过程的结尾可以使用delimiter重新设置

#2.调用语法：
	call 存储过程名(实参列表);	
*/

#1.空参列表
#1.1 插入到admin表中五条记录
SELECT * FROM admin;

DELIMITER $
CREATE PROCEDURE myp1()
BEGIN
	INSERT INTO admin(username,PASSWORD)
	VALUES('john','0000'),('张无忌','1111'),('杨过','2222'),('郭襄','3333'),('郭靖','4444');
END $

CALL myp1()$

#2 带in模式的参数列表
#2.1 根据女神名，查询对应的男生信息
CREATE PROCEDURE myp2(IN girlName VARCHAR(20))
BEGIN
	SELECT bo.*
	FROM boys bo
	RIGHT OUTER JOIN beauty be
	ON be.boyfriend_id=bo.id
	WHERE be.name=girlName;
END $

CALL myp2('柳岩')$

#2.2 用户是否登录成功
CREATE PROCEDURE myp3(IN username VARCHAR(20),IN PASSWORD VARCHAR(20))
BEGIN
	DECLARE result VARCHAR(20) DEFAULT ''; #声明
	SELECT COUNT(*) INTO result	       #赋值	
	FROM admin
	WHERE admin.username=username AND admin.`password`=PASSWORD;
	
	SELECT result; #使用
END $

CREATE PROCEDURE myp4(IN username VARCHAR(20),IN PASSWORD VARCHAR(20))
BEGIN
	DECLARE result INT DEFAULT 0; #声明
	SELECT COUNT(*) INTO result	       #赋值	
	FROM admin
	WHERE admin.username=username AND admin.`password`=PASSWORD;
	
	SELECT IF(result>0,'成功','失败'); #使用
END $

SELECT * FROM admin;
CALL myp3('john','8888')$


#3.带out模式的存储过程
#3.1 根据女生名，返回对应的男生名
CREATE PROCEDURE myp5(IN girlName VARCHAR(20),OUT boyName VARCHAR(20))
BEGIN
	SELECT bo.boyName INTO boyName
	FROM beauty be
	INNER JOIN boys bo
	ON bo.id=be.boyfriend_id
	WHERE be.name=girlName;
END $

SET @boyName$
CALL myp5('柳岩',@boyName)$
SELECT @boyName$

SELECT * FROM boys;
SELECT * FROM beauty;

#3.2 根据女生名，获得对应男生的名字和魅力值
CREATE PROCEDURE myp6(IN girlName VARCHAR(20),OUT boyName VARCHAR(20),OUT CP INT)
BEGIN
	SELECT bo.boyName,bo.userCP INTO boyName,CP
	FROM beauty be
	INNER JOIN boys bo
	ON bo.id=be.boyfriend_id
	WHERE be.name=girlName;
END $

CALL myp6('柳岩',@boyName,@CP)$
SELECT @boyName,@CP$


#4.带inout模式的参数的存储过程
#4.1 传入a和b两个值，最终返回翻倍值

CREATE PROCEDURE myp7(INOUT a INT,INOUT b INT)
BEGIN
	SET a=a*2;
	SET b=b*2;
END$

SET @m=10$
SET @n=10$
CALL myp7(@m,@n)$
SELECT @m,@n$

#四，删除存储过程
/*
drop procedure 存储过程名
*/


#五，查看存储过程的信息
SHOW CREATE PROCEDURE myp1;
















