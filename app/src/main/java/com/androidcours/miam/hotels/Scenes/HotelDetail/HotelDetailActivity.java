package com.androidcours.miam.hotels.Scenes.HotelDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidcours.miam.hotels.R;

public class HotelDetailActivity extends AppCompatActivity implements HotelDetailViewModelDelegete {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
    }
}
