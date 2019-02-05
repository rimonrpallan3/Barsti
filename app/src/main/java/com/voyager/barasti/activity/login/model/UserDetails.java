package com.voyager.barasti.activity.login.model;

import android.os.Parcel;
import android.os.Parcelable;


import java.util.List;

/**
 * Created by rimon on 18-03-2018.
 */

public class UserDetails implements IUserDetials,Parcelable {
    /**
     * id : 3
     * first_name : Jeevan
     * last_name : Mathews
     * phone_num :
     * email : itsmejeevans@gmail.com
     * profile_image :
     * balance : 0
     * status : Active
     * fcm :
     * api_token :
     * created_at : 2019-01-18 07:28:36
     * updated_at : 2019-01-18 07:28:36
     * login_status : success
     * profile_src : http://betaholder.com/barastiapp/public/images/user_pic-225x225.png
     */



    private int id;
    private String phone_num;
    private String fcm;
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
    public String userName;
    public String googleId;
    public String error_status;
    String passwd;
    String usermob;
    String pswd;
    Boolean state;
    String loginType;
    private List<LikedBean> liked;

    public UserDetails() {
    }

    public UserDetails(String googleId, String email, String profile_image, String userName, String usermob, Boolean state) {
        this.googleId = googleId;
        this.email = email;
        this.profile_image = profile_image;
        this.userName = userName;
        this.usermob = usermob;
        this.state = state;
    }

    public UserDetails(String email, String pswd) {
        this.email = email;
        this.pswd = pswd;
    }

    public String getError_status() {
        return error_status;
    }

    public void setError_status(String error_status) {
        this.error_status = error_status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
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
        dest.writeString(this.phone_num);
        dest.writeString(this.fcm);
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
        dest.writeString(this.userName);
        dest.writeString(this.googleId);
        dest.writeString(this.passwd);
        dest.writeString(this.usermob);
        dest.writeString(this.pswd);
        dest.writeValue(this.state);
        dest.writeString(this.loginType);
    }

    protected UserDetails(Parcel in) {
        this.id = in.readInt();
        this.phone_num = in.readString();
        this.fcm = in.readString();
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
        this.userName = in.readString();
        this.googleId = in.readString();
        this.passwd = in.readString();
        this.usermob = in.readString();
        this.pswd = in.readString();
        this.state = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.loginType = in.readString();
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

    public List<LikedBean> getLiked() {
        return liked;
    }

    public void setLiked(List<LikedBean> liked) {
        this.liked = liked;
    }


}
