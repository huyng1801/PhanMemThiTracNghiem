package DTO;
public class LuaChonDTO {
    private int maLuaChon;
    private int maCauHoi;
    private String luaChonText;
    private boolean laLuaChonDung;

    public LuaChonDTO(int maLuaChon, int maCauHoi, String luaChonText, boolean laLuaChonDung) {
        this.maLuaChon = maLuaChon;
        this.maCauHoi = maCauHoi;
        this.luaChonText = luaChonText;
        this.laLuaChonDung = laLuaChonDung;
    }

    public LuaChonDTO(int maCauHoi, String luaChonText, boolean laLuaChonDung) {
        this.maCauHoi = maCauHoi;
        this.luaChonText = luaChonText;
        this.laLuaChonDung = laLuaChonDung;
    }

    public int getMaLuaChon() {
        return maLuaChon;
    }

    public void setMaLuaChon(int maLuaChon) {
        this.maLuaChon = maLuaChon;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getLuaChonText() {
        return luaChonText;
    }

    public void setLuaChonText(String luaChonText) {
        this.luaChonText = luaChonText;
    }

    public boolean isLaLuaChonDung() {
        return laLuaChonDung;
    }

    public void setLaLuaChonDung(boolean laLuaChonDung) {
        this.laLuaChonDung = laLuaChonDung;
    }
}
