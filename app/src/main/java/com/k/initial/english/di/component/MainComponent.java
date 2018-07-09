package com.k.initial.english.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.di.module.MainModule;
import com.k.initial.english.mvp.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 15/05/2018
 * Time: 15:35
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
