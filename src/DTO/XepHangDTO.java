/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author huyng
 */
public class XepHangDTO {
    private String maSinhVien;
    private String tenSinhVien;
    private String soDienThoai;
    private String tenDe;
    private int soCauTraLoiDung;
    private int soCauChuaLam;

    public XepHangDTO() {
    }
    private int soCauTraLoiSai;
    private float diemSoDatDuoc;

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

    public String getTenDe() {
        return tenDe;
    }

    public void setTenDe(String tenDe) {
        this.tenDe = tenDe;
    }

    public int getSoCauTraLoiDung() {
        return soCauTraLoiDung;
    }

    public void setSoCauTraLoiDung(int soCauTraLoiDung) {
        this.soCauTraLoiDung = soCauTraLoiDung;
    }

    public int getSoCauChuaLam() {
        return soCauChuaLam;
    }

    public void setSoCauChuaLam(int soCauChuaLam) {
        this.soCauChuaLam = soCauChuaLam;
    }

    public int getSoCauTraLoiSai() {
        return soCauTraLoiSai;
    }

    public void setSoCauTraLoiSai(int soCauTraLoiSai) {
        this.soCauTraLoiSai = soCauTraLoiSai;
    }

    public float getDiemSoDatDuoc() {
        return diemSoDatDuoc;
    }

    public void setDiemSoDatDuoc(float diemSoDatDuoc) {
        this.diemSoDatDuoc = diemSoDatDuoc;
    }
}
