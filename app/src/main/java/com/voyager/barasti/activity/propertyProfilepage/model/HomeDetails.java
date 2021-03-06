package com.voyager.barasti.activity.propertyProfilepage.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 09-Jan-19.
 */

public class HomeDetails implements Parcelable {


    /**
     * properties_id : 7
     * property_name : 1270 Sq.Ft Apartment in Ajman
     * id : 7
     * property_id : 7
     * cleaning_fee : 0
     * guest_after : 1
     * guest_fee : 0
     * security_fee : 0
     * price : 8
     * weekend_price : 0
     * weekly_discount : 0
     * monthly_discount : 0
     * currency_code : INR
     * property_status : Listed
     * property_created_at : 2018-12-31 06:33:09
     * property_updated_at : 2019-01-22 10:40:46
     * name : Entire home/apt
     * url_name : null
     * host_id : 1
     * bedrooms : 1
     * beds : 1
     * bed_type : 1
     * bathrooms : 1
     * amenities : [{"title":"Internet","id":7,"symbol":"internet","status":7},{"title":"Gym","id":8,"symbol":"gym","status":7}]
     * property_type : 1
     * space_type : 1
     * accommodates : 1
     * booking_type : request
     * cancellation : Flexible
     * status : Active
     * deleted_at : null
     * created_at : 2018-12-31 06:33:09
     * updated_at : 2019-01-22 10:40:46
     * userid : 1
     * first_name : User1
     * last_name : Test
     * email : user@barastiapp.com
     * description : Entire home/apt
     * bedtype : king
     * address_line_1 : 18 شارع حاتم الطائي - Ajman - United Arab Emirates
     * address_line_2 : asa
     * latitude : 25.403747507528625
     * longitude : 55.513679563614915
     * city : Ajman
     * state : Ajman
     * country : AE
     * postal_code : 1213
     * summary : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.
     * place_is_great_for : null
     * about_place : null
     * guest_can_access : null
     * interaction_guests : null
     * other : null
     * about_neighborhood : null
     * get_around : null
     * safety_amenities : []
     * recommend : [{"id":15,"name":"2000 Sq.Ft Room in Sharjah","space_type":2,"property_type":1,"host_id":1,"property_id":15,"cleaning_fee":2,"guest_after":1,"guest_fee":0,"security_fee":0,"price":35,"weekend_price":0,"weekly_discount":0,"monthly_discount":0,"currency_code":"INR","steps_completed":0,"space_type_name":"Private room","property_type_name":"Apartment","property_photo":"1547190326_Hydrangeas.jpg","host_name":"User1","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/15/1547190326_Jellyfish.jpg","photos":["http://betaholder.com/barastiapp/public/images/property/15/1547190326_Hydrangeas.jpg","http://betaholder.com/barastiapp/public/images/property/15/1547190326_Koala.jpg","http://betaholder.com/barastiapp/public/images/property/15/1548238574_1523431461_p19140h20i1mj91uid1djij2s1r8r41.jpg","http://betaholder.com/barastiapp/public/images/property/15/1548240648_1523431431_cambria-dbl.jpg"]},{"id":10,"name":"1000 Sq Ft Apartment in Doha","space_type":1,"property_type":1,"host_id":1,"property_id":10,"cleaning_fee":0,"guest_after":1,"guest_fee":0,"security_fee":0,"price":18,"weekend_price":0,"weekly_discount":0,"monthly_discount":0,"currency_code":"INR","steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Apartment","property_photo":"1546238856_Chrysanthemum.jpg","host_name":"User1","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/10/1546238856_Chrysanthemum.jpg","photos":[]},{"id":4,"name":"3 Bed Private room in Abu Dhabi","space_type":2,"property_type":1,"host_id":1,"property_id":4,"cleaning_fee":0,"guest_after":1,"guest_fee":0,"security_fee":0,"price":15,"weekend_price":0,"weekly_discount":0,"monthly_discount":0,"currency_code":"USD","steps_completed":0,"space_type_name":"Private room","property_type_name":"Apartment","property_photo":"1545990356_Hydrangeas.jpg","host_name":"User1","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/4/1545990356_Hydrangeas.jpg","photos":[]},{"id":1,"name":"5 Bed Apartment","space_type":1,"property_type":1,"host_id":1,"property_id":1,"cleaning_fee":2000,"guest_after":1,"guest_fee":0,"security_fee":0,"price":9999,"weekend_price":0,"weekly_discount":0,"monthly_discount":0,"currency_code":"INR","steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Apartment","property_photo":"1545307614_Jellyfish.jpg","host_name":"User1","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/1/1545307614_Jellyfish.jpg","photos":[]}]
     * steps_completed : 0
     * space_type_name : Entire home/apt
     * property_type_name : Apartment
     * property_photo : 1546238057_Jellyfish.jpg
     * host_name : User1
     * reviews_count : 0
     * overall_rating : 0
     * cover_photo : http://betaholder.com/barastiapp/public/images/property/7/1546238057_Jellyfish.jpg
     * photos : []
     */



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
    private int property_type;
    private int space_type;
    private int accommodates;
    private String booking_type;
    private String cancellation;
    private String status;
    private String  deleted_at;
    private String created_at;
    private String updated_at;
    private int userid;
    private String first_name;
    private String last_name;
    private String email;
    private String description;
    private String bedtype;
    private String address_line_1;
    private String address_line_2;
    private String latitude;
    private String longitude;
    private String city;
    private String state;
    private String country;
    private String postal_code;
    private String summary;
    private String  place_is_great_for;
    private String  about_place;
    private String  guest_can_access;
    private String interaction_guests;
    private String other;
    private String about_neighborhood;
    private String get_around;
    private int steps_completed;
    private String space_type_name;
    private String property_type_name;
    private String property_photo;
    private String host_name;
    private int reviews_count;
    private int overall_rating;
    private String cover_photo;
    private List<Amenities> amenities;
    private List<?> safety_amenities;
    private List<RecommendBean> recommend;
    private List<String> photos;

