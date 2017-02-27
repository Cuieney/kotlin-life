package org.cuieney.videolife.common.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by cuieney on 16/11/30.
 */
public class ToastUtil {
    private static Toast sToastInstance;

    private static Toast createToast(final Context context, String text, int duration) {
        if (null == sToastInstance) {
            sToastInstance = Toast.makeText(context, text, duration);
        }

        return sToastInstance;
    }

    public static void showToast(final Context context, String text, int duration) {
        if (sToastInstance != null) {
            sToastInstance.setText(text);
        } else {
            sToastInstance = createToast(context, text, duration);
        }

        sToastInstance.show();
    }

    public static void showToast(final Context context, String text) {
        if (sToastInstance != null) {
            sToastInstance.setText(text);
        } else {
            sToastInstance = createToast(context, text, Toast.LENGTH_SHORT);
        }

        sToastInstance.show();
    }


    public static void showToast(final Context context, String text,int x,int y) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, x, y);
        toast.show();
    }
}

