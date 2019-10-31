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

@WebServlet(name = "ViewAdByCategoryServlet", urlPatterns = "/category")
public class ViewAdByCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        long id = Long.parseLong(request.getParameter("id"));
//        Ad ad = DaoFactory.getAdsDao().viewAdsByCategory();
//
//        System.out.println("do get in view ad by category");
//        User user = DaoFactory.getUsersDao().findUserId(ad.getUserId());
//        request.setAttribute("ad", ad);
//        request.setAttribute("user", user);

        String cat = request.getParameter("category");

        Long catLong = Long.parseLong(String.valueOf(cat));


        System.out.println("cat = " + cat);

        request.setAttribute("ads", DaoFactory.getAdsDao().viewAdsByCategory(catLong));
        System.out.println("where the error might be happening");
        System.out.println(DaoFactory.getAdsDao().viewAdsByCategory(catLong).toString());
        request.getRequestDispatcher("/WEB-INF/ads/category.jsp").forward(request, response);


    }
}
