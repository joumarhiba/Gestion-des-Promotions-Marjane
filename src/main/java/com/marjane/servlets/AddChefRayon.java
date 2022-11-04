package com.marjane.servlets;


import com.marjane.CryptPwd;
import com.marjane.dao.AdminDao;
import com.marjane.dao.CenterDao;
import com.marjane.dao.ChefRayonDao;
import com.marjane.entities.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "AddChefRayonServlet" ,urlPatterns = {"/AddChefRayonServlet"})
public class AddChefRayon extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addChefRayon(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    public void addChefRayon(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        Center center = new Center();
        int idCenter = Integer.parseInt(req.getParameter("center"));
        center.setId(idCenter);
        try {

            ChefRayon chefRayon = new ChefRayon();
            String email = req.getParameter("email");

            String p = "123456";
            chefRayon.setPassword(p);
            chefRayon.setRole(3);
            chefRayon.setEmail(email);
            chefRayon.setCenter(center);
            chefRayon.setCategoryId(Integer.parseInt(req.getParameter("category")));


            ChefRayonDao chefRayonDao = new ChefRayonDao();
            chefRayonDao.addChefRayon(chefRayon);
            CenterDao centerDao = new CenterDao();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adminPage.jsp");
            requestDispatcher.forward(req, resp);


        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("error: "+e.getMessage());
        }

    }
}
