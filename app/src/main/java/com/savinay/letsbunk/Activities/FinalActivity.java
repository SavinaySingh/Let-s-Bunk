package com.savinay.letsbunk.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.savinay.letsbunk.Adapters.Adapter2;
import com.savinay.letsbunk.Adapters.Adapter3;
import com.savinay.letsbunk.Fragments.Fragment01;

import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;


public class FinalActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

public static final String TAG="yo";
    private ViewPager mViewPager;
    static String n;
    static ArrayList<Subject> ar1;
    public static ArrayList<Subject> ar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        String name=getIntent().getStringExtra("key01");
        n=name;
        int size=getIntent().getIntExtra("key02",0);
        ArrayList<Subject> arrayList=new ArrayList<Subject>(size);
        for (int i=0;i<size;i++)
        {
            arrayList.add(new Subject(getIntent().getStringExtra("key"+String.valueOf(i)),
                    getIntent().getStringExtra("k"+String.valueOf(i))));

        }
        ar1=arrayList;
        ar2=arrayList;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.setOffscreenPageLimit(4);
//
   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_final, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i=new Intent(FinalActivity.this,AboutDeveloper.class);
            startActivity(i);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }



     //      CLASS START

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }





        TextView t1;
        static int count=0;
        TextView t2,t3;
        RecyclerView recyclerView;
        BarChart barChart;
        RecyclerView r;
//        String[] a={"75","87","95","65"};
        String[] stu;
        Button b1;
        FloatingActionButton f1,f2;
        int arr[];

        public int[] getArr() {
            return arr;
        }

        ArrayList<int[]> ar3=new ArrayList<>();


        @Override
        public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;

            if( getArguments().getInt(ARG_SECTION_NUMBER)==1) {

                rootView = inflater.inflate(R.layout.fragment_fragment01, container, false);
                t1 = (TextView) rootView.findViewById(R.id.t);
                t1.setText(n);
                f1= (FloatingActionButton) rootView.findViewById(R.id.f1);
                f2= (FloatingActionButton) rootView.findViewById(R.id.f2);
                recyclerView= (RecyclerView) rootView.findViewById(R.id.rv);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                final Adapter2 adapter2=new Adapter2(getActivity(),ar1);
                recyclerView.setAdapter(adapter2);
                t2= (TextView) rootView.findViewById(R.id.tv1);
                t3= (TextView) rootView.findViewById(R.id.textView6);
//                barChart = (BarChart) rootView.findViewById(R.id.barGraph);
//                r= (RecyclerView) rootView.findViewById(R.id.rec);
                f1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recyclerView.setVisibility(View.INVISIBLE);
                        t2.setVisibility(View.VISIBLE);
                        t3.setVisibility(View.INVISIBLE);



                        for(int i=0;i<ar2.size();i++) {

                            if(ar2.get(i).getPer()!="100")
                            ar2.get(i).setPer("0");
                        }
                        for (int i=0;i<ar2.size();i++)
                        {

                            Log.e("yo",ar2.get(i)+" "+ar2.get(i).getPer());
                        }

                        arr=new int[ar2.size()];

                        for(int i=0;i<ar2.size();i++)
                        {
                            arr[i]= Integer.parseInt(ar2.get(i).getPer());
                        }
                        ar3.add(arr);









                        Log.e("yo", "onClick: "+ar3.size() +"  "+arr.length);


                    }
                });


                Log.e(TAG, "onCreateView: abhi main 1 pe hun"+ar3.size() );
                f2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        recyclerView.setVisibility(View.VISIBLE);
                        t2.setVisibility(View.INVISIBLE);
                        t3.setVisibility(View.VISIBLE);


                        for(int i=0;i<ar2.size();i++){
                            ar2.get(i).setPer("0");
                        }

                    }
                });



            }




            else if( getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                Log.e(TAG, "onCreateView: "+ar3.size() );
                rootView = inflater.inflate(R.layout.fragment_fragment2, container, false);
                barChart = (BarChart) rootView.findViewById(R.id.barGraph);

                ArrayList<BarEntry> barEntries = new ArrayList<>();

                Log.e(TAG, "onCreateView: ye graph vala hai"+ar3.size() );


                barEntries.add(new BarEntry(1,75));
                barEntries.add(new BarEntry(2, 87));
                barEntries.add(new BarEntry(3,95));
                barEntries.add(new BarEntry(4,65));





                BarDataSet barDataSet = new BarDataSet(barEntries, "Subjects");
                ArrayList<String> theDates = new ArrayList<>();
                theDates.add("Physics");
                theDates.add("Chemistry");
                theDates.add("Maths");
                theDates.add("Programming");




                BarData barData = new BarData(barDataSet);
                barChart.setData(barData);

                barChart.setTouchEnabled(true);
                barChart.setScaleEnabled(true);
                barChart.setDragEnabled(true);

            }
            else if( getArguments().getInt(ARG_SECTION_NUMBER)==3){
                rootView = inflater.inflate(R.layout.fragment_fragment3, container, false);
                r= (RecyclerView) rootView.findViewById(R.id.rec);
                r.setLayoutManager(new LinearLayoutManager(getActivity()));

//                Log.e(TAG, "onCreateView: "+ar3.size()+" "+ar3.get(0).length);
                b1= (Button) rootView.findViewById(R.id.button);



                if(ar3.size()!=0) {
                    Log.e(TAG, "onCreateView: if" );
                 int sum = 0;
                 int abc[];
                 stu = new String[ar3.get(0).length];
                 for (int i = 0; i < ar3.get(0).length; i++) {
                     sum = 0;
                     for (int j = 0; j < ar3.size(); j++) {
                         abc = ar3.get(j);
                         sum += abc[i] ;
                     }
                     stu[i] = String.valueOf(sum/ar3.size());
                    }
                 }


             else {
                    Log.e("yo", "onCreateView: "+"always" );
                stu = new String[3];
                    for (int i=0;i<3;i++)
                        stu[i]="0";


             }



                 final Adapter3 adapter01 = new Adapter3(getActivity(), ar1,stu);
                 adapter01.notifyDataSetChanged();
                 r.setAdapter(adapter01);
                adapter01.notifyDataSetChanged();
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Log.e(TAG, "onClick: on button"+stu[0] );
//                        int sum = 0;
//                        int abc[];
//                        stu = new String[ar3.get(0).length];
//                        for (int i = 0; i < ar3.get(0).length; i++) {
//                            sum = 0;
//                            for (int j = 0; j < ar3.size(); j++) {
//                                abc = ar3.get(j);
//                                sum += abc[i] ;
//                            }
//                            stu[i] = String.valueOf(sum/ar3.size());
//                        }
//                        adapter01.setDyn(stu);
                    }
                });

             }
            else
            {
                rootView=inflater.inflate(R.layout.activity_whatever,container,false);


            }

            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }



        //change here
        @Override
        public Fragment getItem(int position) {

           return PlaceholderFragment.newInstance(position + 1);

        }

        @Override
        public int getCount() {
         //4 pages
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Input";
                case 2:
                    return "Graph";
                case 1:
                    return "%";
                case 3:
                    return "Bunk";
            }
            return null;
        }
    }
}
