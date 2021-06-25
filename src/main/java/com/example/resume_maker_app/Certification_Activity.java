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

public class Certification_Activity extends AppCompatActivity {
    EditText cert1,cert2,cert3,cert4;
    ImageButton imageButton1;
    Button save_cert;
    SharedPreferences SP;
    ImageView image;
    String certificate1,certificate2,certificate3,certificate4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification_);
        try {
            cert1=findViewById(R.id.certifications_data1);
            cert2=findViewById(R.id.certifications_data2);
            cert3=findViewById(R.id.certifications_data3);
            cert4=findViewById(R.id.certifications_data4);
            imageButton1=findViewById(R.id.certifications_data_add);
            save_cert=findViewById(R.id.activity_button);
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    certificate1=cert1.getText().toString();
                    certificate2=cert2.getText().toString();
                    certificate3=cert3.getText().toString();
                    certificate4=cert4.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Certificate 1",certificate1);
                    editor.putString("Certificate 2",certificate2);
                    editor.putString("Certificate 3",certificate3);
                    editor.putString("Certificate 4",certificate4);
                    editor.commit();
                    Toast.makeText(Certification_Activity.this," Certificate Data Save Successfully",Toast.LENGTH_LONG).show();
                    cert1.setText("");
                    cert2.setText("");
                    cert3.setText("");
                    cert4.setText("");
                }
            });
            image=findViewById(R.id.back_btn);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Certification_Activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            save_cert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SP=getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    certificate1=cert1.getText().toString();
                    certificate2=cert2.getText().toString();
                    certificate3=cert3.getText().toString();
                    certificate4=cert4.getText().toString();
                    SharedPreferences.Editor editor = SP.edit();
                    editor.putString("Certificate 11",certificate1);
                    editor.putString("Certificate 22",certificate2);
                    editor.putString("Certificate 33",certificate3);
                    editor.putString("Certificate 44",certificate4);
                    editor.commit();
                    Toast.makeText(Certification_Activity.this," Certificate Data Save Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Certification_Activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            Toast.makeText(Certification_Activity.this,"Enter Data Properly",Toast.LENGTH_LONG).show();
        }
    }

}