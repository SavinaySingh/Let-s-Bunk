package com.savinay.letsbunk.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.savinay.letsbunk.Adapters.Adapter1;
import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;

public class SetSubjects extends AppCompatActivity {
RecyclerView recyclerView;
    EditText t1,t2;
    ArrayList<Subject> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_subjects);

        arrayList=new ArrayList<Subject>();
        final String name=getIntent().getStringExtra("key2");

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        t1= (EditText) findViewById(R.id.e1);
        t2= (EditText) findViewById(R.id.e2);

        final Adapter1 adapter1=new Adapter1(SetSubjects.this,arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter1);

        ((Button)findViewById(R.id.add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(new Subject(t1.getText().toString()+"   ",t2.getText().toString()));
                adapter1.notifyDataSetChanged();
            }
        });

        ((Button)findViewById(R.id.done)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(SetSubjects.this,FinalActivity.class);
                //name arraylist
                i3.putExtra("key01",name);


          //      i3.putExtra("key02",arrayList);
                startActivity(i3);
                finish();
            }
        });

//        ((Button)findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                recyclerView.setVisibility(View.INVISIBLE);
//            }
//        });


    }
}
