package com.k.initial.english.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.k.initial.english.mvp.contract.WordTypeContract;
import com.k.initial.english.mvp.model.api.service.WordTypeService;
import com.k.initial.english.mvp.model.entity.WordTypeEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 16:55
 */
@ActivityScope
public class WordTypeModel extends BaseModel implements WordTypeContract.Model {

    @Inject
    public WordTypeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<WordTypeEntity>> getList() {
        return mRepositoryManager
                .obtainRetrofitService(WordTypeService.class)
                .list();
    }
}
