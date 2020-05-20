package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Patient_Registration extends AppCompatActivity {
    String json_string="NULL";
    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    String TAG= "Bijay Self check Patient Registration";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__registration);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Patient Registration");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
      //  toolbar.setBackgroundColor(Color.parseColor("#008577"));
        //To display back Arrow on toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create an Instance of Background Worker
        BackgroundWorker_PatientReg backgroundWorker_patientReg;
        backgroundWorker_patientReg = new BackgroundWorker_PatientReg(this);
        backgroundWorker_patientReg.execute();

        listView= findViewById(R.id.patientListView);
        Log.v(TAG, "Json String mein garbar hai Patient Registration");
    }

//*********** To go back to the previous page using the back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        this.finish();
        return super.onOptionsItemSelected(item);
    }
//*************


    private void displayPatientRegData() {
        Patient_Reg_Adapter patient_reg_adapter= new Patient_Reg_Adapter(this, R.layout.patient_row_layout);
        listView.setAdapter(patient_reg_adapter);

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray= jsonObject.getJSONArray("kitten");

            int count=0;
            String reg_no, patient_name, father_name,
                    age, gender, contact_no, adhar_no,
                    occupation, address, referred_by,
                    referred_to, chief_complaints;
            while (count<jsonArray.length()){

                JSONObject JO= jsonArray.getJSONObject(count);
                reg_no=JO.getString("reg_id");
                patient_name=JO.getString("name");
                father_name=JO.getString("f_name");
                age=JO.getString("age");
                gender=JO.getString("gender");
                contact_no=JO.getString("mobile");
                occupation=JO.getString("occupation");
                address=JO.getString("district");
                referred_by=JO.getString("ref_by");
                referred_to=JO.getString("ref_to");
                chief_complaints=JO.getString("chief_complaint");

                Patient_Reg_Getter_Setter patient_reg_getter_setter =new Patient_Reg_Getter_Setter(reg_no,patient_name,
                        father_name, age, gender, contact_no,occupation,address,referred_by,referred_to, chief_complaints);
                patient_reg_adapter.add(patient_reg_getter_setter);
                count++;

                Log.v(TAG,patient_name + " "+ father_name+ " "+ gender);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /////////////////Background Tasks Coding////////////////
    public class BackgroundWorker_PatientReg extends AsyncTask<Void, Void, String> {

        Context context;
        AlertDialog alertDialog;
        BackgroundWorker_PatientReg(Context ctx){
            context=ctx;
        }

        String json_url;

        @Override
        protected void onPreExecute() {

            // json_url="https://crcapp.000webhostapp.com/crc/tender.php";
            json_url="http://disgenonline.in/CRCAPI/patientReg.php";

            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Loading Please Wait...");
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {
                URL url= new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder= new StringBuilder();
                while ((JSON_STRING= bufferedReader.readLine())!=null){

                    stringBuilder.append(JSON_STRING+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result ) {

            json_string=result;

            if (result.isEmpty()){
                Toast.makeText(context, "NO JSON Data Found....", Toast.LENGTH_SHORT).show();
            }else
            {
                displayPatientRegData();
            }
            //////////////////Parse Json//////////////////////
            json_string=result;
            //////////////////////////////////////////////////
        }
    }
    //////////////////////////////////////////////////////////
}
