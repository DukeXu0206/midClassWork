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

public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView registerBack = findViewById(R.id.register_back);
        Button btn = findViewById(R.id.bt_register_btn);
        EditText account = findViewById(R.id.et_register_account);
        EditText password = findViewById(R.id.et_register_password);
        registerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(2,intent);
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        setResult(2,intent);
                        finish();
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 1000);
            }
        });
    }
}
