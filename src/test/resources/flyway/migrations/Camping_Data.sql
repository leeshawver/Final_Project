-- copy into SQL file in SpringBoot when finished

-- Season
INSERT INTO season (season) VALUES ("SPRING");
INSERT INTO season (season) VALUES ("SUMMER");
INSERT INTO season (season) VALUES ("FALL");
INSERT INTO season (season) VALUES ("WINTER");
INSERT INTO season (season) VALUES ("ALL");

-- Item condition
INSERT INTO item_condition (item_condition) VALUES ("NEW");
INSERT INTO item_condition (item_condition) VALUES ("GOOD");
INSERT INTO item_condition (item_condition) VALUES ("USED");
INSERT INTO item_condition (item_condition) VALUES ("REPAIR");
INSERT INTO item_condition (item_condition) VALUES ("LOANED");
INSERT INTO item_condition (item_condition) VALUES ("REPLACE");

-- Category
INSERT INTO category (category) VALUES ("SLEEP");
INSERT INTO category (category) VALUES ("COOKING");
INSERT INTO category (category) VALUES ("MISC");
INSERT INTO category (category) VALUES ("REPAIR");
INSERT INTO category (category) VALUES ("FIRST_AID");
INSERT INTO category (category) VALUES ("NAVIGATION");
INSERT INTO category (category) VALUES ("CLOTHING");

-- Item
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("REPAIR", "SLEEP", "WINTER", "TENT", "Bivy", "Northface");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("NEW", "SLEEP", "FALL", "SLEEPINGBAG", "Down quilt", "Enlightened Equipment");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("USED", "SLEEP", "WINTER", "SLEEPINGBAG", "Origin subzero", "Sierra Designs");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("USED", "SLEEP", "SUMMER", "SLEEPINGBAG", "Blue summer", "Eddie Bauer");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("NEW", "SLEEP", "SPRING", "SLEEPINGBAG", "Cosmic 20", "Kelty");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("NEW", "CLOTHING", "WINTER", "HAT", "Balaklava", "Outdoor Vitals");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("USED", "CLOTHING", "ALL", "HAT", "Red cashmir", "Unknown");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("USED", "CLOTHING", "FALL", "HAT", "Camp Lassen beanie", "Unknown");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("NEW", "SLEEP", "WINTER", "SLEEPING_PAD", "NeoAir XLite", "Thermarest");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("NEW", "SLEEP", "SUMMER", "SLEEPING_PAD", "Z-Rest", "Thermarest");
INSERT INTO item (item_condition_fk, category_fk, season_fk, item_id, item_name, item_manufacturer) VALUES ("USED", "SLEEP", "ALL", "SLEEPING_PAD", "Women's insulated", "Thermarest");