package com.androidcours.miam.hotels.Scenes.AddHotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.androidcours.miam.hotels.R;

public class AddHotelActivity extends AppCompatActivity implements AddHotelViewModelDelegate {

    private AddHotelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel);

        setup();
        setupView();
    }

    private void setup() {
        viewModel = new AddHotelViewModel();
        viewModel.delegate = this;
    }

    private void setupView() {
        // Setup header
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.header_title_map);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

}
