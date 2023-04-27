package com.libraryapp;

import com.libraryapp.entities.Book;

public class BookDto {
    private String title;
    private String author;
    private int year;

    public BookDto() {
    }

    public BookDto(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.year = book.getReleaseYear();
    }

    public Book toBook(Book book) {
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setReleaseYear(this.year);
        return book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
