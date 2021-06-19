package com.example.midclasswork;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.midclasswork.R;
import com.example.midclasswork.ElecSignatureView;

public class DialogActivity extends AppCompatActivity {
    private ElecSignatureView elec;
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_agreement_dialog);
        elec = findViewById(R.id.elec);
        iv = findViewById(R.id.iv);
        RadioButton rgYes = findViewById(R.id.yes);
        RadioButton rgNo = findViewById(R.id.no);

        rgYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(1,intent);
                finish();
            }
        });
        rgNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(3,intent);
                finish();
            }
        });

    }
    public void onClear(View view){
        elec.clear();
    }
}
