package com.example.lowes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1,e2,e3,e4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.uname);
        e2 = (EditText)findViewById(R.id.email);
        e3 = (EditText)findViewById(R.id.phn);
        e4 = (EditText)findViewById(R.id.pwd);
        b1 = (Button)findViewById(R.id.signup);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")) {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean chkuname = db.chkuname(s1);
                    if(chkuname==true) {
                        Boolean insert = db.insert(s1,s2,Integer.parseInt(s3),s4);
                        Intent intent2 = new Intent();
                        intent2.setClass(MainActivity.this, Next.class);
                        startActivity(intent2);

                    }
                    else {
                        Toast.makeText(getApplicationContext(),"UserName Already Exists",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //register.setMovementMethod(LinkMovementMethod.getInstance());
    public void test(View view)
    {
        TextView register=(TextView)findViewById(R.id.ln);
        Intent intent=new Intent(MainActivity.this,login.class);
        startActivity(intent);
    }
}