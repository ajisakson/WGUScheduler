package com.example.wguscheduler;

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

}
