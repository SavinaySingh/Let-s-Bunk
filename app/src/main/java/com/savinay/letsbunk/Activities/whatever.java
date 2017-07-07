package com.savinay.letsbunk.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.savinay.letsbunk.Adapters.Adapter4;
import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;

public class whatever extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatever);
        ArrayList<Subject>arrayList=new ArrayList<>();
        String[] s={"0","2","4","0"};
        int size=getIntent().getIntExtra("key02",0);
        for (int i=0;i<size;i++)
        {
            arrayList.add(new Subject(getIntent().getStringExtra("key"+String.valueOf(i)),
                    getIntent().getStringExtra("k"+String.valueOf(i))));

        }
        recyclerView= (RecyclerView) findViewById(R.id.rjr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter4 adapter4=new Adapter4(this,arrayList,s);
        recyclerView.setAdapter(adapter4);
    }
}
