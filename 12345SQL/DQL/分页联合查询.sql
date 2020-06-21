#8.分页查询
/*
应用场景：当要显示的数据，一页不能完全展示，需要分页提交sql请求
语法：
	select 
	....
	....
	....
	limit offset,size;
	
	offset 要显示条目的起始索引(索引从0开始)
	size：要显示的条目个数

*/
#1.查询前五条员工信息
SELECT * FROM employees LIMIT 0,5;

#2.查询第11条到第25条的员工信息
SELECT * FROM employees LIMIT 10,15;

#3.有奖金的员工的前10
SELECT * 
FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY salary DESC
LIMIT 0,10;


SELECT 查询列表			7
FROM 表1				1
连接类型 JOIN 表2			2
ON 连接条件			3		根据连接条件形成一个虚拟表
WHERE 筛选条件			4
GROUP BY 分组条件			5
HAVING 分组后的筛选		6		也会形成一个虚拟表
ORDER BY 排序列表			8
LIMIT 偏移，条目数			9


#9.联合查询
/*
union 联合 合并：将多条查询语句的结果合并成一个结果
查询语句1
union
查询语句2
union
查询语句3
....

*/

#9.1 查询部门编号>99或者邮箱中包含a的员工信息
SELECT * FROM employees WHERE email LIKE '%a%' OR department_id>90;

SELECT * FROM employees WHERE email LIKE '%a%'
UNION 
SELECT * FROM employees WHERE department_id>90;

















