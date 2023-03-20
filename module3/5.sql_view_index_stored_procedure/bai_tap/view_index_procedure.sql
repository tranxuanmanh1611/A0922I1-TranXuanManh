CREATE DATABASE demo;
USE demo;

CREATE TABLE product(id INT PRIMARY KEY,
                     product_code INT,
                     product_name VARCHAR(50) NOT NULL,
                     product_price INT,
                     product_amount INT,
                     product_description TEXT,
                     product_status BIT NOT NULL);
           
INSERT INTO product
VALUES (1, 10001, 'TV Samsung 55 inch', 20000, 10, 'This is a description for Samsung TV', 1),
       (2, 10002, 'Tủ lạnh LG 2 cửa', 15000, 5, 'This is a description for LG fridge', 1),
	   (3, 10003, 'TV Sony 65 inch', 30000, 20, 'This is a description for Sony TV', 0),
	   (4, 10004, 'Tủ lạnh Hitachi 3 cửa', 20000, 8, 'This is a description for Hitachi fridge', 1),
	   (5, 10005, 'TV LG 75 inch', 40000, 15, 'This is a description for LG TV', 1);
       
    -- INDEX    
CREATE UNIQUE INDEX product_code_idx ON product(product_code);
CREATE INDEX product_name_price_idx ON product(product_name,product_price);
EXPLAIN SELECT * FROM product WHERE product_code =10005; -- duyệt 1 row
EXPLAIN SELECT * FROM product WHERE product_name ='TV LG 75 inch' OR product_price=40000;  -- duyệt 5 row
EXPLAIN SELECT * FROM product WHERE product_name ='TV LG 75 inch' AND product_price=40000; -- duyệt 1 row

-- VIEW

CREATE VIEW product_view_1 AS
SELECT product_code, product_name, product_price, 
CASE
	WHEN product_status = 1 THEN 'Con Hang'
    ELSE 'Het Hang'
END AS 'ton_kho'
FROM product;

UPDATE product_view_1
SET product_name ='TV LG 125 inch' WHERE product_code=10005;
SELECT * FROM product_view_1;
DROP VIEW product_view_1;

-- PROCEDURE
-- hiển thị product
DELIMITER //
CREATE PROCEDURE displayAllProduct()
BEGIN
	SELECT * FROM product;
END //
DELIMITER ;

-- Thêm 1 sp mới
DELIMITER //
CREATE PROCEDURE addNewProduct (id INT,
                     product_code INT,
                     product_name VARCHAR(50),
                     product_price INT,
                     product_amount INT,
                     product_description TEXT,
                     product_status BIT)
BEGIN
 INSERT INTO product
 VALUES (id, product_code,
                     product_name,
                     product_price,
                     product_amount,
                     product_description,
                     product_status);
END //
DELIMITER ;
call addNewProduct(6,10006, 'Máy giặt Panasonic 30L',100000,5,'Màu đen bản thường',1);

-- sửa thông tin sản phẩm theo ID
DELIMITER //
CREATE PROCEDURE editProduct (in_id INT,
                    in_product_code INT,
                     in_product_name VARCHAR(50),
                     in_product_price INT,
                     in_product_amount INT,
                     in_product_description TEXT,
                     in_product_status BIT)
BEGIN
UPDATE product
SET product_code = in_product_code,
    product_name=in_product_name,  
	product_price = in_product_price,
    product_amount=in_product_amount, 
    product_description = in_product_description,
    product_status=in_product_status
WHERE id = in_id;
END //
DELIMITER ;
call editProduct(6,10006, 'Máy giặt LG 20L',100000,5,'Màu đen bản thường',1);

-- xóa row theo id
DELIMITER //
CREATE PROCEDURE deleteProduct(in_id INT)
BEGIN
	DELETE FROM product
    WHERE id = in_id;
END //
DELIMITER ;
call deleteProduct(6);