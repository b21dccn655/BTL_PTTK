<%-- 
    Document   : statistic
    Created on : Oct 26, 2024, 4:57:11 PM
    Author     : Vhc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="model.TKDVTDT655" %>
<%@ page import="model.TKPTTDT655" %>
<%@ page import="model.TKDVPTTDT655" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Thống kê</title>
    </head>
    <body>
        <%
            // Lấy thuộc tính "id" từ session
            Integer idObject = (Integer) session.getAttribute("id");
            int id = (idObject != null) ? idObject : 0;

            // Lấy thuộc tính "lanv" từ session
            Boolean lanvObject = (Boolean) session.getAttribute("lanv");
            boolean lanv = (lanvObject != null) ? lanvObject : false;
    
            if((id != 0) & (lanv == true)) {
            
                String vitri = (String) session.getAttribute("vitri");
                if("QL".equals(vitri)) {
                
                    // Kiểm tra tham số "error" trong URL
                    Boolean error = (Boolean) request.getAttribute("error");
                    boolean errorst = (error != null) ? error : false;
                    if ((error != null) && (errorst == false)) {
                        TKDVPTTDT655 tkdvpttdt655 = (TKDVPTTDT655) request.getAttribute("tkdvpttdt655");
                        LocalDate ngaybd = tkdvpttdt655.getNgaybd();
                        LocalDate ngaykt = tkdvpttdt655.getNgaykt();
                    
        %>
                    <h2>Ngày bắt đầu: <%= ngaybd %></h2>
                    <h2>Ngày kết thúc: <%= ngaykt %></h2>                
                    <h2>Dịch vụ:</h2>  
                    <table border="1">
                        <tr>
                            <th>ID</th>
                            <th>DichVu655</th>
                            <th>Mô tả</th>
                            <th>Giá</th>
                            <th>Doanh Thu</th>
                            <th>Chi Tiết</th>
                        </tr>
                        <%
                            ArrayList<TKDVTDT655> dvl = (ArrayList<TKDVTDT655>) tkdvpttdt655.getTkdvtdt655();
                            for (TKDVTDT655 dv : dvl) {
                        %>
                            <tr>
                                <td><%= dv.getId() %></td>
                                <td><%= dv.getTen() %></td>
                                <td><%= dv.getMoTa() %></td>
                                <td><%= dv.getGia() %></td>
                                <td><%= dv.getTongtien() %></td>
                                <td>
                                    <a href="ListServlet?ngaybd=<%= ngaybd %>&ngaykt=<%= ngaykt %>&type=dichvu655&id=<%= dv.getId() %>">Xem chi tiết</a>
                                </td>
                            </tr>
                        <%
                            }
                        %>
                    <h2>Phụ tùng:</h2>
                    <table border="1">
                        <tr>
                            <th>ID</th>
                            <th>DichVu655</th>
                            <th>Mô tả</th>
                            <th>Giá</th>
                            <th>Doanh Thu</th>
                            <th>Chi Tiết</th>
                        </tr>
                        <%
                            ArrayList<TKPTTDT655> ptl = (ArrayList<TKPTTDT655>) tkdvpttdt655.getTkpttdt655();
                            for (TKPTTDT655 pt : ptl) {
                        %>
                            <tr>
                                <td><%= pt.getId() %></td>
                                <td><%= pt.getTen() %></td>
                                <td><%= pt.getMoTa() %></td>
                                <td><%= pt.getGia() %></td>
                                <td><%= pt.getTongtien() %></td>
                                <td>
                                    <a href="ListServlet?ngaybd=<%= ngaybd %>&ngaykt=<%= ngaykt %>&type=phutung655&id=<%= pt.getId() %>">Xem chi tiết</a>
                                </td>
                            </tr>
                        <%
                            }
                        %>
            <%
                        } else {
            %>
                        <form action="StatisticServlet" method="post">
                            Ngày bắt đầu: <input type="date" name="ngaybd" required><br>
                            Ngày kết thúc: <input type="date" name="ngaykt" required><br>
                            <input type="submit" value="Statistic">
                        </form>
        <%
                    }
                }   
            }   
        %>
    </body>
</html>
