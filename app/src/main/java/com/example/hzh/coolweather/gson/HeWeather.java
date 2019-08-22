package com.example.hzh.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2019/8/22.
 */

public class HeWeather {
    public Basic basic;
    public Basic.Update update;
    public String status;
    public Now now;

    @SerializedName( "daily_forecast" )
    public List<Forecast> forecastList;

    public AQI aqi;
    public Suggestion suggestion;
    public String msg;
}
