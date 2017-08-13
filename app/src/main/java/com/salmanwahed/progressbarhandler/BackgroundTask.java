package com.salmanwahed.progressbarhandler;

import android.os.Handler;
import android.util.Log;

/**
 * Created by Salman on 11-Jul-17.
 */

public class BackgroundTask implements Runnable {
    private Handler handler;

    public BackgroundTask(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        try
        {
            for (int i = 0; i < 10; i++)
            {
                Thread.sleep(1000);
                handler.sendMessage(handler.obtainMessage());
            }
        }
        catch (Throwable t)
        {
            Log.i("onStart", t.getMessage());
        }
    }
}
