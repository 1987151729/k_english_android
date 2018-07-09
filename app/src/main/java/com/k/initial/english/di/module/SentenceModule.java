package com.k.initial.english.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.SentenceContract;
import com.k.initial.english.mvp.model.SentenceModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 11:44
 */
@Module
public class SentenceModule {
    private SentenceContract.View view;

    /**
     * 构建SentenceModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SentenceModule(SentenceContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SentenceContract.View provideSentenceView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SentenceContract.Model provideSentenceModel(SentenceModel model) {
        return model;
    }
}
