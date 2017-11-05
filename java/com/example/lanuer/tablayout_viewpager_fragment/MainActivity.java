package com.example.lanuer.tablayout_viewpager_fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private List<String> titlelist;
    private List<String> infolist;
    private List<Fragment> fragmentlist;
    private FSPAdapter fspAdapter;

    private ArrayList<ArrayList<String>> infolist2;
    private ArrayList<ArrayList<Integer>> imageid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();//初始化View
        initData();//初始化Data
        initListener();//設置監聽器
        //RecyclerView可以取代ListView
    }

    private void initData() {
        //tablayout文字
        titlelist = new ArrayList<>();
        titlelist.add("Page one");
        titlelist.add("Page two");
        titlelist.add("Page three");

        //設置tablayout的文字
        for(int x = 0;x < titlelist.size();x++) {
            mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(x)));
            //mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(x)).setIcon(R.mipmap.ic_launcher));//設置Icon圖示
        }

        //設置內容
        infolist = new ArrayList<>();
        infolist.add("Page 1");
        infolist.add("Page 2");
        infolist.add("Page 3");

        infolist2 = new ArrayList<ArrayList<String>>();
        infolist2.add(new ArrayList<String>());//每個陣列都需要再new一次
        infolist2.get(0).add("cat");
        infolist2.get(0).add("monkey");
        infolist2.get(0).add("panda");
        infolist2.add(new ArrayList<String>());
        infolist2.get(1).add("panda");
        infolist2.get(1).add("monkey");
        infolist2.get(1).add("cat");

        imageid = new ArrayList<ArrayList<Integer>>();
        imageid.add(new ArrayList<Integer>());
        imageid.get(0).add(R.drawable.cat);
        imageid.get(0).add(R.drawable.monkey);
        imageid.get(0).add(R.drawable.panda);
        imageid.add(new ArrayList<Integer>());
        imageid.get(1).add(R.drawable.panda);
        imageid.get(1).add(R.drawable.monkey);
        imageid.get(1).add(R.drawable.cat);

        //設置fragment，如需其他layout則把Page1改成其他layout.java參數自行設定
        fragmentlist = new ArrayList<>();
        fragmentlist.add(new Page1(infolist2.get(0), imageid.get(0)));
        fragmentlist.add(new Page2(infolist.get(1)));
        fragmentlist.add(new Page1(infolist2.get(1), imageid.get(1)));

        //把titlelist和fragmentlist丟給FSPAdapter
        fspAdapter = new FSPAdapter(getSupportFragmentManager(), titlelist, fragmentlist);
    }

    private void initView() {
        mTablayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.pager);
    }

    private void initListener() {
        mViewPager.setAdapter(fspAdapter);
        mTablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
    }
}