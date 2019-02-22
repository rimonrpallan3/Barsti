package com.voyager.barasti.fragment.explore.model.exploreList;

import android.os.Parcel;
import android.os.Parcelable;

import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.Banner;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04-Jan-19.
 */

public class MainList implements Parcelable {
    /**
     * types : [{"name":"Apartment","id":1},{"name":"Villa","id":2},{"name":"Penthouse","id":3}]
     * properties : [{"like_status":4,"id":4,"name":"3 Bed Private room in Abu Dhabi","space_type":2,"property_type":1,"host_id":1,"price":15,"steps_completed":0,"space_type_name":"Private room","property_type_name":"Apartment","property_photo":"1545990356_Hydrangeas.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/4/1545990356_Hydrangeas.jpg","photos":[]},{"like_status":5,"id":5,"name":"8 Bed 2000 Sq.Ft Villa","space_type":1,"property_type":2,"host_id":1,"price":20,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546237639_Desert.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/5/1546237639_Desert.jpg","photos":[]},{"like_status":3,"id":3,"name":"2 Bed Shared room in Sharjah","space_type":3,"property_type":3,"host_id":1,"price":10,"steps_completed":0,"space_type_name":"Shared room","property_type_name":"Penthouse","property_photo":"1545990109_Tulips.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/3/1545990109_Tulips.jpg","photos":[]},{"like_status":2,"id":2,"name":"1500 Sq.Ft 3 Bed Villa","space_type":2,"property_type":2,"host_id":1,"price":10000,"steps_completed":0,"space_type_name":"Private room","property_type_name":"Villa","property_photo":"1545886382_Koala.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/2/1545886382_Koala.jpg","photos":[]},{"like_status":1,"id":1,"name":"5 Bed Apartment","space_type":1,"property_type":1,"host_id":1,"price":9999,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Apartment","property_photo":"1545307614_Jellyfish.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/1/1545307614_Jellyfish.jpg","photos":[]},{"like_status":6,"id":6,"name":"8 Bed Pent House","space_type":1,"property_type":3,"host_id":1,"price":25,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Penthouse","property_photo":"1546237787_Chrysanthemum.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/6/1546237787_Chrysanthemum.jpg","photos":[]},{"like_status":7,"id":7,"name":"1270 Sq.Ft Apartment in Ajman","space_type":1,"property_type":1,"host_id":1,"price":8,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Apartment","property_photo":"1546238057_Jellyfish.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/7/1546238057_Jellyfish.jpg","photos":[]},{"like_status":11,"id":11,"name":"Contemporary Villa","space_type":1,"property_type":2,"host_id":1,"price":30,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546242463_Lighthouse.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/11/1546242463_Lighthouse.jpg","photos":[]},{"like_status":0,"id":10,"name":"1000 Sq  Ft Apartment in Doha","space_type":1,"property_type":1,"host_id":1,"price":18,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Apartment","property_photo":"1546238856_Chrysanthemum.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/10/1546238856_Chrysanthemum.jpg","photos":[]},{"like_status":9,"id":9,"name":"800 Sq  Ft Pent House in Dubai","space_type":1,"property_type":3,"host_id":1,"price":5,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Penthouse","property_photo":"1546238777_Koala.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/9/1546238777_Koala.jpg","photos":[]},{"like_status":0,"id":8,"name":"2750 Sq.Ft Villa In Arabian Peninsula","space_type":1,"property_type":2,"host_id":1,"price":23,"steps_completed":0,"space_type_name":"Entire home/apt","property_type_name":"Villa","property_photo":"1546238254_Lighthouse.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/8/1546238254_Lighthouse.jpg","photos":[]},{"like_status":15,"id":15,"name":"2000 Sq.Ft Room in  Sharjah","space_type":2,"property_type":1,"host_id":1,"price":35,"steps_completed":0,"space_type_name":"Private room","property_type_name":"Apartment","property_photo":"1547190326_Hydrangeas.jpg","host_name":"User1","host_email":"user@barastiapp.com","reviews_count":0,"overall_rating":0,"cover_photo":"http://betaholder.com/barastiapp/public/images/property/15/1547190326_Jellyfish.jpg","photos":["http://betaholder.com/barastiapp/public/images/property/15/1547190326_Hydrangeas.jpg","http://betaholder.com/barastiapp/public/images/property/15/1547190326_Koala.jpg","http://betaholder.com/barastiapp/public/images/property/15/1548238574_1523431461_p19140h20i1mj91uid1djij2s1r8r41.jpg","http://betaholder.com/barastiapp/public/images/property/15/1548240648_1523431431_cambria-dbl.jpg"]}]
     * sliders : [{"id":1,"title":"Slider1","url":"www.slider1.com","image":"slider_1546680186.jpg","status":"Active","image_url":"http://betaholder.com/barastiapp/public/images/sliders/slider_1546680186.jpg"},{"id":2,"title":"Slider2","url":"www.slider2.com","image":"slider_1546680360.jpg","status":"Active","image_url":"http://betaholder.com/barastiapp/public/images/sliders/slider_1546680360.jpg"},{"id":3,"title":"Slider3","url":"www.slider3.com","image":"slider_1546680394.jpg","status":"Active","image_url":"http://betaholder.com/barastiapp/public/images/sliders/slider_1546680394.jpg"}]
     * listings_count : 12
     * locations : [{"name":"Oman","property_id":6,"photo":"1546237787_Chrysanthemum.jpg","image_url":"http://betaholder.com/barastiapp/public/images/property/6/1546237787_Chrysanthemum.jpg"},{"name":"Qatar","property_id":2,"photo":"1545886382_Koala.jpg","image_url":"http://betaholder.com/barastiapp/public/images/property/2/1545886382_Koala.jpg"},{"name":"Saudi Arabia","property_id":8,"photo":"1546238254_Lighthouse.jpg","image_url":"http://betaholder.com/barastiapp/public/images/property/8/1546238254_Lighthouse.jpg"},{"name":"United Arab Emirates","property_id":1,"photo":"1545307614_Jellyfish.jpg","image_url":"http://betaholder.com/barastiapp/public/images/property/1/1545307614_Jellyfish.jpg"}]
     */

