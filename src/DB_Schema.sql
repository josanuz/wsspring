CREATE DATABASE `sprjpadata` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_pid` varchar(32) NOT NULL,
  `customer_name` varchar(32) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `unique_cpid` (`customer_pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE `account` (
  `owner_id` int(11) NOT NULL,
  `incomes` double NOT NULL,
  `outcomes` double NOT NULL,
  `creation_date` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  `account_number` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`account_number`),
  KEY `FK_OWNER_idx` (`owner_id`),
  CONSTRAINT `FK_OWNER` FOREIGN KEY (`owner_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


insert into account(account.owner_id,incomes,outcomes,creation_date,account.status) values(1,0,0,now(),1);
insert into account(account.owner_id,incomes,outcomes,creation_date,account.status) values(2,0,0,now(),1);
insert into account(account.owner_id,incomes,outcomes,creation_date,account.status) values(3,0,0,now(),1);
insert into account(account.owner_id,incomes,outcomes,creation_date,account.status) values(4,0,0,now(),1);

