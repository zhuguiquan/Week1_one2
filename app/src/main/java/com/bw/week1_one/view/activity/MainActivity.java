package com.bw.week1_one.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.week1_one.R;
import com.bw.week1_one.base.BaseActivity;
import com.bw.week1_one.base.BasePresenter;
import com.bw.week1_one.view.fragment.JiFragment;
import com.bw.week1_one.view.fragment.ZhengFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
List<Fragment>fragmentList=new ArrayList<>();
List<String>arrayList=new ArrayList<>();

    @Override
    protected void initData() {
        ZhengFragment zhengFragment = new ZhengFragment();
        JiFragment jiFragment = new JiFragment();
        fragmentList.add(zhengFragment);
        fragmentList.add(jiFragment);
        arrayList.add("正在上映");
        arrayList.add("即将上映");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return arrayList.get(position);
            }
        });
        tab.setupWithViewPager(vp);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter provideMpresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


}
