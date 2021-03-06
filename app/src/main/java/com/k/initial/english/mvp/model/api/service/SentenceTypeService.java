package com.k.initial.english.mvp.model.api.service;

import com.k.initial.english.mvp.model.entity.SentenceTypeEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 16:38
 */
public interface SentenceTypeService {

    @GET("sentence_type/list/")
    Observable<List<SentenceTypeEntity>> list(
    );
}
