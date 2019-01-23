package com.voyager.barasti.fragment.explore.model.exploreList;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by User on 27-Dec-18.
 */

public class HouseList implements Parcelable {


    /**
     * id : 15
     * name : 2000 Sq.Ft Room in Sharjah
     * space_type : 2
     * property_type : 1
     * host_id : 1
     * property_id : 15
     * cleaning_fee : 2
     * guest_after : 1
     * guest_fee : 0
     * security_fee : 0
     * price : 35
     * weekend_price : 0
     * weekly_discount : 0
     * monthly_discount : 0
     * currency_code : INR
     * steps_completed : 0
     * space_type_name : Private room
     * property_type_name : Apartment
     * property_photo : 1547190326_Hydrangeas.jpg
     * host_name : User1
     * reviews_count : 0
     * overall_rating : 0
     * cover_photo : http://betaholder.com/barastiapp/public/images/property/15/1547190326_Jellyfish.jpg
     * photos : ["http://betaholder.com/barastiapp/public/images/property/15/1547190326_Hydrangeas.jpg","http://betaholder.com/barastiapp/public/images/property/15/1547190326_Koala.jpg"]
     */

    private int id;
    private String name;
    private int space_type;
    private int property_type;
    private int host_id;
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
    private int steps_completed;
    private String space_type_name;
    private String property_type_name;
    private String property_photo;
    private String host_name;
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

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.space_type);
        dest.writeInt(this.property_type);
        dest.writeInt(this.host_id);
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

    public HouseList() {
    }

    protected HouseList(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.space_type = in.readInt();
        this.property_type = in.readInt();
        this.host_id = in.readInt();
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

    public static final Creator<HouseList> CREATOR = new Creator<HouseList>() {
        @Override
        public HouseList createFromParcel(Parcel source) {
            return new HouseList(source);
        }

        @Override
        public HouseList[] newArray(int size) {
            return new HouseList[size];
        }
    };
}
