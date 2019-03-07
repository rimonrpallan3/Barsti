package com.voyager.barasti.activity.locationListPropety.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 04-Mar-19.
 */

public class PropertyPriceBean {

    /**
     * id : 15
     * property_id : 15
     * cleaning_fee : 2
     * guest_after : 1
     * guest_fee : 5
     * security_fee : 0
     * price : 35
     * weekend_price : 0
     * weekly_discount : 0
     * monthly_discount : 0
     * currency_code : INR
     * original_cleaning_fee : 2
     * original_guest_fee : 5
     * original_price : 35
     * original_weekend_price : 0
     * original_security_fee : 0
     * default_code : INR
     * currency : {"id":13,"name":"India","code":"INR","symbol":"&#x20B9;","rate":"66.24","status":"Active","default":"0","org_symbol":"&#x20B9;"}
     */

    private int id;
    private int property_id;
    private int cleaning_fee;
    private int guest_after;
    private int guest_fee;
    private int security_fee;
    private int price;
    private int weekend_price;
    private int weekly_discount;
    private int monthly_discount;
    private String currency_code;
    private int original_cleaning_fee;
    private int original_guest_fee;
    private int original_price;
    private int original_weekend_price;
    private int original_security_fee;
    private String default_code;
    private CurrencyBean currency;

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

    public int getCleaning_fee() {
        return cleaning_fee;
    }

    public void setCleaning_fee(int cleaning_fee) {
        this.cleaning_fee = cleaning_fee;
    }

    public int getGuest_after() {
        return guest_after;
    }

    public void setGuest_after(int guest_after) {
        this.guest_after = guest_after;
    }

    public int getGuest_fee() {
        return guest_fee;
    }

    public void setGuest_fee(int guest_fee) {
        this.guest_fee = guest_fee;
    }

    public int getSecurity_fee() {
        return security_fee;
    }

    public void setSecurity_fee(int security_fee) {
        this.security_fee = security_fee;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeekend_price() {
        return weekend_price;
    }

    public void setWeekend_price(int weekend_price) {
        this.weekend_price = weekend_price;
    }

    public int getWeekly_discount() {
        return weekly_discount;
    }

    public void setWeekly_discount(int weekly_discount) {
        this.weekly_discount = weekly_discount;
    }

    public int getMonthly_discount() {
        return monthly_discount;
    }

    public void setMonthly_discount(int monthly_discount) {
        this.monthly_discount = monthly_discount;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public int getOriginal_cleaning_fee() {
        return original_cleaning_fee;
    }

    public void setOriginal_cleaning_fee(int original_cleaning_fee) {
        this.original_cleaning_fee = original_cleaning_fee;
    }

    public int getOriginal_guest_fee() {
        return original_guest_fee;
    }

    public void setOriginal_guest_fee(int original_guest_fee) {
        this.original_guest_fee = original_guest_fee;
    }

    public int getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(int original_price) {
        this.original_price = original_price;
    }

    public int getOriginal_weekend_price() {
        return original_weekend_price;
    }

    public void setOriginal_weekend_price(int original_weekend_price) {
        this.original_weekend_price = original_weekend_price;
    }

    public int getOriginal_security_fee() {
        return original_security_fee;
    }

    public void setOriginal_security_fee(int original_security_fee) {
        this.original_security_fee = original_security_fee;
    }

    public String getDefault_code() {
        return default_code;
    }

    public void setDefault_code(String default_code) {
        this.default_code = default_code;
    }

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

}
