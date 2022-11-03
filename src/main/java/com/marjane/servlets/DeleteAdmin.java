package com.marjane.servlets;

import com.marjane.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdminServlet" ,urlPatterns = {"/DeleteAdminServlet"})
public class DeleteAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.delete(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idAdmin = Integer.parseInt(req.getParameter("idAdmin"));
        AdminDao adminDao = new AdminDao();
        boolean row = adminDao.deleteCenterAdmin(idAdmin);
        if(row){
        resp.getWriter().println("the admin is deleted");
        }else{
            resp.getWriter().println("nooooooooooo something wrong ...");
        }
    }

}
