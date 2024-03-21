/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.edusys.ui;

import com.edusys.entity.NhanVien;
import com.edusys.utils.MsgBox;
import com.edusys.DAO.nhanVienDAO;
import com.edusys.utils.Auth;
import com.edusys.utils.XImage;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;

/**
 *
 * @author ACER
 */
public class DangNhapJD extends javax.swing.JDialog {

    nhanVienDAO nvdao = new nhanVienDAO();
    Preferences pre;
    boolean remmember;
    /**
     * Creates new form DangNhapJdialog
     */
    public DangNhapJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(XImage.getAppIcon());
        setTitle("Dang Nhap He Thong");
        remmember();
    }
    private void remmember(){
        pre=Preferences.userNodeForPackage(this.getClass());
        remmember=pre.getBoolean("remmember", Boolean.valueOf(""));
        if (remmember) {
            txtTaiKhoan.setText(pre.get("TaiKhoan",""));
            txtMatKhau.setText(pre.get("MatKhau",""));
            cboRemember.setSelected(remmember);
        }
    }
    
    private void login() {
        String manv = txtTaiKhoan.getText();
        String mk = new String(txtMatKhau.getPassword());
        NhanVien nv = nvdao.findById(manv);
        if (nv == null) {
            MsgBox.alert(this, "Sai tên đăng nhập!!!");
        } else if (!mk.equals(nv.getMatKhau())) {
            MsgBox.alert(this, "Sai Mật Khẩu!!!");
        } else {
            MsgBox.alert(this, "Đăng Nhập Thành Công!!!");
            Auth.user = nv;
            this.dispose();
        }
    }

    private void exit() {
        if (MsgBox.confirm(this, "Bạn có chắc muốn thoát không?")) {
            System.exit(0);
        }
    }

    private void introduce() {
        new GioiThieuJD(new javax.swing.JFrame(), true).setVisible(true);
    }
    public void openHuongDan() {
        try {
            Desktop.getDesktop().browse(new java.io.File("help/index.html").toURI());
        } catch (Exception e) {
            MsgBox.alert(this, "Không tìm thấy file hướng dẫn!");
        }
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
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtMatKhau = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCanCel = new javax.swing.JButton();
        btnForgot = new javax.swing.JButton();
        cboRemember = new javax.swing.JCheckBox();
        lblIcon = new javax.swing.JLabel();
        lblshow = new javax.swing.JLabel();
        lblhide = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_Introduce = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_Github = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_Website = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 246, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 112, 82), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-users.png"))); // NOI18N
        jLabel16.setText("jLabel16");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 104, 99, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Tài Khoản:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 216, -1, -1));

        txtTaiKhoan.setBackground(new java.awt.Color(228, 246, 250));
        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTaiKhoan.setText("KienQuoc");
        txtTaiKhoan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 246, 250)));
        txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiKhoanActionPerformed(evt);
            }
        });
        txtTaiKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTaiKhoanKeyPressed(evt);
            }
        });
        jPanel1.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 261, 205, 31));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-user.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 247, 43, -1));

        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 298, 260, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 112, 82));
        jLabel4.setText("Mật khẩu:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 324, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-key.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 355, 45, -1));

        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 406, 260, 20));

        txtMatKhau.setBackground(new java.awt.Color(228, 246, 250));
        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMatKhau.setText("123456");
        txtMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 246, 250)));
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyPressed(evt);
            }
        });
        jPanel1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 367, 170, 33));

        btnLogin.setBackground(new java.awt.Color(0, 76, 76));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-login.png"))); // NOI18N
        btnLogin.setText("Đăng Nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, 40));

        btnCanCel.setBackground(new java.awt.Color(0, 76, 76));
        btnCanCel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnCanCel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-cancel.png"))); // NOI18N
        btnCanCel.setText("Hủy");
        btnCanCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanCelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCanCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, -1, 40));

        btnForgot.setBackground(new java.awt.Color(45, 61, 63));
        btnForgot.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnForgot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-forgot.png"))); // NOI18N
        btnForgot.setText("Quên Mật Khẩu");
        btnForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotActionPerformed(evt);
            }
        });
        jPanel1.add(btnForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 524, 266, 50));

        cboRemember.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cboRemember.setForeground(new java.awt.Color(238, 112, 82));
        cboRemember.setText("Nhớ mật khẩu");
        jPanel1.add(cboRemember, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 432, -1, -1));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-hide.png"))); // NOI18N
        lblIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        lblshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblshowMouseClicked(evt);
            }
        });
        jPanel1.add(lblshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 40, 20));

        lblhide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhideMouseClicked(evt);
            }
        });
        jPanel1.add(lblhide, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 40, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 328, 750));

        jPanel2.setBackground(new java.awt.Color(228, 141, 120));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 112, 82), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PHẦN MỀM QUẢN LÝ HỌC VIÊN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 0, 740, 110));

        jPanel3.setBackground(new java.awt.Color(228, 246, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 112, 82), 2));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/loginbg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(105, 105, 105))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 105, 740, 410));

        jPanel4.setBackground(new java.awt.Color(228, 246, 250));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 112, 82), 2));

        lbl_Introduce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-earth_planet.png"))); // NOI18N
        lbl_Introduce.setText("jLabel7");
        lbl_Introduce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_IntroduceMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(238, 112, 82));
        jLabel8.setText("Introduce");

        lbl_Github.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-github.png"))); // NOI18N
        lbl_Github.setText("jLabel9");
        lbl_Github.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_GithubMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(238, 112, 82));
        jLabel10.setText("Website");

        lbl_Website.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/icons8-website.png"))); // NOI18N
        lbl_Website.setText("jLabel9");
        lbl_Website.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_WebsiteMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(238, 112, 82));
        jLabel12.setText("Github");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_Introduce, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_Website, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addGap(202, 202, 202)
                        .addComponent(jLabel10)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addGap(142, 142, 142)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_Github, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_Introduce)
                        .addComponent(lbl_Website))
                    .addComponent(lbl_Github))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 750, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //trim()xóa khoảng trắng đầu và cuối chuỗi
        if (txtTaiKhoan.getText().trim().length() > 0) {
            if (txtMatKhau.getPassword().length > 0) {
                this.login();
            } else {
                MsgBox.alert(this, "Không được để trống mật khẩu!!!");
            }
        } else {
            MsgBox.alert(this, "Không được để trống tài khoản!!!");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotActionPerformed
        dispose();
        new ForgotJD(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btnForgotActionPerformed

    private void btnCanCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanCelActionPerformed
        this.exit();
    }//GEN-LAST:event_btnCanCelActionPerformed

    private void txtTaiKhoanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaiKhoanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.getRootPane().setDefaultButton(btnLogin);
            btnLogin.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            this.exit();
        }
    }//GEN-LAST:event_txtTaiKhoanKeyPressed

    private void txtMatKhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.getRootPane().setDefaultButton(btnLogin);
            btnLogin.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            this.exit();
        }
    }//GEN-LAST:event_txtMatKhauKeyPressed

    private void lblshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblshowMouseClicked
        lblhide.setVisible(true);
        lblhide.setEnabled(true);
        txtMatKhau.setEchoChar((char) 8226);
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/edusys/icon/icons8-hide.png"));
        lblIcon.setIcon(icon);
        lblshow.setVisible(false);
        lblshow.setEnabled(false);
    }//GEN-LAST:event_lblshowMouseClicked

    private void lblhideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhideMouseClicked
        lblshow.setVisible(true);
        lblshow.setEnabled(true);
        txtMatKhau.setEchoChar((char) 0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/edusys/icon/icons8-show.png"));
        lblIcon.setIcon(icon);
        lblhide.setVisible(false);
        lblhide.setEnabled(false);
    }//GEN-LAST:event_lblhideMouseClicked

    private void lbl_IntroduceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_IntroduceMouseClicked
        this.introduce();
    }//GEN-LAST:event_lbl_IntroduceMouseClicked

    private void lbl_WebsiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_WebsiteMouseClicked
        openHuongDan();
    }//GEN-LAST:event_lbl_WebsiteMouseClicked

    private void lbl_GithubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_GithubMouseClicked
        try {
            Desktop.getDesktop().browse(URI.create("https://github.com/KieuKienQuoc"));
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn.");
        }
    }//GEN-LAST:event_lbl_GithubMouseClicked

    private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaiKhoanActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhapJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapJD dialog = new DangNhapJD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanCel;
    private javax.swing.JButton btnForgot;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cboRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lbl_Github;
    private javax.swing.JLabel lbl_Introduce;
    private javax.swing.JLabel lbl_Website;
    private javax.swing.JLabel lblhide;
    private javax.swing.JLabel lblshow;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables

}
