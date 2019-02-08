package com.voyager.barasti.fragment.explore.model.ExploreFooter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 27-Dec-18.
 */

public class LocItems implements Parcelable {
    /**
     * name : Oman
     * property_id : 6
     * photo : 1546237787_Chrysanthemum.jpg
     * image_url : http://betaholder.com/barastiapp/public/images/property/6/1546237787_Chrysanthemum.jpg
     */

    private String name;
    private int property_id;
    private String photo;
    private String image_url;
    private int viewType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }



  /*  *//**
     * id : 5
     * name : Berlin
     * image : starting_city_5.jpg
     * status : Active
     * image_url : http://betaholder.com/barastiapp/public/front/images/starting_cities/starting_city_5.jpg
     *//*

    private int id;
    private String name;
    private String image;
    private String status;
    private String image_url;
    private int viewType;

    public LocItems() {
    }
*/


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.property_id);
        dest.writeString(this.photo);
        dest.writeString(this.image_url);
        dest.writeInt(this.viewType);
    }

    public LocItems() {
    }

    protected LocItems(Parcel in) {
        this.name = in.readString();
        this.property_id = in.readInt();
        this.photo = in.readString();
        this.image_url = in.readString();
        this.viewType = in.readInt();
    }

    public static final Parcelable.Creator<LocItems> CREATOR = new Parcelable.Creator<LocItems>() {
        @Override
        public LocItems createFromParcel(Parcel source) {
            return new LocItems(source);
        }

        @Override
        public LocItems[] newArray(int size) {
            return new LocItems[size];
        }
    };
}
