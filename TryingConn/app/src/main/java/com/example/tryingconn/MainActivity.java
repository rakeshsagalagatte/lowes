package com.example.tryingconn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       maps = (Button) findViewById(R.id.maps);
       maps.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent inten = new Intent(MainActivity.this , Mapsactivity.class);
               startActivity(inten);
           }
       });

    }



    public void jsdata(View view){
        DownloadTask task = new DownloadTask();
        task.execute("http://rakeshsagalagatte.pythonanywhere.com/users/1/?format=json");
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
          String result = "";
            URL url ;
            HttpURLConnection urlConnection = null;

            try {
                   url = new URL(urls[0]);
                   urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while(data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;
            }catch (Exception e)
            {
                e.printStackTrace();
                return  null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);

                String whet = jsonObject.getString("username");

                Toast.makeText(MainActivity.this, whet, Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(MainActivity.this, "ERROR_IN_CONNECTION", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }


}
