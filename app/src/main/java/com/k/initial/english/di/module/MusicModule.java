package com.k.initial.english.di.module;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.MusicContract;
import com.k.initial.english.mvp.model.MusicModel;
import com.k.initial.english.mvp.model.entity.MusicEntity;
import com.k.initial.english.mvp.ui.adapter.MusicAdapter;

import java.util.ArrayList;
import java.util.List;

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
public class MusicModule {
    private MusicContract.View view;

    /**
     * 构建MusicModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MusicModule(MusicContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MusicContract.View provideMusicView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MusicContract.Model provideMusicModel(MusicModel model) {
        return model;
    }

    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new GridLayoutManager(view.getActivity_(), 1);
    }

    @ActivityScope
    @Provides
    List<MusicEntity> provideMusicEntityList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    MusicAdapter provideMusicAdapter(List<MusicEntity> list) {
        return new MusicAdapter(list);
    }
}
