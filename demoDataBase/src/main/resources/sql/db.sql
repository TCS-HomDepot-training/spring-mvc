CREATE DATABASE db_grocery;
use db_grocery;

CREATE TABLE grocery (
ID INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
NAME VARCHAR(50) NOT NULL, 
UNIT_PRICE DEC(6,2) NOT NULL, 
DISCOUNT DEC(6,2) DEFAULT NULL, 
LAST_UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);