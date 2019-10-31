package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    // get a list of all categories
    List<Category> all();
    Long insertIntoAdCategoryTable(long adId, String category);
    void deleteAdFromCategoryTable(long adId);
    List<Category> getCategoriesForAd(long adId);
}