package com.voyager.barasti.landingpage.model.drawerHeader;


import com.voyager.barasti.landingpage.model.drawerList.LandingItems;

/**
 * Created by User on 25-May-18.
 */

public class HeaderItem extends LandingItems {

    public final static String TAG_NAME = "HeaderItem";

    public HeaderItem(){
        super();
        this.type = TAG_NAME;
    }

    private String btnContent;
    private String ImageUrl;
    private int imgHeader;

    public int getImgHeader() {
        return imgHeader;
    }

    public void setImgHeader(int imgHeader) {
        this.imgHeader = imgHeader;
    }

    @Override
    public String getImageUrl() {
        return ImageUrl;
    }

    @Override
    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getBtnContent() {
        return btnContent;
    }

    public void setBtnContent(String btnContent) {
        this.btnContent = btnContent;
    }
}
