#3.排序查询
/*
语法：
	select 查询列表 
	from employees 
	where 【筛选条件】
	 order by 【排序列表】 [asc|desc]
特点：asc是升序，desc是降序，默认是asc
*/

#查询员工信息，要求工资从高到低
SELECT * FROM employees ORDER BY salary ASC;
SELECT * FROM employees ORDER BY salary DESC;

#查询部门编号大于等于90的员工信息，按照入职时间进行排序
SELECT * FROM employees WHERE department_id >=90 ORDER BY hiredate;

#按表达式排序，按年薪的高低显示员工的信息和年薪
SELECT 
	*,
	salary*12*(1+IFNULL(commission_pct,0)) AS 年薪 
FROM 
	employees 
ORDER BY 
	salary*12*(1+IFNULL(commission_pct,0)) DESC; 

#按别名排序，按年薪的高低显示员工的信息和年薪
SELECT 
	*,
	salary*12*(1+IFNULL(commission_pct,0)) AS 年薪 
FROM 
	employees 
ORDER BY 
	年薪 DESC;

#按照姓名的长度显示员工的姓名和工资 
SELECT 
	LENGTH(last_name) AS 字节长度,
	last_name,
	salary 
FROM employees 
ORDER BY LENGTH(last_name);

#查询员工信息，要求先按照工资排序，然后按照员工编号排序
SELECT * FROM employees ORDER BY salary ASC,employee_id DESC;

