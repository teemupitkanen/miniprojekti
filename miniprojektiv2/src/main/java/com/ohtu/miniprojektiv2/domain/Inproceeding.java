package com.ohtu.miniprojektiv2.domain;

import java.util.Random;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Inproceeding {

    /**
     * Mandatory fields
     */
    private int id;
    @NotBlank
    private String author;
    @NotBlank
    private String title;
    @NotBlank
    private String booktitle;
    @Range(min = 0, max = 9999)
    private String year;

    // editor, volume/number, series, pages, address, month, organization, publisher, note, key
    /**
     * Optional fields
     */
    private String editor;
    private String volumeNumber;
    private String series;
    private String pages;
    private String address;
    private String month;
    private String organization;
    private String publisher;
    private String note;
    private String key;

    public Inproceeding() {
        Random r = new Random();
        this.id = r.nextInt(Integer.MAX_VALUE);
    }

    public Inproceeding(String author, String title, String booktitle, String year, String editor, String volumeNumber, String series, String pages, String address, String month, String organization, String publisher, String note, String key) {
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
        this.editor = editor;
        this.volumeNumber = volumeNumber;
        this.series = series;
        this.pages = pages;
        this.address = address;
        this.month = month;
        this.organization = organization;
        this.publisher = publisher;
        this.note = note;
        this.key = key;
    }

    public int getId() {
        return id;
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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getVolumeNumber() {
        return volumeNumber;
    }

    public void setVolumeNumber(String volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inproceeding other = (Inproceeding) obj;
        if ((this.author == null) ? (other.author != null) : !this.author.equals(other.author)) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if ((this.booktitle == null) ? (other.booktitle != null) : !this.booktitle.equals(other.booktitle)) {
            return false;
        }
        if ((this.year == null) ? (other.year != null) : !this.year.equals(other.year)) {
            return false;
        }
        if ((this.editor == null) ? (other.editor != null) : !this.editor.equals(other.editor)) {
            return false;
        }
        if ((this.volumeNumber == null) ? (other.volumeNumber != null) : !this.volumeNumber.equals(other.volumeNumber)) {
            return false;
        }
        if ((this.series == null) ? (other.series != null) : !this.series.equals(other.series)) {
            return false;
        }
        if ((this.pages == null) ? (other.pages != null) : !this.pages.equals(other.pages)) {
            return false;
        }
        if ((this.address == null) ? (other.address != null) : !this.address.equals(other.address)) {
            return false;
        }
        if ((this.month == null) ? (other.month != null) : !this.month.equals(other.month)) {
            return false;
        }
        if ((this.organization == null) ? (other.organization != null) : !this.organization.equals(other.organization)) {
            return false;
        }
        if ((this.publisher == null) ? (other.publisher != null) : !this.publisher.equals(other.publisher)) {
            return false;
        }
        if ((this.note == null) ? (other.note != null) : !this.note.equals(other.note)) {
            return false;
        }
        if ((this.key == null) ? (other.key != null) : !this.key.equals(other.key)) {
            return false;
        }
        return true;
    }

}
