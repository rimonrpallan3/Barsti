package com.voyager.barasti.fragment.explore.model.ExploreType;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 04-Jan-19.
 */

public class TypeList implements Parcelable {

    /**
     * name : Apartment
     * id : 1
     */

    private String name;
    private int id;
    public int imgId;

    public TypeList() {
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.id);
        dest.writeInt(this.imgId);
    }

    protected TypeList(Parcel in) {
        this.name = in.readString();
        this.id = in.readInt();
        this.imgId = in.readInt();
    }

    public static final Parcelable.Creator<TypeList> CREATOR = new Parcelable.Creator<TypeList>() {
        @Override
        public TypeList createFromParcel(Parcel source) {
            return new TypeList(source);
        }

        @Override
        public TypeList[] newArray(int size) {
            return new TypeList[size];
        }
    };
}
