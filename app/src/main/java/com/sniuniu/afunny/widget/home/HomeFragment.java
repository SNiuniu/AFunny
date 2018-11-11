package com.sniuniu.afunny.widget.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sniuniu.afunny.R;
import com.sniuniu.afunny.widget.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ViewPager mViewPager;

    private TabLayout mTabLayout;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private TabLayout.BaseOnTabSelectedListener nOnTabSelectedListener = new OnTabSelectedListener();

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private void initView() {
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(InterestFragment.newInstance(getString(R.string.interesting_tab), "interest"));
        fragments.add(RecommendFragment.newInstance(getString(R.string.recommend_tab), "recommend"));
        fragments.add(VideoFragment.newInstance(getString(R.string.video_tab), "video"));
        fragments.add(PictureFragment.newInstance(getString(R.string.picture_tab), "picture"));
        fragments.add(TextFragment.newInstance(getString(R.string.text_tab), "text"));

        mViewPager = getView().findViewById(R.id.viewpager);
        mViewPager.setAdapter(new TabPagerAdapter(getChildFragmentManager(), fragments));

        mTabLayout = getView().findViewById(R.id.tab);
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

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(nOnTabSelectedListener);
        mTabLayout.getTabAt(2).select();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {

        private List<BaseFragment> fragments;

        public TabPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public int getCount() {
            if (null == fragments) {
                return 0;
            }
            return fragments.size();
        }

        @Override
        public BaseFragment getItem(int position) {
            if (null == fragments) {
                return null;
            }
            return fragments.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if (getItem(position) == null) {
                return null;
            }
            return getItem(position).getTitle();
        }
    }

    private class OnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

}
