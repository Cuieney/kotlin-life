package org.cuieney.videolife;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cuieney on 17/2/21.
 */

public class RainbowProgressBar extends View {
    private Context context;


    private float progress;
    private Paint paint;
    private Paint rainbowPaint;



    private int[] colors;
    private LinearGradient shader;

    private float measuredWidth;
    private float measuredHeight;


    private float progressHeight = dp2px(5);
    private int startColor = Color.parseColor("#00ff00");
    private int endColor = Color.parseColor("#0000ff");
    private int unreachedColor = Color.parseColor("#cccccc");
    private int max = 100;
    private float radius = dp2px(35);
    private int type;

    private static final int CIRCLE_TYPE = 0;
    private static final int LINE_TYPE = 1;

    public RainbowProgressBar(Context context) {
        super(context);
        init(context);
    }

    public RainbowProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs,
                R.styleable.RainbowProgressBar);
        max = attributes.getInteger(R.styleable.RainbowProgressBar_progress_max,100);
        progress = attributes.getInteger(R.styleable.RainbowProgressBar_progress_current,0);
        startColor = attributes.getColor(R.styleable.RainbowProgressBar_progress_start_color,startColor);
        endColor = attributes.getColor(R.styleable.RainbowProgressBar_progress_end_color,endColor);
        radius = attributes.getDimension(R.styleable.RainbowProgressBar_progress_radius,dp2px(35));
        progressHeight = attributes.getDimension(R.styleable.RainbowProgressBar_progress_height,dp2px(5));
        unreachedColor = attributes.getColor(R.styleable.RainbowProgressBar_progress_unreached_color,unreachedColor);
        type = attributes.getInteger(R.styleable.RainbowProgressBar_progress_type,1);
        attributes.recycle();
        init(context);
    }

    public RainbowProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RainbowProgressBar,
                defStyleAttr, 0);
        max = attributes.getInteger(R.styleable.RainbowProgressBar_progress_max,100);
        progress = attributes.getInteger(R.styleable.RainbowProgressBar_progress_current,0);
        startColor = attributes.getColor(R.styleable.RainbowProgressBar_progress_start_color,startColor);
        endColor = attributes.getColor(R.styleable.RainbowProgressBar_progress_end_color,endColor);
        radius = attributes.getInt(R.styleable.RainbowProgressBar_progress_radius,dp2px(35));
        progressHeight = attributes.getInteger(R.styleable.RainbowProgressBar_progress_height,dp2px(10));
        unreachedColor = attributes.getColor(R.styleable.RainbowProgressBar_progress_unreached_color,unreachedColor);
        type = attributes.getInteger(R.styleable.RainbowProgressBar_progress_type,1);
        attributes.recycle();
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        paint = new Paint();
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(unreachedColor);
        paint.setStrokeWidth(progressHeight);
        paint.setStrokeCap(Paint.Cap.ROUND);

        rainbowPaint = new Paint();
        rainbowPaint.setAntiAlias(true);

        rainbowPaint.setStyle(Paint.Style.STROKE);
        rainbowPaint.setAntiAlias(true);
        rainbowPaint.setColor(startColor);
        rainbowPaint.setStrokeWidth(progressHeight);
        rainbowPaint.setStrokeCap(Paint.Cap.ROUND);

        colors = new int[max];
        initColors();


    }

    @Override
    protected int getSuggestedMinimumWidth() {
        int width = 0;
        if (type == CIRCLE_TYPE) {
            width= ((int) (radius * 2));
        }else if(type == LINE_TYPE){
            width = getWidth();
        }
        return width;
    }

    @Override
    protected int getSuggestedMinimumHeight() {
        int height = 0;
        if (type == CIRCLE_TYPE) {
            height= ((int) (radius * 2));
        }else if(type == LINE_TYPE){
            height = getHeight();
        }
        return height;
    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
//        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
//        setMeasuredDimension(Math.min(measureWidth, measureHeight), Math.min(measureWidth, measureHeight));
//    }

    private int measure(int measureSpec, boolean isWidth) {
        int result;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int padding = isWidth ? getPaddingLeft() + getPaddingRight() : getPaddingTop() + getPaddingBottom();
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = isWidth ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight();
            result += padding;
            if (mode == MeasureSpec.AT_MOST) {
                if (isWidth) {
                    result = Math.max(result, size);
                } else {
                    result = Math.min(result, size);
                }
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (type == CIRCLE_TYPE) {
            drawCircle(canvas);
        }else if(type == LINE_TYPE){
            drawLine(canvas);
        }
    }

    private void drawLine(Canvas canvas) {
        measuredWidth = getWidth();
        measuredHeight = getHeight();
        canvas.drawLine(0, 0, measuredWidth, 0, paint);
        float x1 = measuredWidth / max * progress;
        shader = new LinearGradient(0, 0, x1, 0, colors, null,
                Shader.TileMode.CLAMP);
        rainbowPaint.setShader(shader);
        canvas.drawLine(0, 0, x1, 0, rainbowPaint);
    }

    private void drawCircle(Canvas canvas) {
        measuredWidth = getWidth();
        measuredHeight = getHeight();
        float x = radius+progressHeight;
        float y = radius+progressHeight;
        float sweepAngle = 360f / max * progress;

        canvas.drawCircle(x, y, radius, paint);
        shader = new LinearGradient(x - radius, y - radius,
                x - radius + radius, y + radius, colors, null, Shader.TileMode.MIRROR);
        rainbowPaint.setShader(shader);
        RectF rect = new RectF(((int) (x - radius)),
                ((int) (y - radius)),
                ((int) (x + radius)),
                ((int) (y + radius)));
        canvas.drawArc(
                rect,
                -90, sweepAngle, false, rainbowPaint
        );
    }

    public void setProgress(int currentProgress) {
        this.progress = currentProgress;
        postInvalidate();

    }

    private void initColors() {
        for (int i = 0; i < max; i++) {
            colors[i] = getCurrentColor(i);
        }
    }

    private int getCurrentColor(int progress) {
        int alpha = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        if (progress == 0) {
            return startColor;
        }
        int[] startARGB = convertColor(startColor);
        int[] endARGB = convertColor(endColor);

        alpha = startARGB[0] - ((startARGB[0] - endARGB[0]) / max * progress);
        red = startARGB[1] - ((startARGB[1] - endARGB[1]) / max * progress);
        green = startARGB[2] - ((startARGB[2] - endARGB[2]) / max * progress);
        blue = startARGB[3] - ((startARGB[3] - endARGB[3]) / max * progress);

        return Color.argb(alpha, red, green, blue);
    }

    private int[] convertColor(int color) {
        int alpha = (color & 0xff000000) >>> 24;
        int red = (color & 0x00ff0000) >> 16;
        int green = (color & 0x0000ff00) >> 8;
        int blue = (color & 0x000000ff);
        return new int[]{alpha, red, green, blue};
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
