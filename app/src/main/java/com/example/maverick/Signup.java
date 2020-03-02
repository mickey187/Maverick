package com.example.maverick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText fullname, username, email, password, phone;
    RadioGroup sex;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        sex = findViewById(R.id.sex);
        signup = findViewById(R.id.signup);
        final DbHelper dbHelper = new DbHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullnamevalue = fullname.getText().toString();
                String usernamevalue = username.getText().toString();
                String emailvalue = email.getText().toString();
                String passwordvalue = password.getText().toString();
                String phonevalue = phone.getText().toString();
                RadioButton checkedBtn = findViewById(sex.getCheckedRadioButtonId());
                String sexvalue = checkedBtn.getText().toString();
                if(usernamevalue.length() > 1){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("fullname",fullnamevalue);
                    contentValues.put("username",usernamevalue);
                    contentValues.put("email",emailvalue);
                    contentValues.put("password",passwordvalue);
                    contentValues.put("phone",phonevalue);
                    contentValues.put("sex",sexvalue);
                    dbHelper.insertUser(contentValues);
                    Toast.makeText(Signup.this,"User Registered",Toast.LENGTH_SHORT).show();


                }
                else {
                    Toast.makeText(Signup.this,"Enter The Values",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
