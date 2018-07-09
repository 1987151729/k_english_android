package com.k.initial.english.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.k.initial.english.mvp.contract.MusicContract;
import com.k.initial.english.mvp.model.api.service.MusicService;
import com.k.initial.english.mvp.model.entity.MusicEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 16:54
 */
@ActivityScope
public class MusicModel extends BaseModel implements MusicContract.Model {

    @Inject
    public MusicModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<MusicEntity>> getList(int pageIndex, int pageSize) {
        return mRepositoryManager
                .obtainRetrofitService(MusicService.class)
                .list(pageIndex, pageSize);
    }
}
