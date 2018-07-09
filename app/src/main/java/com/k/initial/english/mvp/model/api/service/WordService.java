package com.k.initial.english.mvp.model.api.service;

import com.k.initial.english.mvp.model.entity.WordEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 16:40
 */
public interface WordService {
    @GET("word/list/")
    Observable<List<WordEntity>> list(
            @Query("pageIndex") int pageIndex,
            @Query("pageSize") int pageSize,
            @Query("type") int type
    );
}