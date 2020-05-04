package com.example.wguscheduler.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "assessments")
public class Assessment {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;
    @ColumnInfo
    private int status;
    @ColumnInfo
    private int type;
    @ColumnInfo
    private Date dueDate;

    @Ignore
    public Assessment(){

    }

    public Assessment(int id, String name, int status, int type, Date dueDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.type = type;
        this.dueDate = dueDate;
    }

    @Ignore
    public Assessment(String name, int status, int type) {
        this.name = name;
        this.status = status;
        this.type = type;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
