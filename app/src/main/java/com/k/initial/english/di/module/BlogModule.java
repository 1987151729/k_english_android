package com.k.initial.english.di.module;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.BlogContract;
import com.k.initial.english.mvp.model.BlogModel;
import com.k.initial.english.mvp.model.entity.BlogEntity;
import com.k.initial.english.mvp.ui.adapter.BlogAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 23/06/2018
 * Time: 22:22
 */
@Module
public class BlogModule {
    private BlogContract.View view;

    /**
     * 构建BlogModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BlogModule(BlogContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BlogContract.View provideBlogView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BlogContract.Model provideBlogModel(BlogModel model) {
        return model;
    }

    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new GridLayoutManager(view.getActivity_(), 1);
    }

    @ActivityScope
    @Provides
    List<BlogEntity> provideBlogEntityList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    BlogAdapter provideBlogAdapter(List<BlogEntity> list) {
        return new BlogAdapter(list);
    }
}
