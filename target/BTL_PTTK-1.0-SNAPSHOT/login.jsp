<%-- 
    Document   : login
    Created on : Oct 26, 2024, 4:56:47 PM
    Author     : Vhc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
        <%
            // Kiểm tra tham số "error" trong URL
            String errorParam = request.getParameter("error");
            if ("true".equals(errorParam)) {
        %>
                <div style="color: red;">
                    Đã xảy ra lỗi! Vui lòng kiểm tra lại thông tin.
                </div>
        <%
            }
        %>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>