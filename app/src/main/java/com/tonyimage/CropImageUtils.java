package com.tonyimage;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

import com.tonyimage.imagepicker.ImagePicker;
import com.tonyimage.imagepicker.view.CropImageView;


/**
 * 裁剪成圆形的
 * corp image utils
 */
public class CropImageUtils {
    private static final String TAG = "CropImageUtils";
    public static ImagePicker initImagePickerSquare(@NonNull Activity activity,
                                                    int width,
                                                    int height) {
        ImagePicker imagePicker = ImagePicker.getInstance();
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;
        int cropWidth, cropHeight;
        double ratio = (double) width / height;
        double screenRatio = (double) screenWidth / screenHeight;
        if (ratio > screenRatio) {
            cropWidth = screenWidth;
            cropHeight = (int) (cropWidth / ratio);
        } else {
            cropHeight = screenHeight;
            cropWidth = (int) (ratio * cropHeight);
        }

        LogUtil.i(TAG,"width "+width+" height "+height);
        LogUtil.i(TAG,"screenWidth "+screenWidth+" screenHeight "+screenHeight);
        LogUtil.i(TAG,"crop width "+cropWidth+" crop height "+cropHeight);
        imagePicker.setImageLoader(new MyImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(false); //是否按矩形区域保存
        imagePicker.setMultiMode(false);    //单选模式
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框为矩形
        imagePicker.setFocusWidth(cropWidth);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(cropHeight);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(width);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(height);//保存文件的高度。单位像素
        return imagePicker;
    }
}
