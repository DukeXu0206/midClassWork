package com.example.midclasswork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class animalActivity extends Activity {
    private Banner banner = null;
    private List<Integer> images = new ArrayList<>();
    private boolean isLogin = false;
    private TextView animal = null;
    private TextView name = null;
    private TextView sex = null;
    private TextView age = null;
    private TextView yimiao = null;
    private TextView medical = null;
    private TextView notes = null;
    private TextView adopt = null;
    private TextView state = null;
    private ImageView home = null;
    private ImageView person = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        animal = findViewById(R.id.animal);
        name = findViewById(R.id.name);
        sex = findViewById(R.id.sex);
        age = findViewById(R.id.age);
        yimiao = findViewById(R.id.yimiao);
        medical = findViewById(R.id.medical);
        notes = findViewById(R.id.notes);
        adopt = findViewById(R.id.adopt);
        state = findViewById(R.id.state);
        home = findViewById(R.id.home);
        person = findViewById(R.id.person);
        animal.setText("纯种大型布偶白猫");
        name.setText("cindy");
        sex.setText("公");
        age.setText("2岁");
        yimiao.setText("已接种疫苗");
        medical.setText("未得过病");
        notes.setText("猫的脾气不好");
        banner = findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImageLoader(new animalActivity.GlideImageLoader());
        images.add(R.drawable.cat3);
        images.add(R.drawable.cat1_1);
        images.add(R.drawable.cat1_2);
        banner.setImages(images);
        banner.setDelayTime(2000);
        banner.start();
        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(animalActivity.this, LoginActivity.class), 4);
            }
        });
        adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLogin){
                    startActivityForResult(new Intent(animalActivity.this, DialogActivity.class), 1);
                }else{
                    startActivityForResult(new Intent(animalActivity.this, LoginActivity.class), 2);
                }

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(animalActivity.this, MainActivity.class), 10);
            }
        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(animalActivity.this, UserActivity.class), 11);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2 && resultCode == 2){
            isLogin = true;
            Toast.makeText(animalActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            state.setText("已登陆");
            state.setBackgroundResource(R.drawable.add_shopping_bt_bg2);
        }
        else if(requestCode == 1 && resultCode == 1){
            adopt.setText("已领养");
            adopt.setBackgroundResource(R.drawable.add_shopping_bt_bg2);
        }
        else if(requestCode == 1 && resultCode == 3){
            Log.v("sss","ss");
        }
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
