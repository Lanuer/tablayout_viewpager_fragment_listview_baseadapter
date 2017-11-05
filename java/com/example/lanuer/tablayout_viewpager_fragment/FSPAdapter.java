package com.example.lanuer.tablayout_viewpager_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

public class FSPAdapter extends FragmentStatePagerAdapter {

    //初始化
    private List<String> titlelist;
    private List<Fragment> fragmentlist;
    public FSPAdapter(FragmentManager fm, List<String> titlelist, List<Fragment> fragmentlist) {
        super(fm);
        this.titlelist = titlelist;
        this.fragmentlist = fragmentlist;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }

    /*@Override
    public Object instantiateItem(ViewGroup container, int position) {//建立
        container.addView(fragmentlist.get(position));
        return fragmentlist.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//刪除
        container.removeView((View) object);
    }*/
}