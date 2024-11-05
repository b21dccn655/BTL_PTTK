/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HoaDon655Dao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Vhc
 */
public class DetailServlet extends HttpServlet {

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
        id = Integer.parseInt(request.getParameter("id"));
        HoaDon655Dao hdd = new HoaDon655Dao();
        
        request.setAttribute("hd", hdd.read(id));
        request.setAttribute("error", false);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
