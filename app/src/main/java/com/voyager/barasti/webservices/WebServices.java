package com.voyager.barasti.webservices;


import android.support.annotation.Nullable;

import com.voyager.barasti.activity.login.model.UserDetails;
import com.voyager.barasti.activity.profilepage.model.HomeDetails;
import com.voyager.barasti.activity.typelist.model.TypedDetail;
import com.voyager.barasti.fragment.explore.model.ExploreHeader.Banner;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.model.exploreList.LikeUnLike;
import com.voyager.barasti.fragment.explore.model.exploreList.MainList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServices {
    //@GET("driver/getDriver/")
    // Call<MainClass> doGetUserList(@Query("page") String page);
    //http://10.1.1.18/sayara/user/booking/--pickup_loc: 9.731235,76.355463 -- user_id 89


 /*   @GET("listings/4/0")
    Call<MainList> doGetHouseList();
    @GET("sliders")
    Call<ArrayList<Banner>> doGetbannerlist();
    @GET("locations/2/0")
    Call<ArrayList<LocItems>> doGetLocList();
    @GET("listings/{id}")
    Call<HomeDetails> doGetHomeDetails(@Path("id") int id);*/

    @GET("home")
    Call<MainList> doGetDetails();

    /*Here limit is the total list count to be fetched
    * and offset is the pointer form which data fetching should start form */
    @GET("listings/{limit}/{offset}")
    Call<MainList> updateHouseList(@Path("limit") int limit, @Path("offset") int offset);
    @FormUrlEncoded
    @GET("propertyLike")
    Call<LikeUnLike> propertyLike(@Nullable @Field("user_id") Integer userID,
                                   @Nullable @Field("property_id") Integer propertyID);
    @FormUrlEncoded
    @GET("propertyUnlike")
    Call<LikeUnLike> propertyUnlike(@Nullable @Field("user_id") Integer email,
                                    @Nullable @Field("property_id") Integer papropertyIDsswd);

    @GET("sliders")
    Call<ArrayList<Banner>> doGetbannerlist();

    @GET("locations/{limit}/{offset}")
    Call<ArrayList<LocItems>> doGetLocList(@Path("limit") int limit, @Path("offset") int offset);

    @GET("listings/{propertyId}")
    Call<HomeDetails> doGetHomeDetails(@Path("propertyId") int propertyId);

    @GET("listings/{limit}/{offset}/{typeId}")
    Call<TypedDetail> doGetTypedDetails(@Path("limit") int limit, @Path("offset") int offset, @Path("typeId") int typeId);

    @FormUrlEncoded
    @POST("mobileLogin")
    public Call<UserDetails> loginNormalUser(@Nullable @Field("email") String email,
                                             @Nullable @Field("password") String passwd,
                                             @Nullable @Field("login_type") String type,
                                             @Nullable @Field("fcm") String fireBaseToken);

    @FormUrlEncoded
    @POST("mobileLogin")
    public Call<UserDetails> loginGoogleUser(@Nullable @Field("email") String email,
                                             @Nullable @Field("login_type") String type,
                                             @Nullable @Field("profile_image") String imageP,
                                             @Nullable @Field("phonenumber") String mobNo,
                                             @Nullable @Field("userName") String userName,
                                             @Nullable @Field("googleId") String googleId,
                                             @Nullable @Field("fcm") String fireBaseToken);

    @FormUrlEncoded
    @POST("mobileLogin")
    public Call<UserDetails> loginFBUser(@Nullable @Field("email") String email,
                                         @Nullable @Field("login_type") String type,
                                         @Nullable @Field("profile_image") String imageP,
                                         @Nullable @Field("phonenumber") String mobNo,
                                         @Nullable @Field("userName") String userName,
                                         @Nullable @Field("token") String fireBaseToken);

/*
    @GET("webservice/getOffertypes")
    Call<OfferList> doGetUserList();

    @FormUrlEncoded
    @POST("register/")
    public Call<UserDetail> registerUser(@Nullable @Field("name") String name,
                                          @Nullable @Field("password") String password,
                                          @Nullable @Field("email") String email,
                                          @Nullable @Field("phone") String phone,
                                          @Nullable @Field("country") String country,
                                          @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("login/")
    public Call<UserDetail> loginUser(@Nullable @Field("email") String email,
                                       @Nullable @Field("password") String passwd,
                                       @Nullable @Field("token") String fireBaseToken);

    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetail> updateProfile(@Nullable @Field("name") String name,
                                    @Nullable @Field("userID") int id,
                                    @Nullable @Field("password") String password,
                                    @Nullable @Field("phone") String phone,
                                    @Nullable @Field("country") String country,
                                    @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetail> updateProfilePass(@Nullable @Field("password") String name,
                                        @Nullable @Field("user_id") int id);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetail> updateProfileName(@Nullable @Field("name") String name,
                                        @Nullable @Field("user_id") int id,
                                        @Nullable @Field("password") String password,
                                        @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetail> updateProfilePhno(@Nullable @Field("phone") String name,
                                        @Nullable @Field("user_id") int id);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetail> updateProfileCity(@Nullable @Field("city") String name,
                                        @Nullable @Field("user_id") int id);
    @FormUrlEncoded
    @POST("tripHistory/")
    Call<List<TripDetails>> getTripHistory(@Field("user_id") int userId,
                                           @Nullable @Field("page") int page);

    @FormUrlEncoded
    @POST("driverProfile/")
    Call<DTDModel> getDriverProfileDetail(@Nullable @Field("driver_id") int userId,
                                          @Nullable @Field("user_id") int tripId);
    @FormUrlEncoded
    @POST("cancelTrip/")
    Call<EndTrip> stopStartUpTrip(@Nullable @Field("user_id") int userId,
                                  @Nullable @Field("trip_id") int tripId);
    @FormUrlEncoded
    @POST("cancelTrip/")
    Call<EndTrip> endOnGoingTrip(@Nullable @Field("user_id") int userId,
                                 @Nullable @Field("trip_id") int tripId);


    @FormUrlEncoded
    @POST("logout/")
    Call<UserDetail> logOut(@Nullable @Field("user_id") int userId,
                             @Nullable @Field("logout") int value);

    @POST("FCMUpdateServlet")
    public Call<UserDetail> updateFCMId(@Nullable @Field("user_id") int userId,
                                         @Nullable @Field("token") String token);
    @FormUrlEncoded
    @POST("confirmTrip/")
    public Call<TripResponse> startTrip(@Nullable @Field("user_id") int userId,
                                        @Nullable @Field("user_name") String userName,
                                        @Nullable @Field("pickup_loc") String nameStartLoc,
                                        @Nullable @Field("pickup_address") String nameStart,
                                        @Nullable @Field("drop_loc") String nameEndLoc,
                                        @Nullable @Field("drop_address") String nameEnd,
                                        @Nullable @Field("distance") String distanceKm,
                                        @Nullable @Field("amount") String costFairSet,
                                        @Nullable @Field("car_id") String driveCarId,
                                        @Nullable @Field("pay_type") String paymentType);

    @Multipart
    @POST("updateProfile/")
    public Call<UserDetail> uploadProfileImg(@Part MultipartBody.Part profileImg, @Part("user_id") RequestBody userID);

    @GET("place/autocomplete/json?")
    Call<PlacesResults> getPlaceSearch(@Query("input") String input, @Query("types") String types, @Query("key") String key);
    //https://developers.google.com/maps/documentation/directions/intro
    @GET("directions/json?")
    Call<GetPaths> getTripRoute(@Query("origin") String source, @Query("destination") String destination, @Query("key") String key);
    @GET("place/details/json?")
    Call<PlaceDetail> getPlaceDetail(@Query("placeid") String source, @Query("key") String key);
    @GET("directions/json?")
    public Call<GetPaths> getPaths(@Query("origin") String origin, @Query("destination") String dest, @Query("sensor") Boolean sensor, @Query("key") String key);
*/


}
