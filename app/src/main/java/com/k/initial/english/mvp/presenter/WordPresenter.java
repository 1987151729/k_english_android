package com.k.initial.english.mvp.presenter;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.k.initial.english.mvp.contract.WordContract;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 17:05
 */
@ActivityScope
public class WordPresenter extends BasePresenter<WordContract.Model, WordContract.View> {

    @Inject
    public WordPresenter(WordContract.Model model, WordContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
