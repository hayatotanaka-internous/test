set names utf8mb4;
set foreign_key_checks =0;
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50) unique,
admin_flg varchar(1),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);


INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date,update_date) VALUES("notebook",100,50,NOW(),NOW());
INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg) VALUES("internous","internous01","test","1");
INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg) VALUES("taro","123","taro-kun","1");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("1","1","1");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("2","2","2");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("3","3","3");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("4","4","4");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("5","5","5");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("6","6","6");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("7","7","7");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("8","8","8");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("9","9","9");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("10","10","10");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("11","11","11");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("12","12","12");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("13","13","13");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("14","14","14");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("15","15","15");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("16","16","16");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("17","17","17");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("18","18","18");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("19","19","19");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("20","20","20");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("21","21","21");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("22","22","22");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("23","23","23");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("24","24","24");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("25","25","25");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("26","26","26");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("27","27","27");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("28","28","28");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("29","29","29");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("30","30","30");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("31","31","31");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("32","32","32");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("33","33","33");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("34","34","34");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("35","35","35");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("36","36","36");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("37","37","37");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("38","38","38");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("39","39","39");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("40","40","40");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("41","41","41");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("42","42","42");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("43","43","43");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("44","44","44");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("45","45","45");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("46","46","46");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("47","47","47");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("48","48","48");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("49","49","49");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("50","50","50");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("51","51","51");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("52","52","52");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("53","53","53");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("54","54","54");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("55","55","55");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("56","56","56");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("57","57","57");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("58","58","58");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("59","59","59");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("60","60","60");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("61","61","61");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("62","62","62");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("63","63","63");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("64","64","64");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("65","65","65");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("66","66","66");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("67","67","67");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("68","68","68");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("69","69","69");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("70","70","70");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("71","71","71");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("72","72","72");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("73","73","73");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("74","74","74");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("75","75","75");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("76","76","76");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("77","77","77");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("78","78","78");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("79","79","79");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("80","80","80");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("81","81","81");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("82","82","82");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("83","83","83");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("84","84","84");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("85","85","85");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("86","86","86");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("87","87","87");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("88","88","88");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("89","89","89");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("90","90","90");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("91","91","91");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("92","92","92");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("93","93","93");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("94","94","94");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("95","95","95");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("96","96","96");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("97","97","97");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("98","98","98");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("99","99","99");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("100","100","100");
