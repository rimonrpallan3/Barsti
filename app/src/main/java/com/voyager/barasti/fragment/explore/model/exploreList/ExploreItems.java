package com.voyager.barasti.fragment.explore.model.exploreList;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import java.util.List;

/**
 * Created by User on 15-May-18.
 */

public class ExploreItems {


    private int ID;
    private String Name;
    private String Discription;
    private String ImageUrl;
    private int ImageId;
    protected String type;
    private boolean enabled = true;
    private int notify;
    String mainHeading;
    private MaterialDrawableBuilder.IconValue iconDraw;
    public int viewType;
    public final static String TAG_NAME = "ExploreItems";


    List<BodyItems> bodyItemsList;

    public ExploreItems() {
        this.type = TAG_NAME;
    }

    public String getMainHeading() {
        return mainHeading;
    }

    public int getViewType() {
        return viewType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<BodyItems> getBodyItemsList() {
        return bodyItemsList;
    }

    public void setBodyItemsList(List<BodyItems> bodyItemsList) {
        this.bodyItemsList = bodyItemsList;
    }

    public void setMainHeading(String mainHeading) {
        this.mainHeading = mainHeading;
    }

    public int getNotify() {
        return notify;
    }


    public void setNotify(int notify) {
        this.notify = notify;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }


    public MaterialDrawableBuilder.IconValue getIconDraw() {
        return iconDraw;
    }

    public void setIconDraw(MaterialDrawableBuilder.IconValue iconDraw) {
        this.iconDraw = iconDraw;
    }

}
