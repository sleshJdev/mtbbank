package com.slesh.mtbbank.ui.map;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.slesh.mtbbank.R;
import com.slesh.mtbbank.data.AppRepository;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

public class MapActivity extends DaggerActivity implements OnMapReadyCallback {

    public static final String EXTRA_LAT = "lat";
    public static final String EXTRA_LON = "lon";
    public static final String EXTRA_TITLE = "title";

    private static final float DEFAULT_ZOOM = 15F;

    @Inject
    AppRepository appRepository;

    @Inject
    MapService mapService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map_container_fragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        double lat = getIntent().getDoubleExtra(EXTRA_LAT, 0D);
        double lon = getIntent().getDoubleExtra(EXTRA_LON, 0D);
        String title = getIntent().getStringExtra(EXTRA_TITLE);

        LatLng departmentCoords = new LatLng(lat, lon);
        googleMap.addMarker(new MarkerOptions().position(departmentCoords).title(title));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(departmentCoords, DEFAULT_ZOOM));

    }
}
