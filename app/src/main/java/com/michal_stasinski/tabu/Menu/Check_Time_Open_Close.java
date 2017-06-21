package com.michal_stasinski.tabu.Menu;

import android.util.Log;

import com.michal_stasinski.tabu.Menu.Adapters.TimeOfDeliveryAdapter;
import com.michal_stasinski.tabu.Menu.Models.MenuItemProduct;
import com.michal_stasinski.tabu.Menu.Models.TimeListItem;
import com.michal_stasinski.tabu.SplashScreen;
import com.michal_stasinski.tabu.Utils.BounceListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by win8 on 21.06.2017.
 */

public class Check_Time_Open_Close {

    private String[] closeTime;
    private String[] openTime;
    private String[] hourArr;
    private int day = 0;
    private TimeOfDeliveryAdapter adapterek;
    private ArrayList<MenuItemProduct> timeArr;

    public String[] getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String[] closeTime) {
        this.closeTime = closeTime;
    }

    public String[] getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String[] openTime) {
        this.openTime = openTime;
    }

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
    String strDate = mdformat.format(calendar.getTime());


    public Check_Time_Open_Close() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
        String strDate = mdformat.format(calendar.getTime());

        Log.i("informacja", " strDate" + strDate);

        hourArr = strDate.split(":");

        DateFormat df = new SimpleDateFormat("EEEE");
        String date = df.format(Calendar.getInstance().getTime());

        if (date.equals("Monday")) {
            day = 1;
        }

        if (date.equals("Tuesday")) {
            day = 2;
        }

        if (date.equals("Wednesday")) {
            day = 3;
        }

        if (date.equals("Thursday")) {
            day = 4;
        }

        if (date.equals("Friday")) {
            day = 5;
        }

        if (date.equals("Saturday")) {
            day = 6;
        }

        if (date.equals("Sunday")) {
            day = 0;
        }

        int hourValue = Integer.parseInt(hourArr[0]) * 60 + Integer.parseInt(hourArr[1]);

        closeTime = String.valueOf(SplashScreen.timeWhenRestaurantIsClose.get(day)).split(":");
        openTime = String.valueOf(SplashScreen.timeWhenRestaurantIsOpen.get(day)).split(":");


        int op = Integer.parseInt(openTime[0]) * 60 + Integer.parseInt(openTime[1]);
        int cl = Integer.parseInt(closeTime[0]) * 60 + Integer.parseInt(closeTime[1]);

        if (op > cl) {
            cl = cl + 24 * 60;
        }
        if (hourValue >= op && hourValue <= cl) {


        } else {

            if (hourValue < Integer.parseInt(openTime[0]) * 60 + Integer.parseInt(openTime[1])) {
                Log.i("informacja", "------------------czas jest w zakresie  dnia 2 ");
                if (day > 0) {
                    closeTime = String.valueOf(SplashScreen.timeWhenRestaurantIsClose.get(day - 1)).split(":");
                    openTime = String.valueOf(SplashScreen.timeWhenRestaurantIsOpen.get(day - 1)).split(":");
                } else {
                    closeTime = String.valueOf(SplashScreen.timeWhenRestaurantIsClose.get(6)).split(":");
                    openTime = String.valueOf(SplashScreen.timeWhenRestaurantIsOpen.get(6)).split(":");
                }

                int op1 = Integer.parseInt(openTime[0]) * 60 + Integer.parseInt(openTime[1]);
                int cl1 = Integer.parseInt(closeTime[0]) * 60 + Integer.parseInt(closeTime[1]);

                if (op1 > cl1) {
                    cl1 = cl1 + 24 * 60;
                }
                if (hourValue >= op1 && hourValue <= cl1) {


                } else {
                    Log.i("informacja", "------------------czas jest w zakresie  dnia 2 zamkniete");
                }

            } else {
                Log.i("informacja", "------------------zamkniete ");
            }


        }
    }
}