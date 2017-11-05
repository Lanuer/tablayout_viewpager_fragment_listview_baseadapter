package com.example.lanuer.tablayout_viewpager_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class BAdapter extends BaseAdapter {

    private LayoutInflater inflate;
    private List<String> infolist;
    private List<Integer> imageid;

    public BAdapter(LayoutInflater inflate, List<String> infolist, List<Integer> imageid) {
        this.inflate = inflate;
        this.infolist = infolist;
        this.imageid = imageid;
    }

    class Holder{
        ImageView image;
        TextView text;
    }

    @Override
    public int getCount() {
        return infolist.size();//listview內有幾列
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            view = inflate.inflate(R.layout.page_content, null);
            holder = new Holder();
            holder.image = (ImageView) view.findViewById(R.id.image);
            holder.text = (TextView) view.findViewById(R.id.text);

            view.setTag(holder);
        } else{
            holder = (Holder) view.getTag();
        }
        for(int x = 0;x < infolist.size();x++) {
            if(i == x) {
                holder.image.setImageResource(imageid.get(i));
                holder.text.setText(infolist.get(i));
            }
        }

        return view;
    }
}