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
        String category_name = request.getParameter("catname");
        System.out.println("category_name = " + category_name);
        Long catLong = Long.parseLong(String.valueOf(cat));
        request.setAttribute("adscat", DaoFactory.getAdsDao().viewAdsByCategory(catLong));
        request.setAttribute("category_name", category_name);
        request.getRequestDispatcher("/WEB-INF/ads/category.jsp").forward(request, response);
    }
}
