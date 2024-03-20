package DAL;


import DTO.LuaChonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LuaChonDAL {

    // Phương thức thêm lựa chọn vào CSDL
    public static boolean themLuaChon(LuaChonDTO luaChon) {
        String sql = "INSERT INTO LuaChon (ma_cau_hoi, lua_chon_text, la_lua_chon_dung) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, luaChon.getMaCauHoi());
            pstmt.setString(2, luaChon.getLuaChonText());
            pstmt.setBoolean(3, luaChon.isLaLuaChonDung());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LuaChonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Phương thức lấy danh sách lựa chọn dựa trên mã câu hỏi
    public static List<LuaChonDTO> layDanhSachLuaChonTheoMaCauHoi(int maCauHoi) {
        List<LuaChonDTO> danhSachLuaChon = new ArrayList<>();
        String sql = "SELECT ma_lua_chon, ma_cau_hoi, lua_chon_text, la_lua_chon_dung FROM LuaChon WHERE ma_cau_hoi = ?";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maCauHoi);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int maLuaChon = rs.getInt("ma_lua_chon");
                    String luaChonText = rs.getString("lua_chon_text");
                    boolean laLuaChonDung = rs.getBoolean("la_lua_chon_dung");
                    LuaChonDTO luaChon = new LuaChonDTO(maLuaChon, maCauHoi, luaChonText, laLuaChonDung);
                    danhSachLuaChon.add(luaChon);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LuaChonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhSachLuaChon;
    }
    public static boolean capNhatLuaChon(LuaChonDTO luaChon) {
        String sql = "UPDATE LuaChon SET lua_chon_text = ?, la_lua_chon_dung = ? WHERE ma_lua_chon = ?";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, luaChon.getLuaChonText());
            pstmt.setBoolean(2, luaChon.isLaLuaChonDung());
            pstmt.setInt(3, luaChon.getMaLuaChon());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LuaChonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
