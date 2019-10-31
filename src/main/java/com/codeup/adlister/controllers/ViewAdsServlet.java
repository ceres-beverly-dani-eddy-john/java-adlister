package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewAdsServlet" , urlPatterns = "/info")
public class ViewAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //parses the charsequence argument of the id number
        long id = Long.parseLong(request.getParameter("id"));
        //gets a ad object ,uses the get ads dao and then uses the get adbyid method.
        Ad ad = DaoFactory.getAdsDao().getAdId(id);
        //gets a user object with the id
         User user = DaoFactory.getUsersDao().findUserId(ad.getUserId());
        request.setAttribute("ad", ad);
        request.setAttribute("user", user);



        // Send to jsp
        request.getRequestDispatcher("/WEB-INF/ads/info.jsp").forward(request, response);
    }
}
