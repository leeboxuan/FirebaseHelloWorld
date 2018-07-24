package com.weebly.leeboxuan.firebasehelloworld;

import java.io.Serializable;

public class Message implements Serializable {

    private String date;
    private String title;
    private boolean completed;
    private int num;

    public Message(String date, String title, boolean completed, int num) {
        this.date = date;
        this.title = title;
        this.completed = completed;
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Message() {
        // Default constructor required for calls to DataSnapshot.getValue(Message.class)

    }



    @Override
    public String toString() {
        return "Message{" +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
