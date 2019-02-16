package com.androidcours.miam.hotels.Scenes.AddHotel;

import android.app.AlertDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidcours.miam.hotels.Models.Hotel;
import com.androidcours.miam.hotels.R;

public class AddHotelActivity extends AppCompatActivity implements AddHotelViewModelDelegate {

    private AddHotelViewModel viewModel;

    // Outlets
    EditText editName, editCity, editRank, editAddress, editPhone, editLat, editLon;
    Button btnAddHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel);

        setup();
        setupView();
    }

    private void setup() {
        viewModel = new AddHotelViewModel(this);
        viewModel.delegate = this;
    }

    private void setupView() {
        // Setup header
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.header_title_map);

        // Setup Outlets

        editName    = (EditText) findViewById(R.id.edit_name);
        editCity    = (EditText) findViewById(R.id.edit_city);
        editRank    = (EditText) findViewById(R.id.edit_rank);
        editAddress = (EditText) findViewById(R.id.edit_address);
        editPhone   = (EditText) findViewById(R.id.edit_phone);
        editLat     = (EditText) findViewById(R.id.edit_lat);
        editLon     = (EditText) findViewById(R.id.edit_lon);
        btnAddHotel = (Button)   findViewById(R.id.btn_add_hotel);

        // Listener
        btnAddHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotel hotel = new Hotel(0,
                        editName.getText().toString(),
                        editAddress.getText().toString(),
                        editCity.getText().toString(),
                        Double.parseDouble(editRank.getText().toString()),
                        editPhone.getText().toString(),
                        Double.parseDouble(editLat.getText().toString()),
                        Double.parseDouble(editLon.getText().toString()));

                viewModel.addHotel(hotel);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void didInsertNewHotel(boolean success, long id) {
        if (success) {
            showMessage(success, "Success", "Hotel inserted successfully with id : " + id);
        } else {
            showMessage(!success, "Error", "Hotel can't be inserted ");
        }
        cleanEditText();
    }


    // Methods
    private void showMessage(boolean success, String title, String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }

        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(success ? R.drawable.success_icon : R.drawable.error_icon);
        builder.setNegativeButton("Cancel", null);

        builder.show();
    }

    private void cleanEditText() {

        editName.setText("");
        editCity.setText("");
        editRank.setText("");
        editAddress.setText("");
        editPhone.setText("");
        editLat.setText("");
        editLon .setText("");
        btnAddHotel.setText("");







    }

}
