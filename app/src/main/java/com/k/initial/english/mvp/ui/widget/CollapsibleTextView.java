package com.k.initial.english.mvp.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.k.initial.english.R;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 09/06/2018
 * Time: 17:23
 */
public class CollapsibleTextView extends LinearLayout {

    public static final int DEFAULT_MAX_LINES = 3;
    public static final int DEFAULT_TEXTSIZE = 14;
    private TextView mTxtContent;
    private TextView mTxtTail;

    private int mMaxLines;
    private float mTextSize;
    private ExpandStatusListener mExpandStatusListener;
//    private ContentClickListener mContentClickListener;
    private boolean mIsExpanded = false;

    public CollapsibleTextView(Context context) {
        super(context);
        initView();
    }

    public CollapsibleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
        initView();
    }

    public CollapsibleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        initView();
    }

    private void initView() {
        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_collapsible_text, this);
        mTxtContent = (TextView) findViewById(R.id.txtContent);
        mTxtContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, mTextSize);
        if (mMaxLines > 0) {
            mTxtContent.setMaxLines(mMaxLines);
        }

//        mTxtContent.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (null != mContentClickListener) {
//                    mContentClickListener.onClick();
//                }
//            }
//        });

        mTxtTail = (TextView) findViewById(R.id.txtTail);
        mTxtTail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mIsExpanded) {
                    setExpanded(true);
                } else {
                    setExpanded(false);
                }

                setExpandedTxt();

                if (null != mExpandStatusListener) {
                    mExpandStatusListener.statusChange(mIsExpanded);
                }
            }
        });
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CollapsibleTextView, 0, 0);
        try {
            mMaxLines = typedArray.getInt(R.styleable.CollapsibleTextView_hx_max_lines, DEFAULT_MAX_LINES);
            mTextSize = typedArray.getFloat(R.styleable.CollapsibleTextView_hx_text_size, DEFAULT_TEXTSIZE);
        } finally {
            typedArray.recycle();
        }
    }

    public void setText(final CharSequence content) {
        mTxtContent.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {
                mTxtContent.getViewTreeObserver().removeOnPreDrawListener(this);
                int lineCount = mTxtContent.getLineCount();
                if (lineCount > mMaxLines) {
                    setExpandedTxt();

                    mTxtTail.setVisibility(View.VISIBLE);
                } else {
                    mTxtTail.setVisibility(View.GONE);
                }
                return true;
            }
        });
        mTxtContent.setText(content);
    }

    private void setExpandedTxt() {
        if (mIsExpanded) {
            mTxtContent.setMaxLines(Integer.MAX_VALUE);
            mTxtTail.setText(getContext().getString(R.string.collapsibletextview_txt_expand_status_expanded));
        } else {
            mTxtContent.setMaxLines(mMaxLines);
            mTxtTail.setText(getContext().getString(R.string.collapsibletextview_txt_expand_status_notexpanded));
        }
    }

    public void setExpanded(boolean isExpanded) {
        this.mIsExpanded = isExpanded;
    }

    public void setExpandStatusListener(ExpandStatusListener listener) {
        this.mExpandStatusListener = listener;
    }

//    public void setContentClickListener(ContentClickListener listener) {
//        this.mContentClickListener = listener;
//    }

    public interface ExpandStatusListener {
        void statusChange(boolean isExpanded);
    }

//    public interface ContentClickListener {
//        void onClick();
//    }
}
