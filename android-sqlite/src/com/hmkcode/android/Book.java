package com.hmkcode.android;

public class Book {
 
    private int id;
    private String title;
    private String author;
 
    public Book(){}
 
    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }
 
    //getters & setters
 
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author
                + "]";
    }
}