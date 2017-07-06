package com.savinay.letsbunk.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.savinay.letsbunk.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i1=new Intent(MainActivity.this,EnterDetails.class);



        startActivity(i1);
        finish();
    }
});

        //Start Activity Main Window




    }
}
