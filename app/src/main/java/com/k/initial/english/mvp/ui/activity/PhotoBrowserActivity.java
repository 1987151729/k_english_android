package com.k.initial.english.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.k.initial.english.R;
import com.k.initial.english.mvp.ui.fragment.PhotoBrowserFragment;
import com.k.initial.english.mvp.ui.widget.HackyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoBrowserActivity extends AppCompatActivity {

    private static final String EXTRA_IMAGE_INDEX = "IMAGE_INDEX";
    private static final String EXTRA_IMAGE_URLS = "IMAGE_URLS";

    @BindView(R.id.view_pager)
    HackyViewPager mViewPager;
    @BindView(R.id.indicator)
    TextView mTxtIndicator;

    public static void actionStart(Context context, int position, String[] urls) {
        Intent intent = new Intent(context, PhotoBrowserActivity.class);
        // 设置需要传输的参数
        intent.putExtra(EXTRA_IMAGE_INDEX, position);
        intent.putExtra(EXTRA_IMAGE_URLS, urls);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_browser);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        // 解析传输的参数
        int pagerPosition = intent.getIntExtra(EXTRA_IMAGE_INDEX, 0);
        String[] urls = intent.getStringArrayExtra(EXTRA_IMAGE_URLS);

        PhotoBrowserAdapter adapter = new PhotoBrowserAdapter(getSupportFragmentManager(), urls);
        mViewPager.setAdapter(adapter);

        CharSequence text = getString(R.string.photo_browser_indicator, 1, mViewPager.getAdapter().getCount());
        mTxtIndicator.setText(text);
        // 更新下标
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int arg0) {
                CharSequence text = getString(R.string.photo_browser_indicator, arg0 + 1, mViewPager.getAdapter().getCount());
                mTxtIndicator.setText(text);
            }
        });

        mViewPager.setCurrentItem(pagerPosition);
    }

    private class PhotoBrowserAdapter extends FragmentStatePagerAdapter {
        public String[] urls;

        public PhotoBrowserAdapter(FragmentManager fm, String[] urls) {
            super(fm);
            this.urls = urls;
        }

        @Override
        public int getCount() {
            return null == urls ? 0 : urls.length;
        }

        @Override
        public Fragment getItem(int position) {
            String url = urls[position];
            return PhotoBrowserFragment.getInstance(url);
        }
    }
}
