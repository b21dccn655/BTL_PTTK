/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import model.TKDVPTTDT655;
import dao.TKDVPTTDT655Dao;

/**
 *
 * @author Vhc
 */
public class StatisticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Integer idObject = (Integer) session.getAttribute("id");
        int id = (idObject != null) ? idObject : 0;

        Boolean lanvObject = (Boolean) session.getAttribute("lanv");
        boolean lanv = (lanvObject != null) ? lanvObject : false;
        
        String vitri = (String) session.getAttribute("vitri");
        
        if ((id == 0) || (lanv == false) || (!"QL".equals(vitri))){
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
        
        // Chuyển hướng đến trang đăng nhập nếu truy cập bằng GET
        request.getRequestDispatcher("statistic.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String ngaybdstr = request.getParameter("ngaybd");
        String ngayktstr = request.getParameter("ngaykt");
        // Chuyển đổi chuỗi thành LocalDate
        LocalDate ngaybd = LocalDate.parse(ngaybdstr);
        LocalDate ngaykt = LocalDate.parse(ngayktstr);
        
        TKDVPTTDT655Dao tkdvpttdt655d = new TKDVPTTDT655Dao();
        TKDVPTTDT655 tkdvpttdt655 = tkdvpttdt655d.thongke(ngaybd, ngaykt);
        
        
        request.setAttribute("tkdvpttdt655", tkdvpttdt655);
        request.setAttribute("error", false);
        request.getRequestDispatcher("statistic.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
