set names utf8mb4;

use ecsite;
drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);
INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date,update_date) VALUES("notebook",100,50,NOW(),NOW());
INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date,update_date) VALUES("water",200,70,NOW(),NOW());
UPDATE item_info_transaction set item_stock ="50", insert_date=NOW(), update_date=NOW() WHERE id =1;
UPDATE item_info_transaction set item_stock ="70", insert_date=NOW(), update_date=NOW() WHERE id =2;
INSERT INTO login_user_transaction(login_id, login_pass, user_name,admin_flg) VALUES("internous", "internous01", "test","0");
INSERT INTO login_user_transaction(login_id, login_pass, user_name,admin_flg) VALUES("admin", "admin", "admin","1");