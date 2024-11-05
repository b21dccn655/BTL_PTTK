<%-- 
    Document   : report
    Created on : Oct 28, 2024, 9:39:02 PM
    Author     : Vhc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Báo cáo</title>
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
        %>
    
            <h1>Trang báo cáo!</h1>
            <a href="statistic.jsp">Thông kê dịch vụ/phụ tùng theo doanh thu</a>
        
        <% 
                }
            }
        %>
    </body>
</html>
