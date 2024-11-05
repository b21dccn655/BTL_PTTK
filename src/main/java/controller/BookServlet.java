package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.Timestamp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dao.LichHen655Dao;
import model.LichHen655;

/**
 *
 * @author Vhc
 */
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Integer idObject = (Integer) session.getAttribute("id");
        int id = (idObject != null) ? idObject : 0;

        Boolean lanvObject = (Boolean) session.getAttribute("lanv");
        boolean lanv = (lanvObject != null) ? lanvObject : false;
        
        // Chỉ khách hàng mới đc đặt lịch
        if ((id == 0) || (lanv == true)){
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
        // Chuyển hướng đến trang đăng nhập nếu truy cập bằng GET
        request.getRequestDispatcher("book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Integer idObject = (Integer) session.getAttribute("id");
        int id = (idObject != null) ? idObject : 0;
        
        
        String ngaygio = request.getParameter("ngaygio");
        String hoten = request.getParameter("hoten");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("diachi");
        
        ngaygio = ngaygio.replace("T", " ") + ":00";
        Timestamp sql_ngaygio = Timestamp.valueOf(ngaygio);
        
        if (!sdt.matches("\\d{10}")){
            response.sendRedirect(request.getContextPath() + "/book.jsp?error=true");
            return;
        }
        
        LichHen655Dao dao = new LichHen655Dao();
        LichHen655 lichHen = dao.create(sql_ngaygio, hoten, sdt, diachi, id);
        if (lichHen != null) {
            response.sendRedirect(request.getContextPath() + "/book.jsp?error=false");
        } else {
            response.sendRedirect(request.getContextPath() + "/book.jsp?error=true");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
