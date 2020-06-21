#2.分组函数
/*
用作统计使用，又称为聚合函数，或组函数

分类：
	sum
	avg
	max
	min
	count
特点：
	1.sum，avg一般用于处理数值型；max，min，count可以处理任何类型
	2.以上分组函数都忽略null值
	3.可以和distinct搭配实现去重的运算
	4.一般使用count(*)用作统计行数
	5.和分组函数一同查询的字段要求是group by后的字段
*/

#1).简单的使用
SELECT SUM(salary) FROM employees;
SELECT AVG(salary) FROM employees;
SELECT MAX(salary) FROM employees;
SELECT MIN(salary) FROM employees;
SELECT COUNT(salary) FROM employees;

SELECT SUM(salary) AS 总工资,
        COUNT(salary) AS 总数,
        MAX(salary) AS 最大工资,
        MIN(salary) AS 最小工资,
        AVG(salary) AS 平均工资
         FROM employees;

#2).参数类型支持

#查询员工表中最大入职和最小入职时间之间的天数
SELECT DATEDIFF(MAX(hiredate),MIN(hiredate)) FROM employees;

#5.分组查询
/*
语法：
	select 分组函数,列(要求出现在group by的后面)
	from 表
	where 筛选条件
	group by 分组的列表
	order by 子句
注意：
	查询列表必须特殊，要求是分组函数和group by后面出现的字段
特点：
	分组查询中筛选条件分为2类
		1.分组前筛选	原始表			group by子句的前面 	where
		2.分组后筛选	分组后的结果集		group by子句的后面	having
	
	* 分组函数作为条件肯定是放在having子句中
	* 能用分组前筛选的，就尽量用分组前筛选
	* 支持单个或者多个字段分组，没有顺序要求
*/

#查询每个工种的最高工资
SELECT MAX(salary),job_id FROM employees GROUP BY job_id;

#查询每个位置上的部门个数
SELECT COUNT(*),location_id FROM departments GROUP BY location_id;

#查询邮箱中包含a字符的，每个部门的平均工资
SELECT AVG(salary),department_id FROM employees WHERE email LIKE '%a%' GROUP BY department_id;

#查询有奖金的每个领导手下的最高工资
SELECT MAX(salary),manager_id FROM employees WHERE commission_pct IS NOT NULL GROUP BY manager_id;

#查询那个部门的员工个数大于2
	#先查询每个部门的员工个数
SELECT COUNT(*),department_id FROM employees GROUP BY department_id;
	#根据上面的查询结果进行筛选
SELECT COUNT(*),department_id FROM employees GROUP BY department_id HAVING COUNT(*)>2;

#查询每个工种有奖金的员工的最高的工资大于12000的工种编号和最高工资
	#查询每个工种的最高工资
SELECT MAX(salary), job_id FROM employees WHERE commission_pct IS NOT NULL GROUP BY job_id;
SELECT MAX(salary), job_id FROM employees WHERE commission_pct IS NOT NULL GROUP BY job_id HAVING MAX(salary)>12000;

#查询领导编号>102的每个领导手下的最低工资>5000的领导编号是哪个，以及其最低工资
	#查询每个领导手下的最低工资
SELECT MIN(salary),manager_id FROM employees WHERE manager_id>120 GROUP BY manager_id;
SELECT MIN(salary),manager_id FROM employees WHERE manager_id>120 GROUP BY manager_id HAVING MIN(salary)>5000;

#按表达式或者函数筛选
#按员工姓名的长度分组，查询每一组的员工个数，筛选员工个数>5的有哪些
SELECT LENGTH(last_name),COUNT(*) FROM employees GROUP BY LENGTH(last_name) HAVING COUNT(*)>5;

#按多个字段分组
#查询每个部门每个工种的员工的平均工资
SELECT AVG(salary),department_id,job_id FROM employees GROUP BY department_id,job_id;

#添加排序
#查询每个部门每个工种的员工的平均工资并且进行排序
SELECT AVG(salary),department_id,job_id FROM employees GROUP BY department_id,job_id ORDER BY AVG(salary) DESC;


#使用含有NULL值的列作为排序键时，NULL会在结果的开头汇总显示
SELECT department_id,manager_id FROM departments ORDER BY manager_id;




