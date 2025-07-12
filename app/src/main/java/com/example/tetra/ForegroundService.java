package com.example.tetra;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

public class ForegroundService extends Service {
    @SuppressLint("ForegroundServiceType")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){
            String CHANNEL_ID = "My Foreground Service";
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "My First notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

            Notification notification = new Notification.Builder(this,CHANNEL_ID)
                    .setContentTitle("First Notification")
                    .setContentText("Have A Nice Day")
                    .setSmallIcon(R.drawable.racoon)
                    .build();

            startForeground(1,notification);
        }
        Toast.makeText(this, "Service Started Look Up", Toast.LENGTH_SHORT).show();
     return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
