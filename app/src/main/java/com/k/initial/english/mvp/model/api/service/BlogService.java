package com.k.initial.english.mvp.model.api.service;

import com.k.initial.english.mvp.model.entity.BlogEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 23/06/2018
 * Time: 22:30
 */
public interface BlogService {

    @GET("blog/list/")
    Observable<List<BlogEntity>> list(
            @Query("pageIndex") int pageIndex,
            @Query("pageSize") int pageSize,
            @Query("userID") String userID
    );
}
