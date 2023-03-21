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
                       ho_ten VARCHAR(45),
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
                        ten__loai_khach VARCHAR(45));
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
(1, 'Le tan'),
(2, 'Phuc vu'),
(3, 'Chuyen vien'),
(4, 'Giam sat'),
(5, 'Quan ly'),
(6, 'Giam doc');
INSERT INTO bo_phan (ma_bo_phan, ten_bo_phan) VALUES
(1, 'Sale - Marketing'),
(2, 'Hanh chinh'),
(3, 'Phuc vu'),
(4, 'Quan ly');
INSERT INTO trinh_do (ma_trinh_do, ten_trinh_do) 
VALUES 
(1, 'Trung cap'),
(2, 'Cao dang'),
(3,'Dai hoc va sau dai hoc');
INSERT INTO nhan_vien (ma_nhan_vien, ho_ten, ngay_sinh, so_cccd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
VALUES
(1, 'Nguyễn Văn A', '1990-05-12', '123456789', 8000000, '0123456789', 'nguyenvana@gmail.com', 'Hà Nội', 2, 3, 2),
(2, 'Trần Thị B', '1992-12-10', '123456789', 9000000, '0123456789', 'tranthib@gmail.com', 'Hải Phòng', 5, 2, 1),
(3, 'Lê Văn K', '1995-03-23', '123456789', 12000000, '0123456789', 'levanc@gmail.com', 'Đà Nẵng', 6, 3, 3),
(4, 'Phạm Thị D', '1991-07-15', '123456789', 7000000, '0123456789', 'phamthid@gmail.com', 'Hà Nội', 1, 1, 4),
(5, 'Đỗ Văn E', '1994-11-30', '123456789', 10000000, '0123456789', 'dovane@gmail.com', 'Hồ Chí Minh', 5, 3, 2),
(6, 'Bùi Thị T', '1993-08-20', '123456789', 9500000, '0123456789', 'buithif@gmail.com', 'Đà Lạt', 3, 2, 3),
(7, 'Hoàng Văn G', '1990-01-06', '123456789', 11000000, '0123456789', 'hoangvang@gmail.com', 'Ninh Bình', 6, 3, 1),
(8, 'Trần Văn H', '1998-04-02', '123456789', 6500000, '0123456789', 'tranvanh@gmail.com', 'Vĩnh Phúc', 1, 1, 4),
(9, 'Lê Thị I', '1996-02-27', '123456789', 8500000, '0123456789', 'lethii@gmail.com', 'Bắc Ninh', 2, 2, 1),
(10, 'Nguyễn Thị K', '1997-09-03', '123456789', 7500000, '0123456789', 'nguyenthik@gmail.com', 'Hà Nội', 1, 1, 4);

INSERT INTO loai_khach (ten__loai_khach)
 VALUES ('Diamond'),
		('Platinium'),
		 ('Gold'),
		 ('Silver'),
		('Member');
        
INSERT INTO khach_hang (ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cccd, so_dien_thoai, email, dia_chi)
VALUES
    (1, 'Nguyen Van A', '1990-01-01', 1, '123456789', '0123456789', 'nguyenvana@gmail.com', '123 Nguyen Hue'),
    (2, 'Tran Thi B', '1995-05-05', 0, '234567890', '0234567890', 'tranthib@gmail.com', '456 Le Loi'),
    (3, 'Le Van C', '1985-10-10', 1, '345678901', '0345678901', 'levanc@gmail.com', '789 Tran Hung Dao'),
    (4, 'Pham Thi D', '2000-02-02', 0, '456789012', '0456789012', 'phamthid@gmail.com', '1111 Nguyen Van Linh'),
    (5, 'Doan Van E', '1988-08-08', 1, '567890123', '0567890123', 'doanvane@gmail.com', '2222 Vo Van Kiet'),
    (2, 'Nguyen Thi F', '1999-03-15', 0, '678901234', '0678901234', 'nguyenthif@gmail.com', '3333 Ly Thai To'),
    (4, 'Tran Van G', '1992-12-20', 1, '789012345', '0789012345', 'tranvang@gmail.com', '4444 Nguyen Tat Thanh'),
    (3, 'Pham Van H', '1998-06-25', 1, '890123456', '0890123456', 'phamvanh@gmail.com', '5555 Vo Thi Sau');
