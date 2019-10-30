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

@WebServlet(name = "SearchAdsServlet", urlPatterns = "/search")
public class SearchAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String search = request.getQueryString().toLowerCase();
//        request.setAttribute("searchTerm", search);
//        response.sendRedirect("/ads/search");

        String searchTerm = request.getParameter("searchTerm");
        request.setAttribute("ads", DaoFactory.getAdsDao().searchedAds(searchTerm));
        System.out.println("searchTerm = " + searchTerm);
        System.out.println("Ads servlet doGet has been ran");

        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request,response);
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String searchTerm = request.getParameter("searchTerm");
//        request.setAttribute("ads", DaoFactory.getAdsDao().searchedAds(searchTerm));
//        System.out.println("searchTerm = " + searchTerm);
//        System.out.println("Ads servlet doGet has been ran");
//
//        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request,response);
//    }
}
