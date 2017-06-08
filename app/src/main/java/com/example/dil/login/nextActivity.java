package com.example.dil.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class nextActivity extends AppCompatActivity {
    GridView gv;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        gv=(GridView) findViewById(R.id.gridview);
        String[] items={"Hindi","Telugu","Tamil","English","  Malayalam"};
        final String[] discrptn = {"Bollywood songs","Tollywood songs","Tamil Songs","English Songs"};
        //ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        Customgridadapter arrayAdapter = new Customgridadapter(this,items);
        gv.setAdapter(arrayAdapter);

        pref = getSharedPreferences("saveddata",MODE_PRIVATE);


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=discrptn[position];
                Intent intent=new Intent(nextActivity.this,Listview.class);
                intent.putExtra("k",s);
                startActivity(intent);

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menubar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.settings :
                Intent i = new Intent(nextActivity.this,nextActivity.class);
                startActivity(i);
                break;
            case R.id.delete :
                break;
            case R.id.logout :

                SharedPreferences.Editor del = pref.edit();
                del.remove("key");
                del.remove("key2");
                del.apply();



                Intent intent = new Intent(nextActivity.this,Login.class);
                startActivity(intent);
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    /*public void logout(View v){

        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }*/
}
