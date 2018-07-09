package com.k.initial.english.mvp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;
import android.support.v7.widget.RecyclerView;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;
import com.k.initial.english.mvp.contract.SentenceTypeContract;
import com.k.initial.english.mvp.model.entity.SentenceTypeEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 17:02
 */
@ActivityScope
public class SentenceTypePresenter extends BasePresenter<SentenceTypeContract.Model, SentenceTypeContract.View> {

    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    List<SentenceTypeEntity> mList;
    @Inject
    RecyclerView.Adapter mAdapter;
    private int preEndIndex;

    @Inject
    public SentenceTypePresenter(SentenceTypeContract.Model model, SentenceTypeContract.View rootView) {
        super(model, rootView);
    }

    /**
     * 使用 2017 Google IO 发布的 Architecture Components 中的 Lifecycles 的新特性 (此特性已被加入 Support library)
     * 使 {@code Presenter} 可以与 {@link SupportActivity} 和 {@link Fragment} 的部分生命周期绑定
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
//        getList(true); // 打开 App 时自动加载列表
    }

    public void getList(final boolean pullToRefresh) {
        mModel.getList()
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
                    if (pullToRefresh) {
                        mRootView.showLoading();//显示下拉刷新的进度条
                    } else {
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    if (pullToRefresh) {
                        mRootView.hideLoading();//隐藏下拉刷新的进度条
                    } else {
                    }
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<List<SentenceTypeEntity>>(mErrorHandler) {
                    @Override
                    public void onNext(List<SentenceTypeEntity> data) {
                        if (pullToRefresh) {
                            mList.clear();//如果是下拉刷新则清空列表
                        }

                        preEndIndex = mList.size();//更新之前列表总长度,用于确定加载更多的起始位置
                        mList.addAll(data);

                        if (pullToRefresh) {
                            mAdapter.notifyDataSetChanged();
                        } else {
                            mAdapter.notifyItemRangeInserted(preEndIndex, data.size());
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mAdapter = null;
        this.mList = null;
        this.mErrorHandler = null;
    }
}
