/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utils;

import com.edusys.entity.NhanVien;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Auth {
    String txt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ1234567890";
    SecureRandom rd = new SecureRandom();
    
    public static NhanVien user = null;
    public static void clear() {
        Auth.user = null;
    }
    public static boolean isLogin() {
        return Auth.user != null;
    }
    public static boolean isManager() {
        return Auth.isLogin() && user.isVaiTro();
    }
    public static String getRank(double diem) {
        String xepLoai = "Xuất sắc";
        if (diem < 0) {
            xepLoai = "Chưa nhập";
        } else if (diem < 3) {
            xepLoai = "Kém";
        } else if (diem < 5) {
            xepLoai = "Yếu";
        } else if (diem < 6.5) {
            xepLoai = "Trung bình";
        } else if (diem < 7.5) {
            xepLoai = "Khá";
        } else if (diem < 9) {
            xepLoai = "Giỏi";
        }
        return xepLoai;
    }
    public static boolean checkMaNV(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{1,15}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải có 1-15 kí tự\nchữ hoa, thường không dấu hoặc số.");
            return false;
        }
    }
    public static boolean checkMaNH(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{7}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải có đúng 7 kí tự \nchữ thường, chữ hoa hoặc số");
            return false;
        }
    }
    public static boolean checkMaCD(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{5}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải có đúng 5 kí tự\nchữ thường, chữ hoa hoặc số");
            return false;
        }
    }
    public static boolean checkPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 2 && txt.getPassword().length
                < 17) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải có từ 3-16 kí tự.");
            return false;
        }
    }
    public static boolean isValidDate(String inDate) {
        if (inDate == null) {
            return false;
        }
        //set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        dateFormat.setLenient(false);
        try {
            //parse the inDate parameter
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
    public static boolean checkDate(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        if (isValidDate(id)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " không đúng định dạng dd / MM / yyyy");
            return false;
        }
    }
    public static boolean checkName(JTextField txt) {
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải là tên có dấu hoặc không và từ 3-25 kí tự.");
            return false;
        }
    }
    public static boolean checkTenCD(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,50}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải từ 3-50 kí tự.");
            return false;
        }
    }
    public static boolean checkMoTaCD(JTextArea txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,255}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải từ 3-255 kí tự.");
            return false;
        }
    }
    public static boolean checkSDT(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải gồm 10 số\nđúng các đầu số của nhà mạng.");
            return false;
        }
    }
    public static boolean checkEmail(JTextField txt) {
        String id = txt.getText();
        String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{5,32}@[a-zA-Z0-9]{2,}(\\.[a-zA-Z0-9]{2,5}){1,2}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            MsgBox.alert(txt.getRootPane(), txt.getText() + " không đúng định dạng (ký tự có dấu)"
                    + "\nhoặc bị giới hạn kí tự cho phép.");
            return false;
        }
    }
    public static boolean checkThoiLuong(JTextField txt) {
        txt.setBackground(white);
        try {
            int hour = Integer.parseInt(txt.getText());
            if (hour >= 0) {
                return true;
            } else {
                txt.setBackground(pink);
                MsgBox.alert(txt.getRootPane(), txt.getText() + " phải lớn hơn bằng 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải là số nguyên.");
            return false;
        }
    }
    public static boolean checkHocPhi(JTextField txt) {
        txt.setBackground(white);
        try {
            float hp = Float.parseFloat(txt.getText());
            if (hp >= 0) {
                return true;
            } else {
                txt.setBackground(pink);
                MsgBox.alert(txt.getRootPane(), txt.getText() + " phải là lớn hơn bằng 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải là số thực.");
            return false;
        }
    }

    public static boolean checkDiem(JTextField txt) {
        txt.setBackground(white);
        try {
            float hp = Float.parseFloat(txt.getText());
            if ((hp >= 0 && hp <= 10) || hp == -1) {
                return true;
            } else {
                txt.setBackground(pink);
                MsgBox.alert(txt.getRootPane(), txt.getText() + " phải là trong khoảng 0-10");
                return false;
            }
        } catch (NumberFormatException e) {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải là số thực.");
            return false;
        }
    }

    public static boolean checkNullText(JTextField txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            MsgBox.alert(txt.getRootPane(), txt.getText() + " không được để trống.");
            return false;
        }
    }

    public static boolean checkNullText(JTextArea txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống "+txt.getText());
            return false;
        }
    }

    public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống "+txt.getText());
            return false;
        }
    }
    public static boolean check5Ngay(JTextField txt, JTextField txt2) {
        Date date = XDate.toDate(txt.getText());
        Date date2 = XDate.toDate(txt2.getText());
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        c2.setTime(date2);
        long a = (c1.getTime().getTime() - c2.getTime().getTime()) / (24 * 3600 * 1000);
        if (a >= 5) {
            return true;
        } else {
            MsgBox.alert(txt.getRootPane(), "Ngày khai giảng phải cách ngày tạo ít nhất 5 ngày.");
            return false;
        }
    }
    public static boolean checkNullHinh(JLabel lbl) {
        if (lbl.getToolTipText() != null) {
            return true;
        } else {
            MsgBox.alert(lbl.getRootPane(), lbl.getText() + " không được để trống.");
            return false;
        }
    }
    public static boolean checkPassNV(JPasswordField txt) {
        if (txt.getPassword().length > 5 && txt.getPassword().length < 17) {
            return true;
        } else {
            MsgBox.alert(txt.getRootPane(), txt.getText() + " phải có từ 3-16 kí tự.");
            return false;
        }
    }
    public String random(int n){
        StringBuilder str = new StringBuilder(n);
        for (int i = 0; i < 1; i++) {
            str.append(txt.charAt(rd.nextInt(txt.length())));
        }
        return str.toString();
        
    }
}
