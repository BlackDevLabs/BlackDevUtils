package gg.blackdev.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.util.Calendar;

public class DateTimeUtilities {

    // ========== Get Current Date/Time ==========
    public static String getCurrentDateTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    // ========== Calculate Date Difference ==========
    public static long calculateDateDifference(String date1, String date2, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);
        long diffInMillis = Math.abs(d2.getTime() - d1.getTime());
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    // ========== Add/Subtract Days ==========
    public static String addDaysToDate(String date, int days, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(date));
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return sdf.format(calendar.getTime());
    }

    // ========== Check if Leap Year ==========
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
