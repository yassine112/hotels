package com.androidcours.miam.hotels.Scenes.HotelsList;

import com.androidcours.miam.hotels.Models.Hotel;

import java.util.ArrayList;

public class HotelsListViewModel {

    public HotelsListViewModelDelegate delegate;

    void getAllHotels() {
        ArrayList<Hotel> hotels = new ArrayList<>();

        hotels.add(new Hotel(1, "Royal Mansour", "", "Marrakech", 3.5, "", 31.625373, -7.998357));
        hotels.add(new Hotel(2, "Kenzi Solazur", "", "Tanger", 3.5, "", 35.781039, -5.798130));
        hotels.add(new Hotel(3, "IDOU ANFA HOTEL & SPA", "", "Casablanca", 3.5, "", 33.595038, -7.632830));
        hotels.add(new Hotel(4, "Ocean Park Appart Hotel", "", "Casablanca", 3.5, "", 33.588031, -7.683471));
        hotels.add(new Hotel(5, "La Mamounia", "", "Marrakech", 3.5, "", 31.626790, -7.997440));

        delegate.didFinishFetchingHotels(hotels);
    }

    void returnNewHotel() {
        delegate.didFinishAddingNewHotel(new Hotel(1, "Movimpic", "", "Casablanca", 3.5, "", 31.56775, -0.124432));
    }

}
