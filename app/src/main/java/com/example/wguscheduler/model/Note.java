package com.example.wguscheduler.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private int courseId;
    @ColumnInfo
    private String contents;

    @Ignore
    public Note(){

    }

    public Note(int id, int courseId, String contents){
        this.id = id;
        this.courseId = courseId;
        this.contents = contents;
    }

    @Ignore
    public Note(int courseId, String contents){
        this.courseId = courseId;
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
