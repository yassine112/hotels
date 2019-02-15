package com.androidcours.miam.hotels.Scenes.HotelsMap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.androidcours.miam.hotels.Models.Hotel;
import com.androidcours.miam.hotels.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class HotelsMapsActivity extends AppCompatActivity implements OnMapReadyCallback, HotelsMapsViewModelDelegate {

    private final String TAG = "HotelsMapsActivity";
    private final LatLng MOROCCO_LOCATION = new LatLng(31.791702, -7.092620);

    private GoogleMap mMap;
    private ArrayList<Hotel> hotels;

    private HotelsMapsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup();

        Bundle bundle = getIntent().getExtras();
        hotels = (ArrayList<Hotel>) bundle.getSerializable("hotels");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.header_title_map);

        setContentView(R.layout.activity_hotels_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setup() {
        viewModel = new HotelsMapsViewModel();
        viewModel.delegate = this;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        for (Hotel hotel : hotels) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(hotel.getLatitude(), hotel.getLongitude())).title(hotel.getName()));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MOROCCO_LOCATION, 6.3f));
    }

}
