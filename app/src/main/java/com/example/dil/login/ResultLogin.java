package com.example.dil.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultLogin extends AppCompatActivity {
    TextView txtv,txtv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_login);
        txtv = (TextView) findViewById(R.id.textView7);
        txtv2 = (TextView) findViewById(R.id.textView8);
        Intent ref = getIntent();
        txtv.setText(ref.getStringExtra("val"));
        txtv2.setText(ref.getStringExtra("val2"));
    }
    public void next(View v)
    {
        Intent nxt = new Intent(this,Navigationplaylist.class);
        //Intent nxt = new Intent(this,nextActivity.class);
        startActivity(nxt);

    }
}
