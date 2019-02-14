package com.androidcours.miam.hotels.Scenes.HotelsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidcours.miam.hotels.Models.Hotel;
import com.androidcours.miam.hotels.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yassine EL HALAOUI on 2/11/19.
 */

public class HotelsListAdapter extends ArrayAdapter<Hotel> {
    private static final String TAG = "HotelsListAdapter";
    private Context mContext;
    private int mResource;

    /**
     * Default Constructor for HotelsListAdapter class
     * @param context
     * @param resource
     * @param objects
     */
    public HotelsListAdapter(Context context, int resource, ArrayList<Hotel> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get hotel information
        String name = getItem(position).getName();
        String city = getItem(position).getCity();


        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = convertView.findViewById(R.id.tv_name);
        TextView tvCity = convertView.findViewById(R.id.tv_city);

        tvName.setText(name);
        tvCity.setText(city);

        return convertView;
    }
}
