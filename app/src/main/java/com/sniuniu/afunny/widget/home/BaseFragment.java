package com.sniuniu.afunny.widget.home;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {
    private String mTitle;

    public void setTitle(String title){
        this.mTitle = title;
    }
    public String getTitle(){
        return mTitle;
    }
}
