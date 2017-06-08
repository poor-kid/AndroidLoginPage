package com.example.dil.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText _email,_password;
    String email,password,semail,spassword;
    SharedPreferences validdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _email = (EditText) findViewById(R.id.editText);
        _password = (EditText) findViewById(R.id.editText8);

         validdata = getSharedPreferences("saveddata",MODE_PRIVATE);
        semail= validdata.getString("key","not present");
        spassword = validdata.getString("key2","not present");
    }


    public void Create(View v)
    {
        Intent sgnup = new Intent(this,Signup.class);
        startActivity(sgnup);

    }

    public void signin(View v){


        if(validate()==true)
        {
            email = _email.getText().toString();
            password = _password.getText().toString();




            //Toast.makeText(this,"the rem is"+email.substring(13,23),Toast.LENGTH_LONG).show();
            //spinner


            final ProgressDialog prd = new ProgressDialog(Login.this,
                    R.style.AppTheme_Dark_Dialog);
            prd.setIndeterminate(true);
            prd.setMessage("Authenticating...");
            prd.show();


            /*final ProgressDialog prd = new ProgressDialog(Login.this);
            //prd.setTitle("Authenticating..");
            prd.setMessage("Authenticating..");
            prd.setProgressStyle(R.drawable.progressbar_circular_style);
            prd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            prd.show();
            */Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        prd.dismiss();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            t.start();

            Intent i = new Intent(this, ResultLogin.class);
            i.putExtra("val", email);
            i.putExtra("val2", password);
            startActivity(i);

            }
        /*else {
            Toast.makeText(this,"Enter Valid login credentials",Toast.LENGTH_LONG).show();

        }
        */}

    //Validation logic

    public boolean validate()
    {
         email = _email.getText().toString();
         password = _password.getText().toString();

        boolean valid = true;

        int len = email.length();

            int rem = len - 10;

            if ( email.isEmpty() == true || len<10 || !(email.substring(rem, len).equals("@gmail.com") || email.substring(rem, len).equals("@yahoo.com"))) {
                _email.setError("enter a valid email address");
                // Toast.makeText(this, "please enter the login credentials", Toast.LENGTH_LONG).show();
                valid = false;
            }
                else if(!email.equals(semail))
                {
                    _email.setError("Email doesn't exist");
                    valid = false;
                }
            else {
                _email.setError(null);

            }
            if ( password.isEmpty() || password.length() < 4 || password.length() > 10) {
                _password.setError("between 4 and 10 alphanumeric characters");
                valid = false;
            }
            else if(!password.equals(spassword))
            {
                _password.setError("password didn't match");
                valid = false;
            }
            else {
                _password.setError(null);
                Toast.makeText(Login.this,semail+" "+spassword,Toast.LENGTH_LONG).show();
            }



        return valid;

    }
}
