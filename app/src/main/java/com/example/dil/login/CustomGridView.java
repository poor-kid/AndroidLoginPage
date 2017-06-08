package com.example.dil.login;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridView extends BaseAdapter {

    ImageView imgv;
    TextView txtv;
    //String[] dscr;
    String [] items;
    Integer[] img;
    FragmentActivity cn;

   // Bollywood cntxt;

    public CustomGridView(FragmentActivity activity, String[] str, Integer[] img) {

        this.cn = activity;
        this.items = str;
        this.img = img;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater lay = (LayoutInflater) cn.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = lay.inflate(R.layout.activity_custom_grid_view,null);
        //View row = convertView;
        //row.setBackgroundColor(Color.BLUE);
        imgv = (ImageView)convertView.findViewById(R.id.imageView9);
        txtv = (TextView)convertView.findViewById(R.id.textView18);
        imgv.setImageResource(img[position]);
        txtv.setText(items[position]);
        return convertView;




    }

}

