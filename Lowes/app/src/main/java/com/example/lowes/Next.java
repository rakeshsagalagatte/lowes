package com.example.lowes;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Next extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View view) {
        Button rate = (Button)findViewById(R.id.b3);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // All your networking logic
                // should be here
                try {
                URL rak1 = new URL("http://rakeshsagalagatte.pythonanywhere.com/users");


                    // Create connection
                    HttpURLConnection myConnection = (HttpURLConnection) rak1.openConnection();
                    myConnection.setRequestProperty("Accept",
                            "application/json");
                    myConnection.setRequestProperty("Contact-Me",
                            "rakeshsagalagatte@gmail.com");
                    if (myConnection.getResponseCode() <= 200) {

                        // Success
                        // Further processing here
                    } else {
                        // Error handling code goes here
                    }
                    InputStream responseBody = myConnection.getInputStream();
                    InputStreamReader responseBodyReader =new InputStreamReader(responseBody, "UTF-8");
                    JsonReader jsonReader = new JsonReader(responseBodyReader);
                    jsonReader.beginObject(); // Start processing the JSON object
                    while (jsonReader.hasNext()) { // Loop through all keys
                        String key = jsonReader.nextName(); // Fetch the next key
                        if (key.equals("username")) { // Check if desired key
                            // Fetch the value as a String
                            //String value = jsonReader.nextString();
                            String vlaue = JSONValue.toJSONString(jsonReader);
                            Toast.makeText(getApplicationContext(), value , Toast.LENGTH_LONG).show();

                            // Do something with the value
                            // ...

                            break; // Break out of the loop
                        } else {
                            jsonReader.skipValue(); // Skip values of other keys
                        }
                    }
                    jsonReader.close();
                    myConnection.disconnect();
                }
                catch (Exception e)
                {

                }
            }
        });
        }
    }