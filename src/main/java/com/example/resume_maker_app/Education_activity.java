package com.example.resume_maker_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;

public class Education_activity extends AppCompatActivity {
    EditText TYPE,COLLEGE_NAME,PASSING_YEAR,MARKS_OBTAINED;
    ImageButton imageButton;
    Button save_edu;
    SharedPreferences SP;
    String type,college_name,passing_year,marks_obtained;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_activity);
        try {
            TYPE=findViewById(R.id.education_name);
            COLLEGE_NAME=findViewById(R.id.college_name);
            PASSING_YEAR=findViewById(R.id.year_passed);
            MARKS_OBTAINED=findViewById(R.id.marks_obtained);
            imageButton=findViewById(R.id.image_edu);
            save_edu=findViewById(R.id.SAVE_dataintotextview);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    type=TYPE.getText().toString();
                    college_name=COLLEGE_NAME.getText().toString();
                    passing_year=PASSING_YEAR.getText().toString();
                    marks_obtained=MARKS_OBTAINED.getText().toString();

                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("TYPE of Education",type);
                    editor.putString("College Name",college_name);
                    editor.putString("Year Passed",passing_year);
                    editor.putString("Marks Obtained",marks_obtained);
                    editor.commit();
                    Toast.makeText(Education_activity.this," Educational Data Save Successfully",Toast.LENGTH_LONG).show();
                    TYPE.setText("");
                    COLLEGE_NAME.setText("");
                    PASSING_YEAR.setText("");
                    MARKS_OBTAINED.setText("");
                }
            });
            save_edu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    type=TYPE.getText().toString();
                    college_name=COLLEGE_NAME.getText().toString();
                    passing_year=PASSING_YEAR.getText().toString();
                    marks_obtained=MARKS_OBTAINED.getText().toString();

                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("TYPE of Education1",type);
                    editor.putString("College Name1",college_name);
                    editor.putString("Year Passed1",passing_year);
                    editor.putString("Marks Obtained1",marks_obtained);
                    editor.commit();
                    Toast.makeText(Education_activity.this," Educational Data Save Successfully",Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Education_activity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            ImageView image;
            image=findViewById(R.id.back_btn);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Education_activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            Toast.makeText(Education_activity.this,"Add Data Properly",Toast.LENGTH_LONG).show();
        }

    }

}



