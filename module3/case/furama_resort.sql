									--- Tạo database, tạo bảng
CREATE DATABASE furama_resort;
USE furama_resort;
CREATE TABLE vi_tri(
					ma_vi_tri INT PRIMARY KEY,
                    ten_vi_tri VARCHAR(45));
CREATE TABLE trinh_do(
					  ma_trinh_do INT PRIMARY KEY,
                      ten_trinh_do VARCHAR(45));
CREATE TABLE bo_phan(
					 ma_bo_phan INT PRIMARY KEY,
                     ten_bo_phan VARCHAR(45));
CREATE TABLE nhan_vien(
					   ma_nhan_vien INT PRIMARY KEY,
                       ho_ten_lot VARCHAR(45),
                       ten VARCHAR(45),
                       ngay_sinh DATE,
                       so_cccd VARCHAR(45),
                       luong DOUBLE,
                       so_dien_thoai VARCHAR(45),
                       email VARCHAR(45),
                       dia_chi VARCHAR(45),
                       ma_vi_tri INT,
                       ma_trinh_do INT,
                       ma_bo_phan INT,
                       FOREIGN KEY (ma_vi_tri) REFERENCES vi_tri(ma_vi_tri),
                       FOREIGN KEY ( ma_trinh_do) REFERENCES trinh_do(ma_trinh_do),
                       FOREIGN KEY (ma_bo_phan) REFERENCES bo_phan(ma_bo_phan));
                       
                       
CREATE TABLE loai_khach(
						ma_loai_khach INT PRIMARY KEY,
                        ten_loai_khach VARCHAR(45));
CREATE TABLE khach_hang(
						ma_khach_hang INT PRIMARY KEY,
                        ma_loai_khach INT,
                        ho_ten VARCHAR(45),
                        ngay_sinh DATE,
                        gioi_tinh BIT(1),
						so_cccd VARCHAR(45),
						so_dien_thoai VARCHAR(45),
                        email VARCHAR(45),
                        dia_chi VARCHAR(45),
                        FOREIGN KEY (ma_loai_khach) REFERENCES loai_khach(ma_loai_khach));
CREATE TABLE kieu_thue(
					   ma_kieu_thue INT PRIMARY KEY,
					   ten_kieu_thue VARCHAR(45));
CREATE TABLE loai_dich_vu(
						  ma_loai_dich_vu INT PRIMARY KEY,
						 ten_loai_dich_vu VARCHAR(45));
CREATE TABLE dich_vu(
					 ma_dich_vu INT PRIMARY KEY,
                     ten_dich_vu VARCHAR(45),
                     dien_tich INT,
                     chi_phi_thue DOUBLE,
                     so_nguoi_toi_da INT,
                     ma_kieu_thue INT,
                     ma_loai_dich_vu INT,
                     tieu_chuan_phong VARCHAR(45),
                     mo_ta_tien_nghi_khac VARCHAR(45),
                     dien_tich_ho_boi DOUBLE,
                     so_tang INT,
                     FOREIGN KEY (ma_kieu_thue) REFERENCES kieu_thue(ma_kieu_thue),
                     FOREIGN KEY (ma_loai_dich_vu) REFERENCES loai_dich_vu(ma_loai_dich_vu));
CREATE TABLE hop_dong(
	          ma_hop_dong INT PRIMARY KEY,
                     ngay_lam_hop_dong DATETIME,
                     ngay_ket_thuc DATETIME,
                     tien_dat_coc DOUBLE,
                     ma_nhan_vien INT,
                     ma_khach_hang INT,
                     ma_dich_vu INT,
                     FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien(ma_nhan_vien),
                     FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang(ma_khach_hang),
                     FOREIGN KEY (ma_dich_vu) REFERENCES dich_vu(ma_dich_vu));

						
CREATE TABLE dich_vu_di_kem(
							ma_dich_vu_di_kem INT PRIMARY KEY,
                            ten_dich_vu_di_kem VARCHAR(45),
							gia DOUBLE,
                            don_vi VARCHAR(10),
                            trang_thai VARCHAR(45));
