DROP DATABASE IF EXISTS camping;
CREATE DATABASE IF NOT EXISTS camping;
USE camping;

DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS item_condition;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS season;

CREATE TABLE item_condition (
	item_condition_pk int unsigned NOT NULL AUTO_INCREMENT,
	item_condition_id varchar(40) NOT NULL,
	item_condition varchar(50) NOT NULL,
	PRIMARY KEY (item_condition_pk)
);

CREATE TABLE category (
	category_pk int unsigned NOT NULL AUTO_INCREMENT,
	category_id varchar(40) NOT NULL,
	category varchar(50) NOT NULL,
	PRIMARY KEY (category_pk)
);

CREATE TABLE season (
	season_pk int unsigned NOT NULL AUTO_INCREMENT,
	season_id varchar(40) NOT NULL,
	season varchar(50) NOT NULL,
	PRIMARY KEY (season_pk)
);

CREATE TABLE item (
	item_pk int unsigned NOT NULL AUTO_INCREMENT,
	item_condition_fk int unsigned NOT NULL,
	category_fk int unsigned NOT NULL,
	season_fk int unsigned NOT NULL,	
	item_id varchar(40) NOT NULL,
	item_name varchar(50) NOT NULL,
	item_manufacturer varchar(50),
	PRIMARY KEY (item_pk),
	FOREIGN KEY (item_condition_fk) REFERENCES item_condition (item_condition_pk),
	FOREIGN KEY (category_fk) REFERENCES category (category_pk),
	FOREIGN KEY (season_fk) REFERENCES season (season_pk)
);
