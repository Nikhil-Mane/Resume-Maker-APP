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

public class Speaking_Languages extends AppCompatActivity {
    EditText speak1,speak2;
    ImageButton imageButton1;
    Button save_speak;
    SharedPreferences SP;
    String Speak1,Speak2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaking__languages);
        try {
            speak1=findViewById(R.id.languages_data1);
            speak2=findViewById(R.id.languages_data2);
            imageButton1=findViewById(R.id.languages_data_add);
            save_speak=findViewById(R.id.languages_data_add_button);
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    Speak1=speak1.getText().toString();
                    Speak2=speak2.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Speaking language 1",Speak1);
                    editor.putString("Speaking language 2",Speak2);
                    editor.commit();
                    Toast.makeText(Speaking_Languages.this," Speaking Language Data Save Successfully",Toast.LENGTH_LONG).show();
                    speak1.setText("");
                    speak2.setText("");
                }
            });
            save_speak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    Speak1=speak1.getText().toString();
                    Speak2=speak2.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Speaking language 11",Speak1);
                    editor.putString("Speaking language 22",Speak2);
                    editor.commit();
                    Toast.makeText(Speaking_Languages.this," Speaking Language Data Save Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Speaking_Languages.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            ImageView image;
            image=findViewById(R.id.back_btn);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Speaking_Languages.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            Toast.makeText(Speaking_Languages.this," Enter Proper Input",Toast.LENGTH_LONG).show();
        }
    }

}