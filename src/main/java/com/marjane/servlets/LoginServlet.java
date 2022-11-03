package com.marjane.servlets;

import com.marjane.CryptPwd;
import com.marjane.dao.AdminDao;
import com.marjane.dao.ChefRayonDao;

import  javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "LoginServlet" ,urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("adminFiles/adminPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            login(req, resp);
        }catch (Exception ex){
            ex.printStackTrace();
            resp.getWriter().println("error DU CATCH : "+ex.getMessage());
            resp.getWriter().println(req.getParameter("role"));
            resp.getWriter().println(req.getParameter("email"));
            resp.getWriter().println(req.getParameter("password"));
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int role = Integer.parseInt(req.getParameter("role"));

        CryptPwd cp = new CryptPwd();
        String hashedP = cp.cryptage(password);

        AdminDao adminDao = new AdminDao();
        ChefRayonDao chefRayonDao = new ChefRayonDao();
       if(role == 2){
           if(adminDao.validate(email,hashedP)) {
               RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminPage.jsp");
               requestDispatcher.forward(req, resp);
               resp.getWriter().println("in if");
           }
           else {
               resp.getWriter().println("in else");
               throw new Exception("username or password is wrong ........");
           }
        } else if (role == 3) {
           if(chefRayonDao.validate(email,password) != 0) {
               RequestDispatcher requestDispatcher = req.getRequestDispatcher("dashboardChefRayon.jsp");
               requestDispatcher.forward(req, resp);
           }
           else{
               resp.getWriter().println(email+"////"+password);
           }
       }else {
           if(adminDao.validate(email,password)) {
               RequestDispatcher requestDispatcher = req.getRequestDispatcher("dashboardAdminGen.jsp");
               requestDispatcher.forward(req, resp);
           }
       }

    }
}
