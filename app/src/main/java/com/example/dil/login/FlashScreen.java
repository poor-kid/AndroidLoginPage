package com.example.dil.login;

import android.content.Intent;
import android.gesture.Gesture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FlashScreen extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener  {

    GestureDetector gestureDetector;
    Thread thread;
    RelativeLayout rel;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flash_screen);
        rel = (RelativeLayout)findViewById(R.id.relativelay);
        gestureDetector = new GestureDetector(FlashScreen.this,FlashScreen.this);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(rel.isPressed())
                    {
                        rel.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                if(event.equals( MotionEvent.ACTION_BUTTON_PRESS))
                                {
                                    Intent i = new Intent(FlashScreen.this,Login.class);
                                    startActivity(i);
                                    finish();
                                    return true;
                                }
                                return false;
                            }
                        });

                    }
                    thread.sleep(10000);

                    Intent i = new Intent(FlashScreen.this,Login.class);
                    startActivity(i);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
            thread.start();
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
       /* if(e.equals(MotionEvent.ACTION_BUTTON_PRESS)) {
            Toast.makeText(FlashScreen.this, "double tap activated", Toast.LENGTH_LONG).show();
            Intent i = new Intent(FlashScreen.this, Login.class);
            startActivity(i);
            finish();
        }
       */
        Toast.makeText(FlashScreen.this, "double tap activated", Toast.LENGTH_LONG).show();

        return false;


    }


    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
