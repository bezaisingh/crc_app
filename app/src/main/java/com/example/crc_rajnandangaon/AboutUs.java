package com.example.crc_rajnandangaon;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class AboutUs extends AppCompatActivity {


TextView textView1, textView2, textView3;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("About Us");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView1= findViewById(R.id.tvAboutUsBody1);
        textView2= findViewById(R.id.tvAboutUsBody2);
        textView3= findViewById(R.id.tvAboutUsBody3);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textView1.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
            textView2.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
            textView3.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }




/*
        webView= findViewById(R.id.webviewAbout_us);
        //String post_content= getString(R.string.about_us);



        String post_content = String.valueOf(Html
                .fromHtml("<![CDATA[<body style=\"text-align:justify;color:#222222; \">"
                        + getResources().getString(R.string.about_us)
                        + "</body>]]>"));

        String mimeType = "text/html";
        String encoding = "utf-8";
        // Load html source code into webview to show the html content.
        webView.loadDataWithBaseURL(null, post_content, mimeType, encoding, null);

*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
