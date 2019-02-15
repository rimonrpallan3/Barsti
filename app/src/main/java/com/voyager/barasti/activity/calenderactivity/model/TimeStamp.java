package com.voyager.barasti.activity.calenderactivity.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 14-Feb-19.
 */

public class TimeStamp implements Parcelable {

    String dayString;
    String monthString;
    String dayNoString;
    String timeString;
    String timeZoneString;
    String yearString;


    public TimeStamp() {
    }

    public TimeStamp(String dayString, String monthString, String dayNoString, String timeString, String timeZoneString, String yearString) {
        this.dayString = dayString;
        this.monthString = monthString;
        this.dayNoString = dayNoString;
        this.timeString = timeString;
        this.timeZoneString = timeZoneString;
        this.yearString = yearString;
    }

    public String getDayString() {
        return dayString;
    }

    public void setDayString(String dayString) {
        this.dayString = dayString;
    }

    public String getMonthString() {
        return monthString;
    }

    public void setMonthString(String monthString) {
        this.monthString = monthString;
    }

    public String getDayNoString() {
        return dayNoString;
    }

    public void setDayNoString(String dayNoString) {
        this.dayNoString = dayNoString;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getTimeZoneString() {
        return timeZoneString;
    }

    public void setTimeZoneString(String timeZoneString) {
        this.timeZoneString = timeZoneString;
    }

    public String getYearString() {
        return yearString;
    }

    public void setYearString(String yearString) {
        this.yearString = yearString;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dayString);
        dest.writeString(this.monthString);
        dest.writeString(this.dayNoString);
        dest.writeString(this.timeString);
        dest.writeString(this.timeZoneString);
        dest.writeString(this.yearString);
    }

    protected TimeStamp(Parcel in) {
        this.dayString = in.readString();
        this.monthString = in.readString();
        this.dayNoString = in.readString();
        this.timeString = in.readString();
        this.timeZoneString = in.readString();
        this.yearString = in.readString();
    }

    public static final Parcelable.Creator<TimeStamp> CREATOR = new Parcelable.Creator<TimeStamp>() {
        @Override
        public TimeStamp createFromParcel(Parcel source) {
            return new TimeStamp(source);
        }

        @Override
        public TimeStamp[] newArray(int size) {
            return new TimeStamp[size];
        }
    };
}
