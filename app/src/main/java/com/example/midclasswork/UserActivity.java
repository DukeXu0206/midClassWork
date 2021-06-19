package com.example.midclasswork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    private TextView update = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_self);
        ImageView head = findViewById(R.id.head);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserActivity.this,HeadActivity.class);
                startActivityForResult(intent, 0x11);
            }
        });
        update = findViewById(R.id.tv_userself_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(3,intent);
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x11 && resultCode == 0x11) {    //判断是否为待处理的结果
            Bundle bundle = data.getExtras();        //获取传递的数据包
            int imageId = bundle.getInt("imageId");    //获取选择的头像ID
            ImageView iv = (ImageView) findViewById(R.id.head);    //获取布局文件中添加的ImageView组件
            iv.setImageResource(imageId);    //显示选择的头像
        }
    }
}
