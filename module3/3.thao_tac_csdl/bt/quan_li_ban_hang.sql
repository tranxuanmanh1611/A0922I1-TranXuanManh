CREATE DATABASE quan_li_ban_hang;
USE quan_li_ban_hang;
CREATE TABLE customer(
customer_id INT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(25),
customer_age TINYINT CHECK(customer_age>0 AND customer_age<150));

CREATE TABLE customer_order(
order_id INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT,
FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
order_date DATE,
order_total_price INT CHECK(order_total_price>0)
);

CREATE TABLE product(
product_id INT AUTO_INCREMENT PRIMARY KEY,
product_name VARCHAR(25),
product_price INT CHECK(product_price>0));

CREATE TABLE order_detail(
order_id INT,
product_id INT,
order_quantity INT CHECK (order_quantity>0),
PRIMARY KEY(order_id,product_id),
FOREIGN KEY (order_id) REFERENCES customer_order(order_id),
FOREIGN KEY (product_id) REFERENCES product(product_id));

INSERT INTO customer (customer_name,customer_age)
VALUES ('Minh Quan',10),
       ('Ngoc Oanh',20),
       ('Hong Ha',50);

INSERT INTO customer_order(customer_id,order_date)
VALUES (1,'2006-03-21'),
	   (2,'2006-03-23'),
       (1,'2006-03-16');

INSERT INTO product(product_name,product_price)
VALUES ('May Giat',3),
       ('Tu Lanh',5),
       ('Dieu Hoa',7),
       ('Quat',1),
       ('Bep Dien',2);
       
INSERT INTO order_detail(order_id,product_id,order_quantity)
VALUES (1,1,3),
	   (1,3,7),
       (1,4,2),
       (2,1,1),
       (3,1,8),
       (2,5,4),
       (2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT customer_order.order_id,
       customer_order.order_date,
       SUM(product.product_price*order_detail.order_quantity) AS 'Total Price'
FROM customer_order
JOIN order_detail
ON customer_order.order_id = order_detail.order_id
JOIN product
ON order_detail.product_id = product.product_id
GROUP BY customer_order.order_id;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT customer.customer_name,
	   product.product_name
FROM customer
JOIN customer_order
ON customer.customer_id = customer_order.customer_id
JOIN order_detail
ON customer_order.order_id = order_detail.order_id
JOIN product
ON order_detail.product_id = product.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT customer.customer_id,
	   customer.customer_name,
       customer_order.order_id
FROM customer
LEFT JOIN customer_order
ON customer.customer_id = customer_order.customer_id
WHERE customer_order.order_id IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT customer_order.order_id,
       customer_order.order_date,
       SUM(product.product_price*order_detail.order_quantity) AS 'Total Price'
FROM customer_order
JOIN order_detail
ON customer_order.order_id = order_detail.order_id
JOIN product
ON order_detail.product_id = product.product_id
GROUP BY customer_order.order_id;