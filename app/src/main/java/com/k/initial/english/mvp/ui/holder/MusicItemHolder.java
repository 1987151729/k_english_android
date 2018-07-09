package com.k.initial.english.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.k.initial.english.R;
import com.k.initial.english.mvp.model.entity.MusicEntity;
import com.k.initial.english.mvp.ui.widget.CollapsibleTextView;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 17:16
 */
public class MusicItemHolder extends BaseHolder<MusicEntity> {

    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用 Glide,使用策略模式,可替换框架
    private ExpandStatusListener mExpandStatusListener;

    @BindView(R.id.img)
    ImageView mImgImg;
    @BindView(R.id.title)
    TextView mTxtTitle;
    @BindView(R.id.description)
    CollapsibleTextView mTxtDescription;

    public MusicItemHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到 Context 的地方,拿到 AppComponent,从而得到用 Dagger 管理的单例对象
        mAppComponent = ArmsUtils.obtainAppComponentFromContext(itemView.getContext());
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public void setData(MusicEntity item, int position) {
        mTxtTitle.setText(item.getTitle());
        mTxtDescription.setExpanded(item.getIsExpanded());
        mTxtDescription.setText(item.getDescription());

        mTxtDescription.setExpandStatusListener(new CollapsibleTextView.ExpandStatusListener() {
            @Override
            public void statusChange(boolean isExpanded) {
                if (null != mExpandStatusListener) {
                    mExpandStatusListener.statusChange(position, isExpanded);
                }
            }
        });

        //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
        mImageLoader.loadImage(itemView.getContext(),
                ImageConfigImpl
                        .builder()
                        .url(item.getImg())
                        .imageView(mImgImg)
                        .build());
    }

    @Override
    protected void onRelease() {
        mImageLoader.clear(mAppComponent.application(),
                ImageConfigImpl.builder()
                        .imageViews(mImgImg)
                        .build());
    }

    public interface ExpandStatusListener {
        void statusChange(int position, boolean isExpanded);
    }

    public void setExpandStatusListener(ExpandStatusListener listener) {
        this.mExpandStatusListener = listener;
    }
}
