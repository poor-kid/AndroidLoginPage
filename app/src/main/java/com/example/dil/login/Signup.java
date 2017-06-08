package com.example.dil.login;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Signup extends AppCompatActivity {
    SharedPreferences pref;
    EditText _name,_email,_password,_confmpassword;
    ImageView visible,notvisible,cnfvisible,cnfnotvisible;
    TextView txt;
    private CheckBox showpassword;
    RadioGroup rg;
    RadioButton rb1,rb2;
    String str,semail,spassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        rg=(RadioGroup)findViewById(R.id.radiogroup);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        _name = (EditText) findViewById(R.id.editText4);
        _email = (EditText) findViewById(R.id.editText5);
        _password = (EditText) findViewById(R.id.editText6);
        _confmpassword = (EditText) findViewById(R.id.editText7);

        visible = (ImageView)findViewById(R.id.imageView2);
        notvisible = (ImageView)findViewById(R.id.imageView3);
        visible.setVisibility(View.INVISIBLE);
        notvisible.setVisibility(View.VISIBLE);


        cnfvisible = (ImageView)findViewById(R.id.imageView4);
        cnfnotvisible = (ImageView)findViewById(R.id.imageView5);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (rb1.getId()==checkedId){
                    str=rb1.getText().toString();
                }
                else {
                    str=rb2.getText().toString();
                }
            }
        });

        pref = getSharedPreferences("saveddata",MODE_PRIVATE);




        /*cnfvisible.setVisibility(View.INVISIBLE);
        cnfnotvisible.setVisibility(View.VISIBLE);
*/
      /*  showpassword = (CheckBox)findViewById(R.id.checkBox);
        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked) {
                   _password.setTransformationMethod(null);
               }
               else
               {
                   _password.setTransformationMethod(new PasswordTransformationMethod());
               }
            }
        });
*/

    /*  _confmpassword.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              if(event.equals(MotionEvent.ACTION_BUTTON_PRESS) )
              {
                  cnfvisible.setVisibility(View.INVISIBLE);
                  cnfnotvisible.setVisibility(View.VISIBLE);

              }

              return false;
          }
      });


    */

    _password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(hasFocus)
            {
                _password.setError(null);

                visible.setVisibility((View.INVISIBLE));
                notvisible.setVisibility(View.VISIBLE);
            }
        }
    });
    _confmpassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
          @Override
          public void onFocusChange(View v, boolean hasFocus) {
              if(hasFocus)
              {
                  _confmpassword.setError(null);

                  cnfvisible.setVisibility(View.INVISIBLE);
                  cnfnotvisible.setVisibility(View.VISIBLE);
              }
              else
              {
                  cnfvisible.setVisibility(View.INVISIBLE);
                  cnfnotvisible.setVisibility(View.INVISIBLE);

              }
          }
      });
    }

    public void visibleoff(View v)
    {
        visible.setVisibility(View.VISIBLE);
        notvisible.setVisibility(View.INVISIBLE);

        _password.setTransformationMethod(null);

    }

    public void visibleon(View v)
    {
        visible.setVisibility(View.INVISIBLE);
        notvisible.setVisibility(View.VISIBLE);
        _password.setTransformationMethod(new PasswordTransformationMethod());
    }

    public void cnfvisibleoff(View v)
    {
        cnfvisible.setVisibility(View.VISIBLE);
        cnfnotvisible.setVisibility(View.INVISIBLE);

        _confmpassword.setTransformationMethod(null);

    }

    public void cnfvisible(View v)
    {
        cnfvisible.setVisibility(View.INVISIBLE);
        cnfnotvisible.setVisibility(View.VISIBLE);

        _confmpassword.setTransformationMethod(new PasswordTransformationMethod());

    }

//showpassword.setO
    /*public void checkBox(View v)
    {

    }
*/
    public void loggin(View v)
    {

        Intent loggin = new Intent(this,Login.class);
        startActivity(loggin);
    }
    public void sgnup(View v)
    {
        if(validate() == true) {
            /*final ProgressDialog prd = new ProgressDialog(Signup.this);

            prd.setMessage("Creating account..");
            prd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            prd.show();
            */
            final ProgressDialog prd = new ProgressDialog(Signup.this,
                    R.style.AppTheme_Dark_Dialog);
            prd.setIndeterminate(true);
            prd.setMessage("Creating account...");
            prd.show();


            Thread t = new Thread(new Runnable() {
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
            String name, email, password, confmpassword;
            name = _name.getText().toString();
            email = _email.getText().toString();
            password = _password.getText().toString();
            confmpassword = _confmpassword.getText().toString();

            Intent sgnup1 = new Intent(this, Login.class);
            sgnup1.putExtra("val", name);
            sgnup1.putExtra("val2", email);
            sgnup1.putExtra("val3", password);
            sgnup1.putExtra("val4", confmpassword);


            startActivity(sgnup1);
        }
        else
        {
            _password.setText("");
            _confmpassword.setText("");
            cnfvisible.setVisibility(View.INVISIBLE);
            cnfnotvisible.setVisibility(View.INVISIBLE);

        }

        SharedPreferences.Editor editdata = pref.edit();
        editdata.putString("key",semail);
        editdata.putString("key2",spassword);
        editdata.commit();

    }

    /*public void radiobutton(View v)
    {
        boolean checked = ((RadioButton)v).isChecked();
        if(checked)
        {

        }
    }*/
  /*  public void cpass(View v)
    {
        Toast.makeText(this,"here",Toast.LENGTH_LONG).show();
        //cnfvisible.setVisibility(View.INVISIBLE);
        cnfnotvisible.setVisibility(View.VISIBLE);

    }
  */  public boolean validate()
    {
        int len,rem;

        boolean valid = true;

        String name = _name.getText().toString();
        String email = _email.getText().toString();
        String password = _password.getText().toString();
        String confmpassword = _confmpassword.getText().toString();

        len = email.length();
        rem = len - 10;

        if (name.isEmpty() || name.length() < 3) {
            _name.setError("at least 3 characters");
            valid = false;
        } else {
            _name.setError(null);
        }

        if (email.isEmpty() || len<11 || !(email.substring(rem, len).equals("@gmail.com") || email.substring(rem, len).equals("@yahoo.com"))) {
            _email.setError("enter a valid email address");
            valid = false;
        } else {
            _email.setError(null);
            semail = _email.getText().toString();

        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _password.setError("between 4 and 10 alphanumeric characters");
            visible.setVisibility(View.INVISIBLE);
            notvisible.setVisibility(View.INVISIBLE);
            valid = false;
        } else {
            _password.setError(null);
        }
        if(confmpassword.isEmpty() || !password.equals(confmpassword))
        {
            //Toast.makeText(this,"password didnot match",Toast.LENGTH_LONG).show();
            _confmpassword.setError("password didnot match");
            cnfvisible.setVisibility(View.INVISIBLE);
            cnfnotvisible.setVisibility(View.INVISIBLE);

            valid = false;
        }
        else
        {
            _confmpassword.setError(null);
            spassword = _password.getText().toString();
            valid = true;
        }

        return valid;
    
    }
}
