package DTO;

public class CauHoiDTO {

    private int maCauHoi;
    private int maDe;
    private String cauHoiText;

    public CauHoiDTO(int maDe, String cauHoiText) {
        this.maDe = maDe;
        this.cauHoiText = cauHoiText;
    }

    public CauHoiDTO(int maCauHoi, int maDe, String cauHoiText) {
        this.maCauHoi = maCauHoi;
        this.maDe = maDe;
        this.cauHoiText = cauHoiText;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public int getMaDe() {
        return maDe;
    }

    public void setMaDe(int maDe) {
        this.maDe = maDe;
    }

    public String getCauHoiText() {
        return cauHoiText;
    }

    public void setCauHoiText(String cauHoiText) {
        this.cauHoiText = cauHoiText;
    }
}
