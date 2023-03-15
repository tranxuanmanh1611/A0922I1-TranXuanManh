CREATE DATABASE quan_li_ban_hang;
USE quan_li_ban_hang;
CREATE TABLE customer(
customer_id INT AUTO_INCREMENT PRIMARY KEY,
customer_name TEXT,
customer_age INT CHECK(customer_age>0 AND customer_age<150));

CREATE TABLE customer_order(
order_id INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT,
FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
order_date DATETIME,
order_total_price INT CHECK(order_total_price>0)
);

CREATE TABLE product(
product_id INT AUTO_INCREMENT PRIMARY KEY,
product_name TEXT,
product_price INT CHECK(product_price>0));

CREATE TABLE order_detail(
order_id INT,
product_id INT,
order_quantity INT CHECK (order_quantity>0),
PRIMARY KEY(order_id,product_id),
FOREIGN KEY (order_id) REFERENCES customer_order(order_id),
FOREIGN KEY (product_id) REFERENCES product(product_id));