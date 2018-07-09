package com.k.initial.english.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.di.module.MusicModule;
import com.k.initial.english.mvp.ui.fragment.MusicFragment;

import dagger.Component;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 11:11
 */
@ActivityScope
@Component(modules = MusicModule.class, dependencies = AppComponent.class)
public interface MusicComponent {
    void inject(MusicFragment fragment);
}
