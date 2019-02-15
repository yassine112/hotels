package com.androidcours.miam.hotels.Scenes.HotelDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.androidcours.miam.hotels.Models.Hotel;
import com.androidcours.miam.hotels.R;

public class HotelDetailActivity extends AppCompatActivity implements HotelDetailViewModelDelegete {

    private final String TAG = "HotelDetailActivity";

    // Parameters
    private Hotel selectedHotel;
    private HotelDetailViewModel viewModel;

    // Outlets
    TextView tvName, tvAddress, tvCity, tvRank, tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);

        setup();
        setupView();

        selectedHotel = (Hotel) getIntent().getSerializableExtra("hotel");

        tvName      .setText(selectedHotel.getName());
        tvAddress   .setText(selectedHotel.getaddress());
        tvCity      .setText(selectedHotel.getCity());
        tvRank      .setText(selectedHotel.getRank().toString());
        tvPhone     .setText(selectedHotel.getPhone());

    }

    private void setup() {
        viewModel = new HotelDetailViewModel();
        viewModel.delegete = this;
    }

    private void setupView() {
        // Setup header
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.header_title_map);

        // Setup Outlets
        tvName      = findViewById(R.id.tv_name);
        tvAddress   = findViewById(R.id.tv_address);
        tvCity      = findViewById(R.id.tv_city);
        tvRank      = findViewById(R.id.tv_rank);
        tvPhone     = findViewById(R.id.tv_phone);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }


}
