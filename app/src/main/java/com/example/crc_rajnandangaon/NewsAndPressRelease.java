package com.example.crc_rajnandangaon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
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

public class NewsAndPressRelease extends AppCompatActivity {
    String json_string="NULL";
    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    String TAG= "Bijay Self check";
    String post_title, post_date, post_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_and_press_release);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("News and Press Release");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
      //  toolbar.setBackgroundColor(Color.parseColor("#FF4500"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create an Instance of Background Worker
        NewsAndPressRelease.BackgroundWorker_newsAndPress backgroundworker_newsAndPress;
        backgroundworker_newsAndPress = new NewsAndPressRelease.BackgroundWorker_newsAndPress(this);
        backgroundworker_newsAndPress.execute();

        listView= findViewById(R.id.newsListView);
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

    private void displayNewsAndPressData() {
        final NewsAndPress_Adapter newsAndPress_adapter= new NewsAndPress_Adapter(this, R.layout.news_row_layout);
        listView.setAdapter(newsAndPress_adapter);

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray= jsonObject.getJSONArray("kitten");

            int count=0;

            while (count<jsonArray.length()){

                JSONObject JO= jsonArray.getJSONObject(count);
                post_title=JO.getString("post_title");
                post_date=JO.getString("DATE(post_date)");
                post_content= JO.getString("post_content");
                NewsAndPress_Getter_Setter newsAndPress_getter_setter =new NewsAndPress_Getter_Setter(post_title, post_date, post_content);
                newsAndPress_adapter.add(newsAndPress_getter_setter);
                count++;

                Log.v(TAG,post_title + " "+ post_content);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((TextView) view.findViewById(R.id.nContent)).getText().toString();
               //  Toast.makeText(NewsAndPressRelease.this, "Position= "+ position+ " Value= " + selected, Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(NewsAndPressRelease.this, NewsAndPressReal_2nd.class);
                intent.putExtra("POST_CONTENT", selected);
                startActivity(intent);
            }
        });
    }

    /////////////////Background Tasks Coding////////////////
    public class BackgroundWorker_newsAndPress extends AsyncTask<Void, Void, String> {

        Context context;
        AlertDialog alertDialog;
        BackgroundWorker_newsAndPress(Context ctx){
            context=ctx;
        }

        String json_url;

        @Override
        protected void onPreExecute() {

            json_url="http://disgenonline.in/CRCAPI/news_content.php";

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
                displayNewsAndPressData();
            }
            //////////////////Parse Json//////////////////////
            json_string=result;
            //////////////////////////////////////////////////
        }
    }
}