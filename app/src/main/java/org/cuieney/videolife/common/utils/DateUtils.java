package org.cuieney.videolife.common.utils;

import android.support.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}\\-\\d{2}\\-\\d{2}");

    public static String[] format(Date date) {
        return format(DATE_FORMAT.format(date));
    }

    @Nullable
    public static String[] format(String date) {
        if (!DATE_PATTERN.matcher(date).matches()) {
            return null;
        }

        return date.split("-");
    }

    public static String toDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }

    public static String toDate(Date date, int add) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, add);
        return toDate(calendar.getTime());
    }


}