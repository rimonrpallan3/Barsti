package com.voyager.barasti.fragment.explore.model.ExploreType;

import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocList;
import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;

import java.util.List;

/**
 * Created by User on 04-Jan-19.
 */

public class TypeBody extends ExploreItems {

    public final static String TAG_NAME = "TypeBody";

    public TypeBody() {
        super();
        this.type = TAG_NAME;
    }


    private String headingTitile;
    List<TypeList> typeLists;

    public static String getTagName() {
        return TAG_NAME;
    }

    public String getHeadingTitile() {
        return headingTitile;
    }

    public void setHeadingTitile(String headingTitile) {
        this.headingTitile = headingTitile;
    }

    public List<TypeList> getTypeLists() {
        return typeLists;
    }

    public void setTypeLists(List<TypeList> typeLists) {
        this.typeLists = typeLists;
    }
}