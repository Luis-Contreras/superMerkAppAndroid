package com.example.supermerkapp;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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
        int posMarcada=1;
    int contadorP=0;//cuenta la cantidad de productos
    String [] cantidad;

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

    public String[] getCantidad() {
        return cantidad;
    }

    @Override
    public void onBindViewHolder(final ListAdapterShop.ViewHolder holder, final int position) {

       holder.binData(mData.get(position));
       final ListElementShop item = mData.get(position);


       holder.btnsumar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                posMarcada = position;
                notifyDataSetChanged();

               if (posMarcada==position){

                   //contadorP++;
                   item.cantidad++;
                   holder.contador.setText(Integer.toString(item.cantidad));
                   System.out.println("SUMANDO");

               }

           }
       });

       holder.btnrestar.setOnClickListener(new View.OnClickListener() {
           @Override

           public void onClick(View v) {

               posMarcada = position;
               notifyDataSetChanged();
               if (posMarcada==position){



                   item.cantidad--;
                   holder.contador.setText(Integer.toString(item.cantidad));
                   System.out.println("SUMANDO");


               }
           }
       });



    }
    public void setItems (List<ListElementShop> items ){mData=items;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        //ImageView imgP;
        TextView nameP,precioP;
        Button btnsumar,btnrestar;
        TextView contador;

        ViewHolder(View itemView){
            super(itemView);
            //imgP = itemView.findViewById(R.id.iconP);
            nameP = itemView.findViewById(R.id.nombreP);
            precioP = itemView.findViewById(R.id.precioP);
            btnsumar = itemView.findViewById(R.id.btnsumar);
            btnrestar = itemView.findViewById(R.id.btnrestar);
            contador = itemView.findViewById(R.id.contador);
            contador.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }



        public void binData(ListElementShop listElementShop) {
            nameP.setText(listElementShop.getNameP());
            precioP.setText(listElementShop.getPrecioP());
            contador.setText(Integer.toString(listElementShop.cantidad));

        }
    }
}
