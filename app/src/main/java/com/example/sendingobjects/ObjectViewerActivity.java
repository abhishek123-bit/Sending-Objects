package com.example.sendingobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sendingobjects.databinding.ActivityObjectViewerBinding;
import com.example.sendingobjects.models.Student;

public class ObjectViewerActivity extends AppCompatActivity {

    ActivityObjectViewerBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityObjectViewerBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setTitle("ObjectViewer Activity");

        receiveData();
    }

    private void receiveData() {
        Student student = (Student) getIntent().getSerializableExtra("STUDENT_DATA");

        b.studentName.setText(student.getName());

        b.phoneNo.setText(student.getPhoneNo());

        b.rollNo.setText(student.getRollNo());

        if(R.id.gender_male==student.getGender()){
            b.genderId.setText("Male");
        }

        else {
            b.genderId.setText("Female");
        }
    }
}