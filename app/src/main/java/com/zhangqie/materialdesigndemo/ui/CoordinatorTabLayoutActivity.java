package com.zhangqie.materialdesigndemo.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zhangqie.materialdesigndemo.R;

/**
 * Created by zhangqie on 2017/8/19.
 */

public class CoordinatorTabLayoutActivity extends AppCompatActivity{

    private Fragment[] mFragmentArrays = new Fragment[3];
    private String[] mTabTitles = new String[3];
    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_tablayout);

        mToolBar = (Toolbar) findViewById(R.id.appbar_toolbar);
        mToolBar.setTitle("AppBar");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mTabTitles[0] = "今天";
        mTabTitles[1] = "明天";
        mTabTitles[2] = "后天";

        mFragmentArrays[0] = TabFragment.newInstance();
        mFragmentArrays[1] = TabFragment.newInstance();
        mFragmentArrays[2] = TabFragment.newInstance();

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter = new AuthorPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);

        //初始化TabLayout，增加Tab，同时关联ViewPager
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(pagerAdapter);

    }

    private class AuthorPagerAdapter extends FragmentPagerAdapter {


        public AuthorPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }

        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];
        }
    }



}
