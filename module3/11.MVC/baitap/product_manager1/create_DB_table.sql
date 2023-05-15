create database product_manager;
use product_manager;
create table product_type(id int primary key auto_increment,
						  type_name varchar(50) not null);
create table brand (id int primary key auto_increment,
					brand varchar(50) not null);
create table product(id int primary key auto_increment,
					product_name varchar(100) not null,
                    product_description varchar(500),
                    product_img_url varchar(200),
                    type_id int,
                    brand_id int,
                    foreign key(type_id) references product_type(id),
                    foreign key(brand_id) references brand(id));

                                
					