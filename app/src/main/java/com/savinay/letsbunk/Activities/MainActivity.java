package com.savinay.letsbunk.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.savinay.letsbunk.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);



        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Intent i1=new Intent(MainActivity.this,EnterDetails.class);



                startActivity(i1);
                finish();
            }
        };
        handler.postDelayed(runnable,1500);

//((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Intent i1=new Intent(MainActivity.this,EnterDetails.class);
//
//
//
//        startActivity(i1);
//        finish();
//    }
//});

        //Start Activity Main Window




    }
}
