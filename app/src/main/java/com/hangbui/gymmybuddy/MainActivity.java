package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amplifyframework.datastore.generated.model.Exercise;
import com.hangbui.gymmybuddy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonExercises.setOnClickListener(button_exercises_clickListener);

    }

    private View.OnClickListener button_exercises_clickListener = new View.OnClickListener() {

        public void onClick(View v) {
            Intent theIntent = new Intent(MainActivity.this, ExercisesActivity.class);
            startActivity(theIntent);
        }

    };

}