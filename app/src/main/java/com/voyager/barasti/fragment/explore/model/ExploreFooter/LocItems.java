package com.voyager.barasti.fragment.explore.model.ExploreFooter;

import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;

/**
 * Created by User on 27-Dec-18.
 */

public class LocItems  {

    /**
     * id : 5
     * name : Berlin
     * image : starting_city_5.jpg
     * status : Active
     * image_url : http://betaholder.com/barastiapp/public/front/images/starting_cities/starting_city_5.jpg
     */

    private int id;
    private String name;
    private String image;
    private String status;
    private String image_url;
    private int viewType;

    public LocItems() {
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}
