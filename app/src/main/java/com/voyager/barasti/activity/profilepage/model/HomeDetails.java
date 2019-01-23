package com.voyager.barasti.activity.profilepage.model;

import java.util.List;

/**
 * Created by User on 09-Jan-19.
 */

public class HomeDetails {


    /**
     * amenitis : Air Conditioning : Common Amenities,Kitchen : Common Amenities
     * properties_id : 2
     * property_name : Private room in Doha
     * property_status : Listed
     * property_created_at : 2018-12-27 04:51:45
     * property_updated_at : 2018-12-27 04:53:51
     * id : 2
     * name : Private room
     * url_name : null
     * host_id : 1
     * bedrooms : 4
     * beds : 3
     * bed_type : 3
     * bathrooms : 2
     * amenities : 4,6
     * property_type : 2
     * space_type : 2
     * accommodates : 1
     * booking_type : request
     * cancellation : Flexible
     * status : Active
     * deleted_at : null
     * created_at : 2018-12-20 10:22:47
     * updated_at : 2018-12-20 10:22:47
     * first_name : User1
     * last_name : Test
     * email : user@barastiapp.com
     * password : $2y$10$n.IkgtYJ7ORzeMDprxqO9uajhkYsDDfSVTHpghzJNenUrs5qHiTBu
     * profile_image : null
     * balance : 0
     * remember_token : ZljQcYRnQkdiw9z8xFZiXRgHkL3mCL4gDpcd1e1RWbwO4aiSfZvIgUssyYb2
     * api_token : null
     * description : Private room
     * bedtype : Double
     * property_id : 2
     * address_line_1 : Al Asmakh St, Doha, Qatar
     * address_line_2 : s
     * latitude : 25.2854473
     * longitude : 51.53103979999992
     * city : Doha
     * state : Doha
     * country : QA
     * postal_code : 111
     * summary : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
     * place_is_great_for : null
     * about_place : null
     * guest_can_access : null
     * interaction_guests : null
     * other : null
     * about_neighborhood : null
     * get_around : null
     * recommend : [{"id":5,"name":"Entire home/apt in","url_name":null,"host_id":1,"bedrooms":8,"beds":8,"bed_type":1,"bathrooms":8,"amenities":"1,2","property_type":2,"space_type":1,"accommodates":1,"booking_type":"request","cancellation":"Flexible","status":"Listed","deleted_at":null,"created_at":"2018-12-31 06:26:25","updated_at":"2018-12-31 06:27:37","steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546237639_Desert.jpg","host_name":"User1","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/5/1546237639_Desert.jpg"},{"id":8,"name":"Entire home/apt in","url_name":null,"host_id":1,"bedrooms":4,"beds":7,"bed_type":4,"bathrooms":4,"amenities":"1,2,4","property_type":2,"space_type":1,"accommodates":1,"booking_type":"request","cancellation":"Flexible","status":"Listed","deleted_at":null,"created_at":"2018-12-31 06:36:48","updated_at":"2018-12-31 06:37:52","steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546238254_Lighthouse.jpg","host_name":"User1","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/8/1546238254_Lighthouse.jpg"},{"id":11,"name":"Entire home/apt in","url_name":null,"host_id":1,"bedrooms":3,"beds":3,"bed_type":3,"bathrooms":3,"amenities":"1,2","property_type":2,"space_type":1,"accommodates":3,"booking_type":"request","cancellation":"Flexible","status":"Listed","deleted_at":null,"created_at":"2018-12-31 07:46:55","updated_at":"2018-12-31 09:33:21","steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546242463_Lighthouse.jpg","host_name":"User1","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/11/1546242463_Lighthouse.jpg"}]
     * steps_completed : 0
     * space_type_name : Private room
     * property_type_name : Villa
     * property_photo : 1545886382_Koala.jpg
     * host_name : User1
     * reviews_count : 0
     * overall_rating : 0
     * cover_photo : http://betaholder.com/barastiapp/public/images/property/2/1545886382_Koala.jpg
     */
    private int viewType;
    private String amenitis;
    private int properties_id;
    private String property_name;
    private String property_status;
    private String property_created_at;
    private String property_updated_at;
    private int id;
    private String name;
    private Object url_name;
    private int host_id;
    private int bedrooms;
    private int beds;
    private int bed_type;
    private int bathrooms;
    private String amenities;
    private int property_type;
    private int space_type;
    private int accommodates;
    private String booking_type;
    private String cancellation;
    private String status;
    private Object deleted_at;
    private String created_at;
    private String updated_at;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Object profile_image;
    private int balance;
    private String remember_token;
    private Object api_token;
    private String description;
    private String bedtype;
    private int property_id;
    private String address_line_1;
    private String address_line_2;
    private String latitude;
    private String longitude;
    private String city;
    private String state;
    private String country;
    private String postal_code;
    private String summary;
    private Object place_is_great_for;
    private Object about_place;
    private Object guest_can_access;
    private Object interaction_guests;
    private Object other;
    private Object about_neighborhood;
    private Object get_around;
    private int steps_completed;
    private String space_type_name;
    private String property_type_name;
    private String property_photo;
    private String host_name;
    private int reviews_count;
    private int overall_rating;
    private String cover_photo;
    private List<RecommendBean> recommend;
    private List<String> photos;

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getAmenitis() {
        return amenitis;
    }

