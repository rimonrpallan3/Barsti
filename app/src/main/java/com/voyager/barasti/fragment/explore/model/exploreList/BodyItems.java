package com.voyager.barasti.fragment.explore.model.exploreList;

/**
 * Created by User on 17-Dec-18.
 */

public class BodyItems {

    int imgHome;
    String urlHome;
    String heading;
    String amtHome;
    String favRate;
    String favRatio;
    int id;
    boolean enabled =false;


    public BodyItems() {
    }

    public BodyItems(int imgHome, String urlHome, String heading, String amtHome, String favRate, String favRatio) {
        this.imgHome = imgHome;
        this.urlHome = urlHome;
        this.heading = heading;
        this.amtHome = amtHome;
        this.favRate = favRate;
        this.favRatio = favRatio;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgHome() {
        return imgHome;
    }

    public void setImgHome(int imgHome) {
        this.imgHome = imgHome;
    }

    public String getUrlHome() {
        return urlHome;
    }

    public void setUrlHome(String urlHome) {
        this.urlHome = urlHome;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getAmtHome() {
        return amtHome;
    }

    public void setAmtHome(String amtHome) {
        this.amtHome = amtHome;
    }

    public String getFavRate() {
        return favRate;
    }

    public void setFavRate(String favRate) {
        this.favRate = favRate;
    }

    public String getFavRatio() {
        return favRatio;
    }

    public void setFavRatio(String favRatio) {
        this.favRatio = favRatio;
    }
}
