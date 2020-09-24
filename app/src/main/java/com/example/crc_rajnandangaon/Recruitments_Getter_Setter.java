package com.example.crc_rajnandangaon;

public class Recruitments_Getter_Setter {
    String post_title, post_date;

    public Recruitments_Getter_Setter(String post_title, String post_date) {
        this.post_title = post_title;
        this.post_date = post_date;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }
}
