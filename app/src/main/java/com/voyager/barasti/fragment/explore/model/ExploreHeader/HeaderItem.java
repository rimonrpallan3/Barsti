package com.voyager.barasti.fragment.explore.model.ExploreHeader;


import com.voyager.barasti.fragment.explore.model.exploreList.ExploreItems;

import java.util.ArrayList;
import java.util.List;

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
    private ArrayList<Integer> IMAGES;
    private List<Banner> banners;


    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public ArrayList<Integer> getIMAGES() {
        return IMAGES;
    }

    public void setIMAGES(ArrayList<Integer> IMAGES) {
        this.IMAGES = IMAGES;
    }

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
