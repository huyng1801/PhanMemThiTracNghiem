package DAL;

import DTO.KetQuaThiDTO;
import DTO.XepHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KetQuaThiDAL {

    // Phương thức thêm kết quả thi vào CSDL
    public static boolean themKetQuaThi(KetQuaThiDTO ketQuaThi) {
        String sql = "INSERT INTO KetQuaThi (ma_sinh_vien, ma_de, ma_cau_hoi, ma_lua_chon) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ketQuaThi.getMaSinhVien());
            pstmt.setInt(2, ketQuaThi.getMaDe());
            pstmt.setInt(3, ketQuaThi.getMaCauHoi());
            pstmt.setInt(4, ketQuaThi.getMaLuaChon());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaThiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<XepHangDTO> layDanhSachKetQuaThi() {
        List<XepHangDTO> danhSachKetQua = new ArrayList<>();
        String sql = "SELECT "
                + "  sv.ma_sinh_vien, "
                + "  sv.ten_sinh_vien, "
                + "  sv.so_dien_thoai, "
                + "  dt.ten_de, "
                + "  COUNT(CASE WHEN kqt.ma_lua_chon = lc.la_lua_chon_dung THEN 1 END) as so_cau_tra_loi_dung, "
                + "  COUNT(CASE WHEN kqt.ma_lua_chon <> lc.la_lua_chon_dung AND kqt.ma_lua_chon IS NOT NULL THEN 1 END) as so_cau_tra_loi_sai, "
                + "  (SELECT COUNT(*) FROM CauHoi WHERE ma_de = dt.ma_de) - COUNT(CASE WHEN kqt.ma_lua_chon = lc.la_lua_chon_dung THEN 1 END) - COUNT(CASE WHEN kqt.ma_lua_chon <> lc.la_lua_chon_dung AND kqt.ma_lua_chon IS NOT NULL THEN 1 END) as so_cau_chua_lam, "
                + "  (SUM(dt.tong_diem) / (SELECT COUNT(*) FROM CauHoi WHERE ma_de = dt.ma_de)) * COUNT(CASE WHEN kqt.ma_lua_chon = lc.la_lua_chon_dung THEN 1 END) as diem_so_dat_duoc "
                + "FROM "
                + "  SinhVien sv "
                + "JOIN "
                + "  KetQuaThi kqt ON sv.ma_sinh_vien = kqt.ma_sinh_vien "
                + "JOIN "
                + "  DeThi dt ON kqt.ma_de = dt.ma_de "
                + "JOIN "
                + "  CauHoi ch ON kqt.ma_cau_hoi = ch.ma_cau_hoi "
                + "LEFT JOIN "
                + "  LuaChon lc ON kqt.ma_lua_chon = lc.ma_lua_chon "
                + "GROUP BY "
                + "  sv.ma_sinh_vien, sv.ten_sinh_vien, sv.so_dien_thoai, dt.ten_de, dt.tong_diem "
                + "ORDER BY "
                + "  diem_so_dat_duoc DESC;";

        try (Connection conn = Database.getConnect(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                XepHangDTO xepHang = new XepHangDTO();
                xepHang.setMaSinhVien(rs.getString("ma_sinh_vien"));
                xepHang.setTenSinhVien(rs.getString("ten_sinh_vien"));
                xepHang.setSoDienThoai(rs.getString("so_dien_thoai"));
                xepHang.setTenDe(rs.getString("ten_de"));
                xepHang.setSoCauTraLoiDung(rs.getInt("so_cau_tra_loi_dung"));
                xepHang.setSoCauChuaLam(rs.getInt("so_cau_chua_lam"));
                xepHang.setSoCauTraLoiSai(rs.getInt("so_cau_tra_loi_sai"));
                xepHang.setDiemSoDatDuoc(rs.getFloat("diem_so_dat_duoc"));

                danhSachKetQua.add(xepHang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaThiDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhSachKetQua;
    }
}
