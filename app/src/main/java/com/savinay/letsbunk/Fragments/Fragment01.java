package com.savinay.letsbunk.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.savinay.letsbunk.Adapters.Adapter2;
import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class Fragment01 extends Fragment {
    TextView t1;
    RecyclerView recyclerView;
    private static final String ARG_PARAM1 = "param1";

    private static  ArrayList<Subject> ar;
    // TODO: Rename and change types of parameters
    private String name;


    private OnFragmentInteractionListener mListener;

    public Fragment01() {
        // Required empty public constructor
    }



    public static Fragment01 newInstance(String param1, ArrayList<Subject> arrayList) {
        Fragment01 fragment = new Fragment01();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        ar=arrayList;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: "+name);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
            Log.e(TAG, "onCreate: "+name );

        }





    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View rtView=inflater.inflate(R.layout.fragment_fragment01, container, false);
//
        t1= (TextView) rtView.findViewById(R.id.t);
        t1.setText(name);
        Log.e(TAG, "onCreateView: "+t1.getText().toString() );
        recyclerView= (RecyclerView) rtView.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Adapter2 adapter2=new Adapter2(getActivity(),ar);
        recyclerView.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();


        return rtView;
    }





























    //useless
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
