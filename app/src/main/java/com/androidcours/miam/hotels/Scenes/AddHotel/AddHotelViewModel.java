package com.androidcours.miam.hotels.Scenes.AddHotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.androidcours.miam.hotels.Models.Hotel;
import com.androidcours.miam.hotels.Utils.DatabaseHelper;

public class AddHotelViewModel {

    public AddHotelViewModelDelegate delegate;

    private DatabaseHelper databaseHelper;

    AddHotelViewModel(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void addHotel(Hotel hotel) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Hotel.COLUMN_NAME,       hotel.getName());
        values.put(Hotel.COLUMN_ADDRESS,    hotel.getaddress());
        values.put(Hotel.COLUMN_CITY,       hotel.getCity());
        values.put(Hotel.COLUMN_RANK,       hotel.getRank());
        values.put(Hotel.COLUMN_PHONE,      hotel.getPhone());
        values.put(Hotel.COLUMN_LAT,        hotel.getLatitude());
        values.put(Hotel.COLUMN_LON,        hotel.getLongitude());

        long id = db.insert(Hotel.TABLE_NAME, null, values);
        db.close();

        delegate.didInsertNewHotel(id >= 0 , id);


    }

}
