#7.子查询
/*
含义：
	出现在其它语句中的select语句，或称为内查询
	外部的查询语句，称为主查询或外查询
分类：
	按子查询出现的位置
		select后面：仅仅支持标量子查询
		from后面：支持表子查询
		where或者having后面【☆】：支持单行子查询、列子查询
		exists后面(相关查询)：支持表子查询
	按功能不同出现的位置
		标量子查询(结果只有一行一列)
		列子查询(结果只有一列多行)
		行子查询(结果集有多行多列)
		表子查询(结果集一般为多行多列)
特点：
	子查询的优先级高于外查询

*/

#1.查询在where或者having后面
#1).标量子查询(单行子查询)
#1.1 谁的工资比Abel高
SELECT salary 
FROM employees
WHERE last_name='Abel';

SELECT * 
FROM employees 
WHERE salary>(
	SELECT salary 
	FROM employees
	WHERE last_name='Abel'
);

#1.2 返回job_id与141号相同的员工，salary比143号员工多的员工姓名，job_id和工资
SELECT last_name,job_id,salary
FROM employees
WHERE job_id=(
	SELECT job_id
	FROM employees
	WHERE employee_id=141
)
AND salary>(
	SELECT salary
	FROM employees
	WHERE employee_id=143
);

#1.3 返回公司工资最少的员工的last_name,job_id和salary
SELECT last_name,salary,job_id
FROM employees
WHERE salary=(
	SELECT MIN(salary)
	FROM employees
);

#1.4 查询最低工资大于50号部门最低工资的部门id和其最低工资
SELECT MIN(salary)
FROM employees
WHERE department_id=50;

SELECT MIN(salary),department_id
FROM employees
GROUP BY department_id;

SELECT MIN(salary),department_id
FROM employees
GROUP BY department_id
HAVING MIN(salary)>(
	SELECT MIN(salary)
	FROM employees
	WHERE department_id=50
);

SELECT department_id,salary
FROM employees
WHERE salary >


#2).列子查询(多行子查询)
#2.1 查询location_id是1400或1700的部门中的所有员工姓名
SELECT department_id,location_id
FROM departments
WHERE location_id=1400
OR location_id=1700;

SELECT last_name
FROM employees
WHERE department_id IN(
	SELECT department_id
	FROM departments
	WHERE location_id=1400
	OR location_id=1700
);

#2.2 查询其它部门中比job_id为‘IT_PROG’部门任一工资低的员工的：工号，姓名。job_id以及salary
SELECT MIN(salary)
FROM employees
WHERE job_id='IT_PROG'

SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary<(
	SELECT MIN(salary)
	FROM employees
	WHERE job_id='IT_PROG'
)AND job_id <>'IT_PROG';

#小于任一一个
SELECT DISTINCT salary
FROM employees
WHERE job_id='IT_PROG'

SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary <ANY(
	SELECT salary
	FROM employees
	WHERE job_id='IT_PROG'
)AND job_id <>'IT_PROG';

#2.3查询其它工种中比job_id为‘IT_PROG’部门所有工资低的员工的：工号，姓名。job_id以及salary
SELECT MIN(salary)
FROM employees
WHERE job_id='IT_PROG'

SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary<(
	SELECT MIN(salary)
	FROM employees
	WHERE job_id='IT_PROG'
)AND job_id <>'IT_PROG';


#3).行子查询（结果集一行多列或多行多列）
#查询员工编号最小并且工资最高的员工信息

SELECT MIN(employee_id)
FROM employees

SELECT MAX(salary)
FROM employees

SELECT *
FROM employees
WHERE (employee_id,salary)=(
	SELECT MIN(employee_id),MAX(salary)
	FROM employees
);


SELECT *
FROM employees
WHERE employee_id=(
	SELECT MIN(employee_id)
	FROM employees
)AND(
	SELECT MAX(salary)
	FROM employees
);

#2.放在select后面
#查询每个部门的人数
SELECT COUNT(*)
FROM employees
GROUP BY department_id;

SELECT d.*,(
	SELECT COUNT(*)
	FROM employees e
	WHERE d.department_id=e.department_id
) 个数
FROM departments d;

#查询员工号=102的部门名
SELECT department_name
FROM departments d
WHERE department_id=(
	SELECT department_id
	FROM employees
	WHERE employee_id=103
);

SELECT department_name
FROM departments d
INNER JOIN employees e
ON e.`department_id`=d.`department_id`
WHERE e.`employee_id`=103;


#3.from后面
#3.1查询每个部门的平均工资的工资等级
SELECT AVG(salary) ag,department_id
FROM employees
GROUP BY department_id

SELECT ag_table.*,grade_level
FROM (
	SELECT AVG(salary) ag,department_id
	FROM employees
	GROUP BY department_id
) ag_table
INNER JOIN job_grades jg
ON ag_table.ag BETWEEN jg.lowest_sal AND jg.highest_sal;


#4.放在exists后面(相关子查询)
#exists返回一个bool值，判断后面的查询结果是否为空
SELECT EXISTS(SELECT employee_id FROM employees);
  
#4.1 查询有员工的部门名
SELECT department_name
FROM departments d
WHERE EXISTS(
	SELECT *
	FROM employees e
	WHERE e.`department_id`=d.`department_id`
);

SELECT department_name
FROM departments d
WHERE department_id IN (
	SELECT department_id
	FROM employees
);

#4.2 查询没有女朋友的男生
USE girls;
SELECT bo.*
FROM boys bo
WHERE bo.id NOT IN (
	SELECT boyfriend_id
	FROM beauty
);

#4.3查询本部门中比平均工资高的员工的姓名，员工号，工资
SELECT AVG(salary)
FROM employees
GROUP BY department_id

SELECT employee_id,last_name,salary,e.department_id,ag_table.ag
FROM employees e
INNER JOIN (
	SELECT AVG(salary) ag,department_id
	FROM employees
	GROUP BY department_id
) ag_table
ON e.department_id=ag_table.department_id
WHERE e.salary>ag_table.ag;









