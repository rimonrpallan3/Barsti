package com.voyager.barasti.fragment.explore.model.ExploreFooter;

import com.voyager.barasti.fragment.explore.model.exploreList.BodyItems;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 19-Dec-18.
 */

public class FooterItems extends ExploreItems {

    public final static String TAG_NAME = "FooterItems";

    public FooterItems() {
        super();
        this.type = TAG_NAME;
    }


    private String headingTitile;
    List<LocList> locLists ;


    public String getHeadingTitile() {
        return headingTitile;
    }

    public void setHeadingTitile(String headingTitile) {
        this.headingTitile = headingTitile;
    }

    public List<LocList> getLocLists() {
        return locLists;
    }

    public void setLocLists(List<LocList> locLists) {
        this.locLists = locLists;
    }
}