package com.example.wguscheduler.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(tableName = "courses")
public class Course {

    @PrimaryKey
    private int id;
    private String title;
    private Date courseStart;
    private Date courseEnd;
    // course status variable (in progress, completed, dropped, planned)
    private int status;
    private String mentorName;
    private String mentorPhone;
    private String mentorEmail;
    // assessments ArrayList
    // course notes ArrayList
    // share notes via email or SMS
    // alerts for start and end date that trigger when app is not running

    @Ignore
    public Course(){

    }

    @Ignore
    public Course(int courseId, String courseTitle, Date courseStart, Date courseEnd, int status, String mentorName, String mentorPhone, String mentorEmail){
        this.id = courseId;
        this.title = courseTitle;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.status = status;
        this.mentorName = mentorName;
        this.mentorEmail = mentorEmail;
        this.mentorPhone = mentorPhone;
    }

    public Course(String courseTitle, int status, String mentorName) {
        this.title = courseTitle;
        this.status = status;
        this.mentorName = mentorName;
    }

    public int getCourseId() {
        return id;
    }

    public void setCourseId(int courseId) {
        this.id = courseId;
    }

    public String getCourseTitle() {
        return title;
    }

    public void setCourseTitle(String courseTitle) {
        this.title = courseTitle;
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
