package com.example.midclasswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Banner banner = null;
    private List<Integer> images = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView cat1 = (ImageView) findViewById(R.id.imagecat1);
        TextView cat = (TextView)findViewById(R.id.cat);
        cat1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, animalActivity.class);
                startActivity(intent);
            }
        });
        banner = findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImageLoader(new MainActivity.GlideImageLoader());
        images.add(R.drawable.cat3);
        images.add(R.drawable.dog1);
        images.add(R.drawable.bird3);
        banner.setImages(images);
        banner.setDelayTime(2000);
        banner.start();

    }
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setImageResource((Integer) path);
        }
        @Override
        public ImageView createImageView(Context context) {
            return new ImageView(context);
        }
    }
}