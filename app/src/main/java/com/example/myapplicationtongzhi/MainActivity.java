package com.example.myapplicationtongzhi;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private int s=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        
        createNotificationChannel();        //首先调用这个方法

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = s+1;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "1")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("提示")
                        .setContentText("s"+s)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                notificationManager.notify(s, builder.build());
            }
        });


    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.app_name);
            String description = getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("1", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    private void initView() {
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }
}