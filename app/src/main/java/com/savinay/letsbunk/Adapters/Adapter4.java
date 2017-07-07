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
        View v= li.inflate(R.layout.adapter_item_1,null);

        Adapter4.HolderClass holderClass=new Adapter4.HolderClass(v);
        holderClass.t1= (TextView) v.findViewById(R.id.ad_item);
        holderClass.t2= (TextView) v.findViewById(R.id.textView3);
        return holderClass;
    }

    @Override
    public void onBindViewHolder(Adapter4.HolderClass holder, int position) {
        holder.t1.setText(arrayList.get(position).getSub());
        holder.t2.setText(a[position]);

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
