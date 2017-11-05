package com.example.lanuer.tablayout_viewpager_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.List;

public class Page1 extends Fragment {

    private List<String> infolist;
    private List<Integer> imageid;
    private ListView mlv;

    public Page1(List<String> infolist, List<Integer> imageid) {
        this.infolist = infolist;
        this.imageid = imageid;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.baseadapter, container, false);

        mlv = (ListView) view.findViewById(R.id.list);
        mlv.setAdapter(new BAdapter(inflater, infolist, imageid));
        mlv.setOnItemClickListener(onClickListView);

        return view;
    }

    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getContext(), "點選第 " + Integer.toString(position +1) + " 個 \n內容：" + infolist.get(position), Toast.LENGTH_SHORT).show();
        }
    };

}