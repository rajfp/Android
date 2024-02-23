package com.example.android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class IOService : Service() {
    override fun onCreate() {
        Log.d("IOService==>", "onCreate")
        super.onCreate()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread.sleep(15000)
        Log.d("IOService==>", "onStartCommand")
        Toast.makeText(this, "Completed", Toast.LENGTH_LONG).show()
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        Log.d("IOService==>", "onDestroy")
        super.onDestroy()

    }
}