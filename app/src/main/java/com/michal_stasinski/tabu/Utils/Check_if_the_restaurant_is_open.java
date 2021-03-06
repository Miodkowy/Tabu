package com.michal_stasinski.tabu.Utils;

import com.michal_stasinski.tabu.User_Side.Adapters.TimeOfDeliveryAdapter;
import com.michal_stasinski.tabu.User_Side.Models.MenuItemProduct;
import com.michal_stasinski.tabu.SplashScreen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by win8 on 21.06.2017.
 */

public class Check_if_the_restaurant_is_open {

    private String[] closeTime;
    private String[] openTime;
    private String[] hourArr;

    private Boolean restaurantIsOpen = false;
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


    public Check_if_the_restaurant_is_open() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
        String strDate = mdformat.format(calendar.getTime());

        hourArr = strDate.split(":");

        DateFormat df = new SimpleDateFormat("EEEE");

        String date = df.format(Calendar.getInstance().getTime());
        Calendar c = Calendar.getInstance();

        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        /* Niedziela = 1  Poniedziałek = 2  Sobota = 7*/

        day = dayOfWeek - 1;

        int dayOfWeek_yesterday = day - 1;
        if (dayOfWeek_yesterday == -1) {
            dayOfWeek_yesterday = 6;
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
            // Log.i("informacja", "------------------otwarte 1 ");
            restaurantIsOpen = true;
        } else {

            if (hourValue < Integer.parseInt(openTime[0]) * 60 + Integer.parseInt(openTime[1])) {
               // Log.i("informacja", "------------------czas jest w zakresie  dnia 2 ");


                closeTime = String.valueOf(SplashScreen.timeWhenRestaurantIsClose.get(dayOfWeek_yesterday)).split(":");
                openTime = String.valueOf(SplashScreen.timeWhenRestaurantIsOpen.get(dayOfWeek_yesterday)).split(":");

                int op1 = 0;
                int cl1 = Integer.parseInt(closeTime[0]) * 60 + Integer.parseInt(closeTime[1]);
                if (hourValue >= op1 && hourValue <= cl1) {
                    restaurantIsOpen = true;
                   // Log.i("informacja", "------------------otwarte 2 ");
                } else {
                    restaurantIsOpen = false;
                    closeTime = String.valueOf(SplashScreen.timeWhenRestaurantIsClose.get(day)).split(":");
                    openTime = String.valueOf(SplashScreen.timeWhenRestaurantIsOpen.get(day)).split(":");
                }

            } else {
                restaurantIsOpen = false;
                // Log.i("informacja", "------------------zamkniete ");
            }
        }
    }

    public Boolean getRestaurantIsOpen() {
        return restaurantIsOpen;
    }

    public void setRestaurantIsOpen(Boolean restaurantIsOpen) {
        this.restaurantIsOpen = restaurantIsOpen;
    }
}
