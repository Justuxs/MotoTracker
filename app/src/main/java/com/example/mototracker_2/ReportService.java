package com.example.mototracker_2;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public class ReportService extends Service {
    private Handler handler= new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Begu");
            handler.postDelayed(runnable, 5 * 1000); // Run every 5 minutes
        }
    };
    public ReportService() {
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.post(runnable);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}