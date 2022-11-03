package com.marjane.servlets;

import com.marjane.CryptPwd;
import com.marjane.dao.AdminDao;
import com.marjane.dao.CenterDao;
import com.marjane.entities.Admin;
import com.marjane.entities.AdminGen;
import com.marjane.entities.Center;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "CenterAdminServlet" ,urlPatterns = {"/CenterAdminServlet"})
public class CenterAdmin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCenterAdmin(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    public void addCenterAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            AdminGen aGen = new AdminGen();
            aGen.setAdminId(1);
            aGen.setEmail("supAdmin@gmail.com");
            aGen.setRole(0);

            Admin admin = new Admin();
            Center center = new Center();
            String email = req.getParameter("email");
            String ville = req.getParameter("ville");

            String p = "123456";
            admin.setPassword(p);
            CryptPwd cp = new CryptPwd();
            String hashedP = cp.cryptage(p);
            admin.setPassword(hashedP);
            admin.setAdminGen(aGen);
            admin.setRole(1);
            admin.setEmail(email);
            center.setAdmin(admin);
            center.setVille(ville);

            AdminDao adminDao = new AdminDao();
            adminDao.addAdmin(admin);
            CenterDao centerDao = new CenterDao();
            centerDao.addCenter(center);
            resp.getWriter().println("L admin est ajouté avec center....");


        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("error: "+e.getMessage());
        }

    }
}
