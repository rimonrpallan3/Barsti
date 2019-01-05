package com.voyager.barasti.fragment.explore.model.ExploreType;

/**
 * Created by User on 04-Jan-19.
 */

public class TypeList {

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
}
