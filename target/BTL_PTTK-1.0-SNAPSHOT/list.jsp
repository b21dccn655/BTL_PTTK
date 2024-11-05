<%-- 
    Document   : list
    Created on : Oct 30, 2024, 12:23:11 AM
    Author     : Vhc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
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
                        String ngaybd = request.getParameter("ngaybd");
                        String ngaykt = request.getParameter("ngaykt");
        %>
                        <h2>Ngày bắt đầu: <%= ngaybd %></h2>
                        <h2>Ngày kết thúc: <%= ngaykt %></h2>
                        <h2>Danh sách hóa đơn:</h2>
                        <table border="1">
                            <tr>
                                <th>ID</th>
                                <th>Chi Tiết</th>
                            </tr>
                            <%
                                ArrayList<Integer> hdl = (ArrayList<Integer>) request.getAttribute("hdl");
                                for (Integer hd : hdl) {
                            %>
                                <tr>
                                    <td><%= hd %></td>
                                    <td>
                                        <a href="DetailServlet?id=<%= hd %>">Xem chi tiết</a>
                                    </td>
                                </tr>
                            <%
                                }
                            %>
        <% 
                }
                }
            }   
        %>
    </body>
</html>
