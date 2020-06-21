#常见的数据类型
/*
数值型：
	整型：Tinyint(1)、smallint(2)、mediumint(3)、int/integer(4)、bigint(8)
	小数：
		定点数
		浮点数
字符型：
	较短的文本：char、varchar
	较长的文本：text、blob(较长的二进制数据)
日期型：
*/

#一，整型[默认是有符号]
#1.如何设置无符号和有符号
DROP TABLE IF EXISTS tab_int;
CREATE TABLE tab_int(
	t1 INT,
	t2 INT UNSIGNED
);
DESC tab_int;

INSERT INTO tab_int VALUES(-12346,123);
SELECT * FROM tab_int;

#二.小数
/*
浮点型
	float(M,D)
	double(M,D)
定点型
	dec(M,D)
	decimal(M,D)
	
特点：
	M:整数部位和小数部位的总长度
	D:小数点后面的位数

*/
DROP TABLE IF EXISTS tab_float;
CREATE TABLE tab_float(
	f1 FLOAT,
	f2 DOUBLE,
	f3 DECIMAL(5,2)
);
INSERT INTO tab_float VALUES(123.45,123.45,123.45);
SELECT * FROM tab_float;

#三,字符型
/*
较短的文本
	char
	varchar
较长的文本
	text
	blob(较大的二进制)

*/

#四，日期型
/*
date:日期
time：时间
year：年份
datetime：日期时间【不受时区的影响】
timestamp：日期时间【受时区的影响】

*/





















