package com.example.crc_rajnandangaon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Patient_Reg_Adapter extends ArrayAdapter {
    List list = new ArrayList();

    public Patient_Reg_Adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public void add(Patient_Reg_Getter_Setter object) {
        super.add(object);
        list.add(object);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row=convertView;
        Patient_Reg_Adapter.PatientRegHolder patientRegHolder;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.patient_row_layout, parent, false);
            patientRegHolder= new Patient_Reg_Adapter.PatientRegHolder();
            patientRegHolder.p_name=row.findViewById(R.id.tvpatientName);
            patientRegHolder.p_FatherName=row.findViewById(R.id.tvP_FatherName);
            patientRegHolder.p_Address=row.findViewById(R.id.tvP_Address);
            patientRegHolder.p_age=row.findViewById(R.id.tvP_Age);
            patientRegHolder.p_Complaints=row.findViewById(R.id.tvP_Complaints);
            patientRegHolder.p_contactNo=row.findViewById(R.id.tvP_contactNo);
            patientRegHolder.p_gender=row.findViewById(R.id.tvP_Gender);
            patientRegHolder.p_occupation=row.findViewById(R.id.tvP_occupation);
            patientRegHolder.p_ReferredBy=row.findViewById(R.id.tvP_RefferedBy);
            patientRegHolder.p_ReferredTo=row.findViewById(R.id.tvP_RefferedTo);
            patientRegHolder.p_regNo=row.findViewById(R.id.tvP_regNo);

            row.setTag(patientRegHolder);
        }
        else{
            patientRegHolder=(Patient_Reg_Adapter.PatientRegHolder) row.getTag();
        }
        Patient_Reg_Getter_Setter patient_reg_getter_setter = (Patient_Reg_Getter_Setter) this.getItem(position);

        patientRegHolder.p_name.setText("Patient Name: "+ patient_reg_getter_setter.getPatient_name());
        patientRegHolder.p_FatherName.setText("Father's Name: "+ patient_reg_getter_setter.getFather_name());
        patientRegHolder.p_Address.setText("Address: "+ patient_reg_getter_setter.getAddress());
        patientRegHolder.p_age.setText("Age: "+ patient_reg_getter_setter.getAge());
        patientRegHolder.p_Complaints.setText("Complaint: "+ patient_reg_getter_setter.getChief_complaints());
        patientRegHolder.p_contactNo.setText("Contact Number: "+ patient_reg_getter_setter.getContact_no());
        patientRegHolder.p_gender.setText("Gender: "+ patient_reg_getter_setter.getGender());
        patientRegHolder.p_occupation.setText("Occupation: "+ patient_reg_getter_setter.getOccupation());
        patientRegHolder.p_ReferredBy.setText("Referred by: "+ patient_reg_getter_setter.getReferred_by());
        patientRegHolder.p_ReferredTo.setText("Referred to: "+ patient_reg_getter_setter.getReferred_to());
        patientRegHolder.p_regNo.setText("Registration No.: "+ patient_reg_getter_setter.getReg_no());



        return row;
    }

    static class PatientRegHolder{
        TextView p_name,
                 p_FatherName,
                 p_regNo,
                 p_Address,
                 p_contactNo,
                 p_ReferredBy,
                 p_ReferredTo,
                 p_Complaints,
                 p_gender,
                 p_age,
                 p_occupation;
    }
}
