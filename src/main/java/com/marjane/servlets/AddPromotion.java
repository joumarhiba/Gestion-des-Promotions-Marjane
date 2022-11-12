package com.marjane.servlets;

import com.marjane.dao.CategoryDao;
import com.marjane.dao.PromotionDao;
import com.marjane.entities.Category;
import com.marjane.entities.Center;
import com.marjane.entities.Promotion;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet( name = "AddPromotionServlet" ,urlPatterns = {"/AddPromotionServlet"})
public class AddPromotion extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Category category = new Category();
        int idCategory = Integer.parseInt(req.getParameter("category"));
        category.setId(idCategory);

        Center center = new Center();
        int idCenter = Integer.parseInt(req.getParameter("center"));
        center.setId(idCenter);
       try {
           Promotion promotion = new Promotion();

          promotion.setCenter(center);
           promotion.setCategory(category);
           String stringDate = req.getParameter("date");
           Date formattedDate = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
           promotion.setDate(formattedDate);
           promotion.setPromo(Double.parseDouble(req.getParameter("promo")));
           Double fidelity = promotion.getPromo() * 50 / 5;
           promotion.setFidelity(fidelity);

           if (promotion.getPromo() < 50.00) {
               if(promotion.getCategory().getId() == 1 && promotion.getPromo() > 20.00) {
                   req.setAttribute("errorMsg", "La promotion n est pas appliquée Vous avez depasser 20% pour Multimedia !!! ");
                   RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addPromotion.jsp");
                   requestDispatcher.forward(req, resp);
               }else  {
                   resp.getWriter().println(promotion.getCategory());
           PromotionDao promotionDao = new PromotionDao();
           promotionDao.addPromotion(promotion);
           req.setAttribute("successMsg", "La promotion est ajoutée avec succes");
           RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addPromotion.jsp");
           requestDispatcher.forward(req, resp);
               }
           }else {
               resp.getWriter().println("Une promotion ne peut pas depasser 50%");
               req.setAttribute("errorMsg", "Une promotion ne peut pas depasser 50% ");
               RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addPromotion.jsp");
               requestDispatcher.forward(req, resp);
           }

       }catch(Exception ex){
           ex.printStackTrace();
           resp.getWriter().println("error: "+ex.getMessage());
           resp.getWriter().println(center);
           resp.getWriter().println("----------------");
           resp.getWriter().println(category);
       }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
