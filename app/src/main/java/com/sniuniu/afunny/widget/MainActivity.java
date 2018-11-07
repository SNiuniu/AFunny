package com.sniuniu.afunny;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sniuniu.afunny.utils.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private TabLayout mTabLayout;

    private String[] DATA;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_find:
                    return true;
                case R.id.navigation_add:
                    break;
                case R.id.navigation_notifications:
                    return true;
                case R.id.navigation_info:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DATA = new String[]{getString(R.string.interesting_tab),
                getString(R.string.recommend_tab),
                getString(R.string.video_tab),
                getString(R.string.picture_tab),
                getString(R.string.text_tab)};

        mViewPager = findViewById(R.id.viewpager);

        mTabLayout = findViewById(R.id.tab);
        TabLayout.Tab interestingTab = mTabLayout.newTab().setText(R.string.interesting_tab);
        mTabLayout.addTab(interestingTab);

        TabLayout.Tab recommendTab = mTabLayout.newTab().setText(R.string.recommend_tab);
        mTabLayout.addTab(recommendTab);

        TabLayout.Tab videoTab = mTabLayout.newTab().setText(R.string.video_tab);
        mTabLayout.addTab(videoTab);

        TabLayout.Tab pictureTab = mTabLayout.newTab().setText(R.string.picture_tab);
        mTabLayout.addTab(pictureTab);

        TabLayout.Tab textTab = mTabLayout.newTab().setText(R.string.text_tab);
        mTabLayout.addTab(textTab);

        recommendTab.select();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        BottomNavigationViewHelper.changeStyle(navigation, 3, R.layout.customer_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private class TabPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return DATA.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            TextView tvContent = new TextView(container.getContext());
            tvContent.setText(DATA[position]);
            tvContent.setGravity(Gravity.CENTER);
            container.addView(tvContent,
                    ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
            return tvContent;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return DATA[position];
        }
    }

}
