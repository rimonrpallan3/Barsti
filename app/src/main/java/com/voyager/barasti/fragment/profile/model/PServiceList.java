package com.voyager.barasti.fragment.profile.model;

/**
 * Created by User on 29-Jan-19.
 */

public class PServiceList {

    String heading;
    String subHeading;
    int index;


    public PServiceList(int index,String heading, String subHeading) {
        this.heading = heading;
        this.subHeading = subHeading;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }
}
