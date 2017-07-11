package com.savinay.letsbunk.Adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.savinay.letsbunk.Activities.Attendence;
import com.savinay.letsbunk.Activities.markAttendence;
import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.savinay.letsbunk.Activities.Attendence.ar2;

/**
 * Created by savinaysingh on 07/07/17.
 */

public class Adapter2 extends RecyclerView.Adapter<Adapter2.HolderClass> {

    private Context context;
    private ArrayList<Subject> arrayList;
    public Adapter2(Context context,ArrayList<Subject> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }





    @Override
    public HolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= li.inflate(R.layout.adapter_item_2,null);

        HolderClass holderClass=new HolderClass(v);
        holderClass.t1= (TextView) v.findViewById(R.id.ad_item);
        holderClass.t2= (TextView) v.findViewById(R.id.textView3);

     //   holderClass.c1=(CheckBox)v.findViewById(R.id.checkBox);



        return holderClass;
    }

    @Override
    public void onBindViewHolder(final Adapter2.HolderClass holder, final int position) {
        holder.t1.setText(arrayList.get(position).getSub());
        holder.t2.setText(arrayList.get(position).getPer());


//       if(holder.c1.isChecked())
//       {
//           Log.e(TAG, "onBindViewHolder: " );
//           FinalActivity.ar2.set(position,new Subject(arrayList.get(position).getSub(),"1"));
//       }

       holder.v.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.e(TAG, "onClick: " );

               Handler h=new Handler();
               Runnable r=new Runnable() {
                   @Override
                   public void run() {
//                       holder.c1.setChecked(false);
                       holder.v.setBackgroundColor(0xffffffff);
                   }
               };
               h.postDelayed(r,250);
//               holder.c1.setChecked(true);
               holder.v.setBackgroundColor(0xff00ef78);



//               FinalActivity.ar2.set(position,new Subject(arrayList.get(position).getSub(),"100"));
               markAttendence.ar2.set(position,new Subject(arrayList.get(position).getSub(),"100"));
           }
       });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class HolderClass extends RecyclerView.ViewHolder {
        TextView t1,t2;
//        CheckBox c1;
        View v;
        public HolderClass(View itemView) {
            super(itemView);
            v=itemView;
        }
    }





}


