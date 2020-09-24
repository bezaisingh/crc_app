package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static boolean isConnected = false;
    private BroadcastReceiver NetworkStatusReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager connMgr = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

            if (!isConnected) {
                Toast noInternetToast = Toast.makeText(getApplicationContext(),
                        R.string.no_internet_msg, Toast.LENGTH_LONG);
                noInternetToast.show();
            }else {
                Toast InternetToast = Toast.makeText(getApplicationContext(),
                        R.string.connected_internet_msg, Toast.LENGTH_LONG);
                InternetToast.show();
            }
        }
    };

    ImageButton imgBtn_TenderAndNotice,
                imgBtn_NewsAndPress,
                imgBtn_AboutUs,
                imgBtn_Departments,
                imgBtn_Photo_Gallery,
                imgBtn_PatientReg,
                imgBtn_Recruitment,
                imgBtn_RelatedWebSites,
                imgBtn_PatientList;

    LinearLayout llNews,
                 llPatientReg,
                 llAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(NetworkStatusReceiver, new IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION));


        setupUIviews();    // typecasted all the buttons, textviews and imageviews etc.

        if(MainActivity.isConnected){
            /** Do your network operation **/

        }

/*

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

                }
            });

            imgBtn_PatientList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // startActivity(new Intent(MainActivity.this, SearchPatient.class));
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


            imgBtn_PatientReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Patient_Registration.class));
                }
            });

 */

        llNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewsAndPressRelease.class));
            }
        });

        llPatientReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Patient_Registration.class));
            }
        });

        llAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            }
        });

        }

    private void setupUIviews() {
/*
        imgBtn_TenderAndNotice = findViewById(R.id.image_notice);
        imgBtn_NewsAndPress = findViewById(R.id.image_press);
        imgBtn_PatientList=findViewById(R.id.image_patient_list);
        imgBtn_PatientReg = findViewById(R.id.image_patient_reg);
        imgBtn_AboutUs = findViewById(R.id.image_about_us);
        imgBtn_Departments = findViewById(R.id.image_departments);
        imgBtn_Photo_Gallery = findViewById(R.id.image_gallery);
        imgBtn_Recruitment= findViewById(R.id.image_recruitment);
        imgBtn_RelatedWebSites= findViewById(R.id.image_relatedWebsites);
*/
        llNews=findViewById(R.id.llNews);
        llPatientReg=findViewById(R.id.llPatientReg);
        llAboutUs=findViewById(R.id.llAboutUs);

    }
}