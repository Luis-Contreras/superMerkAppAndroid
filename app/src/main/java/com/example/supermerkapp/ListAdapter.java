package com.example.supermerkapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater =LayoutInflater.from(context);
        this.context  = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    @Override
    public  ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view = mInflater.inflate(R.layout.list_element,null);

        return new ListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
       holder.binData(mData.get(position));
    }
    public void setItems (List<ListElement> items ){mData=items;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        //ImageView imgP;
        TextView nameP,precioP;
        ViewHolder(View itemView){
            super(itemView);
            //imgP = itemView.findViewById(R.id.iconP);
            nameP = itemView.findViewById(R.id.nombreP);
            precioP = itemView.findViewById(R.id.precioP);
        }



        public void binData(ListElement listElement) {
            nameP.setText(listElement.getNameP());
            precioP.setText(listElement.getPrecioP());
        }
    }
}
