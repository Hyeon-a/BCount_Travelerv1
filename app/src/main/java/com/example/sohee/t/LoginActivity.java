package com.example.sohee.t;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Sohee on 2017-09-06.
 */

public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void OnLoginbtn2Clicked(View v){
        Intent loginbtn2Intent = new Intent(getApplicationContext(),MainActivity.class);
        Toast.makeText(getBaseContext(),"로그인되었습니다!", Toast.LENGTH_SHORT).show();
        startActivity(loginbtn2Intent);
    }
}
