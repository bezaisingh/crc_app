package com.example.crc_rajnandangaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Patient_Registration extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private EditText name, fatName, Age, ContactNo, aadhar, regFeeAmt, chiefcomp,
              incomeAmt,  village, Block, District, State, Pin, medicConsult;

    Spinner spinGender, spinCaste, spinOccupation, spinincome_Type,
            spinperMonth, spinRegFeeType, spinref_By, spinref_To;

    String Gender, Caste, Occupation, income_Type,perMonth,RegFeeType, ref_By, ref_To;


    String TAG = "Bijay Self check";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__registration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Patient Registration");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.etName);
        fatName = findViewById(R.id.etFatherName);
        Age = findViewById(R.id.etAge);
        spinGender = findViewById(R.id.spinGender);
        spinCaste = findViewById(R.id.spinCaste);
        ContactNo = findViewById(R.id.etContactNo);
        aadhar = findViewById(R.id.etAadhar);
        spinOccupation = findViewById(R.id.spinOccupation);
        spinincome_Type = findViewById(R.id.spinIncomeType);
        incomeAmt = findViewById(R.id.etIncomeAmt);
        spinperMonth = findViewById(R.id.spinPerMonth);
        village = findViewById(R.id.etVillage);
        Block = findViewById(R.id.etBlock);
        District = findViewById(R.id.etDistrict);
        State = findViewById(R.id.etState);
        Pin = findViewById(R.id.etPin);
        spinRegFeeType = findViewById(R.id.spinRegFeeType);
        regFeeAmt = findViewById(R.id.etRegFeeAmt);
        chiefcomp = findViewById(R.id.etChiefComp);
        medicConsult = findViewById(R.id.etMedicCons);
        spinref_By = findViewById(R.id.spinRefBy);
        spinref_To = findViewById(R.id.spinRefTo);

        /////////// Spinner ////////////
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_gender = ArrayAdapter.createFromResource(this,R.array.genderArray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_caste = ArrayAdapter.createFromResource(this, R.array.casteArray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_Occupation = ArrayAdapter.createFromResource(this, R.array.occupationArray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_Income_Type = ArrayAdapter.createFromResource(this, R.array.incomeArray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_PerMonth = ArrayAdapter.createFromResource(this, R.array.perMonthArray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_RegFeeType = ArrayAdapter.createFromResource(this, R.array.regFeeTypeArray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_RefBy = ArrayAdapter.createFromResource(this, R.array.refByArray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_RefTo = ArrayAdapter.createFromResource(this, R.array.refToArray, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_caste.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_Occupation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_Income_Type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_PerMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_RegFeeType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_RefBy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_RefTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinGender.setAdapter(adapter_gender);
        spinCaste.setAdapter(adapter_caste);
        spinOccupation.setAdapter(adapter_Occupation);
        spinincome_Type.setAdapter(adapter_Income_Type);
        spinperMonth.setAdapter(adapter_PerMonth);
        spinRegFeeType.setAdapter(adapter_RegFeeType);
        spinref_By.setAdapter(adapter_RefBy);
        spinref_To.setAdapter(adapter_RefTo);

        spinGender.setOnItemSelectedListener(this);
        spinCaste.setOnItemSelectedListener(this);
        spinOccupation.setOnItemSelectedListener(this);
        spinincome_Type.setOnItemSelectedListener(this);
        spinperMonth.setOnItemSelectedListener(this);
        spinRegFeeType.setOnItemSelectedListener(this);
        spinref_By.setOnItemSelectedListener(this);
        spinref_To.setOnItemSelectedListener(this);
        //////////////////////*******///////////////////
    }


    //*********** To go back to the previous page using the back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        this.finish();
        return super.onOptionsItemSelected(item);
    }
//*************

    public void OnSubmit(View view) {

        String pName = name.getText().toString();
        String fName = fatName.getText().toString();
        String age = Age.getText().toString();
        String gender = Gender;
        String caste = Caste;
        String phone = ContactNo.getText().toString();
        String adhar = aadhar.getText().toString();
        String occupation = Occupation;
        String incomeType = income_Type;
        String income = incomeAmt.getText().toString();
        String incomePer = perMonth;
        String vill = village.getText().toString();
        String block = Block.getText().toString();
        String dist = District.getText().toString();
        String state = State.getText().toString();
        String pin = Pin.getText().toString();
        String regFeeType = RegFeeType;
        String regAmt = regFeeAmt.getText().toString();
        String chiefCompl = chiefcomp.getText().toString();
        String medConsult = medicConsult.getText().toString();
        String refBy = ref_By;
        String refTo = ref_To;
        String type = "submit";

        if(pName.isEmpty() ||
                fName.isEmpty() ||
                age.isEmpty() ||
                phone.isEmpty() ||
                adhar.isEmpty() ||
                vill.isEmpty() ||
                block.isEmpty() ||
                dist.isEmpty()||
                state.isEmpty()||
                pin.isEmpty()||
              //  regAmt.isEmpty()||
                chiefCompl.isEmpty()||
                gender.equals("Select")||
                occupation.equals("Select")||
                caste.equals("Select")||
                incomeType.equals("Select")||
              //  regFeeType.equals("Select")||
                refBy.equals("Select")||
                refTo.equals("Select")
            )
        {
            Toast.makeText(this, "Enter all the Mandatory fields marked with * ", Toast.LENGTH_SHORT).show();
        }else{
            BackgroundWorker_Patient_reg backgroundWorker_patient_reg = new BackgroundWorker_Patient_reg(this);

            backgroundWorker_patient_reg.execute(type, pName, fName, age, gender, caste, phone, adhar, occupation,
                    incomeType, income, incomePer, vill, block, dist, state, pin, regFeeType, regAmt, chiefCompl, medConsult,
                    refBy, refTo);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()){
            case R.id.spinGender :
                Gender = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinCaste :
                Caste = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinOccupation :
                Occupation = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinIncomeType :
                income_Type = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinPerMonth :
                perMonth = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinRegFeeType :
                RegFeeType = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinRefBy :
                ref_By = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinRefTo :
                ref_To = parent.getItemAtPosition(position).toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    //////////////////////////////////

    public class BackgroundWorker_Patient_reg extends AsyncTask<String, String, String> {

        Context context;
        AlertDialog alertDialog;

        BackgroundWorker_Patient_reg(Context ctx) {
            context = ctx;
        }

        @Override
        protected String doInBackground(String... params) {

            String type = params[0];
            String submit_url;
            submit_url = "http://disgenonline.in/CRCAPI/submit.php";

            if (type.equals("submit")) {
                try {
                    String pName = params[1];
                    String fName = params[2];
                    String age = params[3];
                    String gender = params[4];
                    String caste = params[5];
                    String phone = params[6];
                    String adhar = params[7];
                    String occupation = params[8];
                    String incomeType = params[9];
                    String income = params[10];
                    String incomePer = params[11];
                    String vill = params[12];
                    String block = params[13];
                    String dist = params[14];
                    String state = params[15];
                    String pin = params[16];
                    String regFeeType = params[17];
                    String regAmt = params[18];
                    String chiefCompl = params[19];
                    String medConsult = params[20];
                    String refBy = params[21];
                    String refTo = params[22];

                    URL url = new URL(submit_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String post_data = URLEncoder.encode("pName", "UTF-8") + "=" + URLEncoder.encode(pName, "UTF-8") + "&"
                            + URLEncoder.encode("fName", "UTF-8") + "=" + URLEncoder.encode(fName, "UTF-8") + "&"
                            + URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(age, "UTF-8") + "&"
                            + URLEncoder.encode("gender", "UTF-8") + "=" + URLEncoder.encode(gender, "UTF-8") + "&"
                            + URLEncoder.encode("caste", "UTF-8") + "=" + URLEncoder.encode(caste, "UTF-8") + "&"
                            + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&"
                            + URLEncoder.encode("adhar", "UTF-8") + "=" + URLEncoder.encode(adhar, "UTF-8") + "&"
                            + URLEncoder.encode("occupation", "UTF-8") + "=" + URLEncoder.encode(occupation, "UTF-8") + "&"
                            + URLEncoder.encode("incomeType", "UTF-8") + "=" + URLEncoder.encode(incomeType, "UTF-8") + "&"
                            + URLEncoder.encode("income", "UTF-8") + "=" + URLEncoder.encode(income, "UTF-8") + "&"
                            + URLEncoder.encode("incomePer", "UTF-8") + "=" + URLEncoder.encode(incomePer, "UTF-8") + "&"
                            + URLEncoder.encode("vill", "UTF-8") + "=" + URLEncoder.encode(vill, "UTF-8") + "&"
                            + URLEncoder.encode("block", "UTF-8") + "=" + URLEncoder.encode(block, "UTF-8") + "&"
                            + URLEncoder.encode("dist", "UTF-8") + "=" + URLEncoder.encode(dist, "UTF-8") + "&"
                            + URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode(state, "UTF-8") + "&"
                            + URLEncoder.encode("pin", "UTF-8") + "=" + URLEncoder.encode(pin, "UTF-8") + "&"
                            + URLEncoder.encode("regFeeType", "UTF-8") + "=" + URLEncoder.encode(regFeeType, "UTF-8") + "&"
                            + URLEncoder.encode("regAmt", "UTF-8") + "=" + URLEncoder.encode(regAmt, "UTF-8") + "&"
                            + URLEncoder.encode("chiefCompl", "UTF-8") + "=" + URLEncoder.encode(chiefCompl, "UTF-8") + "&"
                            + URLEncoder.encode("medConsult", "UTF-8") + "=" + URLEncoder.encode(medConsult, "UTF-8") + "&"
                            + URLEncoder.encode("refBy", "UTF-8") + "=" + URLEncoder.encode(refBy, "UTF-8") + "&"
                            + URLEncoder.encode("refTo", "UTF-8") + "=" + URLEncoder.encode(refTo, "UTF-8");

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
            Log.v(TAG, "Submit Status");
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Submit Status");
        }

        @Override
        protected void onPostExecute(String result) {
            alertDialog.setMessage(result);

            if (result==null){
                Toast.makeText(Patient_Registration.this, "No Internet ", Toast.LENGTH_SHORT).show();
            }

            else if(result.contains("Note")){
                alertDialog.setTitle("Registration Successful");
                alertDialog.show();
                resetText();

                // homeIntentMethod();
                Toast.makeText(Patient_Registration.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Registration Successful");
                Log.v(TAG, result);
               //finish();
            }
            else if (result.contains("Error")) {
                alertDialog.setTitle("Registration Failed!!!!");
                alertDialog.show();

                Toast.makeText(Patient_Registration.this, "Garbar hai baba....",Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Result ka kuch nahi pata");
                Log.v(TAG, result);
            }

        }
        ///////////////////////////////////
    }
    private void resetText(){

        name.setText("");
        fatName.setText("");
        Age.setText("");
        ContactNo.setText("");
        aadhar.setText("");
        regFeeAmt.setText("");
        chiefcomp.setText("");
        incomeAmt.setText("");
        village.setText("");
        Block.setText("");
        District.setText("");
        State.setText("");
        Pin.setText("");
        medicConsult.setText("");
    }
}
