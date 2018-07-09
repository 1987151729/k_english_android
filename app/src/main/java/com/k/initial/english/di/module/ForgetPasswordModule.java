package com.k.initial.english.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.ForgetPasswordContract;
import com.k.initial.english.mvp.model.ForgetPasswordModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 11:43
 */
@Module
public class ForgetPasswordModule {
    private ForgetPasswordContract.View view;

    /**
     * 构建ForgetPasswordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ForgetPasswordModule(ForgetPasswordContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ForgetPasswordContract.View provideForgetPasswordView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ForgetPasswordContract.Model provideForgetPasswordModel(ForgetPasswordModel model) {
        return model;
    }
}
