package com.example.wguscheduler.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(tableName = "courses")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private Date courseStart;
    @ColumnInfo
    private Date courseEnd;
    // course status variable (in progress, completed, dropped, planned)
    @ColumnInfo
    private int status;
    @ColumnInfo
    private String mentorName;
    @ColumnInfo
    private String mentorPhone;
    @ColumnInfo
    private String mentorEmail;
    // assessments ArrayList
    // course notes ArrayList
    // share notes via email or SMS
    // alerts for start and end date that trigger when app is not running

    @Ignore
    public Course(){

    }

    public Course(int id, String title, Date courseStart, Date courseEnd, int status, String mentorName, String mentorPhone, String mentorEmail){
        this.id = id;
        this.title = title;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.status = status;
        this.mentorName = mentorName;
        this.mentorEmail = mentorEmail;
        this.mentorPhone = mentorPhone;
    }

    @Ignore
    public Course(String courseTitle, int status, String mentorName) {
        this.title = courseTitle;
        this.status = status;
        this.mentorName = mentorName;
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

    public Date getCourseStart() {
        return courseStart;
    }

    public void setCourseStart(Date courseStart) {
        this.courseStart = courseStart;
    }

    public Date getCourseEnd() {
        return courseEnd;
    }

    public void setCourseEnd(Date courseEnd) {
        this.courseEnd = courseEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorPhone() {
        return mentorPhone;
    }

    public void setMentorPhone(String mentorPhone) {
        this.mentorPhone = mentorPhone;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    @Override
    public String toString() {
        return title + " " + status + " " + mentorName;
    }
}
