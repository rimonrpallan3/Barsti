package com.voyager.barasti.activity.locationListPropety.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 04-Mar-19.
 */

public class LocDetails {


    /**
     * like_status : 15
     * properties_id : 15
     * property_name : 2000 Sq.Ft Room in  Sharjah
     * id : 15
     * property_id : 15
     * cleaning_fee : 2
     * guest_after : 1
     * guest_fee : 5
     * security_fee : 0
     * price : 35
     * weekend_price : 0
     * weekly_discount : 0
     * monthly_discount : 0
     * currency_code : INR
     * property_status : Listed
     * property_created_at : 2019-01-11 06:54:30
     * property_updated_at : 2019-01-22 10:39:00
     * name : Private room
     * url_name :
     * host_id : 1
     * bedrooms : 1
     * beds : 2
     * bed_type : 1
     * bathrooms : 2
     * amenities : 1,2,3,27,28
     * property_type : 1
     * space_type : 2
     * accommodates : 6
     * booking_type : request
     * cancellation : Flexible
     * status : Active
     * deleted_at :
     * created_at : 2019-01-11 06:54:30
     * updated_at : 2019-01-22 10:39:00
     * description : Private room
     * address_line_1 : 173 Sheikh Zayed St - Sharjah - United Arab Emirates
     * address_line_2 : Sharjah
     * latitude : 25.3462553
     * longitude : 55.42093169999998
     * city : Sharjah
     * state : Sharjah
     * country : AE
     * postal_code : 11111111
     * summary : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.
     * place_is_great_for :
     * about_place :
     * guest_can_access :
     * interaction_guests :
     * other :
     * about_neighborhood :
     * get_around :
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
     * property_address : {"id":15,"property_id":15,"address_line_1":"173 Sheikh Zayed St - Sharjah - United Arab Emirates","address_line_2":"Sharjah","latitude":"25.3462553","longitude":"55.42093169999998","city":"Sharjah","state":"Sharjah","country":"AE","postal_code":"11111111"}
     * property_description : {"id":15,"property_id":15,"summary":"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.","place_is_great_for":"","about_place":"","guest_can_access":"","interaction_guests":"","other":"","about_neighborhood":"","get_around":""}
     * property_price : {"id":15,"property_id":15,"cleaning_fee":2,"guest_after":1,"guest_fee":5,"security_fee":0,"price":35,"weekend_price":0,"weekly_discount":0,"monthly_discount":0,"currency_code":"INR","original_cleaning_fee":2,"original_guest_fee":5,"original_price":35,"original_weekend_price":0,"original_security_fee":0,"default_code":"INR","currency":{"id":13,"name":"India","code":"INR","symbol":"&#x20B9;","rate":"66.24","status":"Active","default":"0","org_symbol":"&#x20B9;"}}
     * users : {"id":1,"first_name":"User1","last_name":"Test","phone_num":"","email":"user@barastiapp.com","about_me":"","profile_image":"","balance":0,"status":"Active","fcm":"","api_token":"","created_at":"2018-12-20 10:22:47","updated_at":"2018-12-20 10:22:47","profile_src":"http://betaholder.com/barastiapp/public/images/user_pic-225x225.png"}
     */

    private int like_status;
    private int properties_id;
    private String property_name;
    private int id;
    private int property_id;
    private int cleaning_fee;
    private int guest_after;
    private int guest_fee;
    private int security_fee;
    private int price;
    private int weekend_price;
    private int weekly_discount;
    private int monthly_discount;
    private String currency_code;
    private String property_status;
    private String property_created_at;
    private String property_updated_at;
    private String name;
    private String url_name;
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
    private String deleted_at;
    private String created_at;
    private String updated_at;
    private String description;
    private String address_line_1;
    private String address_line_2;
    private String latitude;
    private String longitude;
    private String city;
    private String state;
    private String country;
    private String postal_code;
    private String summary;
    private String place_is_great_for;
    private String about_place;
    private String guest_can_access;
    private String interaction_guests;
    private String other;
    private String about_neighborhood;
    private String get_around;
    private int steps_completed;
    private String space_type_name;
    private String property_type_name;
    private String property_photo;
    private String host_name;
    private String host_email;
    private int reviews_count;
    private int overall_rating;
    private String cover_photo;
    private PropertyAddressBean property_address;
    private PropertyDescriptionBean property_description;
    private PropertyPriceBean property_price;
    private UsersBean users;
    private List<String> photos;

    public int getLike_status() {
        return like_status;
    }

    public void setLike_status(int like_status) {
        this.like_status = like_status;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public int getCleaning_fee() {
        return cleaning_fee;
    }

    public void setCleaning_fee(int cleaning_fee) {
        this.cleaning_fee = cleaning_fee;
    }

    public int getGuest_after() {
        return guest_after;
    }

    public void setGuest_after(int guest_after) {
        this.guest_after = guest_after;
    }

    public int getGuest_fee() {
        return guest_fee;
    }

    public void setGuest_fee(int guest_fee) {
        this.guest_fee = guest_fee;
    }

    public int getSecurity_fee() {
        return security_fee;
    }

    public void setSecurity_fee(int security_fee) {
        this.security_fee = security_fee;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeekend_price() {
        return weekend_price;
    }

    public void setWeekend_price(int weekend_price) {
        this.weekend_price = weekend_price;
    }

    public int getWeekly_discount() {
        return weekly_discount;
    }

    public void setWeekly_discount(int weekly_discount) {
        this.weekly_discount = weekly_discount;
    }

    public int getMonthly_discount() {
        return monthly_discount;
    }

    public void setMonthly_discount(int monthly_discount) {
        this.monthly_discount = monthly_discount;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_name() {
        return url_name;
    }

    public void setUrl_name(String url_name) {
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

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getPlace_is_great_for() {
        return place_is_great_for;
    }

    public void setPlace_is_great_for(String place_is_great_for) {
        this.place_is_great_for = place_is_great_for;
    }

    public String getAbout_place() {
        return about_place;
    }

    public void setAbout_place(String about_place) {
        this.about_place = about_place;
    }

    public String getGuest_can_access() {
        return guest_can_access;
    }

    public void setGuest_can_access(String guest_can_access) {
        this.guest_can_access = guest_can_access;
    }

    public String getInteraction_guests() {
        return interaction_guests;
    }

    public void setInteraction_guests(String interaction_guests) {
        this.interaction_guests = interaction_guests;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getAbout_neighborhood() {
        return about_neighborhood;
    }

    public void setAbout_neighborhood(String about_neighborhood) {
        this.about_neighborhood = about_neighborhood;
    }

    public String getGet_around() {
        return get_around;
    }

    public void setGet_around(String get_around) {
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

    public PropertyAddressBean getProperty_address() {
        return property_address;
    }

    public void setProperty_address(PropertyAddressBean property_address) {
        this.property_address = property_address;
    }

    public PropertyDescriptionBean getProperty_description() {
        return property_description;
    }

    public void setProperty_description(PropertyDescriptionBean property_description) {
        this.property_description = property_description;
    }

    public PropertyPriceBean getProperty_price() {
        return property_price;
    }

    public void setProperty_price(PropertyPriceBean property_price) {
        this.property_price = property_price;
    }

    public UsersBean getUsers() {
        return users;
    }

    public void setUsers(UsersBean users) {
        this.users = users;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }


}
