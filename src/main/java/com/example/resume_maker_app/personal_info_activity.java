package com.example.resume_maker_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class personal_info_activity extends AppCompatActivity {
    EditText name_student,DOB,Email,Mobile_number,Location,Hometown;
    RadioGroup rg;
    Button btn;
    SharedPreferences SP;
    String NAME,Genderr,dob,EMIAL,MOBILE_NUMBER,LOCATION,HOMETOWN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_activity);
        try {
            name_student=findViewById(R.id.namePI);
            rg=findViewById(R.id.GENDER);
            DOB=findViewById(R.id.birthdate);
            Email=findViewById(R.id.email);
            Mobile_number=findViewById(R.id.mobile_number);
            Location=findViewById(R.id.location);
            Hometown=findViewById(R.id.hometown);
            btn=findViewById(R.id.btn_save_personalInfo);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP = getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    NAME = name_student.getText().toString();
                    Genderr = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                    dob = DOB.getText().toString();
                    EMIAL = Email.getText().toString();
                    MOBILE_NUMBER = Mobile_number.getText().toString();
                    LOCATION = Location.getText().toString();
                    HOMETOWN = Hometown.getText().toString();

                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("NAME OF STUDENT", NAME);
                    editor.putString("GENDER:", Genderr);
                    editor.putString("Date of Birth:", dob);
                    editor.putString("Email:", EMIAL);
                    editor.putString("Mobile Number:", MOBILE_NUMBER);
                    editor.putString("Location:", LOCATION);
                    editor.putString("HomeTown:", HOMETOWN);
                    editor.commit();
                    Toast.makeText(personal_info_activity.this, " Personal Data Save Successfully", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(personal_info_activity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            ImageView image;
            image=findViewById(R.id.back_btn);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(personal_info_activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            Toast.makeText(personal_info_activity.this, " Enter the values properly", Toast.LENGTH_LONG).show();
        }

    }

}