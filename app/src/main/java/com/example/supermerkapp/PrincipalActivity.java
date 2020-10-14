package com.example.supermerkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONStringer;

import java.util.Arrays;

public class PrincipalActivity extends AppCompatActivity {

    ListView lista;
    PrincipalActivity thisContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lista = findViewById(R.id.lvLista);
        getProductos("http://192.168.1.3/ApiSupermerkApp/getProductos.php");


    }


    private String[] getProductos(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){

                    JSONArray temp = null;
                    try {
                        temp = new JSONArray(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        String[] mArray = temp.join(":").split(":");

                        /*String[][] datos = {
                                {"Arroz Roa","Libra de arroz roa de 500gr, super premuim ideal para compartir con la familia, rendidora","Libra de arroz roa 500gr","50","1500"},
                                {"Panela Caribe","Panela Caribe, dulce de 500gr, traida directamente desde cali, ideal para aguapanela, limbonadas","Panela Caribe 500gr","30","3000"},
                                {"Pañales pequeñin","Pañales pequeñin, Etapa 1 y 2, perfecta para bendiciones traviesas que no se quedan quietas, absorve de todo, con eucalito","Pañales pequeñin etapa 3","40","1200"}
                        };*/

                        lista.setAdapter(new Adaptador(thisContext, mArray ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(PrincipalActivity.this, "No hay productos disponibles", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PrincipalActivity.this, error.toString() , Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        return new String[0];
    }
}