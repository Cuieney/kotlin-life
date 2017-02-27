package org.cuieney.videolife.common.image;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.orhanobut.logger.Logger;


public class AppGlideModule extends OkHttpGlideModule {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        // Prefer higher quality images unless we're on a low RAM device
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize()/4;
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize()/4;

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        //1、内存缓存相关
        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));

        // set size & external vs. internal
        int cacheSize100MegaBytes = 104857600;
        //2、磁盘缓存相关
        builder.setDiskCache(
//                new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes)//内部使用的磁盘缓存区
                new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes)//外部可以访问的磁盘缓存区

        );


        ActivityManager activityManager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        //3、根据运行内存情况，自定义对图像的编码格式
        try {
            builder.setDecodeFormat(activityManager.isLowRamDevice() ?
                    DecodeFormat.PREFER_RGB_565 : DecodeFormat.PREFER_ARGB_8888);
        }catch(NoSuchMethodError e){
            Logger.e(e.getMessage());
        }

    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        super.registerComponents(context, glide);
    }

}
