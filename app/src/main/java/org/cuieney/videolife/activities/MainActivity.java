package org.cuieney.videolife.activities;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.cuieney.videolife.R;
import org.cuieney.videolife.RainbowProgress;

public class MainActivity extends AppCompatActivity {

    private String TAG = "oye";
    private RainbowProgress progress;
    private int progressValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertColor(Color.parseColor("#f00000"));
        progress = ((RainbowProgress) findViewById(R.id.progress));
        new Thread(() -> {

            while(progressValue < 100){
                progressValue+=1;
                SystemClock.sleep(50);
                runOnUiThread(() -> {
                    progress.setProgress(progressValue);
                });
            }

        }).start();
    }

    private float[] convertColor(int color){
        int alpha = (color & 0xff000000) >>> 24;
        int red   = (color & 0x00ff0000) >> 16;
        int green = (color & 0x0000ff00) >> 8;
        int blue  = (color & 0x000000ff);
        Log.e(TAG,
                "alpha: "+alpha+","+
                "red: "+red+","+
                "green: "+green+","+
                "blue: "+blue+","
        );
        return new float[]{alpha,red,green,blue};
    }
}
