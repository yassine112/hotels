package com.androidcours.miam.hotels.Scenes.HotelsList;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.androidcours.miam.hotels.Models.Hotel;
import com.androidcours.miam.hotels.R;
import com.androidcours.miam.hotels.Scenes.HotelsMap.HotelsMapsActivity;

import java.util.ArrayList;

public class HotelsListActivity extends AppCompatActivity implements HotelsListViewModelDelegate {

    private static final String TAG = "HotelsListActivity";

    private HotelsListViewModel viewModel;
    private HotelsListAdapter adapter;
    private ListView listView;
    private SQLiteDatabase db;
    private Cursor cursor;
    private ArrayList<Hotel> hotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_list);

        hotels = new ArrayList<>();

        setup();
        setupView();
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
        if (itemId == R.id.maps_bar_item) {
            // Navigate to Map activity
            Intent intent = new Intent(this, HotelsMapsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("hotels", hotels);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void setup() {
        viewModel = new HotelsListViewModel();
        viewModel.delegate = this;
    }

    private void setupView() {
        adapter = new HotelsListAdapter(this, R.layout.hotel_list_adabter_view_layout, hotels);
        listView = findViewById(R.id.hotelsList);
        listView.setAdapter(adapter);
    }

    // Delegates Methods
    @Override
    public void didFinishFetchingHotels(ArrayList<Hotel> hotels) {
        Log.d(TAG, "didFinishFetchingHotels() called with: hotels = [" + hotels + "]");
        for (Hotel hotel : hotels) {
            this.hotels.add(hotel);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void didFinishAddingNewHotel(Hotel hotel) {
        this.hotels.add(hotel);
        adapter.notifyDataSetChanged();
    }
}
