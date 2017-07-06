package com.savinay.letsbunk.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.savinay.letsbunk.MODELS.Subject;
import com.savinay.letsbunk.R;

import java.util.ArrayList;

/**
 * Created by savinaysingh on 05/07/17.
 */

public class Adapter1 extends RecyclerView.Adapter<Adapter1.HolderClass> {

    private Context context;
    private ArrayList<Subject> arrayList;
    public Adapter1(Context context,ArrayList<Subject> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public HolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View v= li.inflate(R.layout.adapter_item_1,null);

        HolderClass holderClass=new HolderClass(v);
      holderClass.t1= (TextView) v.findViewById(R.id.ad_item);
        holderClass.t2= (TextView) v.findViewById(R.id.textView3);
        return holderClass;
    }

    @Override
    public void onBindViewHolder(HolderClass holder, int position) {
        holder.t1.setText(arrayList.get(position).getSub());
        holder.t2.setText(arrayList.get(position).getPer());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class HolderClass extends RecyclerView.ViewHolder {
      TextView t1,t2;
        public HolderClass(View itemView) {
            super(itemView);
        }
    }
}
