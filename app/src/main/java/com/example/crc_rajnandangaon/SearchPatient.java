package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SearchPatient extends AppCompatActivity {
    EditText phoneNum, regId;
    String type, json_string="NULL";

    String TAG = "Bijay Self check";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Search Registration");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        phoneNum=findViewById(R.id.etSearchPhone);
        regId=findViewById(R.id.etSearchId);
    }

    //*********** To go back to the previous page using the back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        this.finish();
        return super.onOptionsItemSelected(item);
    }
//*************

    public void OnSearch(View view) {

        String phoneNo=phoneNum.getText().toString();
        String regNo=regId.getText().toString();
        type = "submit";

      /*  Intent intent =new Intent(SearchPatient.this, Patient_List.class);
        intent.putExtra("PHONE_NUMBER", phoneNo);
        intent.putExtra("REG_NUMBER", regNo);
        startActivity(intent);
      */
if(phoneNo.isEmpty() & regNo.isEmpty()){

    Toast.makeText(SearchPatient.this, "Enter search credentials first....", Toast.LENGTH_SHORT).show();
}else{
    BackgroundWorker_Patient_Search backgroundWorker_patient_search = new BackgroundWorker_Patient_Search(this);
    backgroundWorker_patient_search.execute(type, phoneNo, regNo );
}

    }

    public class BackgroundWorker_Patient_Search extends AsyncTask<String, String, String> {

        Context context;
        AlertDialog alertDialog;

        BackgroundWorker_Patient_Search(Context ctx) {
            context = ctx;
        }

        @Override
        protected String doInBackground(String... params) {

            String type = params[0];
            String submit_url;
            submit_url = "http://disgenonline.in/CRCAPI/search.php";

            if (type.equals("submit")) {
                try {
                    String phone = params[1];
                    String regUId = params[2];

                    URL url = new URL(submit_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String post_data =URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&"
                            + URLEncoder.encode("regUId", "UTF-8") + "=" + URLEncoder.encode(regUId, "UTF-8");

                    Log.v(TAG, "PostData: " + post_data);

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    //  InputStream inputStream = httpURLConnection.getErrorStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;

                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            Log.v(TAG, "Got Patient DATA");
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Patient Data");
        }

        @Override
        protected void onPostExecute(String result) {
            alertDialog.setMessage(result);
            json_string=result;

            if (result==null){
                Toast.makeText(SearchPatient.this, "No Internet ", Toast.LENGTH_SHORT).show();
            }

            else if (result.contains("No Data Found")) {
                alertDialog.setTitle("No Data Found !!!!");
                alertDialog.show();

                Toast.makeText(SearchPatient.this, "No Data Found Check your details....",Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Result ka kuch nahi pata");
                Log.v(TAG, result);
            }
            else if(result!=null){
                // alertDialog.setTitle("Successful");
                // alertDialog.show();
                //json_string=result;
                Intent intent =new Intent(SearchPatient.this, SearchPatientDisplay.class);
                intent.putExtra("JSON_STRING", json_string);
                startActivity(intent);

                Log.v(TAG, "Got the Data");
                Log.v(TAG, result);
                //finish();
            }

        }
        ///////////////////////////////////
    }

}
