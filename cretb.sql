create table if not exists javademo02.stock
(
seq int primary key auto_increment,
stockno varchar(50) not null,
stocknm varchar(50) not null,
lastprice decimal(10,2) not null,
tradetime varchar(50) not null,
createtime DATETIME default current_timestamp
) 



