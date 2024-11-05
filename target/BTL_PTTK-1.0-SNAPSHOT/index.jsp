<%-- 
    Document   : index
    Created on : Oct 26, 2024, 4:56:10 PM
    Author     : Vhc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ</title>
</head>
<body>
    
    <h1>Chào Mừng Đến Với Ứng Dụng Của Chúng Tôi!</h1>
    <% 
        // Lấy thuộc tính "id" từ session
        Integer idObject = (Integer) session.getAttribute("id");
        int id = (idObject != null) ? idObject : 0;

        // Lấy thuộc tính "lanv" từ session
        Boolean lanvObject = (Boolean) session.getAttribute("lanv");
        boolean lanv = (lanvObject != null) ? lanvObject : false;
    
    if(id == 0) {
    %>
    
        <a href="login.jsp">Đăng Nhập</a>
        
    <% 
    } else {
        if (lanv == false) {
    %>
    
        <a href="book.jsp">Đặt lịch hẹn</a>
        
    <% 
        } else {  
    %>
        
        <a href="report.jsp">Xem báo cáo</a>
    <% 
        }
    }
    %>
    
</body>
</html>