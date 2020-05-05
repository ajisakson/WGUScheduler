package com.example.wguscheduler.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wguscheduler.database.AppRepository;
import com.example.wguscheduler.model.Term;

import java.util.List;

public class TermViewModel extends AndroidViewModel {
    public LiveData<List<Term>> mTerms;
    private AppRepository mRepository;

    public TermViewModel(@NonNull Application application){
        super(application);

        mRepository = AppRepository.getInstance(application.getApplicationContext());
        mTerms = mRepository.mTerms;
    }
}
