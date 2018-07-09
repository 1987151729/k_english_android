package com.k.initial.english.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.WordContract;
import com.k.initial.english.mvp.model.WordModel;

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
public class WordModule {
    private WordContract.View view;

    /**
     * 构建WordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public WordModule(WordContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    WordContract.View provideWordView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    WordContract.Model provideWordModel(WordModel model) {
        return model;
    }
}