    private int listings_count;
    private List<TypeList> types;
    private List<HouseList> properties;
    private List<Banner> sliders;
    private List<LocItems> locations;
    public boolean error;
    public String error_status;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getError_status() {
        return error_status;
    }

    public void setError_status(String error_status) {
        this.error_status = error_status;
    }

    public int getListings_count() {
        return listings_count;
    }

    public void setListings_count(int listings_count) {
        this.listings_count = listings_count;
    }

    public List<TypeList> getTypes() {
        return types;
    }

    public void setTypes(List<TypeList> types) {
        this.types = types;
    }

    public List<HouseList> getProperties() {
        return properties;
    }

    public void setProperties(List<HouseList> properties) {
        this.properties = properties;
    }

    public List<Banner> getSliders() {
        return sliders;
    }

    public void setSliders(List<Banner> sliders) {
        this.sliders = sliders;
    }

    public List<LocItems> getLocations() {
        return locations;
    }

    public void setLocations(List<LocItems> locations) {
        this.locations = locations;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.listings_count);
        dest.writeTypedList(this.types);
        dest.writeTypedList(this.properties);
        dest.writeList(this.sliders);
        dest.writeList(this.locations);
    }

    public MainList() {
    }

    protected MainList(Parcel in) {
        this.listings_count = in.readInt();
        this.types = in.createTypedArrayList(TypeList.CREATOR);
        this.properties = in.createTypedArrayList(HouseList.CREATOR);
        this.sliders = new ArrayList<Banner>();
        in.readList(this.sliders, Banner.class.getClassLoader());
        this.locations = new ArrayList<LocItems>();
        in.readList(this.locations, LocItems.class.getClassLoader());
    }

    public static final Parcelable.Creator<MainList> CREATOR = new Parcelable.Creator<MainList>() {
        @Override
        public MainList createFromParcel(Parcel source) {
            return new MainList(source);
        }

        @Override
        public MainList[] newArray(int size) {
            return new MainList[size];
        }
    };
}
