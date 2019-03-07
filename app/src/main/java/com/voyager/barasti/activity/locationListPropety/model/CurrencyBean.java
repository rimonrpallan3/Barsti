package com.voyager.barasti.activity.locationListPropety.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 04-Mar-19.
 */

public class CurrencyBean {

    /**
     * id : 13
     * name : India
     * code : INR
     * symbol : &#x20B9;
     * rate : 66.24
     * status : Active
     * default : 0
     * org_symbol : &#x20B9;
     */

    private int id;
    private String name;
    private String code;
    private String symbol;
    private String rate;
    private String status;
    @SerializedName("default")
    private String defaultX;
    private String org_symbol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDefaultX() {
        return defaultX;
    }

    public void setDefaultX(String defaultX) {
        this.defaultX = defaultX;
    }

    public String getOrg_symbol() {
        return org_symbol;
    }

    public void setOrg_symbol(String org_symbol) {
        this.org_symbol = org_symbol;
    }
}
