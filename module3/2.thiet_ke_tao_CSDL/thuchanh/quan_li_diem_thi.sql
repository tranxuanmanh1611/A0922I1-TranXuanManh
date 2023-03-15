CREATE DATABASE quan_li_diem_thi;
CREATE TABLE hoc_sinh(
ma_hoc_sinh VARCHAR(20) PRIMARY KEY,
ten_hoc_sinh VARCHAR(20),
ngay_sinh DATETIME,
lop VARCHAR(20),
GT VARCHAR(20)
);
CREATE TABLE mon_hoc(
ma_mon_hoc VARCHAR(20) PRIMARY KEY,
ten_mon_hoc VARCHAR(20),
ma_giao_vien VARCHAR(20));
CREATE TABLE bang_diem(
ma_hoc_sinh VARCHAR(20),
ma_mon_hoc VARCHAR(20),
diem_thi INT,
ngay_thi DATETIME,
PRIMARY KEY(ma_hoc_sinh,ma_mon_hoc),
FOREIGN KEY(ma_hoc_sinh) REFERENCES hoc_sinh(ma_hoc_sinh),
FOREIGN KEY(ma_mon_hoc)REFERENCES mon_hoc(ma_mon_hoc));
CREATE TABLE giao_vien(
ma_giao_vien VARCHAR(20),
ten_giao_vien TEXT,
so_dien_thoai TEXT);

ALTER TABLE mon_hoc
ADD COLUMN ma_giao_vien VARCHAR(20);
ALTER TABLE mon_hoc
ADD FOREIGN KEY (ma_giao_vien) REFERENCES giao_vien(ma_giao_vien);
SELECT * FROM bang_diem;
SELECT * FROM giao_vien;
SELECT * FROM hoc_sinh;
SELECT * FROM mon_hoc;