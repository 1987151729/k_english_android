package com.k.initial.english.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.k.initial.english.mvp.contract.BlogContract;
import com.k.initial.english.mvp.model.api.service.BlogService;
import com.k.initial.english.mvp.model.entity.BlogEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 24/06/2018
 * Time: 08:09
 */
@ActivityScope
public class BlogModel extends BaseModel implements BlogContract.Model {

    @Inject
    public BlogModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<BlogEntity>> getList(int pageIndex, int pageSize, String userID) {
        return mRepositoryManager
                .obtainRetrofitService(BlogService.class)
                .list(pageIndex, pageSize, userID);
    }
}
