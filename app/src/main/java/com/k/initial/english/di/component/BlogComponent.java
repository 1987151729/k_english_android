package com.k.initial.english.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.di.module.BlogModule;
import com.k.initial.english.mvp.ui.fragment.BlogFragment;

import dagger.Component;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 23/06/2018
 * Time: 22:19
 */
@ActivityScope
@Component(modules = BlogModule.class, dependencies = AppComponent.class)
public interface BlogComponent {
    void inject(BlogFragment fragment);
}
