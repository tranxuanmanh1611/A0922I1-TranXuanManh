CREATE DATABASE quan_ly_sinh_vien;
use quan_ly_sinh_vien;
CREATE TABLE class(
class_id INT PRIMARY KEY AUTO_INCREMENT,
class_name VARCHAR(60) NOT NULL,
class_start_date DATETIME NOT NULL,
class_status BIT);
insert into class(class_name,class_start_date,class_status)
values('manh','2022-09-24',1);
select*from class;
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
