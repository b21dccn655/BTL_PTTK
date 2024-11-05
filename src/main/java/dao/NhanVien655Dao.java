/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vhc
 */
public class NhanVien655Dao extends Dao{
    
    public NhanVien655Dao() {
        super();
    }
    
    public String read_vitri(int id){
        String sql = "SELECT vitri FROM nhanvien655 WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String vitri = rs.getString("vitri");
                return vitri;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
