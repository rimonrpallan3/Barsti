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
    private int viewType;
    public final static String TAG_NAME = "ExploreItems";


    List<BodyItems> bodyItemsList;
    List<HouseList> houseList;
    public MainList mainList;

    public List<HouseList> getHouseList() {
        return houseList;
    }

    public MainList getMainList() {
        return mainList;
    }

    public void setMainList(MainList mainList) {
        this.mainList = mainList;
    }

    public void setHouseList(List<HouseList> houseList) {
        this.houseList = houseList;
    }

    public ExploreItems() {
        this.type = TAG_NAME;
    }

    public ExploreItems(int ID, String name, String discription, String imageUrl, int imageId, String type, boolean enabled, int notify, String mainHeading, MaterialDrawableBuilder.IconValue iconDraw, int viewType, List<BodyItems> bodyItemsList) {
        this.ID = ID;
        Name = name;
        Discription = discription;
        ImageUrl = imageUrl;
        ImageId = imageId;
        this.type = type;
        this.enabled = enabled;
        this.notify = notify;
        this.mainHeading = mainHeading;
        this.iconDraw = iconDraw;
        this.viewType = viewType;
        this.bodyItemsList = bodyItemsList;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getNotify() {
        return notify;
    }

    public void setNotify(int notify) {
        this.notify = notify;
    }

    public String getMainHeading() {
        return mainHeading;
    }

    public void setMainHeading(String mainHeading) {
        this.mainHeading = mainHeading;
    }

    public MaterialDrawableBuilder.IconValue getIconDraw() {
        return iconDraw;
    }

    public void setIconDraw(MaterialDrawableBuilder.IconValue iconDraw) {
        this.iconDraw = iconDraw;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public static String getTagName() {
        return TAG_NAME;
    }

    public List<BodyItems> getBodyItemsList() {
        return bodyItemsList;
    }

    public void setBodyItemsList(List<BodyItems> bodyItemsList) {
        this.bodyItemsList = bodyItemsList;
    }
}
