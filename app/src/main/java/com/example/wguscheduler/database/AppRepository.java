package com.example.wguscheduler.database;

import com.example.wguscheduler.SampleData;
import com.example.wguscheduler.model.Term;

import java.util.List;

public class AppRepository {
    private static final AppRepository ourInstance = new AppRepository();

    public List<Term> mTerms;

    public static AppRepository getInstance(){
        return ourInstance;
    }

    private AppRepository(){
        mTerms = SampleData.getTerms();
    }
}
