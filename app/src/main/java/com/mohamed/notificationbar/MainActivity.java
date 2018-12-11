package com.mohamed.notificationbar;

import android.app.Notification;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnTop = findViewById(R.id.btn_top);
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationBar.build(MainActivity.this)
                        .setTitle("top cookie title")
                        .setTitleColor(R.color.yellow)
                        .setMessage("top cookie message")
                        .setIcon(R.drawable.ic_android_black_24dp)
                        .setDuration(5000)
                        .show();
            }
        });
    }
}
