package com.androidcours.miam.hotels.Scenes.HotelsList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.androidcours.miam.hotels.Models.Hotel;
import com.androidcours.miam.hotels.Utils.DatabaseHelper;

import java.util.ArrayList;

public class HotelsListViewModel {

    public HotelsListViewModelDelegate delegate;

    private DatabaseHelper databaseHelper;

    HotelsListViewModel(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    void getAllHotels() {
        ArrayList<Hotel> hotels = new ArrayList<>();


        String selectQuery = "SELECT * FROM " + Hotel.TABLE_NAME;
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {

            Hotel hotel = new Hotel(cursor.getInt(cursor.getColumnIndex(Hotel.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(Hotel.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(Hotel.COLUMN_ADDRESS)),
                    cursor.getString(cursor.getColumnIndex(Hotel.COLUMN_CITY)),
                    cursor.getDouble(cursor.getColumnIndex(Hotel.COLUMN_RANK)),
                    cursor.getString(cursor.getColumnIndex(Hotel.COLUMN_PHONE)),
                    cursor.getDouble(cursor.getColumnIndex(Hotel.COLUMN_LAT)),
                    cursor.getDouble(cursor.getColumnIndex(Hotel.COLUMN_LON)));

            hotels.add(hotel);

        }

        db.close();

        /* hotels.add(new Hotel(1, "Royal Mansour", "", "Marrakech", 3.5, "+212 629 942 973", 31.625373, -7.998357));
        hotels.add(new Hotel(2, "Kenzi Solazur", "", "Tanger", 3.5, "+212 629 942 973", 35.781039, -5.798130));
        hotels.add(new Hotel(3, "IDOU ANFA HOTEL & SPA", "", "Casablanca", 3.5, "+212 629 942 973", 33.595038, -7.632830));
        hotels.add(new Hotel(4, "Ocean Park Appart Hotel", "", "Casablanca", 3.5, "+212 629 942 973", 33.586969,-7.683958));
        hotels.add(new Hotel(5, "La Mamounia", "", "Marrakech", 3.5, "+212 629 942 973", 31.626790, -7.997440)); */

        delegate.didFinishFetchingHotels(hotels);
    }

    void returnNewHotel() {
        delegate.didFinishAddingNewHotel(new Hotel(1, "Movimpic", "", "Casablanca", 3.5, "", 31.56775, -0.124432));
    }

}
