package com.example.sohee.t;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.widget.EditText;
import android.widget.ViewFlipper;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Sohee on 2017-05-10.
 */

public class SignUpActivity extends AppCompatActivity {
    Button signupbt;
    ProgressDialog dialog2 = null;
    EditText ID, PW, GUIDE;
    HttpPost httpPost;
    HttpResponse response;
    HttpClient httpClient;
    List<NameValuePair> nameValuePairs;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ID = (EditText) findViewById(R.id.et_1);
        PW = (EditText) findViewById(R.id.et_2);
        GUIDE = (EditText) findViewById(R.id.et_3);

        signupbt = (Button) findViewById(R.id.signupenterbtn);

        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2 = ProgressDialog.show(SignUpActivity.this, "", "Validating user...", true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        signup();
                        Looper.loop();
                    }
                }).start();
            }
        });

    }

    void signup() {
            try {
                httpClient = new DefaultHttpClient();
                httpPost = new HttpPost("http://10.200.15.145/signup.php");
                nameValuePairs = new ArrayList<NameValuePair>(3);
                nameValuePairs.add(new BasicNameValuePair("name", ID.getText().toString()));
                nameValuePairs.add(new BasicNameValuePair("phone", PW.getText().toString()));
                nameValuePairs.add(new BasicNameValuePair("guide", GUIDE.getText().toString()));
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                response = httpClient.execute(httpPost);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                final String response = httpClient.execute(httpPost,responseHandler);
                System.out.println("Respone:" + response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialog2.dismiss();
                    }
                });
                Log.v("response 값: ", response);
                if(response.equalsIgnoreCase("No Match")) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(SignUpActivity.this, "등록되었습니다!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    finish();
                } else if(response.equalsIgnoreCase("Unvalid Guide")){
                    Toast.makeText(SignUpActivity.this, "가이드번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                } else if(response.equalsIgnoreCase("Already Exists")){
                    Toast.makeText(SignUpActivity.this, "이미 등록된 사용자입니다.", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                dialog2.dismiss();
                System.out.println("Exception : " + e.getMessage());
            }
        }
}

