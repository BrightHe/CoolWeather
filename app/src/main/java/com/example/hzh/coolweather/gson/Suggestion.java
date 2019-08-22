package com.example.hzh.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2019/8/22.
 */

public class Suggestion {
    @SerializedName( "comf" )
    public Comfort comfort;

    @SerializedName( "cw" )
    public CarWash carWash;
    
    public Sport sport;

    public class Comfort {
//        @SerializedName( "type" )
        public String type;

//        @SerializedName( "brf" )
        public String brf;

        @SerializedName( "txt" )
        public String info;
    }

    public class CarWash {
//        @SerializedName( "type" )
        public String type;

//        @SerializedName( "brf" )
        public String brf;

        @SerializedName( "txt" )
        public String info;
    }

    public class Sport {
//        @SerializedName( "type" )
        public String type;

//        @SerializedName( "brf" )
        public String brf;

        @SerializedName( "txt" )
        public String info;
    }
}
