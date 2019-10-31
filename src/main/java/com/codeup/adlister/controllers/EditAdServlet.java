package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/edit")
public class EditAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//edit goes here
        String newAdTitle = request.getParameter("title");

        System.out.println(request.getParameter("adId"));

//        long idToEdit = Long.parseLong(request.getAttribute("adId"));

        String newAdDescription =request.getParameter("description");
       DaoFactory.getAdsDao().editAd(4,newAdTitle,newAdDescription);


        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idToEdit = Long.parseLong(request.getParameter("adId"));
//
//        request.setAttribute("adId", idToEdit);


     Ad adToEdit = DaoFactory.getAdsDao().getAdId(idToEdit);
     request.setAttribute("title", adToEdit.getTitle());
        request.setAttribute("description", adToEdit.getDescription());
        System.out.println(adToEdit.getId());
        // we can see adToEdit.getId here, but we are not setting it correctly for post
//        request.setAttribute("adId", adToEdit.getId());
        request.setAttribute("adId",idToEdit);


        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);



    }
}
