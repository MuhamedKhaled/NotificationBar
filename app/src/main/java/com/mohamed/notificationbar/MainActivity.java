package com.mohamed.notificationbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mohamed.notificationbar.Interface.CustomViewInitializer;
import com.mohamed.notificationbar.Interface.OnActionClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationBar.create(MainActivity.this)
                        .setTitle(R.string.notification_title)
                        .setTitleColor(R.color.orange)
                        .setMessage(R.string.notification_body)
                        .setIcon(R.drawable.image1)
                        .setDuration(5000)
                        .show();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationBar.create(MainActivity.this)
                        .setDuration(5000)
                        .setTitle(R.string.notification_title)
                        .setIcon(R.drawable.ic_android_black_24dp)
                        .setMessage(R.string.notification_body)
                        .setBackgroundColor(R.color.colorPrimaryDark)
                        .setActionColor(R.color.default_action_color)
                        .setTitleColor(R.color.yellow)
                        .setNotificationPosition(NotificationBar.BOTTOM)
                        .setAction(R.string.action_text, new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getApplicationContext(), "Action!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });


        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationBar.create(MainActivity.this)
                        .setTitle(R.string.notification_title)
                        .setMessage(R.string.notification_body)
                        .setIcon(R.drawable.ic_whatshot_black_24dp)
                        .setMessageColor(R.color.liteblue)
                        .setBackgroundColor(R.color.colorPrimary)
                        .setDuration(5000)
                        .setAnimationIn(android.R.anim.fade_in, android.R.anim.fade_in)
                        .setAnimationOut(android.R.anim.slide_out_right, android.R.anim.slide_out_right)
                        .show();
            }
        });




        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationBar.create(MainActivity.this)
                        .setTitle(R.string.notification_title)
                        .setMessage(R.string.notification_body)
                        .setIcon(R.drawable.ic_sync_black_24dp)
                        .setIconAnimation(R.animator.iconspin)
                        .setTitleColor(R.color.fancyMessage)
                        .setActionColor(R.color.orange)
                        .setMessageColor(R.color.fancyMessage)
                        .setBackgroundColor(R.color.colorPrimaryDark)
                        .setDuration(5000)
                        .setNotificationPosition(NotificationBar.BOTTOM)
                        .setAction("Loading....", new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getApplicationContext(), "Action!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationBar.create(MainActivity.this)
                        .setCustomView(R.layout.custome_notification)
                        .setCustomViewInitializer(new CustomViewInitializer() {
                            @Override
                            public void initView(View view) {

                                Button btnOpen = view.findViewById(R.id.custom_btn_open);

                                View.OnClickListener btnListener = new View.OnClickListener() {

                                    @Override
                                    public void onClick(View view) {
                                        Button button = (Button) view;
                                        Toast.makeText(view.getContext(),"Open Button Clicked...",Toast.LENGTH_SHORT).show();
                                    }
                                };

                                btnOpen.setOnClickListener(btnListener);
                            }
                        })
                        .setAction("Close", new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                NotificationBar.dismiss(MainActivity.this);
                            }
                        })
                        .setTitle(R.string.notification_title)
                        .setMessage(R.string.notification_body)
                        .setEnableAutoDismiss(false)
                        .setSwipeToDismiss(false)
                        .setBackgroundColor(R.color.colorPrimary)
                        .setActionColor(R.color.default_action_color)
                        .setNotificationPosition(NotificationBar.BOTTOM)
                        .show();

            }
        });



    }
}
