package com.k.initial.english.mvp.model.api.service;

import com.k.initial.english.mvp.model.entity.MusicEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 16:37
 */
public interface MusicService {

    @GET("music/list/")
    Observable<List<MusicEntity>> list(
            @Query("pageIndex") int pageIndex,
            @Query("pageSize") int pageSize
    );
}
