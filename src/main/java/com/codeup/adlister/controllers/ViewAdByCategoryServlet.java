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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cat = request.getParameter("category");
        Long catLong = Long.parseLong(String.valueOf(cat));
        System.out.println("cat = " + cat);
        request.setAttribute("adscat", DaoFactory.getAdsDao().viewAdsByCategory(catLong));
        System.out.println("where the error might be happening");
        System.out.println(DaoFactory.getAdsDao().viewAdsByCategory(catLong).toString());
        request.getRequestDispatcher("/WEB-INF/ads/category.jsp").forward(request, response);
    }
}
