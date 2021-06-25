package com.example.resume_maker_app;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Rectangle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
public class MainActivity extends AppCompatActivity {
    SharedPreferences SP;
    Button btn1;
    ImageView image;
    String NAME,Genderr,dob,EMIAL,MOBILE_NUMBER,LOCATION,HOMETOWN,
            type,college_name,passing_year,marks_obtained,
            type1,college_name1,passing_year1,marks_obtained1,
            SKILL1,SKILL2,SKILL3,SKILL4,
            SKILL11,SKILL22,SKILL33,SKILL44,
            certificate1,certificate2,certificate3,certificate4,
            certificate11,certificate22,certificate33,certificate44,
            Lang1,Lang2,Lang3,Lang4,
            Lang11,Lang22,Lang33,Lang44,
            Project1,Project2,
            Project11,Project22,
            Speak1,Speak2,
            Speak11,Speak22;
    private static final int PERMISSION_REQUEST_CODE = 200;
    int pageHeight = 1120;
    int pagewidth = 792;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Information Module");
        try {
            btn1 = findViewById(R.id.createPDF);
//            tw = findViewById(R.id.createpdf);
            if (checkPermission()) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                requestPermission();
            }
            btn1.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View v) {

                    SP = getSharedPreferences("MYSHAREDPREFERENCE", Context.MODE_PRIVATE);
                    NAME = SP.getString("NAME OF STUDENT", NAME);
                    Genderr = SP.getString("GENDER:", Genderr);
                    dob = SP.getString("Date of Birth:", dob);
                    EMIAL = SP.getString("Email:", EMIAL);
                    MOBILE_NUMBER = SP.getString("Mobile Number:", MOBILE_NUMBER);
                    LOCATION = SP.getString("Location:", LOCATION);
                    HOMETOWN = SP.getString("HomeTown:", HOMETOWN);

                    type = SP.getString("TYPE of Education", type);
                    college_name = SP.getString("College Name", college_name);
                    passing_year = SP.getString("Year Passed", passing_year);
                    marks_obtained = SP.getString("Marks Obtained", marks_obtained);

                    type1 = SP.getString("TYPE of Education1", type);
                    college_name1 = SP.getString("College Name1", college_name);
                    passing_year1 = SP.getString("Year Passed1", passing_year);
                    marks_obtained1 = SP.getString("Marks Obtained1", marks_obtained);

                    SKILL1 = SP.getString("Skill 1:", SKILL1);
                    SKILL11 = SP.getString("Skill 3:", SKILL1);
                    SKILL2 = SP.getString("Skill 2:", SKILL2);
                    SKILL22 = SP.getString("Skill 4:", SKILL2);
                    SKILL3 = SP.getString("Technology 1:", SKILL3);
                    SKILL33 = SP.getString("Technology 3:", SKILL3);
                    SKILL4 = SP.getString("Technology 2:", SKILL4);
                    SKILL44 = SP.getString("Technology 4:", SKILL4);

                    certificate1 = SP.getString("Certificate 1", certificate1);
                    certificate2 = SP.getString("Certificate 2", certificate2);
                    certificate3 = SP.getString("Certificate 3", certificate3);
                    certificate4 = SP.getString("Certificate 4", certificate4);
                    certificate11 = SP.getString("Certificate 11", certificate11);
                    certificate22 = SP.getString("Certificate 22", certificate22);
                    certificate33 = SP.getString("Certificate 33", certificate33);
                    certificate44 = SP.getString("Certificate 44", certificate44);

                    Lang1 = SP.getString("Coding Lang1", Lang1);
                    Lang2 = SP.getString("Coding Lang2", Lang2);
                    Lang3 = SP.getString("Coding Lang3", Lang3);
                    Lang4 = SP.getString("Coding Lang4", Lang4);
                    Lang11 = SP.getString("Coding Lang11", Lang11);
                    Lang22 = SP.getString("Coding Lang22", Lang22);
                    Lang33 = SP.getString("Coding Lang33", Lang33);
                    Lang44 = SP.getString("Coding Lang44", Lang44);

                    Project1 = SP.getString("Project 1", Project1);
                    Project2 = SP.getString("Project 2", Project2);
                    Project11 = SP.getString("Project 11", Project11);
                    Project22 = SP.getString("Project 22", Project22);

                    Speak1 = SP.getString("Speaking language 1", Speak1);
                    Speak2 = SP.getString("Speaking language 2", Speak2);
                    Speak11 = SP.getString("Speaking language 11", Speak11);
                    Speak22 = SP.getString("Speaking language 22", Speak22);

                    PdfDocument pdfDocument = new PdfDocument();
                    Paint paint = new Paint();
                    Paint title = new Paint();
                    Paint Subtitle = new Paint();
                    PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();
                    PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);
                    Canvas canvas = myPage.getCanvas();
                    title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                    title.setTextSize(55);
                    title.setColor(Color.RED);
                    canvas.drawText("\t\tRESUME", 250, 50, title);
                    Subtitle.setTextSize(15);
                    Subtitle.setColor(Color.BLUE);
                    paint.setTextSize(15);
                    paint.setColor(Color.BLACK);
                    canvas.drawText("PERSONAL INFORNMATION :\n\n\n", 100, 130, Subtitle);
                    canvas.drawText("Student Name :\t\t" + NAME, 200, 150, paint);
                    canvas.drawText("Gender :\t\t" + Genderr, 200, 165, paint);
                    canvas.drawText("Date of Birth :\t\t" + dob, 200, 180, paint);
                    canvas.drawText("Email :\t\t" + EMIAL, 200, 195, paint);
                    canvas.drawText("Mobile Number:\t\t" + MOBILE_NUMBER, 200, 210, paint);
                    canvas.drawText("Location:\t\t" + LOCATION, 200, 225, paint);
                    canvas.drawText("HomeTown\t\t:" + HOMETOWN, 200, 240, paint);

                    canvas.drawText("EDUCATION INFORMATION:\n\n\n\n", 100, 260, Subtitle);
                    if (type != "" && college_name != "" && passing_year != "" && marks_obtained != "") {
                        canvas.drawText("Type of Education\t\t:" + type, 200, 280, paint);
                        canvas.drawText("College Name\t\t:" + college_name, 200, 295, paint);
                        canvas.drawText("Passout Year\t\t:" + passing_year, 200, 310, paint);
                        canvas.drawText("Marks\t\t:" + marks_obtained, 200, 325, paint);
                    } else {
                        canvas.drawText("Type of Education\t\t:" + type1, 200, 280, paint);
                        canvas.drawText("College Name\t\t:" + college_name1, 200, 295, paint);
                        canvas.drawText("Passout Year\t\t:" + passing_year1, 200, 310, paint);
                        canvas.drawText("Marks\t\t:" + marks_obtained1, 200, 325, paint);
                    }
                    if (type1 != "" && college_name1 != "" && passing_year1 != "" && marks_obtained1 != "") {
                        canvas.drawText("Type of Education\t\t:" + type1, 200, 340, paint);
                        canvas.drawText("College Name\t\t:" + college_name1, 200, 355, paint);
                        canvas.drawText("Passout Year\t\t:" + passing_year1, 200, 370, paint);
                        canvas.drawText("Marks\t\t:" + marks_obtained1, 200, 385, paint);
                    }

                    canvas.drawText("SKILLS:\n\n\n", 100, 400, Subtitle);
                    if (SKILL1 != "" && SKILL2 != "") {
                        canvas.drawText(SKILL1, 200, 415, paint);
                        canvas.drawText(SKILL2, 200, 430, paint);
                    } else {
                        canvas.drawText(SKILL11, 200, 415, paint);
                        canvas.drawText(SKILL22, 200, 430, paint);

                    }
                    if (SKILL11 != "" && SKILL22 != "") {
                        canvas.drawText(SKILL11, 200, 445, paint);
                        canvas.drawText(SKILL22, 200, 460, paint);
                    }

                    canvas.drawText("TECHNOLOGY:\n", 100, 475, Subtitle);
                    if (SKILL3 != "" && SKILL4 != "") {
                        canvas.drawText(SKILL3, 200, 490, paint);
                        canvas.drawText(SKILL4, 200, 505, paint);
                    } else {
                        canvas.drawText(SKILL33, 200, 490, paint);
                        canvas.drawText(SKILL44, 200, 505, paint);

                    }
                    if (SKILL33 != "" && SKILL44 != "") {
                        canvas.drawText(SKILL33, 200, 515, paint);
                        canvas.drawText(SKILL44, 200, 530, paint);
                    }
                    canvas.drawText("CERTIFICATES::\n", 100, 545, Subtitle);
                    if (certificate1 != "" && certificate2 != "" && certificate3 != "" && certificate4 != "") {
                        canvas.drawText(certificate1, 200, 560, paint);
                        canvas.drawText(certificate2, 200, 575, paint);
                        canvas.drawText(certificate3, 200, 590, paint);
                        canvas.drawText(certificate4, 200, 605, paint);
                    } else {
                        canvas.drawText(certificate11, 200, 560, paint);
                        canvas.drawText(certificate22, 200, 575, paint);
                        canvas.drawText(certificate33, 200, 590, paint);
                        canvas.drawText(certificate44, 200, 605, paint);
                    }
                    if (certificate11 != "" && certificate22 != "" && certificate33 != "" && certificate44 != "") {
                        canvas.drawText(certificate11, 200, 620, paint);
                        canvas.drawText(certificate22, 200, 635, paint);
                        canvas.drawText(certificate33, 200, 650, paint);
                        canvas.drawText(certificate44, 200, 665, paint);
                    }

                    canvas.drawText("CODING LANGUAGES::\n", 100, 680, Subtitle);
                    if (Lang1 != "" && Lang2 != "" && Lang3 != "" && Lang4 != "") {
                        canvas.drawText(Lang1, 200, 695, paint);
                        canvas.drawText(Lang2, 200, 710, paint);
                        canvas.drawText(Lang3, 200, 725, paint);
                        canvas.drawText(Lang4, 200, 740, paint);
                    } else {
                        canvas.drawText(Lang11, 200, 695, paint);
                        canvas.drawText(Lang22, 200, 710, paint);
                        canvas.drawText(Lang33, 200, 725, paint);
                        canvas.drawText(Lang44, 200, 740, paint);
                    }
                   if (Lang11 !="" && Lang22 !="" && Lang33 !="" && Lang44 !="" )
                   {
                        canvas.drawText(Lang11,200,755,paint);
                        canvas.drawText(Lang22,200,770,paint);
                        canvas.drawText(Lang33,200,785,paint);
                        canvas.drawText(Lang44,200,800,paint);

                   }
                    canvas.drawText("PROJECTS:\n",100,815,Subtitle);
                    if(Project1 !="" && Project2 !="")
                    {
                        canvas.drawText(Project1,200,830,paint);
                        canvas.drawText(Project2,200,845,paint);
                    }
                    else
                    {
                        canvas.drawText(Project11,200,830,paint);
                        canvas.drawText(Project22,200,845,paint);

                    }
                    if(Project11 !="" && Project22 !="" )
                    {
                        canvas.drawText(Project11,200,860,paint);
                        canvas.drawText(Project22,200,875,paint);
                    }
                    canvas.drawText("SPEAKING LANGUAGES :\n",100,890,Subtitle);
                    if(Speak1 !="" && SKILL2 !="")
                    {
                        canvas.drawText(Speak1,200,905,paint);
                        canvas.drawText(Speak2,200,920,paint);
                    }
                    else
                    {
                        canvas.drawText(Speak11,200,905,paint);
                        canvas.drawText(Speak22,200,920,paint);

                    }
                    if(Speak11 !="" && SKILL22 !="" )
                    {
                        canvas.drawText(Speak11,200,935,paint);
                        canvas.drawText(Speak22,200,950,paint);
                    }
                    Toast.makeText(MainActivity.this, "PDF file generated succesfully.", Toast.LENGTH_SHORT).show();
                    title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//                    title.setColor(ContextCompat.getColor(this, R.color.purple_200));
                    title.setTextSize(15);
                    pdfDocument.finishPage(myPage);

                    File file = new File(Environment.getExternalStorageDirectory(), "RESUME_PDF_CREATE.pdf");
                    try {
                        pdfDocument.writeTo(new FileOutputStream(file));
                        Toast.makeText(MainActivity.this, "PDF file generated succesfully.", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    pdfDocument.close();
                    Intent intent=new Intent(MainActivity.this,Create_PDF.class);
                    startActivity(intent);
                }

            });
            image=findViewById(R.id.back_btn);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,starting_page_activity.class);
                    startActivity(intent);
                }
            });

        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"Problem in Code",Toast.LENGTH_LONG).show();
        }


    }
    private boolean checkPermission()
    {
        // checking of permissions.
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }
    private void requestPermission() {
        // requesting permissions if not provided.
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (writeStorage && readStorage) {
                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denined.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }

    public void MoveToPersonalInfoActivity(View view) {
        Intent intent=new Intent(MainActivity.this,personal_info_activity.class);
        startActivity(intent);
    }

    public void MoveToEducationActivity(View view) {
        Intent intent=new Intent(MainActivity.this,Education_activity.class);
        startActivity(intent);
    }

    public void MoveToSkillS_Technology(View view) {
        Intent intent=new Intent(MainActivity.this,SkillS_Technology.class);
        startActivity(intent);
    }

    public void MoveToCoding_Language(View view) {
        Intent intent=new Intent(MainActivity.this,Coding_Language.class);
        startActivity(intent);
    }

    public void MoveToCertification_Activity(View view) {
        Intent intent=new Intent(MainActivity.this,Certification_Activity.class);
        startActivity(intent);
    }

    public void MoveToProject_activity(View view) {
        Intent intent=new Intent(MainActivity.this,Project_activity.class);
        startActivity(intent);
    }

    public void MoveToSpeaking_Language(View view) {
        Intent intent=new Intent(MainActivity.this,Speaking_Languages.class);
        startActivity(intent);
    }

    public void create_pdf_form(View view) {
        Intent intent=new Intent(MainActivity.this,Create_PDF.class);
        startActivity(intent);
    }
}
