package com.sfw.smallupdate.smallupdate_lib.lib.ours;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
@Module
public class WeatherModule {

    private String base_url = "http://apicloud.mob.com";

    @Provides
    public String provideBaseUrl(){
        return this.base_url;
    }
    @Provides
    public WeatherService provideWeatherService(Retrofit retrofit){
        return retrofit.create(WeatherService.class);
    }

    @Provides
    public Retrofit provideRetrofit(String baseurl,OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }
}
