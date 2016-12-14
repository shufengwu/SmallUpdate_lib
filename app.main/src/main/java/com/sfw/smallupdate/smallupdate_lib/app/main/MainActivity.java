package com.sfw.smallupdate.smallupdate_lib.app.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.wequick.small.Small;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"first",Toast.LENGTH_SHORT).show();
                Small.openUri("first", MainActivity.this);
            }
        });
    }

    /*@OnClick(R.id.button1)
    public void click1() {

    }*/

    @OnClick(R.id.button2)
    public void click2() {
        Toast.makeText(this,"second",Toast.LENGTH_SHORT).show();
        Small.openUri("second", MainActivity.this);
    }

    @OnClick(R.id.button3)
    public void click3() {
        Toast.makeText(this,"third",Toast.LENGTH_SHORT).show();
        Small.openUri("third", MainActivity.this);
    }
}
