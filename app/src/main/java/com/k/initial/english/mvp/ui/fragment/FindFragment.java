package com.k.initial.english.mvp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.k.initial.english.R;
import com.k.initial.english.di.component.DaggerFindComponent;
import com.k.initial.english.di.module.FindModule;
import com.k.initial.english.mvp.contract.FindContract;
import com.k.initial.english.mvp.presenter.FindPresenter;

import java.util.ArrayList;

import butterknife.BindString;
import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment<FindPresenter> implements FindContract.View {

    String[] mTabTitles;
    ArrayList<Fragment> mFragments;

    @BindString(R.string.find_tab_word)
    String mTabTitle0;
    @BindString(R.string.find_tab_sentence)
    String mTabTitle1;
    @BindString(R.string.find_tab_music)
    String mTabTitle2;

    @BindView(R.id.layout_tab)
    SegmentTabLayout mTab;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerFindComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .findModule(new FindModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initTab();
    }

    private void initTab() {
        mTabTitles = new String[]{
                mTabTitle0,
                mTabTitle1,
                mTabTitle2
        };

        mFragments = new ArrayList<>();
        mFragments.add(new WordTypeFragment());
        mFragments.add(new SentenceTypeFragment());
        mFragments.add(new MusicFragment());

        mViewPager.setAdapter(new TabPagerAdapter(getChildFragmentManager()));
        mViewPager.setOffscreenPageLimit(3);

        mTab.setTabData(mTabTitles);
        mTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setCurrentItem(0);
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {
        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
