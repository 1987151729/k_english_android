package com.k.initial.english.mvp.presenter;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.k.initial.english.mvp.contract.MineContract;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 17:01
 */
@ActivityScope
public class MinePresenter extends BasePresenter<MineContract.Model, MineContract.View> {

    @Inject
    public MinePresenter(MineContract.Model model, MineContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
