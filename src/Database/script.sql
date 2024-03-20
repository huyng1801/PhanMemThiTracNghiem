create database phan_mem_thi_trac_nghiem;
use phan_mem_thi_trac_nghiem;
-- Bảng Đề thi
CREATE TABLE DeThi (
  ma_de INT AUTO_INCREMENT PRIMARY KEY,
  ten_de VARCHAR(100) NOT NULL,
  tong_diem float DEFAULT 10.00
);
CREATE TABLE CauHoi (
  ma_cau_hoi INT AUTO_INCREMENT PRIMARY KEY,
  ma_de INT,
  cau_hoi_text TEXT NOT NULL,
  CONSTRAINT fk_ma_de FOREIGN KEY (ma_de) REFERENCES DeThi(ma_de) on DELETE CASCADE
);


-- Bảng Lựa chọn
CREATE TABLE LuaChon (
  ma_lua_chon INT AUTO_INCREMENT PRIMARY KEY,
  ma_cau_hoi INT,
  lua_chon_text TEXT NOT NULL,
  la_lua_chon_dung BOOLEAN NOT NULL,
  FOREIGN KEY (ma_cau_hoi) REFERENCES CauHoi(ma_cau_hoi) on DELETE CASCADE

);

-- Bảng Sinh viên
CREATE TABLE SinhVien (
  ma_sinh_vien char(10) PRIMARY KEY,
  ten_sinh_vien VARCHAR(50) NOT NULL,
  so_dien_thoai VARCHAR(20) NOT NULL
);

-- Bảng Kết quả thi
CREATE TABLE KetQuaThi (
  ma_ket_qua INT AUTO_INCREMENT PRIMARY KEY,
  ma_sinh_vien char(10),
  ma_de INT,
  ma_cau_hoi INT,
  ma_lua_chon INT,
  FOREIGN KEY (ma_sinh_vien) REFERENCES SinhVien(ma_sinh_vien),
  FOREIGN KEY (ma_de) REFERENCES DeThi(ma_de),
  FOREIGN KEY (ma_cau_hoi) REFERENCES CauHoi(ma_cau_hoi),
  FOREIGN KEY (ma_lua_chon) REFERENCES LuaChon(ma_lua_chon) 
);
