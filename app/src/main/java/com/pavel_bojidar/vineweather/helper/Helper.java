package com.pavel_bojidar.vineweather.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.content.res.ResourcesCompat;

import com.pavel_bojidar.vineweather.R;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Helper {

    public static final String SUNNY = "Sunny";
    public static final String PATCHY_LIGHT_DRIZZLE = "Patchy light drizzle";
    public static final String FREEZING_FOG = "Freezing fog";
    public static final String OVERCAST = "Overcast";
    public static final String PARTLY_CLOUDY = "Partly cloudy";
    public static final String LIGHT_SHOWERS_OF_ICE_PELLETS = "Light showers of ice pellets";
    public static final String PATCHY_LIGHT_RAIN_WITH_THUNDER = "Patchy light rain with thunder";
    public static final String THUNDERY_OUTBREAKS_IN_NEARBY = "Thundery outbreaks in nearby";
    public static final String THUNDERY_OUTBREAKS_POSSIBLE = "Thundery outbreaks possible";
    public static final String BLOWING_SNOW = "Blowing snow";
    public static final String PATCHY_SNOW_NEARBY = "Patchy snow nearby";
    public static final String LIGHT_SNOW_SHOWERS = "Light snow showers";
    public static final String PATCHY_SNOW_POSSIBLE = "Patchy snow possible";
    public static final String LIGHT_SLEET = "Light sleet";
    public static final String LIGHT_SLEET_SHOWERS = "Light sleet showers";
    public static final String PATCHY_SLEET_POSSIBLE = "Patchy sleet possible";
    public static final String PATCHY_SLEET_NEARBY = "Patchy sleet nearby";
    public static final String MIST = "Mist";
    public static final String FOG = "Fog";
    public static final String CLOUDY = "Cloudy";
    public static final String PATCHY_LIGHT_SNOW_IN_AREA_WITH_THUNDER = "Patchy light snow in area with thunder";
    public static final String MODERATE_OR_HEAVY_SNOW_IN_AREA_WITH_THUNDER = "Moderate or heavy snow in area with thunder";
    public static final String MODERATE_OR_HEAVY_SNOW_WITH_THUNDER = "Moderate or heavy snow with thunder";
    public static final String BLIZZARD = "Blizzard";
    public static final String PATCHY_RAIN_NEARBY = "Patchy rain nearby";
    public static final String PATCHY_FREEZING_DRIZZLE_NEARBY = "Patchy freezing drizzle nearby";
    public static final String LIGHT_DRIZZLE = "Light drizzle";
    public static final String PATCHY_LIGHT_RAIN = "Patchy light rain";
    public static final String PATCHY_RAIN_POSSIBLE = "Patchy rain possible";
    public static final String LIGHT_RAIN_SHOWER = "Light rain shower";
    public static final String FREEZING_DRIZZLE = "Freezing drizzle";
    public static final String HEAVY_FREEZING_DRIZZLE = "Heavy freezing drizzle";
    public static final String LIGHT_FREEZING_RAIN = "Light freezing rain";
    public static final String MODERATE_OR_HEAVY_FREEZING_RAIN = "Moderate or heavy freezing rain";
    public static final String MODERATE_OR_HEAVY_SLEET = "Moderate or heavy sleet";
    public static final String MODERATE_OR_HEAVY_SLEET_SHOWERS = "Moderate or heavy sleet showers";
    public static final String MODERATE_OR_HEAVY_RAIN_SHOWER = "Moderate or heavy rain shower";
    public static final String TORRENTIAL_RAIN_SHOWER = "Torrential rain shower";
    public static final String LIGHT_RAIN = "Light rain";
    public static final String MODERATE_RAIN_AT_TIMES = "Moderate rain at times";
    public static final String MODERATE_RAIN = "Moderate rain";
    public static final String HEAVY_RAIN_AT_TIMES = "Heavy rain at times";
    public static final String HEAVY_RAIN = "Heavy rain";
    public static final String PATCHY_LIGHT_SNOW = "Patchy light snow";
    public static final String LIGHT_SNOW = "Light snow";
    public static final String PATCHY_MODERATE_SNOW = "Patchy moderate snow";
    public static final String MODERATE_SNOW = "Moderate snow";
    public static final String PATCHY_HEAVY_SNOW = "Patchy heavy snow";
    public static final String HEAVY_SNOW = "Heavy snow";
    public static final String MODERATE_OR_HEAVY_SNOW_SHOWERS = "Moderate or heavy snow showers";
    public static final String ICE_PELLETS = "Ice pellets";
    public static final String MODERATE_OR_HEAVY_SHOWERS_OF_ICE_PELLETS = "Moderate or heavy showers of ice pellets";
    public static final String PATCHY_LIGHT_RAIN_IN_AREA_WITH_THUNDER = "Patchy light rain in area with thunder";
    public static final String MODERATE_OR_HEAVY_RAIN_IN_AREA_WITH_THUNDER = "Moderate or heavy rain in area with thunder";
    public static final String MODERATE_OR_HEAVY_RAIN_WITH_THUNDER = "Moderate or heavy rain with thunder";
    public static final String CLEAR = "Clear";
    public static int imageWidget;
    //todo get timezone from device timezone

    public static String getUnixAmPmHour(long unixTS) {
        Date date = new Date(unixTS * 1000L);
        DateFormat dateFormat = new SimpleDateFormat("h a");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }

    public static String getUnixDate(long unixTS) {
        Date date = new Date(unixTS * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public static String getUnixCustomDate(long unixTS) {
        Date date = new Date(unixTS * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat(", MMM dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public static String getWeekDay(String dateInput) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = null;
        try {
            dt1 = format1.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    public static String decimalFormat(double input) {
        DecimalFormat df = new DecimalFormat("##");
        if(input < 0 && input > -1){
            return "0";
        }
        return df.format(input);
    }

    public static String filterCityName(String realName) {
        for (int i = 0; i < realName.length(); i++) {
            if (realName.charAt(i) == ',') {
                return realName.substring(0, i);
            }
            if (realName.charAt(i) == '(') {
                return realName.substring(0, i);
            }
        }
        return realName;
    }

    public static Drawable choosePrecipitationIcon(Context context, double amount){

        Resources resources = context.getResources();
        int drawable = R.drawable.droplet1;
        if(amount > 0.1 && amount <= 0.5){
            drawable = R.drawable.droplet2;
        }
        if(amount > 0.5 && amount <= 1){
            drawable = R.drawable.droplet3;
        }
        if(amount > 1 && amount <= 1.5){
            drawable = R.drawable.droplet4;
        }
        if(amount > 1.5 && amount <= 2){
            drawable = R.drawable.droplet5;
        }
        if(amount > 2 && amount <= 3){
            drawable = R.drawable.droplet6;
        }
        if(amount > 3 && amount <= 4){
            drawable = R.drawable.droplet7;
        }
        if(amount > 4 && amount <= 5){
            drawable = R.drawable.droplet8;
        }
        if(amount > 5 && amount <= 6.5){
            drawable = R.drawable.droplet9;
        }
        if(amount > 6.5 && amount <= 7.5){
            drawable = R.drawable.droplet10;
        }
        if(amount > 7.5 && amount <= 8.5){
            drawable = R.drawable.droplet11;
        }
        if(amount > 8.5 && amount <= 10){
            drawable = R.drawable.droplet12;
        }
        if(amount > 10){
            drawable = R.drawable.droplet13;
        }
        return ResourcesCompat.getDrawable(resources, drawable, null);
    }

    public static Drawable chooseConditionIcon(Context context, boolean isDay, boolean isForecast, String condition) {

        Resources resources = context.getResources();

        if (isDay) {
            switch (condition) {
                case SUNNY:
                    imageWidget = R.drawable.clear_day_icon;
                    break;
                case PATCHY_LIGHT_DRIZZLE:
                    imageWidget = isForecast ?  R.drawable.mostly_cloudy_icon_rv : R.drawable.mostly_cloudy_icon;
                    break;
                case FREEZING_FOG:
                    imageWidget = isForecast ? R.drawable.haze_weather_icon_rv : R.drawable.haze_weather_icon;
                    break;
                case OVERCAST:
                    imageWidget = isForecast ? R.drawable.windy_weather_icon_rv : R.drawable.windy_weather_icon;
                    break;
                case PARTLY_CLOUDY:
                    imageWidget = isForecast ? R.drawable.partly_cloudy_icon_rv : R.drawable.partly_cloudy_icon;
                    break;
                case LIGHT_SHOWERS_OF_ICE_PELLETS:
                case PATCHY_LIGHT_RAIN_WITH_THUNDER:
                    imageWidget = isForecast ? R.drawable.storm_weather_day_icon_rv : R.drawable.storm_weather_day_icon;
                    break;
                case THUNDERY_OUTBREAKS_IN_NEARBY:
                case THUNDERY_OUTBREAKS_POSSIBLE:
                    imageWidget = isForecast ? R.drawable.thunder_day_icon_rv : R.drawable.thunder_day_icon;
                    break;
                case BLOWING_SNOW:
                    imageWidget = isForecast ? R.drawable.snow_weather_icon_rv : R.drawable.snow_weather_icon;
                    break;
                case PATCHY_SNOW_NEARBY:
                case LIGHT_SNOW_SHOWERS:
                case PATCHY_SNOW_POSSIBLE:
                    imageWidget = isForecast ? R.drawable.snow_day_icon_rv : R.drawable.snow_day_icon;
                    break;
                case LIGHT_SLEET:
                case LIGHT_SLEET_SHOWERS:
                case PATCHY_SLEET_POSSIBLE:
                case PATCHY_SLEET_NEARBY:
                    imageWidget = isForecast ? R.drawable.rain_snow_day_icon_rv : R.drawable.rain_snow_day_icon;
                    break;
                case MIST:
                case FOG:
                case CLOUDY:
                    imageWidget = isForecast ? R.drawable.cloudy_weather_icon_rv : R.drawable.cloudy_weather_icon;
                    break;
                case PATCHY_LIGHT_SNOW_IN_AREA_WITH_THUNDER:
                case MODERATE_OR_HEAVY_SNOW_IN_AREA_WITH_THUNDER:
                case MODERATE_OR_HEAVY_SNOW_WITH_THUNDER:
                case BLIZZARD:
                    imageWidget = isForecast ? R.drawable.thunder_weather_icon_rv : R.drawable.thunder_weather_icon;
                    break;
                case PATCHY_RAIN_NEARBY:
                case PATCHY_FREEZING_DRIZZLE_NEARBY:
                case LIGHT_DRIZZLE:
                case PATCHY_LIGHT_RAIN:
                case PATCHY_RAIN_POSSIBLE:
                case LIGHT_RAIN_SHOWER:
                    imageWidget = isForecast ? R.drawable.rainy_day_icon_rv : R.drawable.rainy_day_icon;
                    break;
                case FREEZING_DRIZZLE:
                case HEAVY_FREEZING_DRIZZLE:
                case LIGHT_FREEZING_RAIN:
                case MODERATE_OR_HEAVY_FREEZING_RAIN:
                case MODERATE_OR_HEAVY_SLEET:
                case MODERATE_OR_HEAVY_SLEET_SHOWERS:
                    imageWidget = isForecast ?  R.drawable.rain_snow_icon_rv : R.drawable.rain_snow_icon;
                    break;
                case MODERATE_OR_HEAVY_RAIN_SHOWER:
                case TORRENTIAL_RAIN_SHOWER:
                case LIGHT_RAIN:
                case MODERATE_RAIN_AT_TIMES:
                case MODERATE_RAIN:
                case HEAVY_RAIN_AT_TIMES:
                case HEAVY_RAIN:
                    imageWidget = isForecast ? R.drawable.rainy_weather_icon_rv : R.drawable.rainy_weather_icon;
                    break;
                case PATCHY_LIGHT_SNOW:
                case LIGHT_SNOW:
                case PATCHY_MODERATE_SNOW:
                case MODERATE_SNOW:
                case PATCHY_HEAVY_SNOW:
                case HEAVY_SNOW:
                case MODERATE_OR_HEAVY_SNOW_SHOWERS:
                    imageWidget = isForecast ? R.drawable.snow_weather_icon_rv : R.drawable.snow_weather_icon;
                    break;
                case ICE_PELLETS:
                case MODERATE_OR_HEAVY_SHOWERS_OF_ICE_PELLETS:
                case PATCHY_LIGHT_RAIN_IN_AREA_WITH_THUNDER:
                case MODERATE_OR_HEAVY_RAIN_IN_AREA_WITH_THUNDER:
                case MODERATE_OR_HEAVY_RAIN_WITH_THUNDER:
                    imageWidget = isForecast ? R.drawable.storm_weather_icon_rv : R.drawable.storm_weather_icon;
                    break;
                default:
                    imageWidget = R.drawable.unknown;
                    break;
            }
            return ResourcesCompat.getDrawable(resources, imageWidget, null);
        } else {
            switch (condition) {
                case CLEAR:
                    imageWidget = R.drawable.clear_night_icon;
                    break;
                case PATCHY_LIGHT_DRIZZLE:
                    imageWidget = R.drawable.mostly_cloudy_night_icon;
                    break;
                case FREEZING_FOG:
                    imageWidget = R.drawable.haze_night_icon;
                    break;
                case OVERCAST:
                    imageWidget = R.drawable.windy_night_icon;
                    break;
                case PARTLY_CLOUDY:
                    imageWidget = R.drawable.partly_cloudy_night_icon;
                    break;
                case BLOWING_SNOW:
                case PATCHY_SNOW_NEARBY:
                case LIGHT_SNOW_SHOWERS:
                case PATCHY_SNOW_POSSIBLE:
                    imageWidget = R.drawable.snow_night_icon;
                    break;
                case MIST:
                case FOG:
                case CLOUDY:
                    imageWidget = R.drawable.cloudy_weather_icon;
                    break;
                case THUNDERY_OUTBREAKS_IN_NEARBY:
                case THUNDERY_OUTBREAKS_POSSIBLE:
                case PATCHY_LIGHT_SNOW_IN_AREA_WITH_THUNDER:
                case MODERATE_OR_HEAVY_SNOW_IN_AREA_WITH_THUNDER:
                case MODERATE_OR_HEAVY_SNOW_WITH_THUNDER:
                case BLIZZARD:
                    imageWidget = R.drawable.thunder_night_icon;
                    break;
                case FREEZING_DRIZZLE:
                case HEAVY_FREEZING_DRIZZLE:
                case LIGHT_FREEZING_RAIN:
                case MODERATE_OR_HEAVY_FREEZING_RAIN:
                case MODERATE_OR_HEAVY_SLEET:
                case MODERATE_OR_HEAVY_SLEET_SHOWERS:
                case LIGHT_SLEET:
                case PATCHY_SLEET_NEARBY:
                case LIGHT_SLEET_SHOWERS:
                case PATCHY_SLEET_POSSIBLE:
                    imageWidget = R.drawable.rain_snow_night_icon;
                    break;
                case MODERATE_OR_HEAVY_RAIN_SHOWER:
                case TORRENTIAL_RAIN_SHOWER:
                case LIGHT_RAIN:
                case MODERATE_RAIN_AT_TIMES:
                case MODERATE_RAIN:
                case HEAVY_RAIN_AT_TIMES:
                case HEAVY_RAIN:
                case PATCHY_RAIN_NEARBY:
                case PATCHY_FREEZING_DRIZZLE_NEARBY:
                case LIGHT_DRIZZLE:
                case PATCHY_RAIN_POSSIBLE:
                case PATCHY_LIGHT_RAIN:
                case LIGHT_RAIN_SHOWER:
                    imageWidget = R.drawable.rainy_night_icon;
                    break;
                case PATCHY_LIGHT_SNOW:
                case LIGHT_SNOW:
                case PATCHY_MODERATE_SNOW:
                case MODERATE_SNOW:
                case PATCHY_HEAVY_SNOW:
                case HEAVY_SNOW:
                case MODERATE_OR_HEAVY_SNOW_SHOWERS:
                    imageWidget = R.drawable.snow_weather_icon;
                    break;
                case ICE_PELLETS:
                case MODERATE_OR_HEAVY_SHOWERS_OF_ICE_PELLETS:
                case PATCHY_LIGHT_RAIN_IN_AREA_WITH_THUNDER:
                case MODERATE_OR_HEAVY_RAIN_IN_AREA_WITH_THUNDER:
                case MODERATE_OR_HEAVY_RAIN_WITH_THUNDER:
                case LIGHT_SHOWERS_OF_ICE_PELLETS:
                case PATCHY_LIGHT_RAIN_WITH_THUNDER:
                    imageWidget = R.drawable.storm_weather_night_icon;
                    break;
                default:
                    imageWidget = R.drawable.unknown;
                    break;
            }
            return ResourcesCompat.getDrawable(resources, imageWidget, null);
        }
    }

    public static Drawable chooseFragmentBackground(Context context, String condition, boolean isDay){

        Resources resources = context.getResources();
        int conditionImage;

        switch (condition){
            case CLEAR:
            case PARTLY_CLOUDY:
                conditionImage = isDay ? R.drawable.condition_clear_background_day : R.drawable.condition_clear_background_night;
                break;
            case FREEZING_FOG:
            case OVERCAST:
            case MIST:
            case FOG:
            case CLOUDY:
                conditionImage = isDay ?  R.drawable.condition_overcast_background_day : R.drawable.condition_overcast_background_night;
                break;
            case FREEZING_DRIZZLE:
            case HEAVY_FREEZING_DRIZZLE:
            case LIGHT_FREEZING_RAIN:
            case MODERATE_OR_HEAVY_FREEZING_RAIN:
            case MODERATE_OR_HEAVY_SLEET:
            case MODERATE_OR_HEAVY_SLEET_SHOWERS:
            case PATCHY_LIGHT_DRIZZLE:
            case LIGHT_SLEET:
            case PATCHY_SLEET_NEARBY:
            case LIGHT_SLEET_SHOWERS:
            case PATCHY_SLEET_POSSIBLE:
            case MODERATE_OR_HEAVY_RAIN_SHOWER:
            case TORRENTIAL_RAIN_SHOWER:
            case LIGHT_RAIN:
            case MODERATE_RAIN_AT_TIMES:
            case MODERATE_RAIN:
            case HEAVY_RAIN_AT_TIMES:
            case HEAVY_RAIN:
            case PATCHY_RAIN_NEARBY:
            case PATCHY_FREEZING_DRIZZLE_NEARBY:
            case LIGHT_DRIZZLE:
            case PATCHY_RAIN_POSSIBLE:
            case PATCHY_LIGHT_RAIN:
            case LIGHT_RAIN_SHOWER:
            case MODERATE_OR_HEAVY_SNOW_SHOWERS:
            case LIGHT_SHOWERS_OF_ICE_PELLETS:
            case MODERATE_OR_HEAVY_SHOWERS_OF_ICE_PELLETS:
                conditionImage = isDay ?  R.drawable.condition_rainy_background_day : R.drawable.condition_rainy_background_night;
                break;
            case BLIZZARD:
            case PATCHY_SNOW_POSSIBLE:
            case BLOWING_SNOW:
            case PATCHY_SNOW_NEARBY:
            case LIGHT_SNOW_SHOWERS:
            case PATCHY_LIGHT_SNOW:
            case LIGHT_SNOW:
            case PATCHY_MODERATE_SNOW:
            case MODERATE_SNOW:
            case PATCHY_HEAVY_SNOW:
            case HEAVY_SNOW:
            case ICE_PELLETS:
                conditionImage = isDay ?  R.drawable.condition_snowy_background_day : R.drawable.condition_snowy_background_night;
                break;
            case THUNDERY_OUTBREAKS_IN_NEARBY:
            case THUNDERY_OUTBREAKS_POSSIBLE:
            case PATCHY_LIGHT_SNOW_IN_AREA_WITH_THUNDER:
            case MODERATE_OR_HEAVY_SNOW_IN_AREA_WITH_THUNDER:
            case MODERATE_OR_HEAVY_SNOW_WITH_THUNDER:
            case PATCHY_LIGHT_RAIN_IN_AREA_WITH_THUNDER:
            case MODERATE_OR_HEAVY_RAIN_IN_AREA_WITH_THUNDER:
            case MODERATE_OR_HEAVY_RAIN_WITH_THUNDER:
            case PATCHY_LIGHT_RAIN_WITH_THUNDER:
                conditionImage = isDay ?  R.drawable.condition_thundery_background_day : R.drawable.condition_thundery_background_night;
                break;
            default:
                conditionImage = isDay ? R.drawable.condition_clear_background_day : R.drawable.condition_clear_background_night;
                break;
        }
        return ResourcesCompat.getDrawable(resources, conditionImage, null);
    }

    public static int[] chooseConditionColorSet (String condition, boolean isDay){

        int[] colorSet = new int[2];

        switch (condition){
            case CLEAR:
            case PARTLY_CLOUDY:
                if(isDay){
                    colorSet[0] = R.color.conditionClearDay;
                    colorSet[1] = R.color.conditionClearDayDark;
                } else {
                    colorSet[0] = R.color.conditionClearNight;
                    colorSet[1] = R.color.conditionClearNightDark;
                }
                return colorSet;
            case FREEZING_FOG:
            case OVERCAST:
            case MIST:
            case FOG:
            case CLOUDY:
                if(isDay){
                    colorSet[0] = R.color.conditionOvercastDay;
                    colorSet[1] = R.color.conditionOvercastDayDark;
                } else {
                    colorSet[0] = R.color.conditionOvercastNight;
                    colorSet[1] = R.color.conditionOvercastNightDark;
                }
                break;
            case FREEZING_DRIZZLE:
            case HEAVY_FREEZING_DRIZZLE:
            case LIGHT_FREEZING_RAIN:
            case MODERATE_OR_HEAVY_FREEZING_RAIN:
            case MODERATE_OR_HEAVY_SLEET:
            case MODERATE_OR_HEAVY_SLEET_SHOWERS:
            case PATCHY_LIGHT_DRIZZLE:
            case LIGHT_SLEET:
            case PATCHY_SLEET_NEARBY:
            case LIGHT_SLEET_SHOWERS:
            case PATCHY_SLEET_POSSIBLE:
            case MODERATE_OR_HEAVY_RAIN_SHOWER:
            case TORRENTIAL_RAIN_SHOWER:
            case LIGHT_RAIN:
            case MODERATE_RAIN_AT_TIMES:
            case MODERATE_RAIN:
            case HEAVY_RAIN_AT_TIMES:
            case HEAVY_RAIN:
            case PATCHY_RAIN_NEARBY:
            case PATCHY_FREEZING_DRIZZLE_NEARBY:
            case LIGHT_DRIZZLE:
            case PATCHY_RAIN_POSSIBLE:
            case PATCHY_LIGHT_RAIN:
            case LIGHT_RAIN_SHOWER:
            case MODERATE_OR_HEAVY_SNOW_SHOWERS:
            case LIGHT_SHOWERS_OF_ICE_PELLETS:
            case MODERATE_OR_HEAVY_SHOWERS_OF_ICE_PELLETS:
                if(isDay){
                    colorSet[0] = R.color.conditionRainyDay;
                    colorSet[1] = R.color.conditionRainyDayDark;
                } else {
                    colorSet[0] = R.color.conditionRainyNight;
                    colorSet[1] = R.color.conditionRainyNightDark;
                }
                break;
            case BLIZZARD:
            case PATCHY_SNOW_POSSIBLE:
            case BLOWING_SNOW:
            case PATCHY_SNOW_NEARBY:
            case LIGHT_SNOW_SHOWERS:
            case PATCHY_LIGHT_SNOW:
            case LIGHT_SNOW:
            case PATCHY_MODERATE_SNOW:
            case MODERATE_SNOW:
            case PATCHY_HEAVY_SNOW:
            case HEAVY_SNOW:
            case ICE_PELLETS:
                if(isDay){
                    colorSet[0] = R.color.conditionSnowyDay;
                    colorSet[1] = R.color.conditionSnowyDayDark;
                } else {
                    colorSet[0] = R.color.conditionSnowyNight;
                    colorSet[1] = R.color.conditionSnowyNightDark;
                }
                break;
            case THUNDERY_OUTBREAKS_IN_NEARBY:
            case THUNDERY_OUTBREAKS_POSSIBLE :
            case PATCHY_LIGHT_SNOW_IN_AREA_WITH_THUNDER:
            case MODERATE_OR_HEAVY_SNOW_IN_AREA_WITH_THUNDER:
            case PATCHY_LIGHT_RAIN_IN_AREA_WITH_THUNDER:
            case MODERATE_OR_HEAVY_RAIN_IN_AREA_WITH_THUNDER:
            case MODERATE_OR_HEAVY_SNOW_WITH_THUNDER:
            case MODERATE_OR_HEAVY_RAIN_WITH_THUNDER:
            case PATCHY_LIGHT_RAIN_WITH_THUNDER:
                if(isDay){
                    colorSet[0] = R.color.conditionThunderyDay;
                    colorSet[1] = R.color.conditionThunderyDayDark;
                } else {
                    colorSet[0] = R.color.conditionThunderyNight;
                    colorSet[1] = R.color.conditionThunderyNightDark;
                }
                break;
            default:
                if(isDay){
                    colorSet[0] = R.color.conditionClearDay;
                    colorSet[1] = R.color.conditionClearDayDark;
                } else {
                    colorSet[0] = R.color.conditionClearNight;
                    colorSet[1] = R.color.conditionClearNightDark;
                }
                break;
        }
        return colorSet;
    }

    public static GradientDrawable chooseHeaderColorSet (Context context, int[] colorSet) {
        int colorLight = ResourcesCompat.getColor(context.getResources(), colorSet[0], null);
        int colorDark = ResourcesCompat.getColor(context.getResources(), colorSet[1], null);
        return new GradientDrawable(Orientation.TOP_BOTTOM, new int[] {colorLight, colorDark});
    }
}
