package com.example.dil.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Listview extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        tv=(TextView)findViewById(R.id.textView15);
        Intent i=getIntent();
        tv.setText(i.getStringExtra("k"));
    }


}
