package com.example.tp6;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.Timer;
import java.util.TimerTask;

public class HourService extends Service {
    private Timer timer;

    private class CustomTimerTask extends TimerTask {

        private Handler updateUI = new Handler() {
            @Override
            public void dispatchMessage(@NonNull Message msg) {
                super.dispatchMessage(msg);
                // We can't call Toast.makeText outside of the main thread (i.e outside the handler)
                showTime();
            }
        };

        @Override
        public void run() {
            updateUI.sendEmptyMessage(0);
            SystemClock.sleep(5000);
        }
    }

    public HourService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initService();
        //SystemClock.sleep(30000);
        return Service.START_NOT_STICKY;
    }

    private void initService() {
        Toast.makeText(getApplicationContext(), "Service started.", Toast.LENGTH_SHORT).show();
        timer = new Timer();
        timer.scheduleAtFixedRate(new CustomTimerTask(), 0, 5000);
    }

    private void showTime() {
        String time = (String) DateFormat.format("dd/MM/yy hh:mm:ss", System.currentTimeMillis());
        Toast.makeText(getApplicationContext(), time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void exitService() {
        Toast.makeText(getApplicationContext(), "Service stopped.", Toast.LENGTH_SHORT).show();
        timer.cancel();
        timer.purge();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        exitService();
    }
}
