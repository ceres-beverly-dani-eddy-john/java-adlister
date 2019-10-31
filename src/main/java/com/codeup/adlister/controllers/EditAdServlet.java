package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

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

        response.sendRedirect("/edit");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idToEdit = Long.parseLong(request.getParameter("adId"));
        String titleToEdit = request.getParameter("title");
        String descriptionToEdit = request.getParameter("description");

        System.out.println("descriptionToEdit = " + descriptionToEdit);
        System.out.println("titleToEdit = " + titleToEdit);
        System.out.println("idToEdit = " + idToEdit);

        //get ad by id
        //22-23 dont need
        //add title and descritipn to request so that edit.jsp can prefill request

//
//
//     getQueryString());
//

        request.setAttribute("populated",DaoFactory.getAdsDao().editAd(idToEdit, titleToEdit, descriptionToEdit));



        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);



    }
}
