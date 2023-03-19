package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Lab6_2 extends AppCompatActivity {



    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab62); b1 =
                (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternetConenction();
                downloadImage("https://www.must.edu.mn/static/images/must-logo.png");
            }
        });
    }
    private void downloadImage(String urlStr) {
        progressDialog = ProgressDialog.show(this, "", "Downloading Image from " + urlStr);
        final String url = urlStr;
        new Thread() {
            public void run() {
                InputStream in = null;
                Message msg = Message.obtain();
                msg.what = 1;
                try {
                    in = openHttpConnection(url);
                    if(in == null){
                        Log.d("Haku: ", "null ");
                    }
                    bitmap = BitmapFactory.decodeStream(in);
                    Bundle b = new Bundle();
                    b.putParcelable("bitmap", bitmap);
                    msg.setData(b);
                    in.close();
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
                messageHandler.sendMessage(msg);
            }
        }.start();
    }
    private InputStream openHttpConnection (String urlStr){
        InputStream in = null;
        int resCode = -1;
        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);


            httpConn.setRequestMethod("GET");
            Log.d("Haku: ", httpConn.toString());

            httpConn.connect();
            Log.d("Haku: ", "openHttpConnection: ");
            resCode = httpConn.getResponseCode();
            Log.d("Haku: ", "asdasdasddd");
            if (resCode == HttpURLConnection.HTTP_OK) {
                Log.d("Haku: ", "asda");
                in = httpConn.getInputStream();

            }
        }
//        catch (MalformedURLException e) {
//            e.printStackTrace(); }
        catch  (IOException e) {
            Log.d("Haku: " , e.toString());
            e.printStackTrace(); }
        return in;
    }
    private Handler messageHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageBitmap((Bitmap) (msg.getData().getParcelable("bitmap")));
            progressDialog.dismiss();
        }
    };
    @SuppressLint("MissingPermission")
    private boolean checkInternetConenction () {
        ConnectivityManager connec = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        if (connec.getNetworkInfo(0).getState() ==
             android.net.NetworkInfo.State.CONNECTED || connec.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTING || connec.getNetworkInfo(1).getState()
                == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
            Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            return true;
        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {
            Toast.makeText(this, " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }
}