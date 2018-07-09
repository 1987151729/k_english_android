package com.k.initial.english.mvp.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.k.initial.english.R;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 03/06/2018
 * Time: 09:18
 */
public class CustomToolBar extends LinearLayout {

    Button mBtnLeft;
    Button mBtnRight;

    public CustomToolBar(Context context) {
        this(context, null);
    }

    public CustomToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    /**
     * 初始化属性
     *
     * @param attrs
     */
    public void initView(AttributeSet attrs) {
        String leftTvText = "";
        String rightTvText = "";
        String titleText = "";

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomToolBar);
        // 获取左边按钮属性
        boolean isLeftBtnVisible = typedArray.getBoolean(R.styleable.CustomToolBar_hx_left_btn_visible, false);
        int leftResId = typedArray.getResourceId(R.styleable.CustomToolBar_hx_left_btn_src, -1);
        // 获取左边文本属性
        boolean isLeftTvVisible = typedArray.getBoolean(R.styleable.CustomToolBar_hx_left_tv_visible, false);
        if (typedArray.hasValue(R.styleable.CustomToolBar_hx_left_tv_text)) {
            leftTvText = typedArray.getString(R.styleable.CustomToolBar_hx_left_tv_text);
        }
        // 获取右边按钮属性
        boolean isRightBtnVisible = typedArray.getBoolean(R.styleable.CustomToolBar_hx_right_btn_visible, false);
        int rightResId = typedArray.getResourceId(R.styleable.CustomToolBar_hx_right_btn_src, -1);
        // 获取右边文本属性
        boolean isRightTvVisible = typedArray.getBoolean(R.styleable.CustomToolBar_hx_right_tv_visible, false);
        if (typedArray.hasValue(R.styleable.CustomToolBar_hx_right_tv_text)) {
            rightTvText = typedArray.getString(R.styleable.CustomToolBar_hx_right_tv_text);
        }
        // 获取标题属性
        boolean isTitleVisible = typedArray.getBoolean(R.styleable.CustomToolBar_hx_title_visible, false);
        if (typedArray.hasValue(R.styleable.CustomToolBar_hx_title_text)) {
            titleText = typedArray.getString(R.styleable.CustomToolBar_hx_title_text);
        }
        // 背景
        int backgroundResId = typedArray.getResourceId(R.styleable.CustomToolBar_hx_background, -1);

        typedArray.recycle();

        // 控件布局
        View barLayoutView = View.inflate(getContext(), R.layout.layout_common_toolbar, null);
        mBtnLeft = (Button) barLayoutView.findViewById(R.id.toolbar_left_btn);
        TextView leftTv = (TextView) barLayoutView.findViewById(R.id.toolbar_left_tv);
        TextView titleTv = (TextView) barLayoutView.findViewById(R.id.toolbar_title_tv);
        mBtnRight = (Button) barLayoutView.findViewById(R.id.toolbar_right_btn);
        TextView rightTv = (TextView) barLayoutView.findViewById(R.id.toolbar_right_tv);
        RelativeLayout barRlyt = (RelativeLayout) barLayoutView.findViewById(R.id.toolbar_content_rlyt);

        if (isLeftBtnVisible) {
            mBtnLeft.setVisibility(VISIBLE);
        }
        if (isLeftTvVisible) {
            leftTv.setVisibility(VISIBLE);
        }
        if (isRightBtnVisible) {
            mBtnRight.setVisibility(VISIBLE);
        }
        if (isRightTvVisible) {
            rightTv.setVisibility(VISIBLE);
        }
        if (isTitleVisible) {
            titleTv.setVisibility(VISIBLE);
        }
        leftTv.setText(leftTvText);
        rightTv.setText(rightTvText);
        titleTv.setText(titleText);

        if (leftResId != -1) {
            Drawable btnLeftDrawable = ContextCompat.getDrawable(getContext(), leftResId);
            btnLeftDrawable.setBounds(0, 0, btnLeftDrawable.getMinimumWidth(), btnLeftDrawable.getMinimumHeight());
            mBtnLeft.setCompoundDrawables(btnLeftDrawable, null, null, null);
        }

        if (rightResId != -1) {
            Drawable btnRightDrawable = ContextCompat.getDrawable(getContext(), rightResId);
            btnRightDrawable.setBounds(0, 0, btnRightDrawable.getMinimumWidth(), btnRightDrawable.getMinimumHeight());
            mBtnRight.setCompoundDrawables(null, null, btnRightDrawable, null);
        }

        if (backgroundResId != -1) {
            barRlyt.setBackgroundResource(backgroundResId);
        }

        //将设置完成之后的View添加到此LinearLayout中
        addView(barLayoutView, 0);
    }

    /**
     * 设置左按钮的单击事件
     */
    public void setLeftButtonClickListener(OnClickListener listener) {
        mBtnLeft.setOnClickListener(listener);
    }

    /**
     * 设置右按钮的单击事件
     */
    public void setRightButtonClickListener(OnClickListener listener) {
        mBtnRight.setOnClickListener(listener);
    }
}
