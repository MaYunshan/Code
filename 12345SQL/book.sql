#1.创建用户表
CREATE TABLE bs_user(
	id INTEGER(11) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(100) NOT NULL UNIQUE,
	PASSWORD VARCHAR(100) NOT NULL ,
	email VARCHAR(100)
);

#2.创建图书表
CREATE TABLE bs_book(
	id INTEGER(11) PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	author VARCHAR(100) NOT NULL,
	price DOUBLE(11,2) NOT NULL,
	sales INTEGER(11),
	stock INTEGER(11),
	img_path VARCHAR(100)
	
);

INSERT INTO bs_book(title,author,price,sales,stock img_path) 

SELECT * FROM bs_book;


SELECT * FROM bs_user;

INSERT INTO bs_book(title,author,price,sales,stocks,img_path) VALUE('C#','mys',20.00,10,100,'/static/img/default.jpg');

SELECT * FROM bs_book LIMIT 10,5;

UPDATE bs_book SET img_path='/static/img/default.jpg' WHERE id IN(15,16,18);
