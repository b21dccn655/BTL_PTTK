package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ThanhVien655;
import dao.ThanhVien655Dao;
import dao.NhanVien655Dao;

/**
 *
 * @author Vhc
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển hướng đến trang đăng nhập nếu truy cập bằng GET
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ThanhVien655Dao dao = new ThanhVien655Dao();
        ThanhVien655 tv = dao.login(username, password);
        
        if (tv != null) {
            request.getSession().setAttribute("id", tv.getId());
            request.getSession().setAttribute("lanv", tv.getLanv());
            if (tv.getLanv()){
                NhanVien655Dao nvd = new NhanVien655Dao();
                String vitri = nvd.read_vitri(tv.getId());
                request.getSession().setAttribute("vitri", vitri);
            }
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
