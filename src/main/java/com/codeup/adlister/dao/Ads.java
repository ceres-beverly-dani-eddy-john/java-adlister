package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;


import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    List<Ad> viewAllAdsFromUser(User user);
    List<Ad> viewAdsByCategory(long id);
    List<Ad> searchedAds(String string);
    Ad getAdId(long adId);



    List<Ad> deleteAd(long adId);
}
