package com.example.administrator.fragmentdemo.utils.imageload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.utils.DisplayUtils;

/**
 * Created by Administrator on 2016-04-10.
 */
public class ImageLoader {
    private final int mDefaultImageId = R.drawable.transparenc_shape;
    private final int mErrorImageId = R.mipmap.icon_user_avatar;

    /**
     * 加载正方形用户头像
     *
     * @param mContext
     * @param avatarUrl
     * @param iv
     */
    public static void loadSquareAvatar(Context mContext, String avatarUrl, ImageView iv) {

        if (TextUtils.isEmpty(avatarUrl)) {
            iv.setImageResource(R.mipmap.icon_user_avatar);
            return;
        }

        Glide.with(mContext)
                .load(avatarUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.icon_user_avatar)
                .error(R.mipmap.icon_user_avatar)
                .into(iv);
    }

    /**
     * 加载圆形图片
     *
     * @param mContext
     * @param url
     */
    public static void loadCircleImage(Context mContext, String url, int defaultId, ImageView image) {

        if (TextUtils.isEmpty(url)) {
            image.setImageResource(R.mipmap.icon_user_avatar);
            return;
        }

        Glide.with(mContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .transform(new GlideCircleTransform(mContext))
                .placeholder(defaultId == -1 ? R.drawable.transparenc_shape : defaultId)
                .error(defaultId == -1 ? R.drawable.transparenc_shape : defaultId)
                .into(image);
    }

    /**
     * 加载圆角图片
     *
     * @param mContext
     * @param url
     * @param defaultId
     * @param image
     */
    public static void loadRoundImage(Context mContext, String url, int defaultId, ImageView image) {
        loadRoundImage(mContext, url, 4, defaultId, image);
    }

    public static void loadRoundImage(Context mContext, String url, int radius, int defaultId, ImageView image) {
        if (TextUtils.isEmpty(url)) {
            image.setImageResource(R.mipmap.icon_user_avatar);
            return;
        }
        Glide.with(mContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .transform(new GlideRoundTransform(mContext, radius))
                .placeholder(defaultId == -1 ? R.drawable.transparenc_shape : defaultId)
                .error(defaultId == -1 ? R.drawable.transparenc_shape : defaultId)
                .into(image);
    }

    /**
     * 加载普通图片
     *
     * @param mContext
     * @param url
     * @param iv
     */
    public static void loadNormalImage(Context mContext, String url, int defaultId, ImageView iv) {

        if (TextUtils.isEmpty(url)) {
            iv.setImageResource(defaultId);
            return;
        }

        Glide.with(mContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(defaultId == -1 ? R.drawable.transparenc_shape : defaultId)
                .error(defaultId == -1 ? R.drawable.transparenc_shape : defaultId)
                .into(iv);
    }

    /**
     * 带监听的加载
     *
     * @param mContext
     * @param url
     * @param defaultId
     * @param listener
     * @param iv
     */
    public static void loadNormalImage(Context mContext, String url, int defaultId, GlideDrawableImageViewTarget listener, ImageView iv) {
        if (TextUtils.isEmpty(url)) {
            iv.setImageResource(defaultId);
            return;
        }

        Glide.with(mContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(defaultId == -1 ? R.drawable.transparenc_shape : defaultId)
                .error(defaultId == -1 ? R.drawable.transparenc_shape : defaultId)
                .into(listener);
    }

    public static void loadFullWidthImage(final Context mContext, String url, final int defaultId, final ImageView iv) {
        if (TextUtils.isEmpty(url)) {
            iv.setImageResource(defaultId);
            return;
        }

        Glide.with(mContext).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int swidth = DisplayUtils.getScreenWidthpx(mContext);
                float width_rate = (float) width / swidth;
                ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
                layoutParams.height = (int) (height / width_rate);
                iv.setLayoutParams(layoutParams);
                iv.setImageBitmap(bitmap);
            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                iv.setImageResource(defaultId == -1 ? R.drawable.transparenc_shape : defaultId);
            }
        });
    }


//
//    /**
//     *加载Gif静态图
//     * @param mContext
//     * @param url
//     * @param iv
//     */
//    public static void loadGifBitmap(final Context mContext, String url, final ImageView iv) {
//        if (TextUtils.isEmpty(url)) {
//            iv.setImageResource(R.mipmap.icon_user_avatar);
//            return;
//        }
//        Glide.with(mContext)
//                .load(url)
//                .asBitmap()
//                .into(iv);
//
//    }
//
//    /**
//     * 加载Gif动态图
//     * @param mContext
//     * @param url
//     * @param iv
//     */
//    public static void loadGifImage(final Context mContext, String url, final ImageView iv) {
//        if (TextUtils.isEmpty(url)) {
//            iv.setImageResource(R.mipmap.icon_user_avatar);
//            return;
//        }
//        Glide.with(mContext)
//                .load(url)
//                .asGif()
//                .into(iv);
//    }

}
