package com.example.resume_maker_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class starting_page_activity extends AppCompatActivity {
    private Button move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page_activity);
    }

    public void movetonextactivity(View view) {

        Intent intent=new Intent(starting_page_activity.this,MainActivity.class);
        startActivity(intent);

    }
}