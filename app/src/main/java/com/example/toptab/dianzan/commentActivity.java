package com.example.toptab.dianzan;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class commentActivity extends AppCompatActivity {
    Button comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topfragment1);
        comment = findViewById(R.id.comment);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }
    public void show(){
        View bottom = getLayoutInflater().inflate(R.layout.dialog_comment,null);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(bottom);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        dialog.show();
    }
}
