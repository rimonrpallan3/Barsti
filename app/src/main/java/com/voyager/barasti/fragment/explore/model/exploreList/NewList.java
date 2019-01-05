package com.voyager.barasti.fragment.explore.model.exploreList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.voyager.barasti.fragment.explore.model.ExploreType.TypeList;

import java.util.ArrayList;

/**
 * Created by User on 04-Jan-19.
 */

public class NewList {

    @SerializedName("types")
    @Expose
    private ArrayList<TypeList> typeLists;
    @SerializedName("properties")
    @Expose
    private ArrayList<HouseList> houseLists;

    public NewList() {
    }

    public ArrayList<TypeList> getTypeLists() {
        return typeLists;
    }

    public void setTypeLists(ArrayList<TypeList> typeLists) {
        this.typeLists = typeLists;
    }

    public ArrayList<HouseList> getHouseLists() {
        return houseLists;
    }

    public void setHouseLists(ArrayList<HouseList> houseLists) {
        this.houseLists = houseLists;
    }
}
