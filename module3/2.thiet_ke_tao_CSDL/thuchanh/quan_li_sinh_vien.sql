CREATE DATABASE quan_ly_sinh_vien;
use quan_ly_sinh_vien;
CREATE TABLE class(
class_id INT PRIMARY KEY AUTO_INCREMENT,
class_name VARCHAR(60) NOT NULL,
class_start_date DATETIME NOT NULL,
class_status BIT);

create table student(
student_id int primary key auto_increment,
student_name varchar(30) not null,
student_address varchar(50),
student_phone varchar(20),
student_status bit,
class_id int,
foreign key(class_id)references class(class_id));
create table subject(
subject_id int primary key auto_increment,
subject_name varchar(30) not null,
credit tinyint not null default 1,
check (credit >=1),
subject_status bit default 1);
create table mark(
mark_id int primary key auto_increment,
subject_id int not null,
student_id int not null,
mark float default 0 check(mark between 0 and 100),
exam_time tinyint default 1,
unique(subject_id,student_id),
foreign key (subject_id) references subject(subject_id),
foreign key(student_id) references student(student_id));

INSERT INTO class
VALUES(1,'A1','2008-12-20',1),
	  (2,'A2','2008-12-22',1),
      (3,'B3','2022-03-15',0);
 
INSERT INTO student
VALUES(1,'Hung','Ha Noi','0912113113',1,1),
	  (2,'Hoa','Hai Phong',null,0,2),
	  (3,'Manh','HCM',0123123123,0,2);

INSERT INTO subject
VALUES(1,'CF',5,1),
	  (2,'C',6,1),
	  (3,'HDJ',5,1),
      (4,'RDBMS',10,1);

INSERT INTO mark
VALUES(1,1,1,8,1),
      (2,1,2,10,2),
      (3,2,1,12,1);

select*
from student;

select *
from student
where student_status = true;

SELECT *
FROM subject 
WHERE credit <10;

SELECT student_id,
	   student_name,
       student_address
       student_phone
FROM student
JOIN class
ON student.class_id = class.class_id
WHERE class_name='A1';

SELECT student_name,
       student_phone,
       subject.subject_name,
       mark.mark
FROM student
JOIN mark
ON student.student_id = mark.student_id
JOIN subject
ON mark.subject_id = subject.subject_id
WHERE subject_name = 'CF';