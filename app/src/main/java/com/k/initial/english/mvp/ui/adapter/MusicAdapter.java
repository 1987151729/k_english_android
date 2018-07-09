package com.k.initial.english.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;
import com.k.initial.english.R;
import com.k.initial.english.mvp.model.entity.MusicEntity;
import com.k.initial.english.mvp.ui.holder.MusicItemHolder;

import java.util.List;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 17:10
 */
public class MusicAdapter extends DefaultAdapter<MusicEntity> {

    private ExpandStatusListener mExpandStatusListener;

    public MusicAdapter(List<MusicEntity> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<MusicEntity> getHolder(View v, int viewType) {
        MusicItemHolder holder = new MusicItemHolder(v);
        holder.setExpandStatusListener(new MusicItemHolder.ExpandStatusListener() {
            @Override
            public void statusChange(int position, boolean isExpanded) {
                if (null != mExpandStatusListener) {
                    mExpandStatusListener.statusChange(position, isExpanded);
                }
            }
        });
        return holder;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_music;
    }


    public void setExpandStatusListener(ExpandStatusListener listener) {
        this.mExpandStatusListener = listener;
    }

    public interface ExpandStatusListener {
        void statusChange(int position, boolean isExpanded);
    }
}