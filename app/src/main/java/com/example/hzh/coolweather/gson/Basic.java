package com.example.hzh.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2019/8/22.
 */

public class Basic {

    // @SerializedName注解的方式来让JSON字段和java字段之间建立映射关系

    @SerializedName( "city" )
    public String cityName;

    @SerializedName( "id" )
    public String weatherId;

    public Update update;

    public class Update{

        @SerializedName( "loc" )
        public String updateTime;

//        @SerializedName( "utc" )
        public String utc;

    }

}
