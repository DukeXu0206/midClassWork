package com.example.midclasswork;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class AnimalFragment extends Fragment {
    private Banner banner = null;
    private List<Integer> images = new ArrayList<>();
    private boolean isLogin = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail,container,false);
        TextView animal = view.findViewById(R.id.animal);
        TextView name = view.findViewById(R.id.name);
        TextView sex = view.findViewById(R.id.sex);
        TextView age = view.findViewById(R.id.age);
        TextView yimiao = view.findViewById(R.id.yimiao);
        TextView medical = view.findViewById(R.id.medical);
        TextView notes = view.findViewById(R.id.notes);
        TextView adopt = view.findViewById(R.id.adopt);
        animal.setText("纯种白猫");
        name.setText("小黑");
        sex.setText("公");
        age.setText("1岁6个月");
        yimiao.setText("已接种疫苗");
        medical.setText("未得过病");
        notes.setText("猫的脾气不好");
        banner = view.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImageLoader(new GlideImageLoader());
        images.add(R.drawable.cat1);
        images.add(R.drawable.cat2);
        images.add(R.drawable.cat3);
        banner.setImages(images);
        banner.setDelayTime(2000);
        banner.start();

        adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLogin){
                    Intent intent = new Intent();
                    intent.setClass(getActivity(),DialogActivity.class);
                    startActivity(intent);
                }
                Intent intent = new Intent();
                intent.setClass(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setImageResource((Integer) path);
        }
        //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
        @Override
        public ImageView createImageView(Context context) {
            //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
            return new ImageView(context);
        }
    }
}
