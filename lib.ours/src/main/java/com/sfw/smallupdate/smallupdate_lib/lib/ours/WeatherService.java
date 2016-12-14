package com.sfw.smallupdate.smallupdate_lib.lib.ours;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 *
 */

public interface WeatherService {
    @GET("v1/weather/query")
    Observable<WeatherBean> getWeather(
            @Query("key") String key,
            @Query("city") String city,
            @Query("province") String province
    );
}
