package com.androidcours.miam.hotels.Scenes.HotelsList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidcours.miam.hotels.Models.Hotel;
import com.androidcours.miam.hotels.R;
import com.androidcours.miam.hotels.Scenes.AddHotel.AddHotelActivity;
import com.androidcours.miam.hotels.Scenes.HotelDetail.HotelDetailActivity;
import com.androidcours.miam.hotels.Scenes.HotelsMap.HotelsMapsActivity;

import java.util.ArrayList;

public class HotelsListActivity extends AppCompatActivity implements HotelsListViewModelDelegate {

    private static final String TAG = "HotelsListActivity";

    private HotelsListViewModel viewModel;
    private HotelsListAdapter adapter;
    private ListView listView;
    private ArrayList<Hotel> hotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_list);

        hotels = new ArrayList<>();

        setup();
        setupView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getAllHotels();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Intent intent;

        if (itemId == R.id.maps_bar_item) {
            // Navigate to Map activity
            intent = new Intent(this, HotelsMapsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("hotels", hotels);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (itemId == R.id.add_bar_item) {
            // Navigate to Add hotel activity
            intent = new Intent(this, AddHotelActivity.class);
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }

    private void setup() {
        viewModel = new HotelsListViewModel(this);
        viewModel.delegate = this;
    }

    private void setupView() {
        //
        adapter = new HotelsListAdapter(this, R.layout.hotel_list_adabter_view_layout, hotels);
        listView = findViewById(R.id.hotelsList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Recuperate the selected hotel
                Hotel selectedHotel = (Hotel) parent.getItemAtPosition(position);

                // Navigate to Hotel Detail
                Intent intent = new Intent(HotelsListActivity.this, HotelDetailActivity.class);
                intent.putExtra("hotel", selectedHotel);
                startActivity(intent);
            }
        });

    }

    // Delegates Methods
    @Override
    public void didFinishFetchingHotels(ArrayList<Hotel> hotels) {
        // Recuperate Hotels List
        this.hotels.clear();
        for (Hotel hotel : hotels) { this.hotels.add(hotel); }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void didFinishAddingNewHotel(Hotel hotel) {
        this.hotels.add(hotel);
        adapter.notifyDataSetChanged();
    }
}
