package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;


import java.sql.ResultSet;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    List<Ad> viewAllAdsFromUser(User user);
    List<Ad> searchedAds(String string);


    List<Ad> deleteAd(long adId);
    void editAd(long adId, String title, String description);
    Ad getAdId(long adId);

}
