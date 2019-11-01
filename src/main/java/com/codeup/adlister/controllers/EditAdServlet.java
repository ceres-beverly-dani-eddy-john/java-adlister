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

        String newAdTitle = request.getParameter("title");

     Long id = Long.parseLong(request.getParameter("id"));

        String newAdDescription =request.getParameter("description");
       DaoFactory.getAdsDao().editAd(id,newAdTitle,newAdDescription);


        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idToEdit = Long.parseLong(request.getParameter("adId"));

     Ad adToEdit = DaoFactory.getAdsDao().getAdId(idToEdit);
     request.setAttribute("title", adToEdit.getTitle());
        request.setAttribute("description", adToEdit.getDescription());
        request.setAttribute("id",idToEdit);


        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);



    }
}
