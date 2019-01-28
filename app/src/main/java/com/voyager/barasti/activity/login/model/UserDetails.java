package com.voyager.barasti.activity.login.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rimon on 18-03-2018.
 */

public class UserDetails implements IUserDetials,Parcelable {


    /**
     * id : 1
     * first_name : User1
     * last_name : Test
     * email : user@barastiapp.com
     * profile_image : null
     * balance : 0
     * status : Active
     * api_token : null
     * created_at : 2018-12-20 10:22:47
     * updated_at : 2018-12-20 10:22:47
     * login_status : success
     * profile_src : http://betaholder.com/barastiapp/public/images/user_pic-225x225.png
     */

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String profile_image;
    private int balance;
    private String status;
    private String api_token;
    private String created_at;
    private String updated_at;
    private String login_status;
    private String profile_src;
    public String fcmId;
    String usermob;
    String pswd;


    public UserDetails() {
    }


    public UserDetails(String email, String pswd) {
        this.email = email;
        this.pswd = pswd;
    }

    public String getFcmId() {
        return fcmId;
    }

    public void setFcmId(String fcmId) {
        this.fcmId = fcmId;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public String getUsermob() {
        return usermob;
    }

    public void setUsermob(String usermob) {
        this.usermob = usermob;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getProfile_image() {
        return profile_image;
    }



    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getApi_token() {
        return api_token;
    }


    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLogin_status() {
        return login_status;
    }

    public void setLogin_status(String login_status) {
        this.login_status = login_status;
    }

    public String getProfile_src() {
        return profile_src;
    }

    public void setProfile_src(String profile_src) {
        this.profile_src = profile_src;
    }

    @Override
    public int checkUserValidity(String name, String passwd) {
        if (email==null||passwd==null||!email.equals(getEmail())||!passwd.equals(getPswd())){
            return -1;
        }
        return 0;
    }
    @Override
    public int validateLoginResponseError(String errorMsg) {
        if(errorMsg!=null){
            //if there is no error message then it means that data response is correct.
            return -2;
        }
        return 0;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.first_name);
        dest.writeString(this.last_name);
        dest.writeString(this.email);
        dest.writeString(this.profile_image);
        dest.writeInt(this.balance);
        dest.writeString(this.status);
        dest.writeString(this.api_token);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);
        dest.writeString(this.login_status);
        dest.writeString(this.profile_src);
        dest.writeString(this.usermob);
        dest.writeString(this.pswd);
    }

    protected UserDetails(Parcel in) {
        this.id = in.readInt();
        this.first_name = in.readString();
        this.last_name = in.readString();
        this.email = in.readString();
        this.profile_image = in.readString();
        this.balance = in.readInt();
        this.status = in.readString();
        this.api_token = in.readString();
        this.created_at = in.readString();
        this.updated_at = in.readString();
        this.login_status = in.readString();
        this.profile_src = in.readString();
        this.usermob = in.readString();
        this.pswd = in.readString();
    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel source) {
            return new UserDetails(source);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };
}
