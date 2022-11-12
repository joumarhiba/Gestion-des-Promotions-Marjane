package com.marjane.servlets;

import com.marjane.CryptPwd;
import com.marjane.dao.AdminDao;
import com.marjane.dao.CenterDao;
import com.marjane.entities.Admin;
import com.marjane.entities.AdminGen;
import com.marjane.entities.Center;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAdminServlet" ,urlPatterns = {"/UpdateAdminServlet"})
public class UpdateAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  this.updateAdmin(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateAdmin(req, resp);
    }

    private void updateAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AdminGen aGen = new AdminGen();
        aGen.setAdminId(1);
        aGen.setEmail("supAdmin@gmail.com");
        aGen.setRole(0);
        try {
            Admin admin = new Admin();
            Center center = new Center();
            String fullname = req.getParameter("fullname");
            String email = req.getParameter("email");
            String ville = req.getParameter("ville");
            int role = Integer.parseInt(req.getParameter("role"));
            int idAdmin = Integer.parseInt(req.getParameter("idAdmin"));
            admin.setAdminGen(aGen);
            admin.setRole(role);
            admin.setFullname(fullname);
            admin.setEmail(email);
            admin.setId(idAdmin);
            center.setAdmin(admin);
            center.setVille(ville);

            AdminDao adminDao = new AdminDao();
            adminDao.updateCenterAdmin(aGen,email,fullname, role, idAdmin);
            CenterDao centerDao = new CenterDao();
            centerDao.updateCenter(ville,idAdmin);
            // resp.sendRedirect("/dashboardAdminGen.jsp");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dashboardAdminGen.jsp");
            requestDispatcher.forward(req, resp);


        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("EEEEEEEEEError: "+e.getMessage());
        }
    }

}
