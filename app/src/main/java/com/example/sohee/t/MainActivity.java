package com.example.sohee.t;

/**
 * Created by Sohee on 2017-07-19.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnSignUpbtnClicked(View v){
        Intent signupbtnIntent = new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(signupbtnIntent);
    }

    public void OnFunction1btnClicked(View v){
        Intent function1btnIntent = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(function1btnIntent);
    }

//    public void OnFunction2btnClicked(View v){
//        Intent function2btnIntent = new Intent(getApplicationContext(),Function2Activity.class);
//        startActivity(function2btnIntent);
//    }

    public void OnSurveybtnClicked(View v){
        Intent surveybtnIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/forms/PjYuSwPX28FxMQ9x1"));
        startActivity(surveybtnIntent);

    }
}
