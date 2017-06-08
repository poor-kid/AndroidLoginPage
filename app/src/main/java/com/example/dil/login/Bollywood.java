package com.example.dil.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Bollywood extends Fragment {


    public Bollywood() {
        // Required empty public constructor
    }
GridView gv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bollywood, container, false);
        gv = (GridView) v.findViewById(R.id.gridview);
        String[] str = {"Sachin","Dear Zindagi","Hindi Medium"};
        Integer[] img = {R.drawable.eye,android.R.drawable.alert_dark_frame,R.drawable.eye};
        CustomGridView adapt = new CustomGridView(getActivity(),str,img);
        gv.setAdapter(adapt);

        return null;
    }

}
