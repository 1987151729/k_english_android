package com.k.initial.english.mvp.ui.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.StringUtils;
import com.jaeger.ninegridimageview.ItemImageClickListener;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.k.initial.english.R;
import com.k.initial.english.mvp.model.bean.UserInfo0;
import com.k.initial.english.mvp.model.entity.BlogEntity;
import com.k.initial.english.mvp.ui.widget.CollapsibleTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.jaeger.ninegridimageview.NineGridImageView.NOSPAN;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 24/06/2018
 * Time: 10:16
 */
public class BlogItemHolder extends BaseHolder<BlogEntity> {
    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用 Glide,使用策略模式,可替换框架
    private ExpandStatusListener mExpandStatusListener;
    private AvatarClickListener mAvatarClickListener;
    private NineGridImageClickListener mNineGridImageClickListener;

    @BindView(R.id.avatar)
    ImageView mImgAvatar;
    @BindView(R.id.name)
    TextView mTxtName;
    @BindView(R.id.sex_bg)
    RelativeLayout mLayoutSexBg;
    @BindView(R.id.sex)
    ImageView mImgSex;
    @BindView(R.id.age)
    TextView mTxtAge;
    @BindView(R.id.city)
    TextView mTxtCity;

    @BindView(R.id.content)
    CollapsibleTextView mTxtContent;
    @BindView(R.id.imgs)
    NineGridImageView<String> mLayoutImgs;
    @BindView(R.id.checked_num)
    TextView mTxtCheckNum;
    @BindView(R.id.liked_num)
    TextView mTxtLikeNum;
    @BindView(R.id.commented_num)
    TextView mTxtCommentNum;
    @BindView(R.id.time)
    TextView mTxtTime;

    public BlogItemHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到 Context 的地方,拿到 AppComponent,从而得到用 Dagger 管理的单例对象
        mAppComponent = ArmsUtils.obtainAppComponentFromContext(itemView.getContext());
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public void setData(BlogEntity item, int position) {
        // 注意NineGridImageView的setAdapter方法要在setImagesData之前
        mLayoutImgs.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String url) {
                mImageLoader.loadImage(itemView.getContext(),
                        ImageConfigImpl
                                .builder()
                                .url(url)
                                .imageView(imageView)
                                .build());
            }

            @Override
            protected ImageView generateImageView(Context context) {
                return super.generateImageView(context);
            }

            @Override
            protected void onItemImageClick(Context context, ImageView imageView, int index, List<String> list) {
                Toast.makeText(context, "image position is " + index, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected boolean onItemImageLongClick(Context context, ImageView imageView, int index, List<String> list) {
                Toast.makeText(context, "image long click position is " + index, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        // 用户信息部分
        final UserInfo0 user = item.getUser();
        //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
        mImageLoader.loadImage(itemView.getContext(),
                ImageConfigImpl
                        .builder()
                        .url(user.getAvatar())
                        .imageView(mImgAvatar)
                        .build());

        mTxtName.setText(user.getName());
//        if (Constants.Enum.Sex.FEMALE == user.getSex()) {
//            // 女
//            mLayoutSexBg.setBackgroundResource(R.drawable.icon_female_bg);
//            mImgSex.setImageResource(R.drawable.icon_female);
//        } else {
//            // 男
//            mLayoutSexBg.setBackgroundResource(R.drawable.icon_male_bg);
//            mImgSex.setImageResource(R.drawable.icon_male);
//        }
//        mTxtAge.setText(String.valueOf(user.getAge()));
//        mTxtCity.setText(user.getCity());
        // 说说部分
        String content = item.getContent();
        if (StringUtils.isEmpty(content)) {
            mTxtContent.setVisibility(View.GONE);
            mTxtContent.setText("");
        } else {
            mTxtContent.setVisibility(View.VISIBLE);
            mTxtContent.setText(content);
        }
        String imgs = item.getImgs();
        final String imgUrls[];
        if (StringUtils.isEmpty(imgs)) {
            imgUrls = null;
            mLayoutImgs.setVisibility(View.GONE);
        } else {
            imgUrls = imgs.split(",");
            List<String> urlList = new ArrayList<>();
            for (int j = 0; j < imgUrls.length; j++) {
                String imgUrl = imgUrls[j];
                if (!StringUtils.isEmpty(imgUrl)) {
                    urlList.add(imgUrl);
                }
            }
            mLayoutImgs.setVisibility(View.VISIBLE);
            mLayoutImgs.setImagesData(urlList, NOSPAN); //
        }
        mTxtCheckNum.setText(String.valueOf(item.getCheckNum()));
        mTxtLikeNum.setText(String.valueOf(item.getLikeNum()));
        mTxtCommentNum.setText(String.valueOf(item.getCommentNum()));
//        mTxtTime.setText(DateUtils.countTimeBetween(DateUtils.dateToString(item.getCreatedAt())));

        // 全文/收起
        mTxtContent.setExpandStatusListener(new CollapsibleTextView.ExpandStatusListener() {
            @Override
            public void statusChange(boolean isExpanded) {
                if (null != mExpandStatusListener) {
                    mExpandStatusListener.statusChange(position, isExpanded);
                }
            }
        });

        // 头像点击跳转到个人中心
        mImgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mAvatarClickListener) {
                    mAvatarClickListener.onAvatarClick();
                }
            }
        });

        // 图片列表点击，浏览大图
        mLayoutImgs.setItemImageClickListener(new ItemImageClickListener<String>() {
            @Override
            public void onItemImageClick(Context context, ImageView imageView, int index, List<String> list) {
                if (null != mNineGridImageClickListener) {
                    mNineGridImageClickListener.onImageClick(index, list);
                }
            }
        });
    }

    @Override
    protected void onRelease() {
        mImageLoader.clear(mAppComponent.application(),
                ImageConfigImpl.builder()
                        .imageViews(mImgAvatar)
                        .build());
    }

    public interface ExpandStatusListener {
        void statusChange(int position, boolean isExpanded);
    }

    public void setExpandStatusListener(ExpandStatusListener listener) {
        this.mExpandStatusListener = listener;
    }

    public interface AvatarClickListener {
        void onAvatarClick();
    }

    public void setAvatarClickListener(AvatarClickListener listener) {
        this.mAvatarClickListener = listener;
    }

    public interface NineGridImageClickListener {
        void onImageClick(int index, List<String> list);
    }

    public void setNineGridImageClickListener(NineGridImageClickListener listener) {
        this.mNineGridImageClickListener = listener;
    }
}
