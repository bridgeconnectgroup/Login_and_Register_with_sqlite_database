package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1, e2, e3, e4, e5, e6, e7;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.pass);
        e3 = (EditText) findViewById(R.id.cpass);
        e4 = (EditText) findViewById(R.id.name);
        e5 = (EditText) findViewById(R.id.address);
        e6 = (EditText) findViewById(R.id.gender);
        e7 = (EditText) findViewById(R.id.status);
        b1 = (Button) findViewById(R.id.register);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                String s7 = e7.getText().toString();
                if (s1.equals(" ") || s2.equals("") || s3.equals(" ") || s4.equals(" ") || s5.equals(" ") || s6.equals(" ") || s7.equals(" ")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s2.equals(s3)) {
                        Boolean chkemail = db.chkemail(s1);
                        if ( chkemail==true) {
                            Boolean insert = db.insert(s1, s2, s3, s4, s5, s6, s7);
                            if (insert==true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
    }

}