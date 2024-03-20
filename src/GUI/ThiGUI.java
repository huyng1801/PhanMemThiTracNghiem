/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAL.CauHoiDAL;
import DAL.KetQuaThiDAL;
import DAL.LuaChonDAL;
import DTO.CauHoiDTO;
import DTO.KetQuaThiDTO;
import DTO.LuaChonDTO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 *
 * @author huyng
 */
public class ThiGUI extends javax.swing.JPanel {

    /**
     * Creates new form DeThiGUI
     */
    private int maxIndex;
    private List<CauHoiDTO> lstCauHoi;
    private int indexHienTai;
    private List<KetQuaThiDTO> lstKetQua;
    private List<JButton> lstButton;
    private ButtonGroup btng;

    public ThiGUI() {
        initComponents();
        setThongTinThiSinh();
        loadData();
        groupButton();
        setDeThi();
        setCauHoiDauTien();

    }

    public void setThongTinThiSinh() {
        txtMaSinhVien.setText(SinhVienGUI.maSinhVienHienTai);
        txtTenSinhVien.setText(SinhVienGUI.tenSinhVienHienTai);
        txtSoDienThoai.setText(SinhVienGUI.soDienThoaiHienTai);
    }

    public void setCauHoiDauTien() {
        if (maxIndex >= 0) {
            chuyenCauHoi(0);
            indexHienTai = 0;
        }
    }

