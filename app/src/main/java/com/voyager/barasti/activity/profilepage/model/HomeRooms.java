package com.voyager.barasti.activity.profilepage.model;

/**
 * Created by User on 29-Jan-19.
 */

public class HomeRooms {

    public int imageId;
    public String roomName;

    public HomeRooms() {
    }

    public HomeRooms(int imageId, String roomName) {
        this.imageId = imageId;
        this.roomName = roomName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
