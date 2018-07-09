package com.k.initial.english.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.SettingsContract;
import com.k.initial.english.mvp.model.SettingsModel;

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
public class SettingsModule {
    private SettingsContract.View view;

    /**
     * 构建SettingsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SettingsModule(SettingsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SettingsContract.View provideSettingsView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SettingsContract.Model provideSettingsModel(SettingsModel model) {
        return model;
    }
}
