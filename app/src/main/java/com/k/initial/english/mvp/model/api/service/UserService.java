package com.k.initial.english.mvp.model.api.service;

import com.k.initial.english.mvp.model.bean.StatusBean;
import com.k.initial.english.mvp.model.entity.BaseJson;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 22/05/2018
 * Time: 08:12
 */
public interface UserService {

    @GET("user/check_passwordstate/")
    Observable<BaseJson<StatusBean>> checkPasswordstate(
            @Query("userID") String userID,
            @Query("passwordState") String passwordState
    );

    @GET("user/exist_email/")
    Observable<BaseJson<StatusBean>> existEmail(
            @Query("email") String email
    );

    @GET("user/exist_username/")
    Observable<BaseJson<StatusBean>> existUsername(
            @Query("username") String username
    );

    @GET("user/info/")
    Observable<BaseJson<StatusBean>> info(
            @Query("userID") String userID
    );

    @GET("user/name_avatar/")
    Observable<BaseJson<StatusBean>> nameAvatar(
            @Query("userID") String userID
    );

    @FormUrlEncoded
    @POST("user/login/")
    Observable<BaseJson<StatusBean>> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user/logout/")
    Observable<BaseJson<StatusBean>> logout(
            @Field("userID") String userID
    );

    @FormUrlEncoded
    @POST("user/login_email/")
    Observable<BaseJson<StatusBean>> loginEmail(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user/register_email/")
    Observable<BaseJson<StatusBean>> registerEmail(
            @Field("email") String email,
            @Field("password") String password,
            @Field("verificationCode") String verificationCode,
            @Field("name") String name,
            @Field("sex") int sex,
            @Field("avatar") String avatar
    );

    @GET("user/verification_code_email/")
    Observable<BaseJson<StatusBean>> verificationCodeEmail(
            @Query("email") String email,
            @Query("type") int type
    );

    @FormUrlEncoded
    @POST("user/update_avatar/")
    Observable<BaseJson<StatusBean>> updateAvatar(
            @Field("userID") String userID,
            @Field("avatar") String avatar
    );

    @FormUrlEncoded
    @POST("user/update_name/")
    Observable<BaseJson<StatusBean>> updateName(
            @Field("userID") String userID,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("user/update_height/")
    Observable<BaseJson<StatusBean>> updateHeight(
            @Field("userID") String userID,
            @Field("height") int height
    );

    @FormUrlEncoded
    @POST("user/update_weight/")
    Observable<BaseJson<StatusBean>> updateWeight(
            @Field("userID") String userID,
            @Field("weight") int weight
    );

    @FormUrlEncoded
    @POST("user/update_birth/")
    Observable<BaseJson<StatusBean>> updateBirth(
            @Field("userID") String userID,
            @Field("birth") String birth
    );

    @FormUrlEncoded
    @POST("user/update_city/")
    Observable<BaseJson<StatusBean>> updateCity(
            @Field("userID") String userID,
            @Field("city") String city
    );

    @FormUrlEncoded
    @POST("user/update_home/")
    Observable<BaseJson<StatusBean>> updateHome(
            @Field("userID") String userID,
            @Field("home") String home
    );

    @FormUrlEncoded
    @POST("user/update_signature/")
    Observable<BaseJson<StatusBean>> updateSignature(
            @Field("userID") String userID,
            @Field("signature") String signature
    );

    @FormUrlEncoded
    @POST("user/update_sex/")
    Observable<BaseJson<StatusBean>> updateSex(
            @Field("userID") String userID,
            @Field("sexType") int sexType
    );

    @FormUrlEncoded
    @POST("user/update_longitude_latitude/")
    Observable<BaseJson<StatusBean>> updateLongitudeLatitude(
            @Field("userID") String userID,
            @Field("longitude") float longitude,
            @Field("latitude") float latitude
    );

    @FormUrlEncoded
    @POST("user/update_activetime/")
    Observable<BaseJson<StatusBean>> updateActivetime(
            @Field("userID") String userID
    );

    @FormUrlEncoded
    @POST("user/update_password_withold/")
    Observable<BaseJson<StatusBean>> updatePasswordWithold(
            @Field("userID") String userID,
            @Field("oldPassword") String oldPassword,
            @Field("newPassword") String newPassword
    );

    @FormUrlEncoded
    @POST("user/update_password_withoutold/")
    Observable<BaseJson<StatusBean>> updatePasswordWithoutold(
            @Field("userID") String userID,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user/update_password_email/")
    Observable<BaseJson<StatusBean>> updatePasswordEmail(
            @Field("email") String email,
            @Field("verificationCode") String verificationCode,
            @Field("password") String password
    );
}