package com.savinay.letsbunk.Adapters;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by savinaysingh on 08/07/17.
 */

public class Adapter4 extends RecyclerView.Adapter<Adapter4.HolderClass> {

    private Context context;
    private ArrayList<Subject> arrayList;
    private String[] a;
    public Adapter4(Context context,ArrayList<Subject> arrayList,String[] a) {
        this.context=context;
        this.arrayList=arrayList;
        this.a=a;
    }

    @Override
    public Adapter4.HolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= li.inflate(R.layout.adapter_item_4,null);


        Adapter4.HolderClass holderClass=new Adapter4.HolderClass(v);
        holderClass.t1= (TextView) v.findViewById(R.id.ad_item);
        holderClass.t2= (TextView) v.findViewById(R.id.sb1);
//        holderClass.t3= (TextView) v.findViewById(R.id.sb2);
//        holderClass.t4= (TextView) v.findViewById(R.id.sb3);
        return holderClass;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(Adapter4.HolderClass holder, int position) {
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        holder.t1.setText(formattedDate);

        Log.e(TAG, "onBindViewHolder: let me check "+a[position] );



        if(a[position].equals("100")){
            Log.e(TAG, "onBindViewHolder: check" );
            holder.t2.setText(arrayList.get(position).getSub());
            holder.v.setVisibility(View.VISIBLE);
        }


        else
            holder.v.setVisibility(View.INVISIBLE);


//        holder.t3.setText(arrayList.get(1).getSub());
//        holder.t4.setText(arrayList.get(2).getSub());
//        if(a[0]=="0")
//        {
//            Log.e(TAG, "onBindViewHolder: 0" );
//            holder.t2.setVisibility(View.INVISIBLE);
//        }
//        if(a[1]=="0")
//        {
//            Log.e(TAG, "onBindViewHolder: 1" );
//            holder.t2.setVisibility(View.INVISIBLE);
//        }
//        if(a[2]=="0")
//        {
//            Log.e(TAG, "onBindViewHolder: 2" );
//            holder.t2.setVisibility(View.INVISIBLE);
//        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class HolderClass extends RecyclerView.ViewHolder {
        TextView t1,t2;
        View v;
        public HolderClass(View itemView) {
            super(itemView);
            v=itemView;
        }
    }
}
