package com.k.initial.english.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.TranslateContract;
import com.k.initial.english.mvp.model.TranslateModel;

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
public class TranslateModule {
    private TranslateContract.View view;

    /**
     * 构建TranslateModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public TranslateModule(TranslateContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    TranslateContract.View provideTranslateView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    TranslateContract.Model provideTranslateModel(TranslateModel model) {
        return model;
    }
}
