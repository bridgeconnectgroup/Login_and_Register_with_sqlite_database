package com.example.activity;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.editTextTextPersonName);
        e2 = (EditText)findViewById(R.id.editTextTextPassword);
        b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = e1.getText(). toString();
                String password = e2.getText(). toString();
                Boolean Chkemailpass = db.emailpassword(email,password);
                if(Chkemailpass==true)
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}