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

public class Coding_Language extends AppCompatActivity {
    EditText lang1,lang2,lang3,lang4;
    ImageButton imageButton1;
    Button save_coding;
    SharedPreferences SP;
    String Lang1,Lang2,Lang3,Lang4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding__language);
        try {
            lang1=findViewById(R.id.coding_language_data1);
            lang2=findViewById(R.id.coding_language_data2);
            lang3=findViewById(R.id.coding_language_data3);
            lang4=findViewById(R.id.coding_language_data4);
            imageButton1=findViewById(R.id.coding_language_data_add);
            save_coding=findViewById(R.id.coding_language_data_add_button);
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    Lang1=lang1.getText().toString();
                    Lang2=lang2.getText().toString();
                    Lang3=lang3.getText().toString();
                    Lang4=lang4.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Coding Lang1",Lang1);
                    editor.putString("Coding Lang2",Lang2);
                    editor.putString("Coding Lang3",Lang3);
                    editor.putString("Coding Lang4",Lang4);
                    editor.commit();
                    Toast.makeText(Coding_Language.this," Coding Language Data Save Successfully",Toast.LENGTH_LONG).show();
                    lang1.setText("");
                    lang2.setText("");
                    lang3.setText("");
                    lang4.setText("");
                }
            });
            save_coding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    Lang1=lang1.getText().toString();
                    Lang2=lang2.getText().toString();
                    Lang3=lang3.getText().toString();
                    Lang4=lang4.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Coding Lang11",Lang1);
                    editor.putString("Coding Lang22",Lang2);
                    editor.putString("Coding Lang33",Lang3);
                    editor.putString("Coding Lang44",Lang4);
                    editor.commit();
                    Toast.makeText(Coding_Language.this," Coding Language Data Save Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Coding_Language.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            ImageView image;
            image=findViewById(R.id.back_btn);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Coding_Language.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            Toast.makeText(Coding_Language.this,"Error In Data Input",Toast.LENGTH_LONG).show();
        }
    }

}