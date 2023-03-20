-- test tốc độ khi dùng index
EXPLAIN ANALYZE SELECT *
 FROM customers;
  ALTER TABLE customers DROP INDEX contactFirstName_idx;
  ALTER TABLE customers DROP INDEX contactLastName_idx;
  ALTER TABLE customers ADD INDEX contactFirstName_idx(contactFirstName);
    ALTER TABLE customers ADD INDEX contactLastName_idx(contactLastName);
    ALTER TABLE customers ADD INDEX fullName_idx(contactFirstName,contactLastName);
    --- ở đây dù là index composite nhưng ở dưới toán tử OR, chương trình sẽ hiểu đường nào cũng phải duyệt hết để tìm, nên bỏ qua index
		EXPLAIN SELECT *
		   FROM customers
           WHERE contactFirstName='Jean'
	           AND  contactLastName='King';
               
--- Stored procedure


DELIMITER //
CREATE PROCEDURE displayEmployees()
BEGIN
	SELECT *
    FROM employees;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE displayPayments()
BEGIN
  SELECT *
  FROM payments;
END //
DELIMITER ;

-- procedure truyền tham số

-- tìm khách hàng theo ID
DELIMITER //
CREATE PROCEDURE findCustomerByID(cusID INT(11))
BEGIN
 SELECT *
 FROM customers WHERE customerNumber = cusID;
 END //
DELIMITER ;

call findCustomerByID(122);

-- truyền tham số in out, 
DELIMITER //
CREATE PROCEDURE getTotalCusByCity(in_city VARCHAR(50), OUT total INT)
BEGIN
  SELECT COUNT(customerNumber) INTO total
  FROM customers
  WHERE in_city = city;
END //
DELIMITER ;

call getTotalCusByCity('Las Vegas',@total);
select @total;

-- tạo view
CREATE VIEW customer_view AS
SELECT customerNumber, customerName, phone
FROM customers;

select *
from customer_view;

-- cập nhật view (tajo mới, thay thế nếu tồn tại)
CREATE OR REPLACE VIEW customer_view AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';