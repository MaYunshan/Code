#2.条件查询
/*
语法：
	select
		查询列表
	from
		表名
	where
		筛选条件;
分类：
	a.按条件表达式筛选
		条件运算符：> < = != >= <=
	b.按逻辑表达式筛选
		逻辑运算符：&& || !
			and or not
	c.模糊查询
		like
		between and
		in
		is null
		
*/
#1).按条件表达式查询
#查询工资大于12000的员工
SELECT * FROM employees WHERE salary>12000;
#查询部门编号不等于90号的员工名和部门编号
SELECT 
	last_name,
	department_id 
FROM 
	employees 
WHERE 
	department_id <> 90;
	
#2).按逻辑表达式筛选
#查询工资在10000到20000之间的员工名，工资以及奖金
SELECT last_name,salary,commission_pct FROM employees WHERE salary>=10000 AND salary<=20000;
#查询部门编号不是在90到100之间，或者工资高于15000的员工信息
SELECT * FROM employees WHERE department_id<90 OR department_id>110 OR salary>15000;	
	
#3).模糊查询
/*
like
特点：
	A.一般和通配符搭配使用
		% 任意多个字符，包含0个字符
		_ 任意单个字符
		
between and
in
is null
*/
#查询员工名中包含字母a的员工信息
SELECT * FROM employees WHERE last_name LIKE '%a%';
#查询员工名中第三个字符为e，第五个字符为a的员工名和工资
SELECT last_name,salary FROM employees WHERE last_name LIKE '__n_l%';
#查询员工名中第二个字符为下划线的员工名
SELECT last_name FROM employees WHERE last_name LIKE '_\_%';
SELECT last_name FROM employees WHERE last_name LIKE '_!_%' ESCAPE '!';

#查询员工编号在100到120之间的员工信息
SELECT * FROM employees WHERE employee_id >=100 AND employee_id<120;
SELECT * FROM employees WHERE employee_id BETWEEN 100 AND 120;

#查询员工的工种编号是 IT AD中的一个员工名和工种编号
SELECT last_name,job_id FROM employees WHERE job_id='IT_PROT' OR job_id='AD_VP' OR job_id='AD_PRES';
SELECT last_name,job_id FROM employees WHERE job_id IN ('IT_PROT','AD_VP','AD_PRES');

#查询没有奖金的员工名和奖金率
SELECT last_name,commission_pct FROM employees WHERE commission_pct IS NULL;

#安全等于 <=>
SELECT last_name,commission_pct FROM employees WHERE commission_pct <=> NULL;
SELECT last_name,salary FROM employees WHERE salary <=> 12000;

#案例测试
SELECT * FROM employees WHERE commission_pct LIKE '%%' OR last_name LIKE '%%';
SELECT * FROM employees WHERE commission_pct LIKE '%%' AND last_name LIKE '%%';











