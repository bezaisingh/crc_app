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

public class Tender_Adapter extends ArrayAdapter {
    List list= new ArrayList();

    // Constructor Auto Created when pressed Alt+Enter on above ArrayAdapter
    public Tender_Adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public void add(Tender_Getter_Setter object) {
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
        TenderHolder tenderholder;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout, parent, false);
            tenderholder= new TenderHolder();
            tenderholder.t_title=row.findViewById(R.id.tTitle);
            tenderholder.t_closeDate=row.findViewById(R.id.tClosingDate);
            row.setTag(tenderholder);
        }
        else{
            tenderholder=(TenderHolder) row.getTag();
        }
        Tender_Getter_Setter contacts_getter_setter = (Tender_Getter_Setter) this.getItem(position);
        tenderholder.t_title.setText(contacts_getter_setter.getPost_title());
        tenderholder.t_closeDate.setText(contacts_getter_setter.getPost_date());

        return row;
    }
    static class TenderHolder{
        TextView t_name, t_title, t_closeDate;
    }
}
