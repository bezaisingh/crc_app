package com.example.crc_rajnandangaon;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

public class TendersAndNotice extends AppCompatActivity {

    String json_string="NULL";
    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    String TAG= "Bijay Self check";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenders_and_notice);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Tenders And Notice");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
      //  toolbar.setBackgroundColor(Color.parseColor("#00574B"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create an Instance of Background Worker
        BackgroundTask_Tender backgroundTask_tender;
        backgroundTask_tender = new BackgroundTask_Tender(this);
        backgroundTask_tender.execute();

        listView= findViewById(R.id.tenderListview);
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
    private void displayTenderData() {
        Tender_Adapter tender_adapter= new Tender_Adapter(this, R.layout.row_layout);
        listView.setAdapter(tender_adapter);

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray= jsonObject.getJSONArray("kitten");

            int count=0;
            String post_title, post_excerpt, post_date;
            while (count<jsonArray.length()){

                JSONObject JO= jsonArray.getJSONObject(count);
                post_title=JO.getString("post_title");
                post_date=JO.getString("DATE(post_date)");
                Tender_Getter_Setter tender_getter_setter =new Tender_Getter_Setter(post_title, post_date);
                tender_adapter.add(tender_getter_setter);
                count++;

                Log.v(TAG,post_title + " "+ post_date);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /////////////////Background Tasks Coding////////////////
    public class BackgroundTask_Tender extends AsyncTask<Void, Void, String> {

        Context context;
        AlertDialog alertDialog;
        BackgroundTask_Tender(Context ctx){
            context=ctx;
        }

        String json_url;

        @Override
        protected void onPreExecute() {

            // json_url="https://crcapp.000webhostapp.com/crc/tender.php";
            json_url="http://disgenonline.in/CRCAPI/tender.php";

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
                displayTenderData();

            }

            //////////////////Parse Json//////////////////////
            json_string=result;
            //////////////////////////////////////////////////
        }
    }
    //////////////////////////////////////////////////////////
    }


