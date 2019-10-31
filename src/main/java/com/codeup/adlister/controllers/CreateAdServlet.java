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

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get user object of logged in user to have access to userID for ad creation
        User user = (User) request.getSession().getAttribute("user");
        // Confirm neither title nor description are empty
        if (request.getParameter("title").equals("") || request.getParameter("description").equals("")) {
            // To-Do: Add error message to inform user why they could not create an ad
            response.sendRedirect("/ads/create?error=1");
        } else {
            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description")
            );
            String[] adCategories = request.getParameterValues("categories");
            // Insert ad into DB; save ID in order to insert data into ad_category table as well
            Long adID = DaoFactory.getAdsDao().insert(ad);
            // If at least one category was checked, insert entry into ad_category table
            if (adCategories != null) {
                for (String category : adCategories) {
                    DaoFactory.getCategoriesDao().insertIntoAdCategoryTable(adID, category);
                }

            }
            response.sendRedirect("/ads");
        }
    }
}
