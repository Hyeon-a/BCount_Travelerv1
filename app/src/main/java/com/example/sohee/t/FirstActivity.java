package com.example.sohee.t;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Sohee on 2017-09-06.
 */

public class FirstActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void OnSignUpbtnClicked(View v){
        Intent signupbtnIntent = new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(signupbtnIntent);
    }
    public void OnLoginbtnClicked(View v){
        Intent loginbtnIntent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(loginbtnIntent);
    }
}
