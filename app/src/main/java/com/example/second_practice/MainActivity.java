package com.example.second_practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button_prog = findViewById(R.id.button_prog);
        button_prog.setOnClickListener(v -> {
            sendInfoToNextActivity();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void onNextActivity(View view) {
        sendInfoToNextActivity();
    }

    private void sendInfoToNextActivity() {
        EditText fioText = findViewById(R.id.fio);
        EditText ageText = findViewById(R.id.age);
        EditText groupIdText = findViewById(R.id.group_id);
        EditText gradeText = findViewById(R.id.grade);

        if (!validateInput(fioText, groupIdText, ageText, gradeText)) {
            return;
        }

        String fio = fioText.getText().toString();
        Integer age = Integer.parseInt(ageText.getText().toString());
        String groupId = groupIdText.getText().toString();
        Integer grade = Integer.parseInt(gradeText.getText().toString());

        Student student = new Student(fio, groupId, age, grade);

        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(Student.class.getSimpleName(), student);

        startActivity(intent);
    }

    private boolean validateInput(EditText... fields) {
        for (EditText field : fields) {
            if (field.getText().toString().trim().isEmpty()) {
                field.setError("This field must be filled in.");
                return false;
            }
        }
        return true;
    }
}