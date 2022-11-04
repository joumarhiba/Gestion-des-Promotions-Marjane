package com.marjane.servlets;


import com.marjane.dao.ChefRayonDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "UpdatePromotionServlet" ,urlPatterns = {"/UpdatePromotionServlet"})
public class UpdatePromotion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updatePromotion(req, resp);
    }


    public int updatePromotion(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int idPromotion = Integer.parseInt(req.getParameter("idPromo"));
        int status  = 1;

        ChefRayonDao chefRayonDao = new ChefRayonDao();
        chefRayonDao.updatePromo(idPromotion);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dashboardChefRayon.jsp");
        requestDispatcher.forward(req, resp);

        return 0;
    }
}
