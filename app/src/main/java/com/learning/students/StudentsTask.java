package com.learning.students;

import android.os.AsyncTask;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentsTask extends AsyncTask<File, Void, List<Student>> {
    private ResultCallback resultCallback;

    interface ResultCallback {
        void onStudentsReady(List<Student> students);
    }

    public StudentsTask(ResultCallback resultCallback) {
        this.resultCallback = resultCallback;
    }

    // UI THREAD
    @Override
    protected void onPostExecute(List<Student> students) {
        resultCallback.onStudentsReady(students);
    }

    // BACKGROUND THREAD
    @Override
    protected List<Student> doInBackground(File... files) {
        File studentsFile = files[0];
        try {
            List<Student> studentsFromFile;
            if (!studentsFile.exists()) {
                studentsFromFile = Student.generate();
                studentsFile.createNewFile();
                Student.saveStudents(studentsFromFile, studentsFile);
            } else {
                studentsFromFile = Student.loadStudents(studentsFile);
            }
            return studentsFromFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
