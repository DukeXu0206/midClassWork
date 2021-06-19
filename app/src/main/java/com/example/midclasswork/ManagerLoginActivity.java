package com.example.midclasswork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class ManagerLoginActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        TextView loginBack = findViewById(R.id.login_back);
        EditText account = findViewById(R.id.account);
        EditText password =  findViewById(R.id.password);
        Button btn1 = findViewById(R.id.login_btn);
        loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(2,intent);
                finish();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(ManagerLoginActivity.this,TableActivity.class);
                        startActivity(intent);
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 1000);
            }
        });
    }
}
