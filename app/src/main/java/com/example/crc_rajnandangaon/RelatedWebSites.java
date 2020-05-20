package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

public class RelatedWebSites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_web_sites);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Related Websites");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
      //  toolbar.setBackgroundColor(Color.parseColor("#FF4500"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //*********** To go back to the previous page using the back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        this.finish();
        return super.onOptionsItemSelected(item);
    }
//*************
}
