package com.pavel_bojidar.vineweather.fragment;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pavel_bojidar.vineweather.R;
import com.pavel_bojidar.vineweather.WeatherActivity;
import com.pavel_bojidar.vineweather.adapter.RecentListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment{

    public interface ActivityComrunicator {
        void react();
    }

    private Button celsiusButton;
    private Button fahrenheitButton;
    RecyclerView recentLocationRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        celsiusButton = (Button) view.findViewById(R.id.nav_drawer_celsius_button);
        fahrenheitButton = (Button) view.findViewById(R.id.nav_drawer_fahrenheit_button);
        recentLocationRecyclerView = (RecyclerView) view.findViewById(R.id.favorite_location_list);

        if (WeatherActivity.isImperialUnits) {
            fahrenheitButton.getBackground().clearColorFilter();
            celsiusButton.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
        } else {
            celsiusButton.getBackground().clearColorFilter();
            fahrenheitButton.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
        }

        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeatherActivity.isImperialUnits = false;
                celsiusButton.getBackground().clearColorFilter();
                fahrenheitButton.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
                ((ActivityComrunicator)getActivity()).react();
            }
        });

        fahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeatherActivity.isImperialUnits = true;
                fahrenheitButton.getBackground().clearColorFilter();
                celsiusButton.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
                ((ActivityComrunicator)getActivity()).react();
            }
        });

//        recentLocationRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        RecentListAdapter recentAdapter = new RecentListAdapter(recentList, this);
//        recentLocationRecyclerView.setAdapter(recentAdapter);

        return view;
    }
}
