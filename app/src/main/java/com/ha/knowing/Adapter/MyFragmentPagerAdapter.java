package com.ha.knowing.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ha.knowing.fragment.BaseFragment;

import java.util.ArrayList;

/**
 * Created by email:zhaihoy@Foxmai.com on 2017/11/22.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles;
    private ArrayList<BaseFragment> mFragmentList;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragmentList) {
        super(fm);
        mFragmentList = fragmentList;
        System.out.println("============s=="+fragmentList.size());
        mTitles = new String[fragmentList.size()];

        for (int i = 0; i < mTitles.length; i++) {
            mTitles[i] = fragmentList.get(i).getName();
            System.out.println("========"+mTitles[i]);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        System.out.println("========tit====="+mTitles[position]);
        return mTitles[position];
    }
}
