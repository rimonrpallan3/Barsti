package com.voyager.barasti.activity.locationListPropety.model;

/**
 * Created by User on 04-Mar-19.
 */

public class PropertyAddressBean {

    /**
     * id : 15
     * property_id : 15
     * address_line_1 : 173 Sheikh Zayed St - Sharjah - United Arab Emirates
     * address_line_2 : Sharjah
     * latitude : 25.3462553
     * longitude : 55.42093169999998
     * city : Sharjah
     * state : Sharjah
     * country : AE
     * postal_code : 11111111
     */

    private int id;
    private int property_id;
    private String address_line_1;
    private String address_line_2;
    private String latitude;
    private String longitude;
    private String city;
    private String state;
    private String country;
    private String postal_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
}
