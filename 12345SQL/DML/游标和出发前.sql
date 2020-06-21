/*
	游标：本质上是一种能从select结果集中   每次提取一条记录的指针，主要用于交互式的应用程序
	    1.MySQL中的游标只用于存储过程和函数
	    2.
	
	游标的使用：定义游标-->开启游标-->获取结果-->关闭游标
	1.定义游标：游标在使用之前，必须先定义，让其与指定的select语句相关联，也就是让游标指向selcet语句的结果集
	2.开启游标：使用游标之前先打开游标
	3.使用游标：可以利用MySQL提供的fetch语句检索select结果集中的数据。每访问一次fetch语句就获取一行记录，
		获取数据之后由标的内布指针就会向前移动指向下一条记录，保证每次获取的数据都不同
	4.关闭游标：使用完之后关闭游标
*/

USE myemployees;
SELECT * FROM employees;
SELECT employee_id,salary FROM employees WHERE employee_id%5=0;

#游标的使用
#创建一个存储过程
DELIMITER $
   CREATE PROCEDURE cursor_employees()
BEGIN
    DECLARE mark,cur_id,cur_salary INT DEFAULT 0;
	
	#定义游标，并且让其和slect结果集绑定
	DECLARE curSalary CURSOR FOR
	SELECT employee_id,salary FROM employees WHERE employee_id%2=0;
	
	#自定义错误处理程序，结束游标的遍历
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET mark=1;
	#declare continue handler for not found set flag = 1;
	
	#打开游标
	OPEN curSalary;
	
	#遍历游标
	REPEAT
		#利用游标获取下一行数据
		FETCH curSalary INTO cur_id,cur_salary;
		#处理游标检索的数据
		IF cur_salary < 10000 THEN
			SET cur_salary = cur_salary+3000;
			UPDATE employees SET salary=cur_salary WHERE employee_id = cur_id;
		END IF;
	UNTIL mark END REPEAT;
	#关闭游标
	CLOSE curSalary;		
END $
DELIMITER ;

#调用存储过程
CALL cursor_employees();


#触发器：一种特殊的存储过程，区别在于存储过程使用时需要调用，而触发器是在预先定义好的事件(如insert，update)发生时被MySQL自动调用。
#创建触发器时需要与数据表相关联，当表发生特定事件时，就会自动执行触发器中预定的SQL语句

/*
    创建触发器
    create trigger <触发器名称>  <触发时机>  <触发事件>  on  <表> for each row <触发顺序>
    begin
        操作内容
    end
*/

USE girls;
SELECT * FROM boys;

#当向beauty表中插入数据时，触发器也向boys表中插入数据
DELIMITER $
CREATE TRIGGER insert_trigger BEFORE INSERT ON beauty FOR EACH ROW
BEGIN
    INSERT INTO boys(boyName,userCP,picture) VALUES('乔峰',200,NULL);
END $
DELIMITER ;

#向beauty表中插入数据
INSERT INTO beauty(NAME,sex,borndate,phone,boyfriend_id) VALUES('小龙女','女',NOW(),'1234566',3);
SELECT * FROM beauty;


#存储引擎

SHOW ENGINES;

#在boyName上创建普通索引
ALTER TABLE boys ADD INDEX name_index(boyName);
SHOW CREATE TABLE boys;

EXPLAIN SELECT boyName FROM boys WHERE boyName='乔峰';
EXPLAIN SELECT boyName FROM boys WHERE id-1=4;

