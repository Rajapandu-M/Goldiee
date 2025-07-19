package com.example.tetra;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcatsReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_SCREEN_ON.equals(intent.getAction())){
            Log.d("ScreenReceiver","Screen Turned On");

            Intent inten = new Intent(context, LockscreenActivity.class);
            inten.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(inten);
        }
    }
}
