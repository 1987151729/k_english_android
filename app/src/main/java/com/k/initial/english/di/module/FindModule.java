package com.k.initial.english.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.FindContract;
import com.k.initial.english.mvp.model.FindModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 11:41
 */
@Module
public class FindModule {
    private FindContract.View view;

    /**
     * 构建FindModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public FindModule(FindContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    FindContract.View provideFindView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    FindContract.Model provideFindModel(FindModel model) {
        return model;
    }
}
