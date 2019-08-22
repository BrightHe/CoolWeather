package com.example.hzh.coolweather.util;

import android.text.TextUtils;

import com.example.hzh.coolweather.db.City;
import com.example.hzh.coolweather.db.Country;
import com.example.hzh.coolweather.db.Province;
import com.example.hzh.coolweather.gson.HeWeather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/8/22.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty( response )){
            try{
                JSONArray allProvinces = new JSONArray( response );
                for (int i = 0;i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject( i );
                    Province province = new Province();
                    province.setProvinceName( provinceObject.getString( "name" ) );
                    province.setProvinceCode( provinceObject.getInt( "id" ) );
                    province.save();//存储到数据库中
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty( response )){
            try{
                JSONArray allCities = new JSONArray( response );
                for (int i = 0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject( i );
                    City city = new City();
                    city.setCityName( cityObject.getString( "name" ) );
                    city.setCityCode( cityObject.getInt( "id" ) );
                    city.setProvinceId( provinceId );
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountryResponse(String response,int cityId){
        if (!TextUtils.isEmpty( response )){
            try{
                JSONArray allCountries = new JSONArray( response );
                for(int i = 0;i < allCountries.length() ;i++){
                    JSONObject countryObject = allCountries.getJSONObject( i );
                    Country country = new Country();
                    country.setCountryName( countryObject.getString( "name" ) );
                    country.setWeatherId( countryObject.getString( "weather_id" ) );
                    country.setCityId( cityId );
                    country.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather实体类
     */
    public static HeWeather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject( response );
            JSONArray jsonArray = jsonObject.getJSONArray( "HeWeather" );
            String weatherContent = jsonArray.getJSONObject( 0 ).toString();
            return new Gson().fromJson( weatherContent,HeWeather.class );
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
