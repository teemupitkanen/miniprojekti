package com.ohtu.miniprojektiv2.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Inproceeding {

    @NotBlank
    private String author;
    @NotBlank
    private String title;
    @NotBlank
    private String booktitle;
    @Range(min=0, max=9999)
    private String year;

    public Inproceeding() {
    }

    public Inproceeding(String author, String title, String booktitle, String year) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        
        if (object.getClass() != getClass()) {
            return false;
        }
        Inproceeding ip = (Inproceeding) object;
        return this.author.equals(ip.getAuthor())
                && this.booktitle.equals(ip.getBooktitle())
                && this.title.equals(ip.getBooktitle())
                && this.year.equals(ip.getYear());
    }
}
