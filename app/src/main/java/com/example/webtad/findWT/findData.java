package com.example.webtad.findWT;

public class findData {
    String thumbnail;
    String title;
    String author;
    String platform;

    public findData(String thumbnail, String title, String author, String platform){
        this.thumbnail = thumbnail;
        this.title = title;
        this.author = author;
        this.platform = platform;
    }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPlatform() { return author; }
    public void setPlatform(String platform) { this.platform = platform; }

}
