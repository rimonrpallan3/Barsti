package com.voyager.barasti.activity.UserPropertyList.model;

import java.util.List;

/**
 * Created by User on 06-Mar-19.
 */

public class UserPropertyDetails {


    /**
     * user : {"id":1,"first_name":"User1","last_name":"Test","phone_num":"","email":"user@barastiapp.com","about_me":"","profile_image":"","balance":0,"status":"Active","fcm":"","api_token":"","created_at":"2018-12-20 10:22:47","updated_at":"2018-12-20 10:22:47","profile_src":"http://betaholder.com/barastiapp/public/images/user_pic-225x225.png"}
     * listings : [{"id":15,"name":"2000 Sq.Ft Room in  Sharjah","space_type":2,"property_type":1,"host_id":1,"price":35,"steps_completed":0,"space_type_name":"Private room","property_type_name":"Apartment","property_photo":"1547190326_Hydrangeas.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/15/1547190326_Jellyfish.jpg","photos":["http://betaholder.com/barastiapp/public/images/property/15/1547190326_Hydrangeas.jpg","http://betaholder.com/barastiapp/public/images/property/15/1547190326_Koala.jpg","http://betaholder.com/barastiapp/public/images/property/15/1548238574_1523431461_p19140h20i1mj91uid1djij2s1r8r41.jpg","http://betaholder.com/barastiapp/public/images/property/15/1548240648_1523431431_cambria-dbl.jpg"]},{"id":11,"name":"Contemporary Villa","space_type":1,"property_type":2,"host_id":1,"price":30,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546242463_Lighthouse.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/11/1546242463_Lighthouse.jpg","photos":[]},{"id":10,"name":"1000 Sq  Ft Apartment in Doha","space_type":1,"property_type":1,"host_id":1,"price":18,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Apartment","property_photo":"1546238856_Chrysanthemum.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/10/1546238856_Chrysanthemum.jpg","photos":[]},{"id":9,"name":"800 Sq  Ft Pent House in Dubai","space_type":1,"property_type":3,"host_id":1,"price":5,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Penthouse","property_photo":"1546238777_Koala.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/9/1546238777_Koala.jpg","photos":[]},{"id":8,"name":"2750 Sq.Ft Villa In Arabian Peninsula","space_type":1,"property_type":2,"host_id":1,"price":23,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546238254_Lighthouse.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/8/1546238254_Lighthouse.jpg","photos":[]},{"id":7,"name":"1270 Sq.Ft Apartment in Ajman","space_type":1,"property_type":1,"host_id":1,"price":8,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Apartment","property_photo":"1546238057_Jellyfish.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/7/1546238057_Jellyfish.jpg","photos":[]},{"id":6,"name":"8 Bed Pent House","space_type":1,"property_type":3,"host_id":1,"price":25,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Penthouse","property_photo":"1546237787_Chrysanthemum.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/6/1546237787_Chrysanthemum.jpg","photos":[]},{"id":5,"name":"8 Bed 2000 Sq.Ft Villa","space_type":1,"property_type":2,"host_id":1,"price":20,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546237639_Desert.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/5/1546237639_Desert.jpg","photos":[]},{"id":4,"name":"3 Bed Private room in Abu Dhabi","space_type":2,"property_type":1,"host_id":1,"price":15,"steps_completed":0,"space_type_name":"Private room","property_type_name":"Apartment","property_photo":"1545990356_Hydrangeas.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/4/1545990356_Hydrangeas.jpg","photos":[]},{"id":3,"name":"2 Bed Shared room in Sharjah","space_type":3,"property_type":3,"host_id":1,"price":10,"steps_completed":0,"space_type_name":"Shared room","property_type_name":"Penthouse","property_photo":"1545990109_Tulips.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/3/1545990109_Tulips.jpg","photos":[]},{"id":2,"name":"1500 Sq.Ft 3 Bed Villa","space_type":2,"property_type":2,"host_id":1,"price":10000,"steps_completed":0,"space_type_name":"Private room","property_type_name":"Villa","property_photo":"1545886382_Koala.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/2/1545886382_Koala.jpg","photos":[]},{"id":1,"name":"5 Bed Apartment","space_type":1,"property_type":1,"host_id":1,"price":9999,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Apartment","property_photo":"1545307614_Jellyfish.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/1/1545307614_Jellyfish.jpg","photos":[]}]
     */

    private UserBean user;
    private List<ListingsBean> listings;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<ListingsBean> getListings() {
        return listings;
    }

    public void setListings(List<ListingsBean> listings) {
        this.listings = listings;
    }

}
