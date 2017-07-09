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
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.savinay.letsbunk.Adapters.Adapter1;
import com.savinay.letsbunk.Adapters.Adapter2;
import com.savinay.letsbunk.Adapters.Adapter3;
import com.savinay.letsbunk.Fragments.Fragment01;
import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;


public class FinalActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;
    static String n;
    static ArrayList<Subject> ar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bunk=new Intent(FinalActivity.this,whatever.class);
                bunk.putExtra("key02",ar1.size());
                for (int i=0;i<ar1.size();i++)
                {
                    bunk.putExtra("key"+String.valueOf(i),ar1.get(i).getSub());
                    bunk.putExtra("k"+String.valueOf(i),ar1.get(i).getPer());
                }
                startActivity(bunk);
            }
        });
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.setOffscreenPageLimit(2);
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
        TextView t2;
        RecyclerView recyclerView;
        BarChart barChart;
        RecyclerView r;
        String[] a={"75","87","95","65"};
        FloatingActionButton f1;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;

            if( getArguments().getInt(ARG_SECTION_NUMBER)==1) {

                rootView = inflater.inflate(R.layout.fragment_fragment01, container, false);
                t1 = (TextView) rootView.findViewById(R.id.t);
                t1.setText(n);
                f1= (FloatingActionButton) rootView.findViewById(R.id.f1);
                recyclerView= (RecyclerView) rootView.findViewById(R.id.rv);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                Adapter2 adapter2=new Adapter2(getActivity(),ar1);
                recyclerView.setAdapter(adapter2);
                t2= (TextView) rootView.findViewById(R.id.tv1);
                f1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recyclerView.setVisibility(View.INVISIBLE);
                        t2.setVisibility(View.VISIBLE);
                    }
                });


            }




            else if( getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                rootView = inflater.inflate(R.layout.fragment_fragment2, container, false);
                barChart = (BarChart) rootView.findViewById(R.id.barGraph);

                ArrayList<BarEntry> barEntries = new ArrayList<>();

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
            else {
                rootView = inflater.inflate(R.layout.fragment_fragment3, container, false);
                r= (RecyclerView) rootView.findViewById(R.id.rec);
                r.setLayoutManager(new LinearLayoutManager(getActivity()));
                Adapter3 adapter01=new Adapter3(getActivity(),ar1,a);
                r.setAdapter(adapter01);


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


            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).



            Fragment01.newInstance(n,ar1);


           return PlaceholderFragment.newInstance(position + 1);

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Input";
                case 1:
                    return "Bar Chart";
                case 2:
                    return "Percentage";
            }
            return null;
        }
    }
}
