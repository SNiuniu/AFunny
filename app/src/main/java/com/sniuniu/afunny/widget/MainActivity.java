package com.sniuniu.afunny.widget;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sniuniu.afunny.R;
import com.sniuniu.afunny.utils.BottomNavigationViewHelper;
import com.sniuniu.afunny.widget.add.AddFragment;
import com.sniuniu.afunny.widget.find.FindFragment;
import com.sniuniu.afunny.widget.home.HomeFragment;
import com.sniuniu.afunny.widget.mine.MineFragment;
import com.sniuniu.afunny.widget.notification.NotificationFragment;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener{
    private static final String TAG = "MainActivity";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, HomeFragment.newInstance("param1", "param2"))
                            .commit();
                    return true;
                case R.id.navigation_find:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, FindFragment.newInstance("param1", "param2"))
                            .commit();
                    return true;
                case R.id.navigation_add:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, AddFragment.newInstance("param1", "param2"))
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, NotificationFragment.newInstance("param1", "param2"))
                            .commit();
                    return true;
                case R.id.navigation_info:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, MineFragment.newInstance("param1", "param2"))
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        BottomNavigationViewHelper.changeStyle(navigation, 3, R.layout.customer_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
