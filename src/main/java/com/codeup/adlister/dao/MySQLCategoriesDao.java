package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database.");
        }
    }

    @Override
    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("name")
        );
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }


    public Long insertIntoAdCategoryTable(long adId, String category) {
        try {
            // Find the category_id in the database that matches with the category String
            String selectQuery = "SELECT id FROM categories WHERE name = ?";
            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
            selectStmt.setString(1, category);
            ResultSet selectRS = selectStmt.executeQuery();
            // Initialize categoryId to 0 as an emergency backup
            long categoryId = 0;
            while (selectRS.next()) {
                categoryId = selectRS.getLong("id");
            }
            // Insert a new entry into the ad_category table
            String insertQuery = "INSERT INTO ad_category(ad_id, category_id) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setLong(1, adId);
            insertStmt.setLong(2, categoryId);
            insertStmt.executeUpdate();
            ResultSet rs = insertStmt.getGeneratedKeys();
            if(rs.next()) {
                return rs.getLong(1);
            } else {
                return 0L;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error storing category information in database.", e);
        }
//        return 0L;
    }
}