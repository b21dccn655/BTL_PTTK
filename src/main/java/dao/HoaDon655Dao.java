/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.HoaDon655;

/**
 *
 * @author Vhc
 */
public class HoaDon655Dao extends Dao{

    public HoaDon655Dao() {
        super();
    }

    public HoaDon655 read(int hoadon655) {
        HoaDon655 hd = new HoaDon655();
        String sql = "SELECT * FROM hoadon655 WHERE id = ?;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            
            pstmt.setInt(1, hoadon655);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hd.setId(rs.getInt("id"));                
                hd.setTongtien(rs.getFloat("tongtien"));
                hd.setNgaygio(rs.getTimestamp("ngaygio"));
                hd.setDathanhtoan(rs.getBoolean("dathanhtoan"));
                hd.setKhyeucau655(rs.getInt("khyeucau655"));
                hd.setKh655(rs.getInt("kh655"));
                hd.setNvbh655(rs.getInt("nvbh655"));
                return hd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public ArrayList<Integer> listHoaDon655(LocalDate ngaybdldate, LocalDate ngayktldate, int id, String type){
        ArrayList<Integer> al = new ArrayList<>();
        String sql_list = "";
        if ("dichvu655".equals(type)) {
            sql_list += "SELECT hoadon655.id as id FROM hoadon655\n" +
                            "WHERE (ngaygio BETWEEN ? AND ?) AND dathanhtoan = 1\n" +
                            "AND khyeucau655 IN (SELECT khyeucau655 FROM dvyeucau655 WHERE dichvu655 = ?);";
        } else {
            sql_list += "SELECT hoadon655.id as id FROM hoadon655\n" +
                            "WHERE (ngaygio BETWEEN ? AND ?) AND dathanhtoan = 1\n" +
                            "AND khyeucau655 IN (SELECT khyeucau655 FROM ptyeucau655 WHERE phutung655 = ?);";
        }
        
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql_list)) {
            Date ngaybd = Date.valueOf(ngaybdldate);
            Date ngaykt = Date.valueOf(ngayktldate);
            pstmt.setDate(1, ngaybd);            
            pstmt.setDate(2, ngaykt);
            pstmt.setInt(3, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                al.add(rs.getInt("id"));
            }
            return al;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
