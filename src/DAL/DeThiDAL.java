package DAL;


import DTO.DeThiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeThiDAL {
    // Phương thức thêm đề thi vào CSDL
    public static boolean themDeThi(DeThiDTO deThi) {
        String sql = "INSERT INTO DeThi (ten_de, tong_diem) VALUES (?, ?)";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deThi.getTenDe());
            pstmt.setFloat(2, deThi.getTongDiem());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DeThiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Phương thức cập nhật thông tin đề thi trong CSDL
    public static boolean capNhatDeThi(DeThiDTO deThi) {
        String sql = "UPDATE DeThi SET ten_de = ?, tong_diem = ? WHERE ma_de = ?";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deThi.getTenDe());
            pstmt.setFloat(2, deThi.getTongDiem());
            pstmt.setInt(3, deThi.getMaDe());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DeThiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Phương thức xóa đề thi khỏi CSDL
    public static boolean xoaDeThi(int maDe) {
        String sql = "DELETE FROM DeThi WHERE ma_de = ?";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maDe);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DeThiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Phương thức lấy danh sách đề thi từ CSDL
    public static List<DeThiDTO> layDanhSachDeThi() {
        List<DeThiDTO> danhSachDeThi = new ArrayList<>();
        String sql = "SELECT ma_de, ten_de, tong_diem FROM DeThi";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int maDe = rs.getInt("ma_de");
                String tenDe = rs.getString("ten_de");
                float tongDiem = rs.getFloat("tong_diem");
                DeThiDTO deThi = new DeThiDTO(maDe, tenDe, tongDiem);
                danhSachDeThi.add(deThi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeThiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhSachDeThi;
    }
}
