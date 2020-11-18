package com.example.supermerkapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.supermerkapp.ListAdapter;
import com.example.supermerkapp.ListAdapterShop;
import com.example.supermerkapp.ListElement;
import com.example.supermerkapp.ListElementShop;
import com.example.supermerkapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopCarFragment extends Fragment {

    List<ListElementShop> elementShopList;
    RecyclerView recyclerViewProductosShop;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShopCarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopCarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopCarFragment newInstance(String param1, String param2) {
        ShopCarFragment fragment = new ShopCarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_shop_car, container, false);
        elementShopList = new ArrayList<>();
        recyclerViewProductosShop = vista.findViewById(R.id.listRecyclerViewShop);
        recyclerViewProductosShop.setLayoutManager(new LinearLayoutManager(getContext()));
        init();
        ListAdapterShop listAdapterShop = new ListAdapterShop(elementShopList,getContext());
        recyclerViewProductosShop.setAdapter(listAdapterShop);

       /* btnsumar = vista.findViewById(R.id.btnsumar);
        btnrestar = vista.findViewById(R.id.btnrestar);
        contador = vista.findViewById(R.id.contador);*/
        /*    btnsumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorP++;
                contador.setText(Integer.toString(contadorP));
            }
        });
        btnrestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorP--;
                contador.setText(Integer.toString(contadorP));
            }
        });
        contador.setText(Integer.toString(contadorP));*/
        return vista;
    }
    public  void init   (){
        //elementList = new ArrayList<>();
        elementShopList.add(new ListElementShop("Gaseosa","$4000"));
        elementShopList.add(new ListElementShop("Aceite","5000"));
        elementShopList.add(new ListElementShop("Jabon","$4500"));
        elementShopList.add(new ListElementShop("Azucar","$6000"));
        elementShopList.add(new ListElementShop("Leche","$3000"));




        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));



    }
}