package com.voyager.barasti.fragment.fav.model;

import java.util.List;

/**
 * Created by User on 11-Jan-19.
 */

public class FavDetail {


    /**
     * id : 15
     * name : 2000 Sq.Ft Room in  Sharjah
     * space_type : 2
     * property_type : 1
     * host_id : 1
     * price : 35
     * steps_completed : 0
     * space_type_name : Private room
     * property_type_name : Apartment
     * property_photo : 1547190326_Hydrangeas.jpg
     * host_name : User1
     * host_email : user@barastiapp.com
     * reviews_count : 0
     * overall_rating : 0
     * cover_photo : http://betaholder.com/barastiapp/public/images/property/15/1547190326_Jellyfish.jpg
     * photos : ["http://betaholder.com/barastiapp/public/images/property/15/1547190326_Hydrangeas.jpg","http://betaholder.com/barastiapp/public/images/property/15/1547190326_Koala.jpg","http://betaholder.com/barastiapp/public/images/property/15/1548238574_1523431461_p19140h20i1mj91uid1djij2s1r8r41.jpg","http://betaholder.com/barastiapp/public/images/property/15/1548240648_1523431431_cambria-dbl.jpg"]
     */

    private int id;
    private String name;
    private int space_type;
    private int property_type;
    private int host_id;
    private int price;
    private int steps_completed;
    private String space_type_name;
    private String property_type_name;
    private String property_photo;
    private String host_name;
    private String host_email;
    private int reviews_count;
    private int overall_rating;
    private String cover_photo;
    private List<String> photos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpace_type() {
        return space_type;
    }

    public void setSpace_type(int space_type) {
        this.space_type = space_type;
    }

    public int getProperty_type() {
        return property_type;
    }

    public void setProperty_type(int property_type) {
        this.property_type = property_type;
    }

    public int getHost_id() {
        return host_id;
    }

    public void setHost_id(int host_id) {
        this.host_id = host_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSteps_completed() {
        return steps_completed;
    }

    public void setSteps_completed(int steps_completed) {
        this.steps_completed = steps_completed;
    }

    public String getSpace_type_name() {
        return space_type_name;
    }

    public void setSpace_type_name(String space_type_name) {
        this.space_type_name = space_type_name;
    }

    public String getProperty_type_name() {
        return property_type_name;
    }

    public void setProperty_type_name(String property_type_name) {
        this.property_type_name = property_type_name;
    }

    public String getProperty_photo() {
        return property_photo;
    }

    public void setProperty_photo(String property_photo) {
        this.property_photo = property_photo;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getHost_email() {
        return host_email;
    }

    public void setHost_email(String host_email) {
        this.host_email = host_email;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getOverall_rating() {
        return overall_rating;
    }

    public void setOverall_rating(int overall_rating) {
        this.overall_rating = overall_rating;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
