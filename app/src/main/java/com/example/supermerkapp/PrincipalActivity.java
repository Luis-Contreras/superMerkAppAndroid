package com.example.supermerkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
import org.json.JSONObject;
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

                    JSONArray jsonArray = null;
                    try {
                        jsonArray = new JSONArray(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String[] strArr = new String[jsonArray.length()];

                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            strArr[i] = jsonArray.getString(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    for(int i = 0; i < strArr.length; i++){
                        strArr[i] = strArr[i].replace("[","");
                        strArr[i] = strArr[i].replace("\"","");
                        strArr[i] = strArr[i].replace("]","");
                        strArr[i] = strArr[i].replace("{","");
                        strArr[i] = strArr[i].replace("}","");
                        strArr[i] = strArr[i].replace(":","");
                        strArr[i] = strArr[i].replace("nombre","");
                        strArr[i] = strArr[i].replace("descripcion","");
                        strArr[i] = strArr[i].replace("retrato","");
                        strArr[i] = strArr[i].replace("img","");
                        strArr[i] = strArr[i].replace("stock","");
                        strArr[i] = strArr[i].replace("retrato","");
                        strArr[i] = strArr[i].replace("precio","");
                    }

                    String[][] matrix = new String[strArr.length][];
                    int r = 0;
                    for (String row : strArr) {
                        matrix[r++] = row.split(",");
                    }

                    lista.setAdapter(new Adaptador(thisContext, matrix ));

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