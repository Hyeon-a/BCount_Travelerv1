package com.example.sohee.t;

/**
 * Created by Sohee on 2017-07-19.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(MainActivity.this, "Main Success", Toast.LENGTH_SHORT).show();

        // 추가(바로 백그라운드 하기 위해서)
        Intent intent = new Intent(this, RecoBackgroundMonitoringService.class);
        startService(intent);
    }

    public void OnFunction1btnClicked(View v){
        Intent function1btnIntent = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(function1btnIntent);
    }
    public void OnTestbtnClicked(View v){
        Intent testbtnIntent = new Intent(getApplicationContext(),RecoMainActivity.class);
        startActivity(testbtnIntent);
    }

    public void OnFunction2btnClicked(View v){      //schedule 버튼
        Intent function2btnIntent = new Intent(getApplicationContext(), ScheduleActivity.class);
        startActivity(function2btnIntent);
    }

    public void OnSurveybtnClicked(View v){
        Intent surveybtnIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/forms/PjYuSwPX28FxMQ9x1"));
        startActivity(surveybtnIntent);

    }
}
