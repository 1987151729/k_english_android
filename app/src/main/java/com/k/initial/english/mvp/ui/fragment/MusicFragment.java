package com.k.initial.english.mvp.ui.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.k.initial.english.R;
import com.k.initial.english.di.component.DaggerMusicComponent;
import com.k.initial.english.di.module.MusicModule;
import com.k.initial.english.mvp.contract.MusicContract;
import com.k.initial.english.mvp.model.entity.MusicEntity;
import com.k.initial.english.mvp.presenter.MusicPresenter;
import com.k.initial.english.mvp.ui.adapter.MusicAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends BaseFragment<MusicPresenter> implements MusicContract.View {

    @Inject
    RecyclerView.LayoutManager mLayoutManager;
    @Inject
    MusicAdapter mAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.layout_swipe_refresh)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerMusicComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .musicModule(new MusicModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initRecyclerView();
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.getList(true);

        mAdapter.setExpandStatusListener(new MusicAdapter.ExpandStatusListener() {
            @Override
            public void statusChange(int position, boolean isExpanded) {
                mPresenter.updateExpandState(position, isExpanded);
            }
        });

        mAdapter.setOnItemClickListener(new DefaultAdapter.OnRecyclerViewItemClickListener<MusicEntity>() {
            @Override
            public void onItemClick(View view, int viewType, MusicEntity data, int position) {
                switch (view.getId()) {
                    case R.id.txtContent:
                        Toast.makeText(getContext(), "pppp", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.txtTail:
                        Toast.makeText(getContext(), "xxxxx", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.description:
                        Toast.makeText(getContext(), "uuuuu", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getContext(), "ooooooo" + position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


    @Override
    public void setData(Object data) {
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        ArmsUtils.configRecyclerView(mRecyclerView, mLayoutManager);

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getList(true);
                refreshlayout.finishRefresh(500/*,false*/);//传入false表示刷新失败
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                mPresenter.getList(false);
                refreshlayout.finishLoadMore(500/*,false*/);//传入false表示加载失败
            }
        });
    }

    @Override
    public void showLoading() {
        Timber.tag(TAG).w("showLoading");
    }

    @Override
    public void hideLoading() {
        Timber.tag(TAG).w("hideLoading");
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
    public Activity getActivity_() {
        return this.getActivity();
    }

    @Override
    public void onDestroy() {
        DefaultAdapter.releaseAllHolder(mRecyclerView);//super.onDestroy()之后会unbind,所有view被置为null,所以必须在之前调用
        super.onDestroy();
    }

}