package com.example.sohee.t;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Looper;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2017-09-13.
 */

public class CheckActivity extends Activity {

    ProgressDialog dialog = null;
    HttpPost httpPost;
    HttpResponse response;
    HttpClient httpClient;
    List<NameValuePair> nameValuePairs;

    public void execute() {
        if(RecoBackgroundRangingService.flag==88) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    addUser2();
                    Looper.loop();
                }
            }).start();
        }
    }

    void addUser2() {
        try {

            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost("http://10.200.15.145/addUser.php");
            nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("phonenum", LoginActivity.phonenum));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            response = httpClient.execute(httpPost);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpClient.execute(httpPost, responseHandler);
            System.out.println("Respone:" + response);


            /*RecoBackgroundRangingService.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            });*/
            Log.v("response 값: ", response);

        } catch (Exception e) {
            dialog.dismiss();
            System.out.println("Exception : " + e.getMessage());
        }
    }

}
