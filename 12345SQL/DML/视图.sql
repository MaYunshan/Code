#视图
/*
含义：虚拟表，是动态生成的数据



*/

#一，创建视图
USE myemployees;
SET autocommit=1;
#1.查询邮箱中包含字符a的员工名、部门名和工种信息
CREATE VIEW myv1
AS 
SELECT last_name,department_name,job_title
FROM employees e
INNER JOIN departments d
ON e.department_id=d.department_id
INNER JOIN jobs j
ON e.job_id=j.job_id;

SELECT * FROM myv1 WHERE last_name LIKE '%a%';

#2.查询各部门的平均工资级别
CREATE VIEW myv2
AS
SELECT department_name, AVG(salary) ag
FROM employees e
INNER JOIN departments d
ON e.department_id=d.department_id
GROUP BY e.department_id;

SELECT myv2.`ag`,grade_level
FROM myv2 
INNER JOIN job_grades jg
ON myv2.`ag` BETWEEN jg.`lowest_sal` AND jg.`highest_sal`;

#3.查询平均工资最低的部门的信息
CREATE VIEW myv3
AS
SELECT e.department_id,department_name,d.manager_id,location_id,AVG(salary) ag
FROM departments d
INNER JOIN employees e
ON d.`department_id`=e.`department_id`
GROUP BY e.`department_id`; 

SELECT * FROM myv3 ORDER BY ag LIMIT 1;  


#二，视图的修改
/*
1.
	create or replace view 视图名
	as
	查询语句

2.
	alter view 视图名
	as
	查询语句

*/
ALTER VIEW myv3
AS
SELECT e.department_id,department_name,d.manager_id,location_id,AVG(salary) ag
FROM departments d
INNER JOIN employees e
ON d.`department_id`=e.`department_id`
GROUP BY e.`department_id`; 


#三.删除视图
/*
drop view 视图名1，视图名2,....;

*/


#四 查看视图
DESC myv3;
SHOW CREATE VIEW myv3;

#4.1创建视图empv1，要求出现电话号码以011开头的员工姓名和工资以及邮箱
CREATE VIEW empv1
AS
SELECT last_name,salary,email,phone_number
FROM employees;

SELECT last_name,salary,email FROM empv1
WHERE phone_number LIKE '011%';

#4.2创建视图empv2，要求查询部门的最高工资高于12000的部门信息
CREATE VIEW empv2
AS
SELECT e.department_id,d.manager_id,location_id, MAX(salary) maxsalary
FROM employees e
INNER JOIN departments d
ON e.department_id=d.department_id
GROUP BY e.department_id;

SELECT * FROM empv2
WHERE maxsalary>12000;


#五.视图的更新
CREATE OR REPLACE VIEW v1
AS
SELECT last_name,email FROM employees;

SELECT * FROM v1;

#1.插入[原始表中同时也插入了]
INSERT INTO v1 VALUES('张飞','333');

#2.修改[原始表中也修改了]
UPDATE v1 SET last_name='张无忌' WHERE last_name='张飞';

#3.删除[原始表中也修改了]
DELETE FROM v1 WHERE last_name='张无忌';




