package com.tonyimage;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tonyimage.imagepicker.loader.ImageLoader;

import java.io.File;

/**
 * Created by admin on 2017/4/13.
 */

public class MyImageLoader implements ImageLoader {
    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setLayoutParams(new AutoFrameLayout.LayoutParams(width, height));
//        imageView.setImageResource(R.mipmap.default_image);
//        Observable.fromCallable(() -> Uri.fromFile(new File(path)))
//                .compose(NetWorkUtils.netWorkScheduler(Injection.provideSchedulerProvider()))
//                .subscribe(new DefaultSubscriber<Uri>() {
//                    @Override
//                    public void onNext(Uri uri) {
//                        imageView.setImageURI(uri);
//                    }
//                });
        Glide.with(activity)
                .load(Uri.fromFile(new File(path)))
                .placeholder(R.mipmap.default_image)
                .error(R.mipmap.default_image)
                .centerCrop()
                .override(width, height)
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {

    }
}
