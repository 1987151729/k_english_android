package com.k.initial.english.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.k.initial.english.R;
import com.k.initial.english.di.component.DaggerMainComponent;
import com.k.initial.english.di.module.MainModule;
import com.k.initial.english.mvp.contract.MainContract;
import com.k.initial.english.mvp.presenter.MainPresenter;
import com.k.initial.english.mvp.ui.fragment.BlogFragment;
import com.k.initial.english.mvp.ui.fragment.FindFragment;
import com.k.initial.english.mvp.ui.fragment.MineFragment;
import com.k.initial.english.mvp.ui.fragment.NewsFragment;
import com.k.initial.english.mvp.ui.widget.flycotab.TabEntity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Inject
    RxPermissions mRxPermissions;

    @BindString(R.string.main_tab_home)
    String mTabTitle0;
    @BindString(R.string.main_tab_find)
    String mTabTitle1;
    @BindString(R.string.main_tab_news)
    String mTabTitle3;
    @BindString(R.string.main_tab_mine)
    String mTabTitle4;

    @BindView(R.id.layout_tab)
    CommonTabLayout mTab;
    @BindView(R.id.tab_main_center)
    ImageButton mTabCenter;


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initTab();
    }

    private void initTab() {
        String[] mTabTitles = {
                mTabTitle0,
                mTabTitle1,
                "",
                mTabTitle3,
                mTabTitle4
        };
        int[] mTabIconUnselectIds = {
                R.drawable.tab_main_home,
                R.drawable.tab_main_find,
                R.drawable.icon_dot,
                R.drawable.tab_main_news,
                R.drawable.tab_main_mine
        };
        int[] mTabIconSelectIds = {
                R.drawable.tab_main_home_focused,
                R.drawable.tab_main_find_focused,
                R.drawable.icon_dot,
                R.drawable.tab_main_news_focused,
                R.drawable.tab_main_mine_focused
        };

        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        for (int i = 0; i < mTabTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTabTitles[i], mTabIconSelectIds[i], mTabIconUnselectIds[i]));
        }

        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new BlogFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new Fragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new MineFragment());

        mTab.setTabData(mTabEntities, this, R.id.layout_container, mFragments);
        mTab.setCurrentTab(0);
        mTab.showDot(3); // 显示未读红点
        mTab.setSpecialTab(2); // 设置特殊的tab
        mTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                // 这里是FlycoTabLayout的tab点击事件
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    @OnClick(R.id.tab_main_center)
    public void onClick(View v) {
        Toast.makeText(this, "中间凸起按钮点击了miao", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
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