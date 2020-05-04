package com.example.wguscheduler.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.wguscheduler.SampleData;
import com.example.wguscheduler.database.AppRepository;
import com.example.wguscheduler.model.Term;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public List<Term> mTerms;
    private AppRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepository = AppRepository.getInstance();
        mTerms = mRepository.mTerms;
    }
}