    public String getUrl_name() {
        return url_name;
    }

    public void setUrl_name(String url_name) {
        this.url_name = url_name;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
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

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public List<Amenities> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenities> amenities) {
        this.amenities = amenities;
    }

    public List<?> getSafety_amenities() {
        return safety_amenities;
    }

    public void setSafety_amenities(List<?> safety_amenities) {
        this.safety_amenities = safety_amenities;
    }



    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }


    public HomeDetails() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.properties_id);
        dest.writeString(this.property_name);
        dest.writeInt(this.id);
        dest.writeInt(this.property_id);
        dest.writeInt(this.cleaning_fee);
        dest.writeInt(this.guest_after);
        dest.writeInt(this.guest_fee);
        dest.writeInt(this.security_fee);
        dest.writeInt(this.price);
        dest.writeInt(this.weekend_price);
        dest.writeInt(this.weekly_discount);
        dest.writeInt(this.monthly_discount);
        dest.writeString(this.currency_code);
        dest.writeString(this.property_status);
        dest.writeString(this.property_created_at);
        dest.writeString(this.property_updated_at);
        dest.writeString(this.name);
        dest.writeString(this.url_name);
        dest.writeInt(this.host_id);
        dest.writeInt(this.bedrooms);
        dest.writeInt(this.beds);
        dest.writeInt(this.bed_type);
        dest.writeInt(this.bathrooms);
        dest.writeInt(this.property_type);
        dest.writeInt(this.space_type);
        dest.writeInt(this.accommodates);
        dest.writeString(this.booking_type);
        dest.writeString(this.cancellation);
        dest.writeString(this.status);
        dest.writeString(this.deleted_at);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);
        dest.writeInt(this.userid);
        dest.writeString(this.first_name);
        dest.writeString(this.last_name);
        dest.writeString(this.email);
        dest.writeString(this.description);
        dest.writeString(this.bedtype);
        dest.writeString(this.address_line_1);
        dest.writeString(this.address_line_2);
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
        dest.writeString(this.city);
        dest.writeString(this.state);
        dest.writeString(this.country);
        dest.writeString(this.postal_code);
        dest.writeString(this.summary);
        dest.writeString(this.place_is_great_for);
        dest.writeString(this.about_place);
        dest.writeString(this.guest_can_access);
        dest.writeString(this.interaction_guests);
        dest.writeString(this.other);
        dest.writeString(this.about_neighborhood);
        dest.writeString(this.get_around);
        dest.writeInt(this.steps_completed);
        dest.writeString(this.space_type_name);
        dest.writeString(this.property_type_name);
        dest.writeString(this.property_photo);
        dest.writeString(this.host_name);
        dest.writeInt(this.reviews_count);
        dest.writeInt(this.overall_rating);
        dest.writeString(this.cover_photo);
        dest.writeStringList(this.photos);
    }

    protected HomeDetails(Parcel in) {
        this.properties_id = in.readInt();
        this.property_name = in.readString();
        this.id = in.readInt();
        this.property_id = in.readInt();
        this.cleaning_fee = in.readInt();
        this.guest_after = in.readInt();
        this.guest_fee = in.readInt();
        this.security_fee = in.readInt();
        this.price = in.readInt();
        this.weekend_price = in.readInt();
        this.weekly_discount = in.readInt();
        this.monthly_discount = in.readInt();
        this.currency_code = in.readString();
        this.property_status = in.readString();
        this.property_created_at = in.readString();
        this.property_updated_at = in.readString();
        this.name = in.readString();
        this.url_name = in.readString();
        this.host_id = in.readInt();
        this.bedrooms = in.readInt();
        this.beds = in.readInt();
        this.bed_type = in.readInt();
        this.bathrooms = in.readInt();
        this.property_type = in.readInt();
        this.space_type = in.readInt();
        this.accommodates = in.readInt();
        this.booking_type = in.readString();
        this.cancellation = in.readString();
        this.status = in.readString();
        this.deleted_at = in.readString();
        this.created_at = in.readString();
        this.updated_at = in.readString();
        this.userid = in.readInt();
        this.first_name = in.readString();
        this.last_name = in.readString();
        this.email = in.readString();
        this.description = in.readString();
        this.bedtype = in.readString();
        this.address_line_1 = in.readString();
        this.address_line_2 = in.readString();
        this.latitude = in.readString();
        this.longitude = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.country = in.readString();
        this.postal_code = in.readString();
        this.summary = in.readString();
        this.place_is_great_for = in.readString();
        this.about_place = in.readString();
        this.guest_can_access = in.readString();
        this.interaction_guests = in.readString();
        this.other = in.readString();
        this.about_neighborhood = in.readString();
        this.get_around = in.readString();
        this.steps_completed = in.readInt();
        this.space_type_name = in.readString();
        this.property_type_name = in.readString();
        this.property_photo = in.readString();
        this.host_name = in.readString();
        this.reviews_count = in.readInt();
        this.overall_rating = in.readInt();
        this.cover_photo = in.readString();
        this.photos = in.createStringArrayList();
    }

    public static final Creator<HomeDetails> CREATOR = new Creator<HomeDetails>() {
        @Override
        public HomeDetails createFromParcel(Parcel source) {
            return new HomeDetails(source);
        }

        @Override
        public HomeDetails[] newArray(int size) {
            return new HomeDetails[size];
        }
    };
}
