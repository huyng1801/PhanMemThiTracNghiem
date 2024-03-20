/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAL.SinhVienDAL;
import DTO.SinhVienDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author huyng
 */
public class GiaoDienChinh extends javax.swing.JFrame {

    private DeThiGUI panelDeThi;
    private CauHoiGUI panelCauHoi;
    public static GiaoDienChinh frameGiaoDienChinh;
    private ThiGUI panelThi;
    private SinhVienGUI panelSinhVien;
    private XepHangGUI panelXepHang;

    public GiaoDienChinh() {
        initComponents();
        frameGiaoDienChinh = this;
        CanGiua();
        hienThiDeThi();
    }

    public void CanGiua() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelChinh = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuTuyChon = new javax.swing.JMenu();
        menuItemThoat = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemDeThi = new javax.swing.JMenuItem();
        menuKetQua = new javax.swing.JMenu();
        menuItemXemKetQuaThi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelChinh.setBackground(new java.awt.Color(139, 233, 253));
        panelChinh.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        panelChinh.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelChinh, java.awt.BorderLayout.CENTER);

        menuTuyChon.setText("Tùy chọn");

        menuItemThoat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuItemThoat.setText("Thoát");
        menuItemThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemThoatActionPerformed(evt);
            }
        });
        menuTuyChon.add(menuItemThoat);

        jMenuBar1.add(menuTuyChon);

        jMenu2.setText("Danh mục");

        menuItemDeThi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemDeThi.setForeground(new java.awt.Color(40, 42, 54));
        menuItemDeThi.setText("Đề thi");
        menuItemDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDeThiActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemDeThi);

        jMenuBar1.add(jMenu2);

        menuKetQua.setText("Kết quả");

        menuItemXemKetQuaThi.setText("Xem kết quả thi");
        menuItemXemKetQuaThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemXemKetQuaThiActionPerformed(evt);
            }
        });
        menuKetQua.add(menuItemXemKetQuaThi);

        jMenuBar1.add(menuKetQua);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuItemThoatActionPerformed
    public void hienThiGiaoDienSinhVien() {
        panelSinhVien = new SinhVienGUI();
        panelSinhVien.setVisible(true);
        panelChinh.setLayout(new FlowLayout());
        panelChinh.removeAll();
        panelChinh.add(panelSinhVien, BorderLayout.CENTER);
        panelChinh.updateUI();
        panelChinh.revalidate();
        panelChinh.repaint();
    }

    public void hienThiCauHoiCuaDeThi() {
        panelCauHoi = new CauHoiGUI();
        panelCauHoi.setVisible(true);
        panelChinh.setLayout(new FlowLayout());
        panelChinh.removeAll();
        panelChinh.add(panelCauHoi, BorderLayout.CENTER);
        panelChinh.updateUI();
        panelChinh.revalidate();
        panelChinh.repaint();
    }

    public void hienThiBaiThi() {
        panelThi = new ThiGUI();
        panelThi.setVisible(true);
        panelChinh.setLayout(new FlowLayout());
        panelChinh.removeAll();
        panelChinh.add(panelThi, BorderLayout.CENTER);
        panelChinh.updateUI();
        panelChinh.revalidate();
        panelChinh.repaint();
    }

    public void hienThiDeThi() {
        panelDeThi = new DeThiGUI();
        panelDeThi.setVisible(true);
        panelChinh.setLayout(new FlowLayout());
        panelChinh.removeAll();
        panelChinh.add(panelDeThi, BorderLayout.CENTER);
        panelChinh.updateUI();
        panelChinh.revalidate();
        panelChinh.repaint();
    }

    public void hienThiKetQua() {
        panelXepHang = new XepHangGUI();
        panelXepHang.setVisible(true);
        panelChinh.setLayout(new FlowLayout());
        panelChinh.removeAll();
        panelChinh.add(panelXepHang, BorderLayout.CENTER);
        panelChinh.updateUI();
        panelChinh.revalidate();
        panelChinh.repaint();
    }
    private void menuItemDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDeThiActionPerformed
        // TODO add your handling code here:
        hienThiDeThi();
    }//GEN-LAST:event_menuItemDeThiActionPerformed

    private void menuItemXemKetQuaThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemXemKetQuaThiActionPerformed
        // TODO add your handling code here:
        hienThiKetQua();
    }//GEN-LAST:event_menuItemXemKetQuaThiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuItemDeThi;
    private javax.swing.JMenuItem menuItemThoat;
    private javax.swing.JMenuItem menuItemXemKetQuaThi;
    private javax.swing.JMenu menuKetQua;
    private javax.swing.JMenu menuTuyChon;
    private javax.swing.JPanel panelChinh;
    // End of variables declaration//GEN-END:variables
}
