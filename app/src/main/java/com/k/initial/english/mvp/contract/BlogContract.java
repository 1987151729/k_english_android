package com.k.initial.english.mvp.contract;

import android.app.Activity;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.k.initial.english.mvp.model.entity.BlogEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 23/06/2018
 * Time: 22:25
 */
public interface BlogContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        Activity getActivity_();
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<List<BlogEntity>> getList(
                int pageIndex,
                int pageSize,
                String userID
        );
    }
}
