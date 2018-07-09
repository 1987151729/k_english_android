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
import com.k.initial.english.di.component.DaggerBlogComponent;
import com.k.initial.english.di.module.BlogModule;
import com.k.initial.english.mvp.contract.BlogContract;
import com.k.initial.english.mvp.model.entity.BlogEntity;
import com.k.initial.english.mvp.presenter.BlogPresenter;
import com.k.initial.english.mvp.ui.adapter.BlogAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends BaseFragment<BlogPresenter> implements BlogContract.View {


    @Inject
    RecyclerView.LayoutManager mLayoutManager;
    @Inject
    BlogAdapter mAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.layout_swipe_refresh)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerBlogComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .blogModule(new BlogModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blog, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initRecyclerView();
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.getList(true);

        mAdapter.setExpandStatusListener(new BlogAdapter.ExpandStatusListener() {
            @Override
            public void statusChange(int position, boolean isExpanded) {
                mPresenter.updateExpandState(position, isExpanded);
            }
        });

        mAdapter.setAvatarClickListener(new BlogAdapter.AvatarClickListener() {
            @Override
            public void onAvatarClick() {
                mPresenter.onAvatarClick();
            }
        });

        mAdapter.setNineGridImageClickListener(new BlogAdapter.NineGridImageClickListener() {
            @Override
            public void onImageClick(int index, List<String> list) {
                mPresenter.onNineGridImageClick(index, list);
            }
        });

        mAdapter.setOnItemClickListener(new DefaultAdapter.OnRecyclerViewItemClickListener<BlogEntity>() {
            @Override
            public void onItemClick(View view, int viewType, BlogEntity data, int position) {
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