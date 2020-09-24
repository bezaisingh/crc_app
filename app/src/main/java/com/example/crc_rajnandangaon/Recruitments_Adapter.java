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

public class Recruitments_Adapter extends ArrayAdapter {
    List list= new ArrayList();

    public Recruitments_Adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    public void add(Recruitments_Getter_Setter object) {
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
        Recruitments_Adapter.RecruitmentsHolder recruitmentsHolder;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.recruitments_row_layout, parent, false);
            recruitmentsHolder= new  Recruitments_Adapter.RecruitmentsHolder();
            recruitmentsHolder.r_Date=row.findViewById(R.id.rDate);
            recruitmentsHolder.r_Name=row.findViewById(R.id.rTitle);

            row.setTag(recruitmentsHolder);
        }
        else{
            recruitmentsHolder=( Recruitments_Adapter.RecruitmentsHolder) row.getTag();
        }
        Recruitments_Getter_Setter recruitments_getter_setter = (Recruitments_Getter_Setter) this.getItem(position);
        recruitmentsHolder.r_Date.setText(recruitments_getter_setter.getPost_date());
        recruitmentsHolder.r_Name.setText(recruitments_getter_setter.getPost_title());

        return row;
    }


    //Static Class
    static class RecruitmentsHolder{
        TextView r_Name, r_Date, r_Content;
    }
}
