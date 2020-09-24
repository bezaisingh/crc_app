package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RelatedWebSites extends AppCompatActivity {

    TextView btnNationalInst,
            btnRehabCouncil,
            btnDoEPD,
            btnSocialJust,
            btnChiefCommision,
            btnNationalTrust,
            btnNHFDC,
            btnALIMCO;

    String titleOfActivity="Related Websites";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_web_sites);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(titleOfActivity);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
      //  toolbar.setBackgroundColor(Color.parseColor("#FF4500"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnNationalInst= findViewById(R.id.tvNationalInst);
        btnRehabCouncil= findViewById(R.id.tvRehabCouncil);
        btnDoEPD= findViewById(R.id.tvDoEPD);
        btnSocialJust= findViewById(R.id.tvSocialJust);
        btnChiefCommision= findViewById(R.id.tvChiefCommision);
        btnNationalTrust= findViewById(R.id.tvNationalTrust);
        btnNHFDC= findViewById(R.id.tvNHFDC);
        btnALIMCO= findViewById(R.id.tvALIMCO);

        btnNationalInst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected="<p>List of National Institutes in India</p>\n" +
                        "<!-- /wp:paragraph -->\n" +
                        "\n" +
                        "<!-- wp:list {\"ordered\":true} -->\n" +
                        "<ol><li><a href=\"http://www.iphnewdelhi.in/\" target=\"_blank\" rel=\"noreferrer noopener\" aria-label=\"Pt. Deendayal Upadhyaya National Institute for Persons with Disabilities (PDUNIPPD), New Delhi   (opens in a new tab)\">Pt. Deendayal Upadhyaya National Institute for Persons with Disabilities (PDUNIPPD), New Delhi  </a>    </li><li><a rel=\"noreferrer noopener\" aria-label=\"Ali Yavar Jung National Institute of Speech And hearing Disabilities, AYJNISHD, Mumbai (opens in a new tab)\" href=\"http://www.ayjnihh.nic.in/\" target=\"_blank\">Ali Yavar Jung National Institute of Speech And hearing Disabilities, AYJNISHD, Mumbai</a>      </li><li><a rel=\"noreferrer noopener\" aria-label=\"Swami Vivekananda National Institute of Rehabilitation training &amp; Research, SVNIRTAR, Cuttack (opens in a new tab)\" href=\"http://svnirtar.nic.in\" target=\"_blank\">Swami Vivekananda National Institute of Rehabilitation training &amp; Research, SVNIRTAR, Cuttack</a>      </li><li><a rel=\"noreferrer noopener\" aria-label=\"National Institute For Empowerment of Persons with Multiple Disabilities (NIEPMD), Chennai (opens in a new tab)\" href=\"http://niepmd.tn.nic.in\" target=\"_blank\">National Institute For Empowerment of Persons with Multiple Disabilities (NIEPMD), Chennai</a>       </li><li><a rel=\"noreferrer noopener\" aria-label=\"National Institute For the Empowerment Of Persons With Multiple Disabilities (NIEPID), Secunderabad (opens in a new tab)\" href=\"http://niepid.nic.in/\" target=\"_blank\">National Institute For the Empowerment Of Persons With Multiple Disabilities (NIEPID), Secunderabad</a>       </li><li><a rel=\"noreferrer noopener\" aria-label=\"National Institute for the Empowerment of Persons with Visual Dasabilities, (NIEPVD), Dehradun (opens in a new tab)\" href=\"http://nivh.gov.in/\" target=\"_blank\">National Institute for the Empowerment of Persons with Visual Dasabilities, (NIEPVD), Dehradun</a>      </li><li><a rel=\"noreferrer noopener\" aria-label=\"National Nistitute For Locomotor Disabilities, Kolkata (opens in a new tab)\" href=\"http://niohkol.nic.in/\" target=\"_blank\">National Nistitute For Locomotor Disabilities, Kolkata</a>     </li></ol>\n" +
                        "<!-- /wp:list -->";
                titleOfActivity="List of National Institutes";
                Intent intent =new Intent(RelatedWebSites.this, WEB_VIEW_Page.class);
                intent.putExtra("POST_CONTENT", selected);
                intent.putExtra("TITLE_OF_ACTIVITY",titleOfActivity );

                startActivity(intent);
            }
        });

        btnRehabCouncil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://www.rehabcouncil.nic.in/"));
                startActivity(openURL);
            }

        });

        btnDoEPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://disabilityaffairs.gov.in/content/"));
                startActivity(openURL);
            }

        });


        btnSocialJust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://socialjustice.nic.in/"));
                startActivity(openURL);
            }

        });


        btnChiefCommision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://ccdisabilities.nic.in/"));
                startActivity(openURL);
            }

        });


        btnNationalTrust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://www.thenationaltrust.gov.in/content/"));
                startActivity(openURL);
            }

        });

        btnNHFDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://www.nhfdc.nic.in/"));
                startActivity(openURL);
            }

        });

        btnALIMCO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://www.alimco.in/"));
                startActivity(openURL);
            }

        });


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
