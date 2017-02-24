package org.cuieney.videolife.activities;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import org.cuieney.videolife.R;
import org.cuieney.videolife.RainbowProgressBar;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_STATIC;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

public class MainActivity extends AppCompatActivity {

    private String TAG = "oye";
    private RainbowProgressBar progress;
    private int progressValue = 0;
    private boolean  isHide;

    TextView mTextView;
    private BottomNavigationBar mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_layout);
        convertColor(Color.parseColor("#f00000"));
//        progress = ((RainbowProgressBar) findViewById(R.id.progress));
//        new Thread(() -> {
//
//            while(progressValue < 100){
//                progressValue+=1;
//                SystemClock.sleep(100);
//                runOnUiThread(() -> {
//                    progress.setProgress(progressValue);
//                });
//            }
//
//        }).start();


        mTextView = (TextView) findViewById(R.id.text);
        mNavigationView = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mNavigationView
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Home").setActiveColor("#FF0000").setInActiveColor("#CCCCCC"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Books").setActiveColor("#FFFF00"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Music").setActiveColor("#00FFFF"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Games").setActiveColor("#FFFF00"))
                .initialise();
        mNavigationView.setBackgroundStyle(BACKGROUND_STYLE_STATIC);
        mNavigationView.setMode(MODE_FIXED);
        mTextView.setOnClickListener(v -> {
            if (isHide) {
                mNavigationView.hide();
                isHide = false;
            }else{
                mNavigationView.show();
                isHide = true;
            }
        });
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
