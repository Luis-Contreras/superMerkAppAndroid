package com.example.supermerkapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supermerkapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {

    //se definen los elementos a utilizar desde el layout
    TextView tvUsuario, tvCorreo;

    //variable global que recibe los datos del usuario
    private String usuario;

    public UserFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //recibimos los datos que vienen desde el NavigationApp
            usuario = getArguments().getString("Usuario", "");

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_user, container, false);

        tvUsuario = vista.findViewById(R.id.tvUsuario);
        tvCorreo = vista.findViewById(R.id.tvCorreo);

        String[] arreglo = usuario.split(",");

        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = arreglo[i].replace("[","");
            arreglo[i] = arreglo[i].replace("\"","");
            arreglo[i] = arreglo[i].replace("]","");
            arreglo[i] = arreglo[i].replace("}","");
            arreglo[i] = arreglo[i].replace("{","");
            arreglo[i] = arreglo[i].replace("name:","");
            arreglo[i] = arreglo[i].replace("lastName:","");
            arreglo[i] = arreglo[i].replace("email:","");
        }


        tvUsuario.setText(arreglo[0].toString() + " " + arreglo[1]);
        tvCorreo.setText(arreglo[2].toString());

        return  vista;

    }
}