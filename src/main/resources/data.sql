USE hms_db;
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Bananas', 'FOOD', 'LOW');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Apples', 'FOOD', 'NONE');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Onions', 'FOOD', 'ENOUGH');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Ketchup', 'FOOD', 'MAX');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Harissa', 'FOOD', 'ENOUGH');

INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Soap', 'CLEANING', 'ENOUGH');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Shampoo', 'CLEANING', 'LOW');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Toothpaste', 'CLEANING', 'LOW');

INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Garbage bags-big', 'OTHER', 'LOW');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Garbage bags-small', 'OTHER', 'ENOUGH');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Food wrap', 'OTHER', 'LOW');
INSERT IGNORE INTO supply (s_name, s_category, s_amount) values ('Baking paper', 'OTHER', 'ENOUGH');