package com.voyager.barasti.activity.register.model;

/**
 * Created by User on 20-Feb-19.
 */

public class DOBDetails {

    String day;
    String month;
    String year;

    public DOBDetails() {
    }

    public DOBDetails(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
