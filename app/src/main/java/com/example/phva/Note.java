package com.example.phva;

public class Note {
    private int id;
    private String title;
    private String description;
    private String date;
    private String url;
    private String status;
    private String tp_doc;
    private String rol;

    public Note() {

    }

    public Note(int id, String title, String description, String date, String url, String status, String tp_doc, String rol) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.url = url;
        this.status = status;
        this.tp_doc = tp_doc;
        this.rol = rol;
    }


    public Note(String title, String description, String date, String url, String status, String tp_doc, String rol) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.url = url;
        this.status = status;
        this.tp_doc = tp_doc;
        this.rol = rol;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String geturl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getstp_doc() {
        return tp_doc;
    }

    public void settp_doc(String tp_doc) {
        this.tp_doc = tp_doc;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
