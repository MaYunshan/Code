`empv1`#TCL
/*
transaction control language 事务控制语言
事务：
	一个或者一组sql语句组成一个执行单元，这个执行单元要么全部执行，要么全部不执行
特性：
	ACID
	A(原子性):一个事务不可再分割，要么都执行要么不执行
	C(一致性):一个事务执行会使数据从一个一致状态切换到另外一个一致状态
	I(隔离性):一个事务的执行不会受其它事务的干扰
	D(持久性):一个事务一旦提交，则会永远的改变数据库的数据

事务的创建
	隐式事务：事务没有明显地开启和结束的标记
	显式事务：事务具有明显地开启和结束的标记【必须先设置自动提交功能为禁用】
		开启事务：set autocommit=0;
	1.开启事务
		set autocommit=0;
		start transaction; 【可选的】
	2.编写事务中的sql语句(select insert update delete)
		语句1,
		语句2,
		...
	3.结束事务
		commit;提交事务
		rollback;回滚事务

savepoint：节点名，设置保存点

事务的并发问题：
	1)脏读：当一个事务读取到另外一个事务未提交的更新数据时称为脏读。例如当A和B两个事务并发执行，A事务如果读取到B事务没有提交的数据，
		这个时候如果B事务进行回滚，那么A事务得到的数据就不是数据库中的真实数据。
	2)不可重复读：当事务对同一行数据进行重复读取时，得到的数据不同时出现数据不一样的问题。例如当A和B两个事务进行并发执行，A要读取表中
		的一条记录，而B恰好要修改表中的这一条记录，当A读取时B恰好对这条记录进行了修改，那么当A再次对该条记录进行读取的时候内容已经发生了变化。
	3)幻读：一个事务读取到另一个事务已提交的新插入的数据。例如A和B并发执行，A中事务查询数据，B中事务插入或者删除数据，当A查询一个结果集时，B正好插入了
		一条记录，这时A再次查询时会出现以前没有的数据或者删除后的数据。
事务的隔离级别：	
				脏读		幻读		不可重复读
	read uncommitted:	可以		可以		可以
	read committed:		不可以		可以		可以
	repeatable read: 	不可以		不可以		可以
	serializable：		不可以		不可以		不可以
	
mysql中默认是第三个隔离级别：repeatable read
查看隔离级别
select @@transaction_isolation
show variables like 'transaction_isolation'
设置隔离级别
set session/global transaction isolation level 隔离级别

*/
USE books;
TRUNCATE account;
CREATE TABLE accout(
	id INT PRIMARY KEY,
	username VARCHAR(20),
	balance DOUBLE
);
INSERT INTO account VALUES(1,'张无忌',1000),(2,'赵敏',1000);
SELECT * FROM account;

#set autocommit=1;
#show variables like 'autocommit';

#开启事务
SET autocommit=1;
START TRANSACTION;
#编写一组事务的语句
UPDATE account SET balance=500 WHERE username='张无忌';
UPDATE account SET balance=1500 WHERE username='赵敏';
#结束事务
COMMIT;

SELECT * FROM account;



#设置保存点
SET autocommit=0;
START TRANSACTION;
DELETE FROM account WHERE id=1;
SAVEPOINT a;#设置保存点
DELETE FROM account WHERE id=2;
ROLLBACK TO a; #回滚到保存点





