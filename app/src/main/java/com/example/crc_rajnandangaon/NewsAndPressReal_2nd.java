package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class NewsAndPressReal_2nd extends AppCompatActivity {

    String post_content;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_and_press_real_2nd);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("News and Press Release");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
     //   toolbar.setBackgroundColor(Color.parseColor("#FF4500"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        post_content=getIntent().getExtras().getString("POST_CONTENT");

       // Toast.makeText(this, "Post_Content= "+ post_content, Toast.LENGTH_SHORT).show();

        webView = findViewById(R.id.webviewNews);

        String mimeType = "text/html";
        String encoding = "utf-8";
        // Load html source code into webview to show the html content.
        webView.loadDataWithBaseURL(null, post_content, mimeType, encoding, null);
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
