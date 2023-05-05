INSERT INTO ROLES (name, description) VALUES ('USER','Basic role for any user');
INSERT INTO ROLES (name, description) VALUES ('ADMIN', 'Sysadmin role');
INSERT INTO USERS (username, email, password) VALUES ('tony', 'tony@mail.com', '$2a$10$DXLNjmOBkyk5I315fxF6PuNHzqVmu9wu1L7FmDKd5GIIRzEKpV2RW');
INSERT INTO USERS (username, email, password) VALUES ('mailen', 'mailen@mail.com', '$2a$10$wgGrqFroS.aah424sXywQurq1PY6ns3RhadyxQsbbJVmLgPo3r9fa');
INSERT INTO USER_ROLES (user_id, role_id) VALUES (1,2);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (2,1);
INSERT INTO USER_ROLES (user_id, role_id) VALUES (1,1);
INSERT INTO CATEGORIES (name, description) VALUES ('Category 1', 'This is the description for Category 1');
INSERT INTO CATEGORIES (name, description) VALUES ('Category 2', 'This is the description for Category 2');
INSERT INTO CATEGORIES (name, description) VALUES ('Category 3', 'This is the description for Category 3');
INSERT INTO CATEGORIES (name, description) VALUES ('Category 4', 'This is the description for Category 4');
INSERT INTO PRODUCTS (price, name, description) VALUES (45.2, 'Product 1', 'This is the description of the Product');
INSERT INTO PRODUCTS (price, name, description) VALUES (5.6, 'Product 2', 'This is the description of the Product');
INSERT INTO PRODUCTS (price, name, description) VALUES (22.6, 'Product 3', 'This is the description of the Product');
INSERT INTO PRODUCTS (price, name, description) VALUES (10.5, 'Product 4', 'This is the description of the Product');
INSERT INTO PRODUCTS (price, name, description) VALUES (3, 'Product 5', 'This is the description of the Product');
INSERT INTO PRODUCTS (price, name, description) VALUES (78.4, 'Product 6', 'This is the description of the Product');
INSERT INTO PRODUCTS (price, name, description) VALUES (9.6, 'Product 7', 'This is the description of the Product');
INSERT INTO PRODUCTS (price, name, description) VALUES (8.4, 'Product 8', 'This is the description of the Product');
INSERT INTO PRODUCTS (price, name, description) VALUES (5.6, 'Product 9', 'This is the description of the Product');
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (1,1);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (2,1);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (3,2);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (4,3);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (5,4);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (6,1);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (7,1);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (8,2);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (9,3);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (2,3);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (6,2);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (8,1);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (7,4);
INSERT INTO PRODUCTS_CATEGORIES (products_id, categories_id) VALUES (1,4);