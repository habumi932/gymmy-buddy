package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hangbui.gymmybuddy.databinding.ActivityExercisesBinding;

public class ExercisesActivity extends AppCompatActivity {

    private ActivityExercisesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExercisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}