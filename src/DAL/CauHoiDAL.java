package DAL;


import DTO.CauHoiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CauHoiDAL {

    // Phương thức thêm câu hỏi vào CSDL
    public static boolean themCauHoi(CauHoiDTO cauHoi) {
        String sql = "INSERT INTO CauHoi (ma_de, cau_hoi_text) VALUES (?, ?)";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cauHoi.getMaDe());
            pstmt.setString(2, cauHoi.getCauHoiText());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Phương thức cập nhật thông tin câu hỏi trong CSDL
    public static boolean capNhatCauHoi(CauHoiDTO cauHoi) {
        String sql = "UPDATE CauHoi SET ma_de = ?, cau_hoi_text = ? WHERE ma_cau_hoi = ?";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cauHoi.getMaDe());
            pstmt.setString(2, cauHoi.getCauHoiText());
            pstmt.setInt(3, cauHoi.getMaCauHoi());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Phương thức xóa câu hỏi khỏi CSDL
    public static boolean xoaCauHoi(int maCauHoi) {
        String sql = "DELETE FROM CauHoi WHERE ma_cau_hoi = ?";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maCauHoi);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

 public static List<CauHoiDTO> layDanhSachCauHoiTheoMaDe(int maDeThi) {
        List<CauHoiDTO> danhSachCauHoi = new ArrayList<>();
        String sql = "SELECT ma_cau_hoi, ma_de, cau_hoi_text FROM CauHoi WHERE ma_de = ?";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maDeThi);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int maCauHoi = rs.getInt("ma_cau_hoi");
                    int maDe = rs.getInt("ma_de");
                    String cauHoiText = rs.getString("cau_hoi_text");
                    CauHoiDTO cauHoi = new CauHoiDTO(maCauHoi, maDe, cauHoiText);
                    danhSachCauHoi.add(cauHoi);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhSachCauHoi;
    }
    public static int layMaCauHoiLonNhat() {
        int maCauHoiLonNhat = 0;
        String sql = "SELECT MAX(ma_cau_hoi) AS maxMaCauHoi FROM CauHoi";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                maCauHoiLonNhat = rs.getInt("maxMaCauHoi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maCauHoiLonNhat;
    }
}
