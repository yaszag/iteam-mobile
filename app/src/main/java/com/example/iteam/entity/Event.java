package com.example.iteam.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Event {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String title;
    private String description;
    private String date;
    private String organizer;

    public Event(Long id, String title, String description, String date, String organizer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.organizer = organizer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

}
