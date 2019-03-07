package com.voyager.barasti.activity.UserPropertyList.model;

/**
 * Created by User on 06-Mar-19.
 */

public class UserBean {

    /**
     * id : 1
     * first_name : User1
     * last_name : Test
     * phone_num :
     * email : user@barastiapp.com
     * about_me :
     * profile_image :
     * balance : 0
     * status : Active
     * fcm :
     * api_token :
     * created_at : 2018-12-20 10:22:47
     * updated_at : 2018-12-20 10:22:47
     * profile_src : http://betaholder.com/barastiapp/public/images/user_pic-225x225.png
     */

    private int id;
    private String first_name;
    private String last_name;
    private String phone_num;
    private String email;
    private String about_me;
    private String profile_image;
    private int balance;
    private String status;
    private String fcm;
    private String api_token;
    private String created_at;
    private String updated_at;
    private String profile_src;

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

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
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

    public String getFcm() {
        return fcm;
    }

    public void setFcm(String fcm) {
        this.fcm = fcm;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
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

    public String getProfile_src() {
        return profile_src;
    }

    public void setProfile_src(String profile_src) {
        this.profile_src = profile_src;
    }
}
