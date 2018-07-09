package com.k.initial.english.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.ContactContract;
import com.k.initial.english.mvp.model.ContactModel;

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
public class ContactModule {
    private ContactContract.View view;

    /**
     * 构建ContactModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ContactModule(ContactContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ContactContract.View provideContactView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ContactContract.Model provideContactModel(ContactModel model) {
        return model;
    }
}
