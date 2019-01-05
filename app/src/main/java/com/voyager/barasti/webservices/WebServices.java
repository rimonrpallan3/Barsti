package com.voyager.barasti.webservices;


import com.voyager.barasti.fragment.explore.model.exploreList.HouseList;
import com.voyager.barasti.fragment.explore.model.ExploreFooter.LocItems;
import com.voyager.barasti.fragment.explore.model.exploreList.NewList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {
    //@GET("driver/getDriver/")
   // Call<MainClass> doGetUserList(@Query("page") String page);
    //http://10.1.1.18/sayara/user/booking/--pickup_loc: 9.731235,76.355463 -- user_id 89


    @GET("listings/4/0")
    Call<NewList> doGetHouseList();
    @GET("locations/2/0")
    Call<ArrayList<LocItems>> doGetLocList();

/*
    @GET("webservice/getOffertypes")
    Call<OfferList> doGetUserList();

    @FormUrlEncoded
    @POST("register/")
    public Call<UserDetails> registerUser(@Nullable @Field("name") String name,
                                          @Nullable @Field("password") String password,
                                          @Nullable @Field("email") String email,
                                          @Nullable @Field("phone") String phone,
                                          @Nullable @Field("country") String country,
                                          @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("login/")
    public Call<UserDetails> loginUser(@Nullable @Field("email") String email,
                                       @Nullable @Field("password") String passwd,
                                       @Nullable @Field("token") String fireBaseToken);

    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfile(@Nullable @Field("name") String name,
                                    @Nullable @Field("userID") int id,
                                    @Nullable @Field("password") String password,
                                    @Nullable @Field("phone") String phone,
                                    @Nullable @Field("country") String country,
                                    @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfilePass(@Nullable @Field("password") String name,
                                        @Nullable @Field("user_id") int id);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfileName(@Nullable @Field("name") String name,
                                        @Nullable @Field("user_id") int id,
                                        @Nullable @Field("password") String password,
                                        @Nullable @Field("city") String city);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfilePhno(@Nullable @Field("phone") String name,
                                        @Nullable @Field("user_id") int id);
    @FormUrlEncoded
    @POST("updateProfile/")
    Call<UserDetails> updateProfileCity(@Nullable @Field("city") String name,
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
    @POST("getCars/")
    Call<TripCarDetails> getTripDetails(@Nullable @Field("pickup_loc") String latLng,
                                        @Nullable @Field("user_id") int userId);

    @FormUrlEncoded
    @POST("logout/")
    Call<UserDetails> logOut(@Nullable @Field("user_id") int userId,
                             @Nullable @Field("logout") int value);

    @POST("FCMUpdateServlet")
    public Call<UserDetails> updateFCMId(@Nullable @Field("user_id") int userId,
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
    public Call<UserDetails> uploadProfileImg(@Part MultipartBody.Part profileImg, @Part("user_id") RequestBody userID);

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
