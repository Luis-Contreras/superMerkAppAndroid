package com.example.supermerkapp.fragments;

import com.example.supermerkapp.MainActivity;
import com.example.supermerkapp.NavigationApp;
import com.example.supermerkapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    //definimos variables
    private GoogleMap mMap;
    private Marker marcador;
    double lat = 0.0;
    double lng = 0.0;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        @Override
        public void onMapReady(GoogleMap googleMap) {

            mMap = googleMap;

            /*if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }

            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);*/



            //obtener latitud y longitud de la ubicacion actual
            ubicacion();
            LatLng myPosition = new LatLng(6.2895187, -75.5969561);
            googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicacion)).position(myPosition).title(" Mi ubicacion "));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(6.2895187, -75.5969561), 13));



            String [][] matriz = {

                    {"6.2876321", "-75.594591", "tienda de pedro"},
                    {"6.2810216", "-75.5881251", "tienda Bello Horizonte"},
                    {"6.2828965", "-75.5904979", "Mega Burger"},
                    {"6.2831077", "-75.5924211", "Doña Vilma"},
                    {"6.2838225", "-75.59279", "Brosty pollo"},
                    {"6.2861296", "-75.5897562", "tienda de carlos"},
                    {"6.2859081", "-75.5881562", "tienda de pedro"},
                    {"6.2859328", "-75.5862435", "Pizza Loco"},
                    {"6.2851638", "-75.5861014", "Margarina Gurmet"},
                    {"6.2853051", "-75.583952", "Parche Cool"},
            };






            for (int i = 0; i < matriz.length; i++) {

                    myPosition = new LatLng( Double.parseDouble(matriz[i][0]), Double.parseDouble(matriz[i][1]));
                    googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.compras)).position(myPosition).title(matriz[i][2]));



            }
        }



    };

    //obtener latitud y longitud de la ubicacion actual
    public void ubicacion(){
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)){

            }else{
                ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                lng = location.getLongitude();
                lat = location.getLatitude();
            }

        };

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}