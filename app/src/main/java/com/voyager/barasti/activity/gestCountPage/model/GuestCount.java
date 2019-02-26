package com.voyager.barasti.activity.gestCountPage.model;

/**
 * Created by User on 25-Feb-19.
 */

public class GuestCount {

    int dress;
    String menheading;
    String subheading;
    String intialAmt;

    public GuestCount(int dress, String menheading, String subheading, String intialAmt) {
        this.dress = dress;
        this.menheading = menheading;
        this.subheading = subheading;
        this.intialAmt = intialAmt;
    }

    public int getDress() {
        return dress;
    }

    public void setDress(int dress) {
        this.dress = dress;
    }

    public String getMenheading() {
        return menheading;
    }

    public void setMenheading(String menheading) {
        this.menheading = menheading;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public String getIntialAmt() {
        return intialAmt;
    }

    public void setIntialAmt(String intialAmt) {
        this.intialAmt = intialAmt;
    }
}
