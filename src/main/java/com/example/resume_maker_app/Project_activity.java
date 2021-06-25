package com.example.resume_maker_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Project_activity extends AppCompatActivity {
    EditText project1,project2;
    ImageButton imageButton1;
    Button save_project;
    SharedPreferences SP;
    String Project1,Project2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_activity);
        try {
            project1=findViewById(R.id.projects_data1);
            project2=findViewById(R.id.projects_data2);
            imageButton1=findViewById(R.id.projects_data_add);
            save_project=findViewById(R.id.projects_data_add_button);
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    Project1=project1.getText().toString();
                    Project2=project2.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Project 1",Project1);
                    editor.putString("Project 2",Project2);
                    editor.commit();
                    Toast.makeText(Project_activity.this," Project Data Save Successfully",Toast.LENGTH_LONG).show();
                    project1.setText("");
                    project2.setText("");
                }
            });
            save_project.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    Project1=project1.getText().toString();
                    Project2=project2.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Project 11",Project1);
                    editor.putString("Project 22",Project2);
                    editor.commit();
                    Toast.makeText(Project_activity.this," Project Data Save Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Project_activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            ImageView image;
            image=findViewById(R.id.back_btn);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Project_activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            Toast.makeText(Project_activity.this," Inproper Data",Toast.LENGTH_LONG).show();
        }
    }

}