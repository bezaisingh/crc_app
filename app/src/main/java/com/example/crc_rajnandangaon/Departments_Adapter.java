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

public class Departments_Adapter extends ArrayAdapter {
    List list= new ArrayList();

    public Departments_Adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    public void add(Departments_Getter_Setter object) {
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
        Departments_Adapter.DepartmentsHolder departmentsHolder;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.dept_row_layout, parent, false);
            departmentsHolder= new DepartmentsHolder();
            departmentsHolder.d_title=row.findViewById(R.id.dTitle);
            row.setTag(departmentsHolder);
        }
        else{
            departmentsHolder=(Departments_Adapter.DepartmentsHolder) row.getTag();
        }
        Departments_Getter_Setter departments_getter_setter = (Departments_Getter_Setter) this.getItem(position);
        departmentsHolder.d_title.setText(departments_getter_setter.getPost_title());

        return row;
    }

    static class DepartmentsHolder{
        TextView d_title;
    }
}
