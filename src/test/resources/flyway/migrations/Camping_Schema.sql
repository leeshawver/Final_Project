DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS item_condition;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS season;

CREATE TABLE item_condition (
	-- item_condition_pk int unsigned NOT NULL AUTO_INCREMENT,
	-- item_condition_id varchar(40) NOT NULL,
	item_condition varchar(50) NOT NULL,
	PRIMARY KEY (item_condition)
);

CREATE TABLE category (
	-- category_pk int unsigned NOT NULL AUTO_INCREMENT,
	-- category_id varchar(40) NOT NULL,
	category varchar(50) NOT NULL,
	PRIMARY KEY (category)
);

CREATE TABLE season (
	-- season_pk int unsigned NOT NULL AUTO_INCREMENT,
	-- season_id varchar(40) NOT NULL,
	season varchar(50) NOT NULL,
	PRIMARY KEY (season)
);

CREATE TABLE item (
	item_pk int unsigned NOT NULL AUTO_INCREMENT,
	item_condition_fk VARCHAR(50) NOT NULL,
	category_fk VARCHAR(50) NOT NULL,
	season_fk VARCHAR(50) NOT NULL,	
	item_id varchar(50) NOT NULL,
	item_name varchar(50) NOT NULL,
	item_manufacturer varchar(50),
	PRIMARY KEY (item_pk),
	FOREIGN KEY (item_condition_fk) REFERENCES item_condition (item_condition),
	FOREIGN KEY (category_fk) REFERENCES category (category),
	FOREIGN KEY (season_fk) REFERENCES season (season)
);
