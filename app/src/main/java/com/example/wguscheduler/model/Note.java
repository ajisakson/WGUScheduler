package com.example.wguscheduler.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey
    private int id;
    private String contents;

    @Ignore
    public Note(){

    }

    @Ignore
    public Note(int id, String contents){
        this.id = id;
        this.contents = contents;
    }

    public Note(String contents){
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", text='" + contents + '\'' +
                '}';
    }
}
