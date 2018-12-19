package com.voyager.barasti.fragment.explore.model.ExploreFooter;

/**
 * Created by User on 19-Dec-18.
 */

public class LocList {

    String urlImg;
    String imgHeading;
    int idImg;

    int id;
    boolean enabled =false;


    public LocList() {
    }

    public String getImgHeading() {
        return imgHeading;
    }

    public void setImgHeading(String imgHeading) {
        this.imgHeading = imgHeading;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocList(String urlImg, int idImg) {
        this.urlImg = urlImg;
        this.idImg = idImg;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }
}
