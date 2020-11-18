package com.example.supermerkapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supermerkapp.ListAdapter;
import com.example.supermerkapp.ListElement;
import com.example.supermerkapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    List<ListElement> elementList;
    RecyclerView recyclerViewProductos;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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


        View vista = inflater.inflate(R.layout.fragment_home2, container, false);


        elementList = new ArrayList<>();
        recyclerViewProductos = vista.findViewById(R.id.listRecyclerView);
        recyclerViewProductos.setLayoutManager(new GridLayoutManager(getContext(),2));
        init();
        ListAdapter listAdapter = new ListAdapter(elementList,getContext());
        recyclerViewProductos.setAdapter(listAdapter);
        return vista;
    }
    public  void init   (){
        //elementList = new ArrayList<>();
        elementList.add(new ListElement("Gaseosa","$4000"));
        elementList.add(new ListElement("Pasta","$1200"));
        elementList.add(new ListElement("Frijol","$4300"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));
        elementList.add(new ListElement("Aceite 1000ml","$5000"));




        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));



    }
}