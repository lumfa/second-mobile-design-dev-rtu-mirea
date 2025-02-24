package com.example.second_practice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class InfoActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView ageLabel = findViewById(R.id.ageLabel);
        TextView groupLabel = findViewById(R.id.groupLabel);
        TextView fioLabel = findViewById(R.id.fioLabel);
        TextView gradeLabel = findViewById(R.id.gradeLabel);


        Bundle arguments = getIntent().getExtras();
        Student student;

        if (arguments != null) {
            student = (Student) arguments.getSerializable(Student.class.getSimpleName());
            ageLabel.setText("Age: " + student.getAge());
            groupLabel.setText("Group: " + student.getgroupId());
            fioLabel.setText("Name: " + student.getName());
            gradeLabel.setText("Grade: " + student.getGrade());
        }
    }
}