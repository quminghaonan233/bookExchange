use book_exchange;

drop table if exists user;

create table user(
	uId int(11) primary key auto_increment,
    userName varchar(50),
    passwd varchar(50),
    score int(11),
    credit int(11)
)charset utf8;

drop table if exists book;

create table book(
	bId int(11) primary key auto_increment,
    bookName varchar(100),
    book_owner int(11),
    bookType varchar(100),
    publisher varchar(100),
    author varchar(100),
    newDegree varchar(100),
    address varchar(100),
    onSale int(1),
    isDel int(1),
    price int(11),
    img varchar(100),
    foreign key(book_owner) references user(uId)
)charset utf8;

drop table if exists trade;

create table trade(
	tId int(11) primary key auto_increment,
    buyer int(11),
    bId int(11),
    start datetime,
    end datetime,
    sendTo varchar(100),
    status int(1),
    foreign key(buyer) references user(uId),
    foreign key(bId) references book(bId)
)charset utf8;

drop table if exists trade_cancel;

create table trade_cancel(
	tId int(11),
    initiate int(11),
    description varchar(100),
    status int(1),
    foreign key(tId) references trade(tId),
    foreign key(initiate) references user(uId)
)charset utf8;
