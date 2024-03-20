package DTO;

public class DeThiDTO {

    private int maDe;
    private String tenDe;
    private float tongDiem;

    public DeThiDTO(int maDe, String tenDe, float tongDiem) {
        this.maDe = maDe;
        this.tenDe = tenDe;
        this.tongDiem = tongDiem;
    }

    public DeThiDTO(String tenDe, float tongDiem) {
        this.tenDe = tenDe;
        this.tongDiem = tongDiem;
    }

    public int getMaDe() {
        return maDe;
    }

    public void setMaDe(int maDe) {
        this.maDe = maDe;
    }

    public String getTenDe() {
        return tenDe;
    }

    public void setTenDe(String tenDe) {
        this.tenDe = tenDe;
    }

    public float getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(float tongDiem) {
        this.tongDiem = tongDiem;
    }
}
