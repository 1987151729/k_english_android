package com.k.initial.english.mvp.ui.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;
import com.k.initial.english.R;
import com.k.initial.english.mvp.model.entity.SentenceTypeEntity;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * UserEntity: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 18/05/2018
 * Time: 17:16
 */
public class SentenceTypeItemHolder extends BaseHolder<SentenceTypeEntity> {

    @BindView(R.id.item_box)
    LinearLayout mLayoutBox;
    @BindView(R.id.name)
    TextView mTxtName;
    @BindView(R.id.description)
    TextView mTxtDescription;

    public SentenceTypeItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(SentenceTypeEntity data, int position) {
        if (0 == position) {
            mLayoutBox.setBackgroundResource(R.drawable.icon_rectangle_bg2);
        } else {
            mLayoutBox.setBackgroundResource(R.drawable.icon_rectangle_bg3);
        }
        mTxtName.setText(data.getName());
        mTxtDescription.setText(data.getDescription());
    }

    @Override
    protected void onRelease() {
    }
}
