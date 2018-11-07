package com.sniuniu.afunny.utils;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.reflect.Field;

public class BottomNavigationViewHelper {

    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView navigationView){
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("labelVisibilityMode");
            shiftingMode.setAccessible(true);
            shiftingMode.set(menuView, 1);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView menuItemView = (BottomNavigationItemView) menuView.getChildAt(i);
                menuItemView.setShifting(false);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void changeStyle(BottomNavigationView navigationView, int index, int resId){
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);
        if ( 0 < index && index <= menuView.getChildCount()){
            BottomNavigationItemView menuItemView = (BottomNavigationItemView) menuView.getChildAt(index - 1);
            menuItemView.removeAllViews();
            View view = LayoutInflater.from(navigationView.getContext()).inflate(resId, null);
            menuItemView.addView(view);
        }
    }

    public static void addBadge(){

    }

}
