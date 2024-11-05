<%-- 
    Document   : book
    Created on : Oct 26, 2024, 4:56:57 PM
    Author     : Vhc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đặt lịch hẹn</title>
    </head>
    <body>
        <% 
        // Lấy thuộc tính "id" từ session
            Integer idObject = (Integer) session.getAttribute("id");
            int id = (idObject != null) ? idObject : 0;

            // Lấy thuộc tính "lanv" từ session
            Boolean lanvObject = (Boolean) session.getAttribute("lanv");
            boolean lanv = (lanvObject != null) ? lanvObject : false;
    
            if((id != 0) & (lanv == false)) {
                // Kiểm tra tham số "error" trong URL
                String errorParam = request.getParameter("error");
                if ("true".equals(errorParam)) {
            %>
                    <div style="color: red;">
                        Đã xảy ra lỗi! Vui lòng kiểm tra lại thông tin.
                    </div>
            <%
                } else if("false".equals(errorParam)) {
            %>
                    <div style="color: green;">
                        Tạo lịch hẹn thành công. Chúng tôi sẽ duyệt trong thời gian ngắn!.
                    </div>
             <%
                } else {
            %>
            <form action="BookServlet" method="post">
                Ngày giờ: <input type="datetime-local" name="ngaygio" required><br>
                Họ tên: <input type="text" name="hoten" required><br>
                SDT: <input type="text" name="sdt" required><br>
                Địa chỉ: <input type="text" name="diachi" required><br>
                <input type="submit" value="Book">
            </form>
            <%
                }
            }
            %>
    </body>
</html>
