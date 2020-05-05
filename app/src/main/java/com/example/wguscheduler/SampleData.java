package com.example.wguscheduler;

import com.example.wguscheduler.model.Assessment;
import com.example.wguscheduler.model.Course;
import com.example.wguscheduler.model.Note;
import com.example.wguscheduler.model.Term;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleData {

    private static final String title1 = "Term 1";
    private static final String title2 = "Term 2";
    private static final String title3 = "Term 3";

    private static Date getDate(int diff) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MONTH, diff);
        return cal.getTime();
    }

    public static List<Term> getTerms(){
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(title1, getDate(0),getDate(1)));
        terms.add(new Term(title2, getDate(1),getDate(2)));
        terms.add(new Term(title3, getDate(2),getDate(3)));

        return terms;
    }

    public static List<Course> getCourses(){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("course1", 1, 0, "Dave"));
        courses.add(new Course("course2", 1, 1, "Karen"));
        courses.add(new Course("course3", 2, 0, "Bob"));
        return courses;
    }

    public static List<Note> getNotes(){
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1, "course 1 note goes here"));
        notes.add(new Note(2, "course 2 note goes here!"));
        notes.add(new Note(3, "finally course 3 note will go here"));
        return notes;
    }

    public static List<Assessment> getAssessments() {
        List<Assessment> assessments = new ArrayList<>();
        assessments.add(new Assessment("Assessment1", 1, 1, 1));
        assessments.add(new Assessment("Assessment2", 2, 0, 0));
        assessments.add(new Assessment("Assessment3", 3, 0, 1));
        return assessments;
    }
}
