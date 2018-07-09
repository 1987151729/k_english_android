package com.k.initial.english.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;
import com.k.initial.english.R;
import com.k.initial.english.mvp.model.entity.BlogEntity;
import com.k.initial.english.mvp.ui.holder.BlogItemHolder;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 24/06/2018
 * Time: 09:56
 */
public class BlogAdapter extends DefaultAdapter<BlogEntity> {

    private ExpandStatusListener mExpandStatusListener;
    private AvatarClickListener mAvatarClickListener;
    private NineGridImageClickListener mNineGridImageClickListener;

    public BlogAdapter(List<BlogEntity> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<BlogEntity> getHolder(View v, int viewType) {
        BlogItemHolder holder = new BlogItemHolder(v);

        holder.setExpandStatusListener(new BlogItemHolder.ExpandStatusListener() {
            @Override
            public void statusChange(int position, boolean isExpanded) {
                if (null != mExpandStatusListener) {
                    mExpandStatusListener.statusChange(position, isExpanded);
                }
            }
        });

        holder.setAvatarClickListener(new BlogItemHolder.AvatarClickListener() {
            @Override
            public void onAvatarClick() {
                if (null != mAvatarClickListener) {
                    mAvatarClickListener.onAvatarClick();
                }
            }
        });

        holder.setNineGridImageClickListener(new BlogItemHolder.NineGridImageClickListener() {
            @Override
            public void onImageClick(int index, List<String> list) {
                if (null != mNineGridImageClickListener) {
                    mNineGridImageClickListener.onImageClick(index, list);
                }
            }
        });

        return holder;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_blog;
    }

    public interface ExpandStatusListener {
        void statusChange(int position, boolean isExpanded);
    }

    public void setExpandStatusListener(ExpandStatusListener listener) {
        this.mExpandStatusListener = listener;
    }

    public interface AvatarClickListener {
        void onAvatarClick();
    }

    public void setAvatarClickListener(AvatarClickListener listener) {
        this.mAvatarClickListener = listener;
    }

    public interface NineGridImageClickListener {
        void onImageClick(int index, List<String> list);
    }

    public void setNineGridImageClickListener(NineGridImageClickListener listener) {
        this.mNineGridImageClickListener = listener;
    }
}
