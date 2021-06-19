package com.example.midclasswork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView toRegister = findViewById(R.id.to_register);
        TextView loginBack = findViewById(R.id.login_back);
        TextView manager = findViewById(R.id.login_manager);
        EditText account = findViewById(R.id.account);
        EditText password =  findViewById(R.id.password);
        Button btn1 = findViewById(R.id.login_btn);
        toRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(2,intent);
                finish();
            }
        });
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,ManagerLoginActivity.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(account.getText().toString().equals("123")&& password.getText().toString().equals("123456")){
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
                }else{
                    //延迟1秒
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this,RegisterActivity.class);
                            startActivity(intent);
                        }
                    };
                    Timer timer = new Timer();
                    timer.schedule(task, 1000);
                }
            }
        });
    }
}
