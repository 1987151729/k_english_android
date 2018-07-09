package com.k.initial.english.di.module;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jess.arms.di.scope.ActivityScope;
import com.k.initial.english.mvp.contract.WordTypeContract;
import com.k.initial.english.mvp.model.WordTypeModel;
import com.k.initial.english.mvp.model.entity.WordTypeEntity;
import com.k.initial.english.mvp.ui.adapter.WordTypeAdapter;

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
public class WordTypeModule {
    private WordTypeContract.View view;

    /**
     * 构建WordTypeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public WordTypeModule(WordTypeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    WordTypeContract.View provideWordTypeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    WordTypeContract.Model provideWordTypeModel(WordTypeModel model) {
        return model;
    }

    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new GridLayoutManager(view.getActivity_(), 2);
    }

    @ActivityScope
    @Provides
    List<WordTypeEntity> provideWordTypeEntityList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    RecyclerView.Adapter provideWordTypeAdapter(List<WordTypeEntity> list) {
        return new WordTypeAdapter(list);
    }
}
