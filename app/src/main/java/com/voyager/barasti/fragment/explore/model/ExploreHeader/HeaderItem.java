package com.voyager.barasti.fragment.explore.model.ExploreHeader;


import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;

/**
 * Created by User on 25-May-18.
 */

public class HeaderItem extends ExploreItems {

    public final static String TAG_NAME = "HeaderItem";

    public HeaderItem(){
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

    @Override
    public String getImageUrl() {
        return ImageUrl;
    }

    @Override
    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getImgHeader() {
        return imgHeader;
    }

    public void setImgHeader(int imgHeader) {
        this.imgHeader = imgHeader;
    }
}
