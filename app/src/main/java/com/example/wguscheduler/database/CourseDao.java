package com.example.wguscheduler.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wguscheduler.model.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCourse(Course course);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Course> courses);

    @Delete
    void deleteCourse(Course course);

    @Query("SELECT * FROM courses WHERE id - :id")
    Course getCourseById(int id);

    @Query("SELECT * FROM courses ORDER BY courseStart DESC")
    LiveData<List<Course>> getAll();

    @Query("SELECT * FROM courses WHERE termId = :termId")
    LiveData<List<Course>> getCoursesByTerm(final int termId);

    @Query("DELETE FROM courses")
    int deleteAll();

    @Query("SELECT COUNT(*) FROM courses")
    int getCount();
}
