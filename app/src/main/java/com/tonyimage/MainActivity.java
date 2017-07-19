package com.tonyimage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.tonyimage.imagepicker.ImagePicker;
import com.tonyimage.imagepicker.bean.ImageItem;
import com.tonyimage.imagepicker.ui.ImageGridActivity;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final int REQUEST_CODE_PICK_IMAGE = 888;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon = (ImageView) findViewById(R.id.icon);
    }

    public void chooseAvatar(View view) {
        CropImageUtils.initImagePickerSquare(this, 400, 400);
        Intent intent = new Intent(this, ImageGridActivity.class);
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_IMAGE) {
            if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
                ArrayList<ImageItem> imageItems = (ArrayList<ImageItem>) data.getSerializableExtra(
                        ImagePicker.EXTRA_RESULT_ITEMS);
                String path = imageItems.get(0).path; // 选择头像路径
                Log.i("gyz", "---------------- croped path : " + path);
                Bitmap bitmap = BitmapFactory.decodeFile(path); // 头像转化为Bitmap
                icon.setImageBitmap(bitmap);
            }
        }
    }
}


