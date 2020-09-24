package com.example.crc_rajnandangaon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NewsAndPress_Adapter extends ArrayAdapter {
    List list= new ArrayList();

    // Constructor Auto Created when pressed Alt+Enter on above ArrayAdapter
    public NewsAndPress_Adapter(@NonNull Context context, int resource) {
        super(context, resource);
        }
    public void add(NewsAndPress_Getter_Setter object) {
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
        NewsAndPress_Adapter.NewsAndPressHolder newsAndPressHolder;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.news_row_layout, parent, false);
            newsAndPressHolder= new NewsAndPress_Adapter.NewsAndPressHolder();
            newsAndPressHolder.n_Date=row.findViewById(R.id.nDate);
            newsAndPressHolder.n_Name=row.findViewById(R.id.nTitle);
            newsAndPressHolder.n_Content=row.findViewById(R.id.nContent);

            row.setTag(newsAndPressHolder);
        }
        else{
            newsAndPressHolder=( NewsAndPress_Adapter.NewsAndPressHolder) row.getTag();
        }
        NewsAndPress_Getter_Setter newsAndPress_getter_setter = (NewsAndPress_Getter_Setter) this.getItem(position);
        newsAndPressHolder.n_Date.setText(newsAndPress_getter_setter.getPost_date());
        newsAndPressHolder.n_Name.setText(newsAndPress_getter_setter.getPost_title());
        newsAndPressHolder.n_Content.setText(newsAndPress_getter_setter.getPost_content());

        return row;
    }

    //Static Class
    static class NewsAndPressHolder{
        TextView n_Name, n_Date, n_Content;
    }
}