CREATE TABLE hop_dong_chi_tiet(
							   ma_hop_dong_chi_tiet INT PRIMARY KEY,
                               ma_hop_dong INT,
                               ma_dich_vu_di_kem INT,
                               so_luong INT,
                               FOREIGN KEY (ma_hop_dong) REFERENCES hop_dong(ma_hop_dong),
                               FOREIGN KEY (ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem));
                               
																							-- thêm dữ liệu

INSERT INTO vi_tri (ma_vi_tri, ten_vi_tri) VALUES
(1, 'Quan Ly'),
(2, 'Nhan Vien');
INSERT INTO bo_phan (ma_bo_phan, ten_bo_phan) VALUES
(1, 'Sale - Marketing'),
(2, 'Hanh chinh'),
(3, 'Phuc vu'),
(4, 'Quan ly');
INSERT INTO trinh_do (ma_trinh_do, ten_trinh_do) 
VALUES 
(1, 'Trung Cap'),
(2, 'Cao Dang'),
(3,'Dai Hoc'),
(4,'Sau Dai Hoc');
INSERT INTO nhan_vien (ma_nhan_vien,ho_ten_lot, ten, ngay_sinh, so_cccd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
VALUES
(1,'Nguyễn Văn','An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
(2,'Lê Văn','Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
(3,'Hồ Thị','Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
(4,'Võ Công','Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
(5,'Nguyễn Bỉnh','Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
(6,'Khúc Nguyễn An','Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
(7,'Nguyễn Hữu','Hà','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
(8,'Nguyễn Hà','Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
(9,'Tòng','Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
(10,'Nguyễn Công','Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);
INSERT INTO loai_khach (ma_loai_khach,ten_loai_khach)
 VALUES (1,'Diamond'),
		(2,'Platinium'),
		 (3,'Gold'),
		 (4,'Silver'),
		(5,'Member');
        
INSERT INTO khach_hang (ma_khach_hang, ho_ten, ngay_sinh, gioi_tinh, so_cccd, so_dien_thoai, email, dia_chi,ma_loai_khach)
VALUES
    (1,'Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
(2,'Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
(3,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
(4,'Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
(5,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
(6,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
(7,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
(8,'Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
(9,'Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
(10,'Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);
INSERT INTO kieu_thue (ma_kieu_thue, ten_kieu_thue)
VALUES (1, 'year'), (2, 'month'), (3, 'day'), (4, 'hour');
INSERT INTO loai_dich_vu (ma_loai_dich_vu, ten_loai_dich_vu)
VALUES (1, 'Villa'), (2, 'House'), (3, 'Room');
INSERT INTO dich_vu (ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi, so_tang, ma_kieu_thue, ma_loai_dich_vu)
VALUES 
(1,'Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
(2,'House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,3,2,2),
(3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,4,3),
(4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
(5,'House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,3,2),
(6,'Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,4,3);
INSERT INTO hop_dong (ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
VALUES (1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18',100000,7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',100000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,3,4,1),
(9,'2020-11-19','2020-11-19',0,3,4,3),
(10,'2021-04-12','2021-04-14',0,10,3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0,7,10,1);

INSERT INTO dich_vu_di_kem(ma_dich_vu_di_kem
,ten_dich_vu_di_kem
,gia
,don_vi
,trang_thai)
VALUES
(1,'Karaoke',10000,'giờ','tiện nghi, hiện tại'),
(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
(3,'Thuê xe đạp',20000,'chiếc','tốt'),
(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');

INSERT INTO hop_dong_chi_tiet(ma_hop_dong_chi_tiet
,so_luong
,ma_hop_dong
,ma_dich_vu_di_kem
)
VALUES (1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6,1,1,3),
(7,2,1,2),
(8,2,12,2);

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT *
FROM nhan_vien WHERE (ten LIKE 'H%' OR ten LIKE 'T%' OR ten LIKE 'K%') AND CHAR_LENGTH(CONCAT(ho_ten_lot,ten)) <= 15; 

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT *
FROM khach_hang
WHERE ((YEAR(NOW())-YEAR(ngay_sinh)) BETWEEN 18 AND 50)
AND   (dia_chi LIKE '%Đà Nẵng%' OR dia_chi LIKE '%Quảng Trị%');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT khach_hang.ma_khach_hang,
	   khach_hang.ho_ten,
       COUNT(*) AS so_lan_dat
FROM khach_hang
JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
WHERE khach_hang.ma_loai_khach =1
GROUP BY 1
ORDER BY 3 DESC;

-- 5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT khach_hang.ma_khach_hang,
	   khach_hang.ho_ten,
       loai_khach.ten_loai_khach,
       hop_dong.ma_hop_dong,
       dich_vu.ten_dich_vu,
       hop_dong.ngay_lam_hop_dong,
       hop_dong.ngay_ket_thuc,
      SUM( IF(dich_vu.chi_phi_thue IS NULL,0,dich_vu.chi_phi_thue)) AS chi_phi_thue,
     SUM(  IF(dich_vu_di_kem.gia IS NULL,0,dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong)) AS chi_phi_dich_vu_kem,
     ( SUM(IF(dich_vu.chi_phi_thue IS NULL,0,dich_vu.chi_phi_thue)) +
		SUM(IF(dich_vu_di_kem.gia IS NULL,0,dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong)) )        AS tong_chi_phi
FROM khach_hang
LEFT JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang	
LEFT JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
LEFT JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
GROUP BY 4,1;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
-- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
FROM dich_vu
JOIN loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
LEFT JOIN hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE DATE(hop_dong.ngay_lam_hop_dong)<'2020-12-31' OR DATE(hop_dong.ngay_lam_hop_dong)>'2021-04-01'
GROUP BY 1;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
FROM hop_dong
JOIN dich_vu
ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
JOIN loai_dich_vu 
ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
WHERE YEAR(hop_dong.ngay_lam_hop_dong) =2020 AND hop_dong.ma_dich_vu NOT IN (SELECT hop_dong.ma_dich_vu 
																			FROM hop_dong
																			WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2021)
GROUP BY 1;

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
SELECT DISTINCT ho_ten
FROM khach_hang;

SELECT ho_ten
FROM khach_hang
GROUP BY 1;

SELECT ho_ten
FROM khach_hang
UNION
SELECT ho_ten
FROM khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2023 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
SELECT MONTH(ngay_lam_hop_dong) AS thang,
	   COUNT(*) AS doanh_thu
FROM hop_dong
WHERE ngay_lam_hop_dong > DATE('2020-12-31') AND ngay_lam_hop_dong < DATE('2022-01-01')
GROUP BY 1
ORDER BY 1;

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc,
		SUM(IF(hop_dong_chi_tiet.so_luong IS NULL,0,hop_dong_chi_tiet.so_luong)) AS so_luong_dich_vu_di_kem
FROM hop_dong
LEFT JOIN hop_dong_chi_tiet
ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
GROUP BY 1;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng
-- có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
SELECT khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, khach_hang.dia_chi
FROM khach_hang
JOIN loai_khach ON khach_hang.ma_loai_khach=loai_khach.ma_loai_khach
WHERE loai_khach.ten_loai_khach = 'Diamond' AND (khach_hang.dia_chi LIKE '%Vinh' OR khach_hang.dia_chi LIKE '%Quảng Ngãi%');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

SELECT hop_dong.ma_hop_dong,
	   CONCAT(nhan_vien.ho_ten_lot," ",nhan_vien.ten) AS ten_nhan_vien,
       khach_hang.ho_ten AS ten_khach_hang,
       khach_hang.so_dien_thoai AS sdt_khach,
       dich_vu.ten_dich_vu,
       
       
FROM hop_dong       
JOIN nhan_vien ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
JOIN khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu