package DTO;
public class KetQuaThiDTO {
    private int maKetQua;
    private String maSinhVien;
    private int maDe;
    private int maCauHoi;
    private int maLuaChon;

    public KetQuaThiDTO(int maKetQua, String maSinhVien, int maDe, int maCauHoi, int maLuaChon) {
        this.maKetQua = maKetQua;
        this.maSinhVien = maSinhVien;
        this.maDe = maDe;
        this.maCauHoi = maCauHoi;
        this.maLuaChon = maLuaChon;
    }

    public KetQuaThiDTO(String maSinhVien, int maDe, int maCauHoi, int maLuaChon) {
        this.maSinhVien = maSinhVien;
        this.maDe = maDe;
        this.maCauHoi = maCauHoi;
        this.maLuaChon = maLuaChon;
    }

    public int getMaKetQua() {
        return maKetQua;
    }

    public void setMaKetQua(int maKetQua) {
        this.maKetQua = maKetQua;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public int getMaDe() {
        return maDe;
    }

    public void setMaDe(int maDe) {
        this.maDe = maDe;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public int getMaLuaChon() {
        return maLuaChon;
    }

    public void setMaLuaChon(int maLuaChon) {
        this.maLuaChon = maLuaChon;
    }

}
