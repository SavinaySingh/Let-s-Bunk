package com.savinay.letsbunk.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.savinay.letsbunk.R;

public class EnterDetails extends AppCompatActivity {
EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);

        e1= (EditText) findViewById(R.id.name);



        ((FloatingActionButton)findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(EnterDetails.this,SetSubjects.class);
                i2.putExtra("key2",e1.getText().toString());
                startActivity(i2);
                finish();
            }
        });
        ((FloatingActionButton)findViewById(R.id.fab)).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(EnterDetails.this,"Why so angry?",Toast.LENGTH_SHORT).show();
                Intent i2=new Intent(EnterDetails.this,SetSubjects.class);
                i2.putExtra("key2",e1.getText().toString());
                startActivity(i2);
                finish();
                return true;
            }
        });

    }
}
