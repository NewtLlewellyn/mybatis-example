create database librarydb default character set utf8mb4 collate utf8mb4_unicode_ci;
use librarydb;
create table book(
bookid varchar(64) primary key,
bookname varchar(300) not null,
author varchar(100),
price double,
isbn varchar(100),
press varchar(300),
vtype varchar(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into book(bookid, bookname, isbn, vtype, price, author, press) values ('432545fff4', 'ttt', '111', 'book',10.01, 'mmma', 'kkk');

drop database librarydb;

select * from book;