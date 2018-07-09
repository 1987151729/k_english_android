package com.k.initial.english.mvp.presenter;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;
import com.k.initial.english.R;
import com.k.initial.english.app.Constants;
import com.k.initial.english.mvp.contract.BlogContract;
import com.k.initial.english.mvp.model.entity.BlogEntity;
import com.k.initial.english.mvp.ui.activity.PhotoBrowserActivity;
import com.k.initial.english.mvp.ui.adapter.BlogAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;
import timber.log.Timber;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 24/06/2018
 * Time: 09:50
 */
@ActivityScope
public class BlogPresenter extends BasePresenter<BlogContract.Model, BlogContract.View> {

    private final int PAGE_SIZE = 20;

    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    List<BlogEntity> mList;
    @Inject
    BlogAdapter mAdapter;
    private int preEndIndex;
    private int pageIndex;

    @Inject
    public BlogPresenter(BlogContract.Model model, BlogContract.View rootView) {
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

    public void updateExpandState(int position, boolean isExpanded) {
        BlogEntity item = mList.get(position);
        item.setIsExpanded(isExpanded);
        mList.set(position, item);
    }

    public void onAvatarClick() {
        SharedPreferences sp = mRootView.getActivity_().getSharedPreferences(Constants.SharedPreferencesKeys.INSTANCE, Activity.MODE_PRIVATE);
        String userID = sp.getString(Constants.SharedPreferencesKeys.USER_ID, "");
        if (StringUtils.isEmpty(userID)) {
            ToastUtils.showShort(R.string.system_tip_please_login);
        } else {
//                    UserInfoActivity.actionStart(itemView.getContext(), user.getUserID());
        }
    }

    public void onNineGridImageClick(int index, List<String> list) {
        SharedPreferences sp = mRootView.getActivity_().getSharedPreferences(Constants.SharedPreferencesKeys.INSTANCE, Activity.MODE_PRIVATE);
        String userID = sp.getString(Constants.SharedPreferencesKeys.USER_ID, "");
        if (!StringUtils.isEmpty(userID)) {
            // 添加查看记录
        }

        // 浏览大图
        ToastUtils.showShort("iiiiii");
        PhotoBrowserActivity.actionStart(mRootView.getActivity_(), index, list.toArray(new String[list.size()]));
    }

    public void getList(final boolean pullToRefresh) {
        if (pullToRefresh) {
            pageIndex = 1;
        } else {
            pageIndex++; //
        }

        SharedPreferences sp = mRootView.getActivity_().getSharedPreferences(Constants.SharedPreferencesKeys.INSTANCE, Activity.MODE_PRIVATE);
        String userID = sp.getString(Constants.SharedPreferencesKeys.USER_ID, "");

        mModel.getList(pageIndex, PAGE_SIZE, userID)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
                    if (pullToRefresh) {
//                        mRootView.showLoading();//显示下拉刷新的进度条
                    } else {
                        Timber.w("xxxxxxxxxxxxxxxxxxxxx: -0");
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    if (pullToRefresh) {
//                        mRootView.hideLoading();//隐藏下拉刷新的进度条
                    } else {
                        Timber.w("xxxxxxxxxxxxxxxxxxxxx: -1");
                    }
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<List<BlogEntity>>(mErrorHandler) {
                    @Override
                    public void onNext(List<BlogEntity> data) {
                        if (pullToRefresh) {
                            mList.clear(); // 如果是下拉刷新则清空列表
                        }

                        preEndIndex = mList.size(); // 更新之前列表总长度,用于确定加载更多的起始位置
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
