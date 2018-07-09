package com.k.initial.english.mvp.ui.fragment;


import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.OnMatrixChangedListener;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.OnSingleFlingListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.k.initial.english.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoBrowserFragment extends BaseFragment {

    private AppComponent mAppComponent;
    private ImageLoader mImageLoader; // 用于加载图片的管理类,默认使用 Glide,使用策略模式,可替换框架
    private String url;

    @BindView(R.id.photo_view)
    PhotoView mPhotoView;

    public static PhotoBrowserFragment getInstance(String url) {
        final PhotoBrowserFragment fragment = new PhotoBrowserFragment();
        final Bundle args = new Bundle();
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_photo_browser, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //可以在任何可以拿到 Context 的地方,拿到 AppComponent,从而得到用 Dagger 管理的单例对象
        mAppComponent = ArmsUtils.obtainAppComponentFromContext(getContext());
        mImageLoader = mAppComponent.imageLoader();

        url = null != getArguments() ? getArguments().getString("url") : null;
//        mPhotoView.setImageURI(Uri.parse(url));
//        mPhotoView.setImageResource(R.drawable.default_avatar);
        mImageLoader.loadImage(getContext(),
                ImageConfigImpl
                        .builder()
                        .url(url)
                        .imageView(mPhotoView)
                        .build());

        // Lets attach some listeners, not required though!
        mPhotoView.setOnMatrixChangeListener(new MatrixChangeListener());
        mPhotoView.setOnPhotoTapListener(new PhotoTapListener());
        mPhotoView.setOnSingleFlingListener(new SingleFlingListener());
    }

    private class PhotoTapListener implements OnPhotoTapListener {

        @Override
        public void onPhotoTap(ImageView view, float x, float y) {
//            float xPercentage = x * 100f;
//            float yPercentage = y * 100f;
        }
    }

    private class MatrixChangeListener implements OnMatrixChangedListener {

        @Override
        public void onMatrixChanged(RectF rect) {
        }
    }

    private class SingleFlingListener implements OnSingleFlingListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return true;
        }
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
