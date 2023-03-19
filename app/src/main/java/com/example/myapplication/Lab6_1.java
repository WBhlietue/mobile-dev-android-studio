package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.myapplication.databinding.ActivityLab61Binding;

public class Lab6_1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityLab61Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLab61Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng mongol = new LatLng(46.5275431, 94.8525224);
        Log.d("Haku: " , "MAP");
        mMap.addMarker(new MarkerOptions().position(mongol).title("Mongolia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mongol));
    }
}