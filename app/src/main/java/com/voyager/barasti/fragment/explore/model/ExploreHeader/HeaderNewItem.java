package com.voyager.barasti.fragment.explore.model.ExploreHeader;


import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;

/**
 * Created by User on 25-May-18.
 */

public class HeaderNewItem extends ExploreItems {

    public final static String TAG_NAME = "HeaderNewItem";

    public HeaderNewItem(){
        super();
        this.type = TAG_NAME;
    }

    private String btnContent;
    private String ImageUrl;
    private int imgHeader;

    public String getBtnContent() {
        return btnContent;
    }

    public void setBtnContent(String btnContent) {
        this.btnContent = btnContent;
    }

    public int getImgHeader() {
        return imgHeader;
    }

    public void setImgHeader(int imgHeader) {
        this.imgHeader = imgHeader;
    }
}
