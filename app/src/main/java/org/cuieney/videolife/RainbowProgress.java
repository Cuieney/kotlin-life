package org.cuieney.videolife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by cuieney on 17/2/21.
 */

public class RainbowProgress extends View {
    private Context context;
    private String TAG = "oye";
    private int startColor = Color.parseColor("#ff0000");
    private int endColor = Color.parseColor("#00ff00");
    private int unreachColor = Color.parseColor("#cccccc");

    private int progress;
    private Paint paint;
    private Paint rainbowPaint;

    private static int[]colors = new int[100];
    private LinearGradient shader;

    public RainbowProgress(Context context) {
        super(context);
        init(context);
    }

    public RainbowProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RainbowProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        this.context = context;
        paint = new Paint();
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(unreachColor);
        paint.setStrokeWidth(dp2px(5));
        paint.setStrokeCap(Paint.Cap.ROUND);

        rainbowPaint = new Paint();
        rainbowPaint.setAntiAlias(true);

        rainbowPaint.setStyle(Paint.Style.STROKE);
        rainbowPaint.setAntiAlias(true);
        rainbowPaint.setColor(startColor);
        rainbowPaint.setStrokeWidth(dp2px(5));
        rainbowPaint.setStrokeCap(Paint.Cap.ROUND);
        initColors();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int measuredWidth = getMeasuredWidth();
        canvas.drawLine(0,0, measuredWidth,0, paint);
        shader = new LinearGradient(0,0, measuredWidth /100*progress,0, colors, null,
                Shader.TileMode.CLAMP);
        rainbowPaint.setShader(shader);
        canvas.drawLine(0,0, measuredWidth /100*progress,0,rainbowPaint);

    }


    public void setProgress(int progress){
        this.progress = progress;
        Log.e(TAG, "setProgress: "+progress );
        postInvalidate();

    }

    private void initColors(){
        for (int i = 0; i < 100; i++) {
            colors[i] = getCurrentColor(i);
        }
    }

    private int getCurrentColor(int progress){
        if (progress == 0){
            return startColor;
        }
        int[] startARGB = convertColor(startColor);
        int[] endARGB = convertColor(endColor);
        int alpha = startARGB[0]-((startARGB[0] - endARGB[0])/100 *progress);
        int red = startARGB[1]-((startARGB[1] - endARGB[1])/100 *progress);
        int green = startARGB[2]-((startARGB[2] - endARGB[2])/100 *progress);
        int blue = startARGB[3]-((startARGB[3] - endARGB[3])/100 *progress);
        return Color.argb(alpha,red,green,blue);
    }

    private int[] convertColor(int color){
        int alpha = (color & 0xff000000) >>> 24;
        int red   = (color & 0x00ff0000) >> 16;
        int green = (color & 0x0000ff00) >> 8;
        int blue  = (color & 0x000000ff);
//        Log.e(TAG,
//                "alpha: "+alpha+","+
//                        "red: "+red+","+
//                        "green: "+green+","+
//                        "blue: "+blue+","
//        );
        return new int[]{alpha,red,green,blue};
    }

    private int dp2px(int value) {
        float v = getContext().getResources().getDisplayMetrics().density;
        return (int) (v * value + 0.5f);
    }

    private int sp2px(int value) {
        float v = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (v * value + 0.5f);
    }
}
