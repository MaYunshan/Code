#6.连接查询
/*
含义：又称为多表查询，当查询的字段来自多张表，就会用到连接查询

笛卡尔乘积现象：表1有m行，表2有n行，结果=m*n行

分类：
	按照年代分类
		sql92标准【仅仅支持内连接】
		sql99标准(推荐)【支持内连接+外连接(左外和全外)+交叉连接】
	按照功能分类
		内连接
			等值连接
			非等值连接
			自连接
		外连接
			左外连接
			右外连接
			全外连接
		交叉连接
*/

/*
sql99语法
	select 查询列表
	from 表1 别名 【连接类型】
	join 表2 别名
	on 连接条件
	【where 筛选条件】
	【group by 分组】
	【having 筛选条件】
	【order by 排序列表】
分类
	内连接：inner
	外连接：
		左外：left 【outer】
		右外：right 【outer】
		全外：full 【outer】
	交叉连接：cross
*/

USE girls;
SELECT * FROM boys;
SELECT * FROM beauty;

#笛卡尔乘积现象
SELECT NAME,boyName FROM boys,beauty;

#根据连接条件查找
SELECT NAME,boyName FROM boys,beauty WHERE beauty.boyfriend_id=boys.id;


#a.内连接

#1).等值连接

#1.1查询女生名字和对应的男生名字
SELECT NAME,boyName FROM boys,beauty WHERE beauty.boyfriend_id=boys.id;

#1.2查询员工名和对应的部门名
SELECT last_name,department_name FROM employees,departments WHERE employees.`department_id`=departments.`department_id`;

#1.3.为表起别名[提高语句的简洁度，区分多个重名的字段]【如果起了别名，则查询的字段就不能使用原来的表名】
#查询员工名、工种号、工种名
SELECT last_name,e.job_id,job_title FROM employees AS e,jobs AS j WHERE e.`job_id`=j.`job_id`;

#加入筛选条件
#1.4查询有奖金的员工名、部门名[]
SELECT 
	last_name,department_name,commission_pct
FROM
	employees AS e,departments AS d 
WHERE 
	commission_pct IS NOT NULL 
AND 
	e.`department_id`=d.`department_id` ;

#1.5查询城市名中第二个字符为o的部门名和城市名
SELECT 
	department_name,city 
FROM
	departments AS d,locations AS l
WHERE
	d.`location_id`= l.`location_id`
AND 
	city LIKE '_o%';

#可以加入分组
#1.6查询每个城市的部门个数
SELECT COUNT(*),city 
FROM departments AS d,locations AS l
WHERE d.`location_id`=l.`location_id`
GROUP BY city;

#1.7查询有奖金的每个部门的部门名和部门的领导编号和该部门的最低工资
SELECT MIN(salary),d.manager_id,department_name
FROM employees AS e,departments AS d
WHERE e.`commission_pct` IS NOT NULL 
AND e.`department_id`=d.`department_id`
GROUP BY department_name,d.`manager_id`;

#可以加入排序
#1.7 查询每个工种的工种名和员工的个数，并且按照员工人数降序
SELECT job_title,COUNT(*)
FROM employees AS e,jobs AS j
WHERE e.`job_id`=j.`job_id`
GROUP BY job_title
ORDER BY COUNT(*)

#实现三表连接
#1.8 查询员工名、部门名和所在的城市
SELECT last_name,department_name,city
FROM employees AS e,departments AS d,locations AS l
WHERE e.`department_id`=d.department_id
AND d.location_id=l.location_id;


#2).非等值连接

/*CREATE TABLE job_grades
(grade_level VARCHAR(3),
 lowest_sal  int,
 highest_sal int);

INSERT INTO job_grades
VALUES ('A', 1000, 2999);

INSERT INTO job_grades
VALUES ('B', 3000, 5999);

INSERT INTO job_grades
VALUES('C', 6000, 9999);

INSERT INTO job_grades
VALUES('D', 10000, 14999);

INSERT INTO job_grades
VALUES('E', 15000, 24999);

INSERT INTO job_grades
VALUES('F', 25000, 40000);*/

#查询员工的工资和工资级别
SELECT salary, grade_level
FROM employees AS e,job_grades AS jg
WHERE salary BETWEEN jg.`lowest_sal` AND jg.`highest_sal`
AND jg.`grade_level`='A';


#3.自连接[在一张表内查找]
#查询员工名和上级的名称
SELECT e.employee_id,e.last_name,m.employee_id,m.last_name
FROM employees AS e,employees AS m
WHERE e.`manager_id`=m.`employee_id`;


###################################################################
#———————————————————————sql99语法——————————————————————————————————#
#1.内连接
/*
select 查询列表
from 表1 别名
inner join 表2 别名
on 连接条件

	等值连接
	非等值连接
	自连接
*/
#1).等值连接
#1.1 查询员工名、部门名
SELECT last_name,department_name
FROM employees AS e
INNER JOIN departments AS d
ON e.`department_id`=d.`department_id`;

#1.2 查询名字中包含e的员工名和工种名
SELECT last_name,job_title
FROM employees e
INNER JOIN jobs j
ON e.`job_id`=j.`job_id`
WHERE last_name LIKE '%e%';

#1.3 查询部门个数>3的城市名和部门个数
SELECT COUNT(*) AS 部门个数,city
FROM departments AS d
INNER JOIN locations AS l
ON d.`location_id`=l.`location_id`
GROUP BY l.`city`
HAVING COUNT(*);

#1.4 查询哪个部门的员工个数>3的部门名和员工个数，并且按降序排序
SELECT COUNT(*) 员工个数,department_name
FROM employees e
INNER JOIN departments d
ON e.`department_id`=d.`department_id`
GROUP BY e.`department_id`
HAVING COUNT(*)
ORDER BY COUNT(*) DESC;

#1.5 查询员工名、部门名、工种名，并且按照部门名降序
SELECT last_name,department_name,job_title
FROM employees e
INNER JOIN departments d ON e.`department_id`=d.`department_id`
INNER JOIN jobs j ON e.`job_id`=j.`job_id`
ORDER BY department_name DESC;


#2).非等值连接
#2.1查询员工的工资级别
SELECT salary,grade_level
FROM employees e
INNER JOIN job_grades g
ON e.`salary` BETWEEN g.`lowest_sal` AND g.`highest_sal`;



#2.外连接
/*
应用场景：查询一个表中有另外一个表中没有的项

特点：外连接的查询结果为主表中的所有记录
	如果从表中有和它匹配的，则显示匹配的值
	如果从表中没有和它匹配的，则显示null
	外连接查询结果=内连接查询结果+主表中有而从表中没有的记录
2.左外连接，left join 左边的是主表
  右外连接，right join 右边的是主表
3.左外连接和右外连接可以通过交换标的顺序来实现相同的查询结果
4.全外连接=内连接+左外+右外

*/
# 没有男朋友的女生名字
SELECT g.`name`,bo.id,bo.`boyName`
FROM beauty g
LEFT OUTER JOIN boys bo
ON g.`boyfriend_id`=bo.`id`
WHERE bo.`id` IS NULL;

#2.1 查询那个部门没有员工
SELECT department_name,e.`last_name`,e.`department_id`
FROM departments d
LEFT OUTER JOIN employees e
ON d.`department_id`=e.`department_id`
WHERE employee_id IS NULL;


#3.全外连接
USE girls;


#4.交叉连接
SELECT beauty.*,boys.*
FROM beauty
CROSS JOIN boys





