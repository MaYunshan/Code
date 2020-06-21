#函数
/*
存储过程：可以没有返回值，也可以有多个返回值，适合做批量插入、更新
函数：有且仅有一个返回值适合做处理数据后返回一个结果

*/

#一，创建语法
/*
	create function 函数名(参数列表) returns 返回类型 
	begin 
		函数体
	end
	
	参数列表：参数名 参数类型
*/
/*

	这是我们开启了bin-log, 我们就必须指定我们的函数是否是
	1 DETERMINISTIC 不确定的
	2 NO SQL 没有SQl语句，当然也不会修改数据
	3 READS SQL DATA 只是读取数据，当然也不会修改数据
	4 MODIFIES SQL DATA 要修改数据
	5 CONTAINS SQL 包含了SQL语句
	
	#set global log_bin_trust_function_creators=TRUE;
*/

#1.没有参数有返回值
#1.1 返回公司的员工个数

DELIMITER $
CREATE FUNCTION myfun1() RETURNS INT
BEGIN
	DECLARE c INT DEFAULT 0;
	SELECT COUNT(*) INTO c
	FROM employees;
	RETURN c;
END $

SELECT myfun1()$

#2有参数
#2.1 根据员工名，返回他的工资
CREATE FUNCTION myfun2(NAME VARCHAR(20)) RETURNS DOUBLE
BEGIN
	DECLARE sa DOUBLE DEFAULT 0;
	SELECT salary INTO sa
	FROM employees 
	WHERE last_name=NAME;
	RETURN sa;
END $

SELECT myfun2('Khoo')$

#2.2 根据部门名，返回该部门的平均工资
CREATE FUNCTION myfun3(deptName VARCHAR(20)) RETURNS DOUBLE
BEGIN
	SET @sal=0;		#定义用户变量
	SELECT AVG(salary) INTO @sal
	FROM employees e
	INNER JOIN departments d
	ON e.department_id=d.department_id
	WHERE d.department_name=deptName
	RETURN @sal;
END $

SELECT myfun3('Adm');
SELECT * FROM departments;

#3.查看函数
SHOW CREATE FUNCTION myfun1;

#4.删除函数
DROP FUNCTION 函数名;




#三.流程控制语句
1.类似于switch语句，一般用于实现等值判断

	CASE 变量|表达式|字段
	WHEN 要判断的值 THEN 返回的值1或者语句1
	WHEN 要判断的值 THEN 返回的值2或者语句2
	...
	ELSE 要返回的值n或者语句n
	END CASE; 

2.类似于多重if语句，一般用于实现区间判断
	CASE
	WHEN 要判断的条件1 THEN 返回的值1或者语句1
	WHEN 要判断的条件1 THEN 返回的值1或者语句1
	...
	ELSE 要返回的值n或者语句n;
	END CASE;


#1.1 根据存储过程，根据传入的成绩，来显示等级
DELIMITER $;
CREATE PROCEDURE rankScore(IN score INT)
BEGIN
	CASE
	WHEN score>=90 AND score<=100 THEN SELECT 'A';
	WHEN score>=80 THEN SELECT 'B';
	WHEN score>=70 THEN SELECT 'C';
	ELSE SELECT 'D';
	END CASE;
END $



#if结构
#实现多重分支
IF 条件1 THEN 语句1;
ELSEIF 条件2 THEN 语句2;
...
ELSE 语句n;
END IF;

#循环结构
/*
iterate 类似于continue，结束本次循环，继续下一次循环
leave 类似于break，跳出循环体，
*/
#1.while
label:WHILE 循环条件 DO
	循环体
END WHILE label;

#2.loop
label:LOOP
	循环体;
END LOOP label;

#3.repeat
label:REPEAT
	循环体;
UNTIL 循环结束条件
END REPEAT label;


#已知表stringContent，其中
id自增长，
content VARCHAR(20)
向该表中插入指定个数的，随机字符串

DROP TABLE IF EXISTS stringContent;
CREATE TABLE stringContent(
	id INT PRIMARY KEY AUTO_INCREMENT,
	content VARCHAR(20)
);

DELIMITER $
CREATE PROCEDURE randerString(IN insertCount INT)
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE str VARCHAR(26) DEFAULT 'abcdefghijklmnopqrstuvwxyz';
	DECLARE startIndex INT DEFAULT 1;
	DECLARE len INT DEFAULT 1;
	WHILE i<=insertCount DO
		SET startIndex=FLOOR(RAND()*26+1);
		SET len=FLOOR(RAND()*(20-startIndex+1)+1);
		INSERT INTO stringContent(content) VALUES(SUBSTR(str,startIndex,len));
		SET i=i+1;		
	END WHILE;
END $



SELECT * FROM BOYS;

INSERT INTO BOYS(id,boyname,userCP) VALUES('5','杨过','50');

DELETE FROM boys WHERE id=5;

UPDATE boys SET boyName='关羽' WHERE id=2;

CREATE TABLE exam_student(
	FlowID INT NOT NULL COMMENT '流水号',
	`Type` INT DEFAULT NULL COMMENT '四级/六级',
	IDCard VARCHAR(11) DEFAULT NULL COMMENT '身份证号',
	ExamCard VARCHAR(15) DEFAULT NULL COMMENT '准考证号',
	StudentName VARCHAR(20)DEFAULT NULL COMMENT '学生姓名',
	Location VARCHAR(20) DEFAULT NULL COMMENT '区域',
	Grade INT DEFAULT NULL COMMENT'成绩',
	PRIMARY KEY(FlowID)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO exam_student VALUES(1,4,'12341234','123456','tzc','甘肃','100');
SELECT * FROM exam_student;

INSERT INTO exam_student(TYPE,idcard,examcard,studentName,location,grade) VALUES(2,6,'1234','54321','gansu',12);
SELECT * FROM exam_student WHERE IDCard='1234';


SELECT flowID FlowID,TYPE TYPE,idcard IDCard, examcard ExamCard,studentName StudentName,location Location,grade Grade FROM exam_student;
SELECT flowID flowID,TYPE TYPE,idcard idCard, examcard examCard,studentName studentName,location location,grade grade FROM exam_student WHERE flowid=3;

SELECT * FROM boys;
DELETE FROM boys WHERE id=7;

UPDATE boys SET usercp=usercp-100 WHERE id=1;
UPDATE boys SET usercp=usercp+100 WHERE id=4;

SHOW ENGINES
SHOW CREATE TABLE boys;
#显示数据表的状态信息
 SHOW TABLE STATUS FROM girls WHERE NAME='boys'
 
 SHOW PROCESSLIST 
