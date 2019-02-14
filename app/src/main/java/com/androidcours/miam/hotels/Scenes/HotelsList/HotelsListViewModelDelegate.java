package com.androidcours.miam.hotels.Scenes.HotelsList;

import com.androidcours.miam.hotels.Models.Hotel;

import java.util.ArrayList;

/**
 * Created by Yassine EL HALAOUI on 2/11/19.
 */

public interface HotelsListViewModelDelegate {
    void didFinishFetchingHotels(ArrayList<Hotel> hotels);
    void didFinishAddingNewHotel(Hotel hotel);
}
