package com.salmanwahed.progressbarhandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private boolean isRunning = false;
    int taskId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mProgressBar.setProgress(0);

        Thread background = new Thread(new BackgroundTask(handler));
        background.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }

    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            mTextView.setText(String.format(Locale.US, "Current task: %d", taskId));
            mProgressBar.incrementProgressBy((100/10));
            taskId++;
        }
    };

}
