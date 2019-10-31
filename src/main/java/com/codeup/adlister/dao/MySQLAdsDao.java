package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
//This method allows us to view user specific ads
    @Override
    public List<Ad> viewAllAdsFromUser(User user) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ? ");

            stmt.setLong(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }

    }

    public Ad getAdId(long id) {
        try {
            // New statement to find an ad with a specific id
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            // Insert ad id into statement
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads by id.", e);
        }
    }

    @Override
    public List<Ad> searchedAds(String searchTerm) {
        try {
            String sql = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
            String searchTermWithWildcards = "%" + searchTerm + "%";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchTermWithWildcards);
            stmt.setString(2, searchTermWithWildcards);

            List<Ad> ads = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")));
            }
            return ads;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public List<Ad> deleteAd(long adId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE FROM ads WHERE id = ?");
            stmt.setLong(1, adId);
            stmt.executeUpdate();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }

    }
}
