package com.k.initial.english.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.NewsContract;
import com.k.initial.english.mvp.model.NewsModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 11:42
 */
@Module
public class NewsModule {
    private NewsContract.View view;

    /**
     * 构建NewsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public NewsModule(NewsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    NewsContract.View provideNewsView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    NewsContract.Model provideNewsModel(NewsModel model) {
        return model;
    }
}
