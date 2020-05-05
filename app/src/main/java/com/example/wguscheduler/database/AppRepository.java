package com.example.wguscheduler.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.wguscheduler.SampleData;
import com.example.wguscheduler.model.Assessment;
import com.example.wguscheduler.model.Course;
import com.example.wguscheduler.model.Note;
import com.example.wguscheduler.model.Term;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static AppRepository ourInstance;

    public LiveData<List<Term>> mTerms;
    public LiveData<List<Course>> mCourses;
    public LiveData<List<Assessment>> mAssessments;
    public LiveData<List<Note>> mNotes;

    private AppDatabase mDb;

    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context){
        if (ourInstance == null){
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    private AppRepository(Context context){

        mDb = AppDatabase.getInstance(context);
        mTerms = getTerms();
        mCourses = getCourses();
        mAssessments = getAssessments();
        mNotes = getNotes();
    }

    private LiveData<List<Term>> getTerms() {
        return mDb.termDao().getAll();
    }

    private LiveData<List<Course>> getCourses() {
        return mDb.courseDao().getAll();
    }

    private LiveData<List<Note>> getNotes() {
        return mDb.noteDao().getAll();
    }

    private LiveData<List<Assessment>> getAssessments() {
        return mDb.assessmentDao().getAll();
    }

    public void deleteAllData(){
        executor.execute(() -> mDb.termDao().deleteAll());
        executor.execute(() -> mDb.courseDao().deleteAll());
        executor.execute(() -> mDb.assessmentDao().deleteAll());
        executor.execute(() -> mDb.noteDao().deleteAll());
    }


    public Term getTermById(int termId) {
        return mDb.termDao().getTermById(termId);
    }

    public void insertTerm(final Term term) {
        executor.execute(() -> mDb.termDao().insertTerm(term));
    }

    public void deleteTerm(final Term term) {
        executor.execute(() -> mDb.termDao().deleteTerm(term));
    }

    public Course getCourseById(int courseId) {
        return mDb.courseDao().getCourseById(courseId);
    }

    public LiveData<List<Course>> getCoursesByTerm(final int termId) {
        return mDb.courseDao().getCoursesByTerm(termId);
    }

    public void insertCourse(final Course course) {
        executor.execute(() -> mDb.courseDao().insertCourse(course));
    }

    public void deleteCourse(final Course course) {
        executor.execute(() -> mDb.courseDao().deleteCourse(course));
    }

    public Assessment getAssessmentById(int assessmentId) {
        return mDb.assessmentDao().getAssessmentById(assessmentId);
    }

    public LiveData<List<Assessment>> getAssessmentsByCourse(final int courseId) {
        return mDb.assessmentDao().getAssessmentsByCourse(courseId);
    }

    public void insertAssessment(final Assessment assessment) {
        executor.execute(() -> mDb.assessmentDao().insertAssessment(assessment));
    }

    public void deleteAssessment(final Assessment assessment) {
        executor.execute(() -> mDb.assessmentDao().deleteAssessment(assessment));
    }

    public Note getNoteById(int noteId){
        return mDb.noteDao().getNoteById(noteId);
    }

    public LiveData<List<Note>> getNotesByCourse(final int courseId) {
        return mDb.noteDao().getNotesByCourse(courseId);
    }

    public void insertNote(final Note note){
        executor.execute(() -> mDb.noteDao().insertNote(note));
    }

    public void deleteNote(final Note note){
        executor.execute(() -> mDb.noteDao().deleteNote(note));
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.termDao().insertAll(SampleData.getTerms());
                mDb.courseDao().insertAll(SampleData.getCourses());
                mDb.noteDao().insertAll(SampleData.getNotes());
                mDb.assessmentDao().insertAll(SampleData.getAssessments());
            }
        });
    }
}
