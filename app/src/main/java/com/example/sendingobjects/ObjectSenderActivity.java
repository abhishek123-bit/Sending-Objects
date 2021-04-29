package com.example.sendingobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sendingobjects.databinding.ActivityObjectSenderBinding;
import com.example.sendingobjects.models.Student;

public class ObjectSenderActivity extends AppCompatActivity {
    ActivityObjectSenderBinding b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityObjectSenderBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setTitle("ObjectSender Activity");

        sendDataToViewerActivity();
    }

    private void sendDataToViewerActivity() {
        b.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {
                    sendData();
                }
            }
        });
    }

    //Sending data to ObjectViewer Activity
    private void sendData() {

        Student student = new Student(b.studentName.getText().toString().trim(), b.rollNo.getText().toString().trim(), b.phoneNo.getText().toString().trim(), b.gender.getCheckedRadioButtonId());

        Intent intent = new Intent(ObjectSenderActivity.this, ObjectViewerActivity.class);
        intent.putExtra("STUDENT_DATA", student);

        startActivity(intent);

    }

    //Validation
    private boolean checkValidation() {

        //validation of name
        if (b.studentName.getText().toString().trim().isEmpty()) {
            b.studentName.setError("Please enter student name");
            return false;
        }

        int genderId = b.gender.getCheckedRadioButtonId();

        if (genderId != R.id.gender_male && genderId != R.id.gender_female) {
            Toast.makeText(ObjectSenderActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        //validation of roll no
        if (b.rollNo.getText().toString().trim().isEmpty()) {
            b.rollNo.setError("Please enter a rollNo");
            return false;
        }
        if (!b.rollNo.getText().toString().trim().matches("(?!00)\\d{2}(([a-z]{4})|([A-Z]{4}))\\d{3,4}")) {
            b.rollNo.setError("Please enter valid rollNo");
            return false;
        }

        //validation of phone no
        if (b.phoneNo.getText().toString().trim().isEmpty()) {
            b.phoneNo.setError("Please enter a phone number");
            return false;
        }
        if (b.phoneNo.getText().toString().trim().length() != 10) {
            b.phoneNo.setError("Please enter valid number");
            return false;
        }

        return true;
    }
}