package com.pavel_bojidar.vineweather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pavel_bojidar.vineweather.Constants;
import com.pavel_bojidar.vineweather.R;
import com.pavel_bojidar.vineweather.adapter.WeekForecastAdapter.WeekForecastViewHolder;
import com.pavel_bojidar.vineweather.helper.Helper;
import com.pavel_bojidar.vineweather.model.DayForecast;
import com.pavel_bojidar.vineweather.singleton.AppManager;

import java.util.List;

/**
 * Created by Pavel Pavlov on 3/18/2017.
 */

public class WeekForecastAdapter extends RecyclerView.Adapter<WeekForecastViewHolder> {

    private List<DayForecast> weeklyForecast;

    public WeekForecastAdapter(List<DayForecast> weeklyForecast) {
        this.weeklyForecast = weeklyForecast;
    }

    @Override
    public WeekForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WeekForecastViewHolder(parent.inflate(parent.getContext(), R.layout.row_week_forecast, null));
    }

    @Override
    public void onBindViewHolder(WeekForecastViewHolder holder, int position) {
        DayForecast forecast = weeklyForecast.get(position);
        String units = AppManager.getInstance().getUnits();
        if (units.equals(Constants.KEY_CELSIUS)) {
            holder.temperature.setText(Helper.decimalFormat(forecast.getMidTemperature() - Constants.COEF_FOR_CONVERT_CELSIUS) + Constants.CELSIUS_SYMBOL);
        } else {
            holder.temperature.setText(Helper.decimalFormat(Helper.kelvinToFahrenheit(forecast.getMidTemperature())) + Constants.FAHRENHEIT_SYMBOL);
        }
        holder.date.setText(Helper.getWeekDay(Helper.getUnixDate(forecast.getForecasts().get(0).getUnixTimestamp())));
        holder.condition.setText(forecast.getMidCondition());
        switch (forecast.getMidCondition()) {
            case "Rain":
                holder.conditionImage.setBackgroundResource(R.drawable.drizzle);
                break;
            case "Clouds":
                holder.conditionImage.setBackgroundResource(R.drawable.cloudy);
                break;
            case "Clear":
                holder.conditionImage.setBackgroundResource(R.drawable.clear);
                break;
            case "Snow":
                holder.conditionImage.setBackgroundResource(R.drawable.snow);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return weeklyForecast.size();
    }

    public class WeekForecastViewHolder extends RecyclerView.ViewHolder {

        TextView date, temperature, condition;
        ImageView conditionImage;

        public WeekForecastViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date_week);
            temperature = (TextView) itemView.findViewById(R.id.temperature_week);
            condition = (TextView) itemView.findViewById(R.id.condition_week);
            conditionImage = (ImageView) itemView.findViewById(R.id.condition_image_week);
        }
    }
}