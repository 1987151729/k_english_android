package com.k.initial.english.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.di.module.SentenceModule;
import com.k.initial.english.mvp.ui.activity.SentenceActivity;

import dagger.Component;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 11:13
 */
@ActivityScope
@Component(modules = SentenceModule.class, dependencies = AppComponent.class)
public interface SentenceComponent {
    void inject(SentenceActivity activity);
}