    public void setDanhSachCauHoi() {
        lstButton = new ArrayList<JButton>();
        for (int i = 0; i <= maxIndex; i++) {
            JButton btn = new JButton("Câu " + (i + 1));
            btn.setBackground(Color.red);
            lstButton.add(btn);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cauHoi = ((JButton) e.getSource()).getText();
                    indexHienTai = Integer.parseInt(cauHoi.replace("Câu ", "")) - 1;
                    chuyenCauHoi(indexHienTai);
                }
            });
            panelDanhSachCauHoi.add(btn);
        }
    }

    public void chuyenCauHoi(int index) {
        clearSelected();
        removeBorderButton();
        int maCauHoi = lstCauHoi.get(index).getMaCauHoi();
        String cauHoi = lstCauHoi.get(index).getCauHoiText();
        List<LuaChonDTO> lstLuaChon = LuaChonDAL.layDanhSachLuaChonTheoMaCauHoi(maCauHoi);
        LuaChonDTO luaChonA = lstLuaChon.get(0);
        LuaChonDTO luaChonB = lstLuaChon.get(1);
        LuaChonDTO luaChonC = lstLuaChon.get(2);
        LuaChonDTO luaChonD = lstLuaChon.get(3);
        txtCauHoi.setText(cauHoi);
        txtA.setText(luaChonA.getLuaChonText());
        txtB.setText(luaChonB.getLuaChonText());
        txtC.setText(luaChonC.getLuaChonText());
        txtD.setText(luaChonD.getLuaChonText());
        labelCauHoi.setText("Câu " + (index + 1) + ":");

        Border border = BorderFactory.createLineBorder(Color.black, 2);
        lstButton.get(index).setBorder(border);

    }

    public void removeBorderButton() {
        for (int i = 0; i < lstButton.size(); i++) {
            lstButton.get(i).setBorder(null);
        }
    }

    public void setDanhSachKetQuaThi() {
        lstKetQua = new ArrayList<KetQuaThiDTO>();
        for (int i = 0; i <= maxIndex; i++) {
            String maSinhVien = txtMaSinhVien.getText();
            int maDe = Integer.parseInt(txtDeThi.getText().split("-")[0]);
            int maCauHoi = lstCauHoi.get(i).getMaCauHoi();
            KetQuaThiDTO kqt = new KetQuaThiDTO(maSinhVien, maDe, maCauHoi, -1);
            lstKetQua.add(kqt);
        }
    }

    public void setDeThi() {
        int maDe = DeThiGUI.maDeThiDuocChon;
        String tenDe = DeThiGUI.tenDeThiDuocChon;
        txtDeThi.setText(maDe + "-" + tenDe);
        setDanhSachCauHoi();
        setDanhSachKetQuaThi();
    }

    private void clearSelected() {
        btng.remove(rbtnA);
        btng.remove(rbtnB);
        btng.remove(rbtnC);
        btng.remove(rbtnD);
        rbtnA.setSelected(false);
        rbtnB.setSelected(false);
        rbtnC.setSelected(false);
        rbtnD.setSelected(false);
        btng.add(rbtnA);
        btng.add(rbtnB);
        btng.add(rbtnC);
        btng.add(rbtnD);
    }

    private void groupButton() {
        btng = new ButtonGroup();
        btng.add(rbtnA);
        btng.add(rbtnB);
        btng.add(rbtnC);
        btng.add(rbtnD);
        ActionListener radioListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
                String selectedText = selectedRadioButton.getText();
                List<LuaChonDTO> lstLuaChon = LuaChonDAL.layDanhSachLuaChonTheoMaCauHoi(lstKetQua.get(indexHienTai).getMaCauHoi());
                int maLuaChonA = lstLuaChon.get(0).getMaLuaChon();
                int maLuaChonB = lstLuaChon.get(1).getMaLuaChon();
                int maLuaChonC = lstLuaChon.get(2).getMaLuaChon();
                int maLuaChonD = lstLuaChon.get(3).getMaLuaChon();
                int maLuaChon = -1;
                if (selectedText == "A") {
                    maLuaChon = maLuaChonA;
                } else if (selectedText == "B") {
                    maLuaChon = maLuaChonB;
                } else if (selectedText == "C") {
                    maLuaChon = maLuaChonC;
                } else if (selectedText == "D") {
                    maLuaChon = maLuaChonD;
                }
                lstKetQua.get(indexHienTai).setMaLuaChon(maLuaChon);
                for (int i = 0; i <= maxIndex; i++) {
                    if (lstKetQua.get(i).getMaLuaChon() != -1) {
                        lstButton.get(i).setBackground(Color.blue);
                    }
                }
            }
        };

        rbtnA.addActionListener(radioListener);
        rbtnB.addActionListener(radioListener);
        rbtnC.addActionListener(radioListener);
        rbtnD.addActionListener(radioListener);
    }

    private void loadData() {
        int maDe = DeThiGUI.maDeThiDuocChon;
        lstCauHoi = CauHoiDAL.layDanhSachCauHoiTheoMaDe(maDe);
        maxIndex = lstCauHoi.size() - 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        txtDeThi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtTenSinhVien = new javax.swing.JTextField();
        btnKetThuc = new javax.swing.JButton();
        btnCauTiepTheo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rbtnC = new javax.swing.JRadioButton();
        rbtnD = new javax.swing.JRadioButton();
        rbtnA = new javax.swing.JRadioButton();
        rbtnB = new javax.swing.JRadioButton();
        labelCauHoi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCauHoi = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtB = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtC = new javax.swing.JTextArea();
        panelDanhSachCauHoi = new javax.swing.JPanel();

        setBackground(new java.awt.Color(139, 233, 253));
        setForeground(new java.awt.Color(139, 233, 253));

        jPanel1.setBackground(new java.awt.Color(139, 233, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thí sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(40, 42, 54))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(40, 42, 54));

        jLabel2.setText("Mã sinh viên:");

        txtMaSinhVien.setEnabled(false);

        txtDeThi.setEnabled(false);

        jLabel3.setText("Đề thi:");

        jLabel1.setText("Tên sinh viên:");

        jLabel5.setText("Số điện thoại:");

        txtSoDienThoai.setEnabled(false);

        txtTenSinhVien.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(txtMaSinhVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenSinhVien))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(txtDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );

        btnKetThuc.setText("Kết thúc");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });

        btnCauTiepTheo.setText("Câu tiếp theo");
        btnCauTiepTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCauTiepTheoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(139, 233, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin câu hỏi"));

        rbtnC.setText("C");

        rbtnD.setText("D");

        rbtnA.setText("A");

        rbtnB.setText("B");

        labelCauHoi.setText("Câu 1:");

        txtA.setColumns(20);
        txtA.setRows(5);
        jScrollPane2.setViewportView(txtA);

        txtCauHoi.setColumns(20);
        txtCauHoi.setRows(5);
        jScrollPane3.setViewportView(txtCauHoi);

        txtB.setColumns(20);
        txtB.setRows(5);
        jScrollPane4.setViewportView(txtB);

        txtD.setColumns(20);
        txtD.setRows(5);
        jScrollPane5.setViewportView(txtD);

        txtC.setColumns(20);
        txtC.setRows(5);
        jScrollPane6.setViewportView(txtC);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbtnC)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbtnA)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbtnD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbtnB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCauHoi)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnA))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnC)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnB)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnD)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        panelDanhSachCauHoi.setBackground(new java.awt.Color(139, 233, 253));
        panelDanhSachCauHoi.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách câu hỏi"));
        panelDanhSachCauHoi.setLayout(new java.awt.GridLayout(15, 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnKetThuc)
                        .addGap(182, 182, 182)
                        .addComponent(btnCauTiepTheo)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelDanhSachCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDanhSachCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKetThuc)
                    .addComponent(btnCauTiepTheo))
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có muốn kết thúc?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            for (int i = 0; i < lstKetQua.size(); i++) {
                if (lstKetQua.get(i).getMaLuaChon() != -1) {

                    KetQuaThiDAL.themKetQuaThi(lstKetQua.get(i));
                }
            }
            GiaoDienChinh.frameGiaoDienChinh.hienThiKetQua();
        } else {
        }


    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnCauTiepTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCauTiepTheoActionPerformed
        chuyenCauHoi(indexHienTai < maxIndex ? ++indexHienTai : indexHienTai);
    }//GEN-LAST:event_btnCauTiepTheoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCauTiepTheo;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelCauHoi;
    private javax.swing.JPanel panelDanhSachCauHoi;
    private javax.swing.JRadioButton rbtnA;
    private javax.swing.JRadioButton rbtnB;
    private javax.swing.JRadioButton rbtnC;
    private javax.swing.JRadioButton rbtnD;
    private javax.swing.JTextArea txtA;
    private javax.swing.JTextArea txtB;
    private javax.swing.JTextArea txtC;
    private javax.swing.JTextArea txtCauHoi;
    private javax.swing.JTextArea txtD;
    private javax.swing.JTextField txtDeThi;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenSinhVien;
    // End of variables declaration//GEN-END:variables
}
