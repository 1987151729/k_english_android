package com.k.initial.english.mvp.presenter;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.k.initial.english.mvp.contract.SentenceContract;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 17:04
 */
@ActivityScope
public class SentencePresenter extends BasePresenter<SentenceContract.Model, SentenceContract.View> {

    @Inject
    public SentencePresenter(SentenceContract.Model model, SentenceContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
