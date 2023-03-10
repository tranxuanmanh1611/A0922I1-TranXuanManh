CREATE TABLE student(
student_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
student_name VARCHAR(45),
student_age INTEGER,
student_country VARCHAR(45)
);
CREATE TABLE class(
class_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
class_name VARCHAR(45)
);
CREATE TABLE teacher(
teacher_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
teacher_name VARCHAR(45),
teacher_age INTEGER,
teacher_country VARCHAR(125)
);

