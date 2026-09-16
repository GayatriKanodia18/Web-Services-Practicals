package com.example.bookapi;

public class Book {

    private int id;
    private String name;
    private String author;
    private String lang;

    public Book() {
    }

    public Book(int id, String name, String author, String lang) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.lang = lang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
