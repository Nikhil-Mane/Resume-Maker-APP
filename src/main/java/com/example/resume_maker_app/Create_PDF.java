package com.example.resume_maker_app;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
public class Create_PDF extends AppCompatActivity {
    ImageView imageView,back;
    SharedPreferences SP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__p_d_f);
        PDFView pdfview =findViewById(R.id.pdfView);
        File file = new File(Environment.getExternalStorageDirectory(), "RESUME_PDF_CREATE.pdf");
        Uri path = Uri.fromFile(file);
        pdfview.fromUri(path).load();
        imageView=findViewById(R.id.download);
        imageView.setOnClickListener(new View.OnClickListener() {
            String url=file.toString();
            @Override
            public void onClick(View v) {
                Toast.makeText(Create_PDF.this,"File Saved in Internal Storage Directory",Toast.LENGTH_SHORT).show();
            }
        });
        back=findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Create_PDF.this,starting_page_activity.class);
                startActivity(intent);
            }
        });

    }

}