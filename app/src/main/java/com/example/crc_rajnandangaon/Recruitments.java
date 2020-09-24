package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
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

public class Recruitments extends AppCompatActivity {
    String json_string="NULL";
    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    String TAG= "Bijay Self check", titleOfActivity="Recruitments";
    String post_title, post_date, post_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitments);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(titleOfActivity);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
       // toolbar.setBackgroundColor(Color.parseColor("#FF4500"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create an Instance of Background Worker
        Recruitments.BackgroundWorker_Recruitments backgroundWorker_recruitments;
        backgroundWorker_recruitments = new   Recruitments.BackgroundWorker_Recruitments(this);
        backgroundWorker_recruitments.execute();

        listView= findViewById(R.id.recrutmentListView);
        // jsonstring=getIntent().getExtras().getString("JsonData");
        Log.v(TAG, "Json String mein garbar hai");
        //Log.v(TAG, jsonstring);
    }

    //*********** To go back to the previous page using the back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        this.finish();
        return super.onOptionsItemSelected(item);
    }
//*************

    public void displayRecruitmentsData() {

        final Recruitments_Adapter recruitments_adapter= new Recruitments_Adapter(this, R.layout.news_row_layout);
        listView.setAdapter(recruitments_adapter);

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray= jsonObject.getJSONArray("kitten");

            int count=0;

            while (count<jsonArray.length()){

                JSONObject JO= jsonArray.getJSONObject(count);
                post_title=JO.getString("post_title");
                post_date=JO.getString("DATE(post_date)");
                Recruitments_Getter_Setter recruitments_getter_setter =new Recruitments_Getter_Setter(post_title, post_date);
                recruitments_adapter.add(recruitments_getter_setter);
                count++;

                Log.v(TAG,post_title + " "+ post_content);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Recruitments.this, "Loading...", Toast.LENGTH_SHORT).show();
                String selected = ((TextView) view.findViewById(R.id.rTitle)).getText().toString();
                titleOfActivity=selected;
                Intent intent =new Intent(Recruitments.this, WEB_VIEW_Page.class);
                intent.putExtra("POST_CONTENT", selected);
                intent.putExtra("TITLE_OF_ACTIVITY",titleOfActivity );

                startActivity(intent);
            }
        });
    }


    /////////////////Background Tasks Coding////////////////
    public class BackgroundWorker_Recruitments extends AsyncTask<Void, Void, String> {
        ProgressDialog progressDialog = new ProgressDialog(Recruitments.this);

        Context context;
        AlertDialog alertDialog;
        BackgroundWorker_Recruitments(Context ctx){
            context=ctx;
        }

        String json_url;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();

            json_url="http://disgenonline.in/CRCAPI/recruitment.php";

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

            if (result==null){
                Toast.makeText(context, "NO Data Found.... Check your Internet", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }else
            {
                displayRecruitmentsData();
                progressDialog.dismiss();
            }
            //////////////////Parse Json//////////////////////
            json_string=result;
            //////////////////////////////////////////////////
        }
    }


}
