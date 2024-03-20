package DAL;


import DTO.SinhVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinhVienDAL {

    // Phương thức thêm sinh viên vào CSDL
    public static boolean themSinhVien(SinhVienDTO sinhVien) {
        String sql = "INSERT INTO SinhVien (ma_sinh_vien, ten_sinh_vien, so_dien_thoai) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sinhVien.getMaSinhVien());
            pstmt.setString(2, sinhVien.getTenSinhVien());
            pstmt.setString(3, sinhVien.getSoDienThoai());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
