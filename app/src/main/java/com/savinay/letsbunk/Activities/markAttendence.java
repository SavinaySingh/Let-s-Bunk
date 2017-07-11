package com.savinay.letsbunk.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.savinay.letsbunk.Adapters.Adapter2;
import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;



public class markAttendence extends AppCompatActivity {
    TextView t1;
    FloatingActionButton f1,f2;
    RecyclerView recyclerView;
    TextView t2,t3;
   public static ArrayList<Subject> ar2=new ArrayList<>();

    int [] arr;
    public static ArrayList<int[]> ar3=new ArrayList<>();
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragment01);


//        Log.e("yo", "measuring ar3 size in on create "+ar3.size() );
        final String name=getIntent().getStringExtra("key01");

        int size=getIntent().getIntExtra("key02",0);
        final ArrayList<Subject> arrayList=new ArrayList<Subject>(size);

               for (int i=0;i<size;i++)
               {
                arrayList.add(new Subject(getIntent().getStringExtra("key"+String.valueOf(i)),
                    getIntent().getStringExtra("k"+String.valueOf(i))));

               }


        for(int i=0;i<arrayList.size();i++)
        {
            ar2.add(arrayList.get(i));
        }


        t1 = (TextView)findViewById(R.id.t);
        t1.setText(name);
        f1= (FloatingActionButton) findViewById(R.id.f1);
        f2= (FloatingActionButton)findViewById(R.id.f2);
        recyclerView= (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final Adapter2 adapter2=new Adapter2(this,arrayList);
        recyclerView.setAdapter(adapter2);
        t2= (TextView) findViewById(R.id.tv1);
        t3= (TextView) findViewById(R.id.textView6);





//
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.INVISIBLE);

                count++;
                for (int i = 0; i < ar2.size(); i++) {

                    if (ar2.get(i).getPer() != "100")
                        ar2.get(i).setPer("0");
                }
                for (int i = 0; i < ar2.size(); i++) {

                    Log.e("yo", ar2.get(i) + " " + ar2.get(i).getPer());
                }
                arr=new int[ar2.size()];
//
                for(int i=0;i<ar2.size();i++)
                {
                    arr[i]= Integer.parseInt(ar2.get(i).getPer());
                }
                ar3.add(arr);






                Log.e("yo", "onClick: "+ar3.size() +"  "+arr.length);
//
            }
            });

//                arr=new int[ar2.size()];
//
//                for(int i=0;i<ar2.size();i++)
//                {
//                    arr[i]= Integer.parseInt(ar2.get(i).getPer());
//                }
//                ar3.add(arr);


//
//
//                Log.e("yo", "onClick: "+ar3.size() +"  "+arr.length);
//
//
//            }
//        });
//
//
//        Log.e(TAG, "onCreateView: abhi main 1 pe hun"+ar3.size() );

        f1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent in=new Intent(markAttendence.this,Attendence.class);
                int sum = 0;
                        int abc[];
                        String []stu = new String[ar3.get(0).length];
                        for (int i = 0; i < ar3.get(0).length; i++) {
                            sum = 0;
                            for (int j = 0; j < ar3.size(); j++) {
                                abc = ar3.get(j);
                                sum += abc[i] ;
                            }
                            stu[i] = String.valueOf(sum/ar3.size());
                        }
                for (int i = 0; i < ar3.get(0).length; i++){
                    Log.e("yo", "onLongClick: " +stu[i]);
                }

                in.putExtra("key01",name);
            in.putExtra("key02",arrayList.size());
           for (int i=0;i<arrayList.size();i++)
          {
            in.putExtra("key"+String.valueOf(i),arrayList.get(i).getSub());
            in.putExtra("k"+String.valueOf(i),arrayList.get(i).getPer());
          }



              in.putExtra("key#1",stu);
                in.putExtra("key#2",count);
                startActivity(in);


                return true;
            }
        });





        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("yo", "onClick: "+ar3.size());

                recyclerView.setVisibility(View.VISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.VISIBLE);


                for(int i=0;i<ar2.size();i++){
                    ar2.get(i).setPer("0");
                }

            }
        });



    }
}
