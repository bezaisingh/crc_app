package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageButton imgBtn_TenderAndNotice,
                imgBtn_NewsAndPress,
                imgBtn_AboutUs,
                imgBtn_Departments,
                imgBtn_Photo_Gallery,
                imgBtn_PatientReg,
                imgBtn_Recruitment,
                imgBtn_RelatedWebSites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupUIviews();    // typecasted all the buttons, textviews and imageviews etc.

        imgBtn_TenderAndNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TendersAndNotice.class));

               /////

              /*  if(json_string==null){
                    new BackgroundTask_home().execute();
                    Toast.makeText(getApplicationContext(),"First get JSON", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent =new Intent(MainActivity.this, TendersAndNotice.class);
                    intent.putExtra("JsonData", json_string);
                    startActivity(intent);
                }
                ////
*/
            }
        });

        imgBtn_PatientReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Patient_Registration.class));
            }
        });

        imgBtn_NewsAndPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewsAndPressRelease.class));
            }
        });

        imgBtn_AboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            }
        });

        imgBtn_Departments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Departments.class));
            }
        });

        imgBtn_Photo_Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Photo_Gallery.class));
            }
        });

        imgBtn_Recruitment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Recruitments.class));
            }
        });

        imgBtn_RelatedWebSites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RelatedWebSites.class));
            }
        });
    }

    private void setupUIviews() {

        imgBtn_TenderAndNotice = findViewById(R.id.image_notice);
        imgBtn_NewsAndPress = findViewById(R.id.image_press);
        imgBtn_PatientReg = findViewById(R.id.image_patient_reg);
        imgBtn_AboutUs = findViewById(R.id.image_about_us);
        imgBtn_Departments = findViewById(R.id.image_departments);
        imgBtn_Photo_Gallery = findViewById(R.id.image_gallery);
        imgBtn_Recruitment= findViewById(R.id.image_recruitment);
        imgBtn_RelatedWebSites= findViewById(R.id.image_relatedWebsites);

    }

}