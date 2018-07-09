package com.k.initial.english.di.module;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.SentenceTypeContract;
import com.k.initial.english.mvp.model.SentenceTypeModel;
import com.k.initial.english.mvp.model.entity.SentenceTypeEntity;
import com.k.initial.english.mvp.ui.adapter.SentenceTypeAdapter;

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
public class SentenceTypeModule {
    private SentenceTypeContract.View view;

    /**
     * 构建SentenceTypeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SentenceTypeModule(SentenceTypeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SentenceTypeContract.View provideSentenceTypeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SentenceTypeContract.Model provideSentenceTypeModel(SentenceTypeModel model) {
        return model;
    }

    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new GridLayoutManager(view.getActivity_(), 2);
    }

    @ActivityScope
    @Provides
    List<SentenceTypeEntity> provideSentenceTypeEntityList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    RecyclerView.Adapter provideSentenceTypeAdapter(List<SentenceTypeEntity> list) {
        return new SentenceTypeAdapter(list);
    }
}
