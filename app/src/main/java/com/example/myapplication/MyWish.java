package com.example.myapplication;

public class MyWish {
    private String title;
    private String content;
    private int id;
    private String date;

    public String getTitle(){
        return title;
    }
    public void setTitle(String str){
        title = str;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String str){
        content = str;
    }
    public  int getID(){
        return id;
    }
    public void setID(int i)
    {
        id = i;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String str) {
        date = str;
    }
}
