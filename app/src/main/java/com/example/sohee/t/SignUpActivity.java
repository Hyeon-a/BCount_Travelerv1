package com.example.sohee.t;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Sohee on 2017-05-10.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signupenterbtn = (Button)findViewById(R.id.signupenterbtn);
        signupenterbtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this,"등록되었습니다!",Toast.LENGTH_SHORT).show();
        Intent signupenterbtnIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(signupenterbtnIntent);
    }


}
