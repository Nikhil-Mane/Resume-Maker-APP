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

public class SkillS_Technology extends AppCompatActivity {
    EditText skill1,skill2,skill3,skill4;
    ImageButton imageButton1,imageButton2;
    Button save_tech;
    SharedPreferences SP;
    String SKILL1,SKILL2,SKILL3,SKILL4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills__technology);
        try {
            skill1=findViewById(R.id.skills_data);
            skill2=findViewById(R.id.skills_data1);
            imageButton1=findViewById(R.id.skill_data_add);
            skill3=findViewById(R.id.technology_data);
            skill4=findViewById(R.id.technology_data1);
            imageButton2=findViewById(R.id.technology_data_add);
            save_tech=findViewById(R.id.skills_technology_data_add);
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    SKILL1=skill1.getText().toString();
                    SKILL2=skill2.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Skill 1:",SKILL1);
                    editor.putString("Skill 2:",SKILL2);
                    editor.commit();
                    Toast.makeText(SkillS_Technology.this," Skills Data Save Successfully",Toast.LENGTH_LONG).show();
                    skill1.setText("");
                    skill2.setText("");
                }
            });
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    SKILL3=skill3.getText().toString();
                    SKILL4=skill4.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Technology 1:",SKILL3);
                    editor.putString("Technology 2:",SKILL4);
                    editor.commit();
                    Toast.makeText(SkillS_Technology.this," Tech Data Save Successfully",Toast.LENGTH_LONG).show();
                    skill3.setText("");
                    skill4.setText("");
                }
            });

            save_tech.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    SKILL1=skill1.getText().toString();
                    SKILL2=skill2.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Skill 3:",SKILL1);
                    editor.putString("Skill 4:",SKILL2);
                    SKILL3=skill3.getText().toString();
                    SKILL4=skill4.getText().toString();
                    editor.putString("Technology 3:",SKILL3);
                    editor.putString("Technology 4:",SKILL4);
                    editor.commit();
                    Toast.makeText(SkillS_Technology.this," Skills  and Tech Data Save Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(SkillS_Technology.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            ImageView image;
            image=findViewById(R.id.back_btn);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(SkillS_Technology.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            Toast.makeText(SkillS_Technology.this," Fill data Properly",Toast.LENGTH_LONG).show();
        }
    }
    public void savetodoc(View view) {
        Intent intent=new Intent(SkillS_Technology.this,MainActivity.class);
        startActivity(intent);
    }
}