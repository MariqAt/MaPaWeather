package com.pavel_bojidar.vineweather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pavel_bojidar.vineweather.Constants;
import com.pavel_bojidar.vineweather.R;
import com.pavel_bojidar.vineweather.adapter.HourlyTempAdapter.HourlyForecastViewHolder;
import com.pavel_bojidar.vineweather.helper.Helper;
import com.pavel_bojidar.vineweather.model.HourForecast;

import java.util.ArrayList;

/**
 * Created by Pavel Pavlov on 4/7/2017.
 */

public class HourlyTempAdapter extends RecyclerView.Adapter<HourlyForecastViewHolder> {

    ArrayList<HourForecast> forecast;
    ViewGroup parent;

    public HourlyTempAdapter(ArrayList<HourForecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public HourlyForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HourlyForecastViewHolder holder = new HourlyForecastViewHolder(parent.inflate(parent.getContext(), R.layout.row_forecast_details, null));
        this.parent = parent;
        return holder;
    }

    @Override
    public void onBindViewHolder(HourlyForecastViewHolder holder, int position) {
        HourForecast currentHour = forecast.get(position);
        holder.degrees.setText(Helper.decimalFormat(currentHour.getTempC()) + Constants.CELSIUS_SYMBOL);
        holder.hour.setText(Helper.getUnixAmPmHour(currentHour.getTimeEpoch()));
        holder.icon.setImageDrawable(Helper.chooseIcon(parent.getContext(), currentHour.getIsDay() == 1, currentHour.getCondition().getIcon()));
    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    public class HourlyForecastViewHolder extends RecyclerView.ViewHolder {

        TextView degrees, hour;
        ImageView icon;

        public HourlyForecastViewHolder(View itemView) {
            super(itemView);
            degrees = (TextView) itemView.findViewById(R.id.row_forecast_details_degrees);
            hour = (TextView) itemView.findViewById(R.id.row_forecast_details_hour);
            icon = (ImageView) itemView.findViewById(R.id.row_forecast_details_icon);
        }
    }
}