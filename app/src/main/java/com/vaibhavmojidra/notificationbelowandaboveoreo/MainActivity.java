package com.vaibhavmojidra.notificationbelowandaboveoreo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText TitleTB,MessageTB;
    private Button ShowNotifcation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TitleTB=findViewById(R.id.TitleTB);
        MessageTB=findViewById(R.id.MessageTB);
        ShowNotifcation=findViewById(R.id.ShowNotification);


        ShowNotifcation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CHANNEL_ID="MESSAGE";
                String CHANNEL_NAME="MESSAGE";
                NotificationManagerCompat manager=NotificationManagerCompat.from(MainActivity.this);
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
                    manager.createNotificationChannel(channel);
                }
                Notification notification = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_android_black_24dp)
                        .setContentTitle(TitleTB.getText().toString())
                        .setContentText(MessageTB.getText().toString())
                        .build();
                manager.notify(getRandomNumber(),notification);
            }
        });
    }

    private static int getRandomNumber() {
        Date dd= new Date();
        SimpleDateFormat ft =new SimpleDateFormat ("mmssSS");
        String s=ft.format(dd);
        return Integer.parseInt(s);
    }
}
