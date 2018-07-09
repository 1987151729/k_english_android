package com.k.initial.english.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.k.initial.english.mvp.contract.WordContract;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 16:58
 */
@ActivityScope
public class WordModel extends BaseModel implements WordContract.Model{

    @Inject
    public WordModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
