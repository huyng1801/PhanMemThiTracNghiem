package DTO;
public class SinhVienDTO {
    private String maSinhVien;
    private String tenSinhVien;
    private String soDienThoai;

    public SinhVienDTO(String maSinhVien, String tenSinhVien, String soDienThoai) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.soDienThoai = soDienThoai;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