    public void setAmenitis(String amenitis) {
        this.amenitis = amenitis;
    }

    public int getProperties_id() {
        return properties_id;
    }

    public void setProperties_id(int properties_id) {
        this.properties_id = properties_id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getProperty_status() {
        return property_status;
    }

    public void setProperty_status(String property_status) {
        this.property_status = property_status;
    }

    public String getProperty_created_at() {
        return property_created_at;
    }

    public void setProperty_created_at(String property_created_at) {
        this.property_created_at = property_created_at;
    }

    public String getProperty_updated_at() {
        return property_updated_at;
    }

    public void setProperty_updated_at(String property_updated_at) {
        this.property_updated_at = property_updated_at;
    }

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

    public Object getUrl_name() {
        return url_name;
    }

    public void setUrl_name(Object url_name) {
        this.url_name = url_name;
    }

    public int getHost_id() {
        return host_id;
    }

    public void setHost_id(int host_id) {
        this.host_id = host_id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBed_type() {
        return bed_type;
    }

    public void setBed_type(int bed_type) {
        this.bed_type = bed_type;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public int getProperty_type() {
        return property_type;
    }

    public void setProperty_type(int property_type) {
        this.property_type = property_type;
    }

    public int getSpace_type() {
        return space_type;
    }

    public void setSpace_type(int space_type) {
        this.space_type = space_type;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }

    public String getBooking_type() {
        return booking_type;
    }

    public void setBooking_type(String booking_type) {
        this.booking_type = booking_type;
    }

    public String getCancellation() {
        return cancellation;
    }

    public void setCancellation(String cancellation) {
        this.cancellation = cancellation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Object deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Object profile_image) {
        this.profile_image = profile_image;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public Object getApi_token() {
        return api_token;
    }

    public void setApi_token(Object api_token) {
        this.api_token = api_token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Object getPlace_is_great_for() {
        return place_is_great_for;
    }

    public void setPlace_is_great_for(Object place_is_great_for) {
        this.place_is_great_for = place_is_great_for;
    }

    public Object getAbout_place() {
        return about_place;
    }

    public void setAbout_place(Object about_place) {
        this.about_place = about_place;
    }

    public Object getGuest_can_access() {
        return guest_can_access;
    }

    public void setGuest_can_access(Object guest_can_access) {
        this.guest_can_access = guest_can_access;
    }

    public Object getInteraction_guests() {
        return interaction_guests;
    }

    public void setInteraction_guests(Object interaction_guests) {
        this.interaction_guests = interaction_guests;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    public Object getAbout_neighborhood() {
        return about_neighborhood;
    }

    public void setAbout_neighborhood(Object about_neighborhood) {
        this.about_neighborhood = about_neighborhood;
    }

    public Object getGet_around() {
        return get_around;
    }

    public void setGet_around(Object get_around) {
        this.get_around = get_around;
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

    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }

}
