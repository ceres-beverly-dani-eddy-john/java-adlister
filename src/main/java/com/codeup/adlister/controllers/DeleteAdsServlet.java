package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "controllers.DeleteAdsServlet", urlPatterns = "/delete")
public class DeleteAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//this takes the ad id that is stored in the query when we click delete ad and stores it in a variable
        Long idToDelete = Long.parseLong(request.getParameter("adId"));
//this accesses our deletead method and puts in our stored variable
        DaoFactory.getAdsDao().deleteAd(idToDelete);
        //then redirects to profile once successfully deleted
        response.sendRedirect("/profile");



    }
}
