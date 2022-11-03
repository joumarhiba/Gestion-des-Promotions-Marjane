package com.marjane.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( name = "LogoutServlet" ,value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); //Fetch session object
        try {
            if (session != null) //If session is not null
            {
                session.invalidate(); //removes all session attributes bound to the session
                req.setAttribute("errMessage", "You have logged out successfully");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(req, resp);
                System.out.println("Logged out");
            } else {
                resp.getWriter().println("logout no found");
            }
        }catch(Exception exception){
            resp.getWriter().println("the error is found in catch ..............;;;;;;");
    }

    }
}
