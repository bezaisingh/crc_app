package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchPatientDisplay extends AppCompatActivity {
    String JSON_STRING, json_string = "NULL";
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    String TAG = "Bijay Self check Patient Registration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach_patient_display);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Patient Registration");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        json_string=getIntent().getExtras().getString("JSON_STRING");

        listView = findViewById(R.id.patientListView);


        Patient_List_Adapter patient_list_adapter = new Patient_List_Adapter(this, R.layout.patient_row_layout);
        listView.setAdapter(patient_list_adapter);

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("kitten");

            int count = 0;
            String reg_no, patient_name, father_name,
                    age, gender, contact_no, adhar_no,
                    occupation, address, referred_by,
                    referred_to, chief_complaints;
            while (count < jsonArray.length()) {

                JSONObject JO = jsonArray.getJSONObject(count);
                reg_no = JO.getString("reg_id");
                patient_name = JO.getString("name");
                father_name = JO.getString("f_name");
                age = JO.getString("age");
                gender = JO.getString("gender");
                contact_no = JO.getString("mobile");
                occupation = JO.getString("occupation");
                address = JO.getString("district");
                referred_by = JO.getString("ref_by");
                referred_to = JO.getString("ref_to");
                chief_complaints = JO.getString("chief_complaint");

                Patient_List_Getter_Setter patient_list_getter_setter = new Patient_List_Getter_Setter(reg_no, patient_name,
                        father_name, age, gender, contact_no, occupation, address, referred_by, referred_to, chief_complaints);
                patient_list_adapter.add(patient_list_getter_setter);
                count++;

                Log.v(TAG, patient_name + " " + father_name + " " + gender);
            }
        } catch (
                JSONException e) {
            e.printStackTrace();
        }

    }
    //*********** To go back to the previous page using the back arrow
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        onBackPressed();
        this.finish();
        return super.onOptionsItemSelected(item);
    }
//*************
}
