package com.savinay.letsbunk.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.savinay.letsbunk.R;

public class EnterDetails extends AppCompatActivity {
EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);

        e1= (EditText) findViewById(R.id.name);

        ((Button)findViewById(R.id.check)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(EnterDetails.this,SetSubjects.class);
                i2.putExtra("key2",e1.getText().toString());
                startActivity(i2);
                finish();

            }
        });


    }
}
