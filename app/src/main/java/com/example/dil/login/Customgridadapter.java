package com.example.dil.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by dil on 5/26/17.
 */

public class Customgridadapter extends BaseAdapter {
    TextView text;
    String[] dscr;
    String [] items;
    Integer[] clr;
    Context cntxt;
    public Customgridadapter(nextActivity act,String[] items)
    {
       // this.dscr = dscr;
       // this.clr = clr;
        this.items = items;
        this.cntxt =act;
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
        LayoutInflater lay = (LayoutInflater) cntxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = convertView;
        row = lay.inflate(R.layout.customgridadapter,null);
        text = (TextView)row.findViewById(R.id.textView3);
       // row.setBackgroundColor(Color.BLUE);
        text.setText(items[position]);



        return row;
    }

   }
