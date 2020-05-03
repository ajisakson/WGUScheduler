package com.example.wguscheduler.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity(tableName = "terms")
public class Term {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private Date startDate;
    private Date endDate;
    // ArrayList of courses within the term

    @Ignore
    public Term(){

    }

    @Ignore
    public Term(int id, String title, Date startDate, Date endDate){
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Term(String title, Date startDate, Date endDate){
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return title + " " + startDate;
    }


}
