/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dao;

import model.LichHen655;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
/**
 *
 * @author Vhc
 */
public class LichHen655Dao extends Dao{
    
    public LichHen655Dao() {
        super();
    }

    // Tạo lịch hẹn
    public LichHen655 create(Timestamp ngaygio, String hoten, String sdt, String diachi, int kh655) {
        LichHen655 lichHen = new LichHen655(ngaygio, hoten, sdt, diachi, kh655);
        String sql = "INSERT INTO lichhen655 (ngaygio, hoten, sdt, diachi, daduyet, kh655) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            
            pstmt.setTimestamp(1, lichHen.getNgaygio());
            pstmt.setString(2, lichHen.getHoten());
            pstmt.setString(3, lichHen.getSdt());
            pstmt.setString(4, lichHen.getDiachi());
            pstmt.setBoolean(5, lichHen.getDaduyet());
            pstmt.setInt(6, lichHen.getKh655());
            int status = pstmt.executeUpdate();

            if (status > 0) {
                return lichHen;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
