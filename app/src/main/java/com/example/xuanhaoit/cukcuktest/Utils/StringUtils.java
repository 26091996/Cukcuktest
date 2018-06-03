package com.example.xuanhaoit.cukcuktest.Utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StringUtils {


    public static String splitEmail(String email) {
        String[] s = email.split("@gmail.com");
        return s[0];
    }

    public static String formatCurrency(int money) {
        DecimalFormat format = new DecimalFormat("#,###,###");
        return format.format(money) + " VNĐ";
    }

    public static String getDate()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft=null;
        dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate=dft.format(cal.getTime());
        dft = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String strTime = dft.format(cal.getTime());

        return strDate;
    }

    public static String getTime()
    {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft=null;
        dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate=dft.format(cal.getTime());
        dft = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String strTime = dft.format(cal.getTime());

        return strTime;
    }
}
