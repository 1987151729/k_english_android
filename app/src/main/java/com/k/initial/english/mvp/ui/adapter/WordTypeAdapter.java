package com.k.initial.english.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;
import com.k.initial.english.R;
import com.k.initial.english.mvp.model.entity.WordTypeEntity;
import com.k.initial.english.mvp.ui.holder.WordTypeItemHolder;

import java.util.List;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 17:11
 */
public class WordTypeAdapter extends DefaultAdapter<WordTypeEntity> {
    public WordTypeAdapter(List<WordTypeEntity> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<WordTypeEntity> getHolder(View v, int viewType) {
        return new WordTypeItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_word_type;
    }
}
