package com.example.supermerkapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapterShop extends RecyclerView.Adapter<ListAdapterShop.ViewHolder> {

    private List<ListElementShop> mData;
    private LayoutInflater mInflater;
    private Context context;
    private Button btnsumar;


    public ListAdapterShop(List<ListElementShop> itemList, Context context){
        this.mInflater =LayoutInflater.from(context);
        this.context  = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    @Override
    public  ListAdapterShop.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view = mInflater.inflate(R.layout.list_shopcar,null);

        return new ListAdapterShop.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ListAdapterShop.ViewHolder holder, final int position) {
        Button btnsumar,btnrestar;
        EditText contador;
        int contadorP;//cuenta la cantidad de productos
       holder.binData(mData.get(position));
       //holder.btnsumar
    }
    public void setItems (List<ListElementShop> items ){mData=items;

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



        public void binData(ListElementShop listElementShop) {
            nameP.setText(listElementShop.getNameP());
            precioP.setText(listElementShop.getPrecioP());
        }
    }
}
