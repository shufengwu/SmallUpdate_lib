package com.sfw.smallupdate.smallupdate_lib.app.third;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.sfw.smallupdate.smallupdate_lib.lib.ours.WeatherContract;
import com.sfw.smallupdate.smallupdate_lib.lib.ours.WeatherModel;
import com.sfw.smallupdate.smallupdate_lib.lib.ours.WeatherPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements WeatherContract.IWeatherView{

    private final String AppKey = "12c5afd699940";

    @BindView(R.id.show)
    ListView show;
    @BindView(R.id.progess)
    ProgressBar progress;
    WeatherPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new WeatherPresenter(new WeatherModel(), this);
        initShow();
    }

    @OnClick(R.id.button)
    public void click() {
        presenter.load();
    }

    @Override
    public void initShow() {
        show.setVisibility(View.INVISIBLE);
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoadStart() {
        show.setVisibility(View.INVISIBLE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showWeather(List<String> list) {
        show.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list));
    }

    @Override
    public void showLoadSuccess() {
        show.setVisibility(View.VISIBLE);
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoadFailed() {
        show.setVisibility(View.INVISIBLE);
        progress.setVisibility(View.INVISIBLE);
    }
}
