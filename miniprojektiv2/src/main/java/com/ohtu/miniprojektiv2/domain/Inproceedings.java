package com.ohtu.miniprojektiv2.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

public class Inproceedings {

    @NotBlank
    private String author;
    @NotBlank
    private String title;
    @NotBlank
    private String booktitle;
    @NotBlank
    @Min(0)
    @Max(9999)
    private int year;

    public Inproceedings(String author, String title, String booktitle, int year) {
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}