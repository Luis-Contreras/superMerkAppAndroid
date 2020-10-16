package com.example.supermerkapp;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

public class Adaptador extends BaseAdapter{

    private static LayoutInflater inflater = null;

    Context context;
    String[][] datos;
    Adaptador thisContext = this;

    public Adaptador(Context conexto, String[][] datos){
        this.context =  conexto;
        this.datos = datos;

        inflater = (LayoutInflater) conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView tvNombre = vista.findViewById(R.id.tvNombre);
        TextView tvDescripcion = vista.findViewById(R.id.tvDescripcion);
        TextView tvPrecio = vista.findViewById(R.id.tvPrecio);
        ImageView imgList = vista.findViewById(R.id.imgList);


        tvNombre.setText(Html.fromHtml(datos[i][0]));
        tvDescripcion.setText(Html.fromHtml(datos[i][2]));
        tvPrecio.setText("$ " + datos[i][5]);
        /*imgList.setImageResource(datosImg[i]);*/

        /*imgList.setTag(i);

        imgList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen = new Intent(context, VisorImagen.class);
                visorImagen.putExtra("IMG", datosImg[(Integer)v.getTag()]);
                context.startActivity(visorImagen);
            }
        });*/

        return vista;
    }

    @Override
    public int getCount() {
        /*return datosImg.length;*/
        return datos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
