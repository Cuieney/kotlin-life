package org.cuieney.videolife.common.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.cuieney.videolife.R;

import java.io.File;

public class ImageLoader {
    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private static class ImageLoaderHolder {
        private static final ImageLoader INSTANCE = new ImageLoader();
    }

    private ImageLoader() {
    }

    public static final ImageLoader getInstance() {
        return ImageLoaderHolder.INSTANCE;
    }

    //直接加载网络图片
    private void displayImage(String url, Context context, ImageView imageView, int placeholderImage, int failureImage) {
        Glide.with(context)
                .load(url)
                .placeholder(placeholderImage)
                .error(failureImage)
                .override(200, 200)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    public void displayImage(File url, Context context, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.bg)
                .error(R.drawable.bg)
                .override(80, 80)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    public void displayLongImage(String url, Context context, ImageView imageView) {
        displayImage(url, context, imageView, R.drawable.bg, R.drawable.bg);
    }

    //加载SD卡图片
    public void displayImage(Context context, File file, ImageView imageView) {
        Glide
                .with(context)
                .load(file)
                .centerCrop()
                .into(imageView);

    }

    //加载SD卡图片并设置大小
    public void displayImage(Context context, File file, ImageView imageView, int width, int height) {
        Glide
                .with(context)
                .load(file)
                .override(width, height)
                .into(imageView);

    }

    //加载网络图片并设置大小
    public void displayImage(Context context, String url, ImageView imageView, int width, int height) {
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .override(width, height)
                .crossFade()
                .into(imageView);
    }

    //加载drawable图片
    public void displayImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .crossFade()
                .into(imageView);
    }

    //加载drawable图片显示为圆形图片
    public void displayCricleImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    //加载网络图片显示为圆形图片
    public void displayCricleImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .override(80, 80)
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    //加载SD卡图片显示为圆形图片
    public void displayHeadImage(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                //.centerCrop()
                .override(40, 40)

                .error(R.drawable.bg)
                .transform(new GlideCircleTransform(context))
                .into(imageView);

    }

    //将资源ID转为Uri
    public Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    public void displayBlurImage(File url, Context context, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.bg)
                .error(R.drawable.bg)
                .override(100, 100)
                .transform(new BlurTransformation(context))
                .into(imageView);
    }

    public static void load(Activity activity, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
        if (!activity.isDestroyed()) {
            Glide.with(activity).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        }
    }

    public static void loadAll(Context context, String url, ImageView iv) {    //不缓存，全部从网络加载
//        SimpleTarget target2 = new SimpleTarget<Bitmap>(250, 250) {
//            @Override
//            public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
//                iv.setImageBitmap(bitmap);
//            }
//        };
        Glide.with(context).load(url).crossFade().skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(iv);
    }

    public static void loadAll(Activity activity, String url, ImageView iv) {    //不缓存，全部从网络加载
        if (!activity.isDestroyed()) {
            Glide.with(activity).load(url).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(iv);
        }
    }

}