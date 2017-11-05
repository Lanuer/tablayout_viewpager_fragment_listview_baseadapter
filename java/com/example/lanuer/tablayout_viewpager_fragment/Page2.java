package com.example.lanuer.tablayout_viewpager_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Page2 extends Fragment {

    private String infolist;

    public Page2(String infolist) {
        this.infolist = infolist;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_content2, container, false);
        TextView text2 = (TextView) view.findViewById(R.id.text2);
        text2.setText(infolist);
        return view;
    }

}