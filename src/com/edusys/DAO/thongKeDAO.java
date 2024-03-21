/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.DAO;


import com.edusys.utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class thongKeDAO {
//    "{call sp_ThongKeNguoiHoc}"
//   "{call sp_BangDiem (?)}"
//    "{call sp_ThongKeDiem}"
//    "{call sp_ThongKeDoanhThu (?)}"

    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String BANGDIEM_SQL = "{call sp_BangDiem (?)}";
    public static String LUONGNGUOIHOC_SQL = "{call sp_LuongNguoiHoc}";
    public static String DIEMCHUYENDE_SQL = "{call sp_DiemChuyenDe}";
    public static String DOANHTHU_SQL = "{call sp_DoanhThu (?)}";

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            rs = XJDBC.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getBangDiem(Integer makh) {
        String[] cols = {"MaNH", "HoTen", "Diem"};
        return this.getListOfArray(BANGDIEM_SQL, cols, makh);
    }

    public List<Object[]> getLuongNguoiHoc() {
        String[] cols = {"Nam", "SoLuong", "DauTien", "CuoiCung"};
        return this.getListOfArray(LUONGNGUOIHOC_SQL, cols);
    }

    public List<Object[]> getDiemChuyenDe() {
        String[] cols = {"ChuyenDe", "SoHV", "ThapNhat", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(DIEMCHUYENDE_SQL, cols);
    }

    public List<Object[]> getDoanhThu(int nam) {
        String[] cols = {"ChuyenDe", "SoKH", "SoHV", "DoanhThu", "ThapNhat", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(DOANHTHU_SQL, cols, nam);
    }
}
