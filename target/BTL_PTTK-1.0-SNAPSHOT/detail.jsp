<%-- 
    Document   : detail
    Created on : Oct 30, 2024, 12:56:21 AM
    Author     : Vhc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.HoaDon655" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
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
        %>
                        <h2>Chi tiết hóa đơn:</h2>
                        <table border="1">
                            <tr>
                                <th>ID</th>
                                <th>Tổng tiền</th>
                                <th>Đã thanh toán</th>
                                <th>Ngày giờ</th>
                                <th>khyeucau655</th>
                                <th>kh655</th>
                                <th>nvbh655</th>
                            </tr>
                            <%
                                HoaDon655 hd = (HoaDon655) request.getAttribute("hd");
                            %>
                                <tr>
                                    <td><%= hd.getId() %></td>     
                                    <td><%= hd.getTongtien() %></td> 
                                    <td><%= hd.isDathanhtoan() %></td> 
                                    <td><%= hd.getNgaygio() %></td> 
                                    <td><%= hd.getKhyeucau655() %></td> 
                                    <td><%= hd.getKh655() %></td> 
                                    <td><%= hd.getNvbh655() %></td> 
                                </tr>
        <% 
                }
                }   
            }   
        %>
    </body>
</html>
