#4.常见函数
/*


*/

#a.字符函数

#1).length 统计传入参数的字符的字节个数
SELECT LENGTH('john');
SELECT LENGTH('马云山');

#1.1). char_length() 获取字符个数
SELECT CHAR_LENGTH('马云山');


#显示当前采用的编码
SHOW VARIABLES LIKE '%char%';

#2).concat拼接字符串
SELECT CONCAT(last_name,'_',first_name) AS 姓名 FROM employees;

#3).upper,lower大小写转换
SELECT UPPER('john');
SELECT CONCAT(UPPER(last_name),'_',LOWER(first_name)) AS 姓名 FROM employees;

#4).substr,substring字符截取
	#从指定索引处开始截取字符串
SELECT SUBSTR('现代控制理论',5) AS output;
	#从指定索引处截取指定字符长度的字符串
SELECT SUBSTR('现代控制理论',1,2) AS output;
	#姓名中首字符大写，其它字符小写然后拼接
SELECT CONCAT(UPPER(SUBSTR(last_name,1,1)),'_',LOWER(SUBSTR(last_name,2))) AS output FROM employees;

#5).instr 返回子串在给定字符串中首次出现的索引，如果字符串不包含给定的子串，返回0
SELECT INSTR('现代控制理论','控制') AS output;

#6).trim 去除前后的空格
SELECT LENGTH(TRIM('     现代控制理论        ')) AS output; 
SELECT TRIM('a' FROM 'aaaaaaaaaaaa现aaaaaaa代aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa') AS output;

#7).lpad , rpad 用指定的字符左填充指定长度
SELECT LPAD('理论',5,'a') AS output;
SELECT RPAD('理论',5,'a') AS output;

#8).replace 字符串替换
SELECT REPLACE('现代控制理论','现代','自动') AS output;

#b.数学函数

#1).round 四舍五入
SELECT ROUND(1.4)AS output;
SELECT ROUND(2.5) AS output;
SELECT ROUND(-1.4)AS output;
SELECT ROUND(-2.5) AS output;
SELECT ROUND(2.555555,3) AS output;

#2).ceil 向上取整,返回大于等于该数的最大整数
SELECT CEIL(1.002) AS output;
SELECT CEIL(-1.002) AS output;

#3).floor 向下取整,返回小于等于该数的最大整数
SELECT FLOOR(-1.002) AS output;
SELECT FLOOR(1.002) AS output;

#4).truncate 截断 保留小数点后面的位数
SELECT TRUNCATE(1.5555555,2);

#5).mod 取余
SELECT MOD(5,2);
SELECT MOD(-10,-3);
SELECT MOD(10,-3);


#3.日期函数

#1).now 返回当前系统日期+时间
SELECT NOW();

#2).curdate 返回当前系统的日期，不包含时间
SELECT CURDATE();

#3).curtime 返回当前系统的时间，不包含日期
SELECT CURTIME();

#可以获取指定的部分，年、月、日、小时、分钟、秒
SELECT YEAR(NOW());
SELECT YEAR('1998-1-1');
SELECT YEAR(hiredate) FROM employees;

SELECT MONTH(NOW());
SELECT MONTHNAME(NOW());

SELECT DAY(NOW());

#4).str_to_date 将字符串按照指定的格式转化为日期
SELECT STR_TO_DATE('1998-3-14','%Y-%c-%d') AS date1;
	#查询入职日期为1992-4-3的员工信息
SELECT * FROM employees WHERE hiredate='1992-3-4';

SELECT * FROM employees WHERE hiredate=STR_TO_DATE('4-3 1992','%c-%d %Y');

#5).date_format 将日期转化为字符串
SELECT DATE_FORMAT(NOW(),'%y年%m月%d日') AS output;
	#查询有奖金的员工名和入职日期
SELECT last_name,DATE_FORMAT(hiredate,'%m月/%d日 %y年'),commission_pct FROM employees WHERE commission_pct IS NOT NULL;

#4.其它函数

SELECT VERSION();
SELECT DATABASE();
SELECT USER();


#5.流程控制函数

#1).if函数: if else的效果
SELECT IF(10>5,'大','小');
SELECT last_name, commission_pct, IF(commission_pct IS NULL,'没有奖金','有奖金') AS 奖金 FROM employees;

#2).case函数的使用：1.switch case的效果   
		# 2.类似于多重if
	
/*
case 要判断的字段或者表达式
when 常量1 then 语句1
when 常量2 then 语句2
...
else 语句
end

*/

/*
case 
when 条件1 then 执行的表达式1
when 条件2 then 执行的表达式2
when 条件3 then 执行的表达式3
...
else 要执行的表达式 
end
*/

SELECT salary,department_id,
	CASE department_id
	WHEN 30 THEN salary*1.1
	WHEN 40 THEN salary*1.2
	WHEN 50 THEN salary*1.3
	ELSE salary
	END 
	AS 新工资
FROM employees;

SELECT salary,
CASE
WHEN salary>20000 THEN 'A'
WHEN salary>15000 THEN 'B'
WHEN salary>10000 THEN 'C'
ELSE  'D'
END
AS 工资级别
FROM employees;




