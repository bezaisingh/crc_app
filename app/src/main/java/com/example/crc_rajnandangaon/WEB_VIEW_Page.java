package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.webkit.WebView;

public class WEB_VIEW_Page extends AppCompatActivity {



    String post_content, titleOfActivity;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        titleOfActivity=getIntent().getExtras().getString("TITLE_OF_ACTIVITY");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(titleOfActivity);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
     //   toolbar.setBackgroundColor(Color.parseColor("#FF4500"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ProgressDialog progress= new ProgressDialog(WEB_VIEW_Page.this);
        progress.setMessage("Please wait...");
        progress.setIndeterminate(false);
        progress.setCancelable(false);
        progress.show();

        final Handler mHandler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                super.handleMessage(msg);
                if (progress.isShowing())
                    progress.dismiss();
            }
        };

        post_content=getIntent().getExtras().getString("POST_CONTENT");

       // Toast.makeText(this, "Post_Content= "+ post_content, Toast.LENGTH_SHORT).show();

        webView = findViewById(R.id.webviewNews);
        String mimeType = "text/html";
        String encoding = "utf-8";
        // Load html source code into webview to show the html content.
        webView.loadDataWithBaseURL(null, post_content, mimeType, encoding, null);
        mHandler.sendMessageDelayed(new Message(), 2000);
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
