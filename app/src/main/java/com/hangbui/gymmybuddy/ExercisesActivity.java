package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.query.Where;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Category;
import com.amplifyframework.datastore.generated.model.Exercise;
import com.amplifyframework.datastore.generated.model.Muscle;
import com.hangbui.gymmybuddy.databinding.ActivityExercisesBinding;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExercisesActivity extends AppCompatActivity {

    private ActivityExercisesBinding binding;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    private View.OnClickListener button_search_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateListview();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExercisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSearch.setOnClickListener(button_search_onClickListener);

        updateListview();

    }

    private void updateListview() {
        exercises = new ArrayList<>();
        String searchKey = binding.edittextFindExercise.getText().toString().toLowerCase();
        Amplify.API.query(
                ModelQuery.list(Exercise.class, Exercise.EXERCISE_NAME.contains(searchKey)),
                response -> {
                    for(Exercise exercise : response.getData()) {
                        if (exercise != null && !exercise.getCategory().isEmpty()) {
                            exercises.add(exercise);
                            Log.i("Exercises", exercise.getExerciseName());
                        }
                    }
                    CustomAdapter adapter = new CustomAdapter(this, exercises);
                    runOnUiThread(new Runnable() {
                        public void run() {
                            binding.listviewExercises.setAdapter(adapter);
                        }
                    });
                    Log.d("Try", String.valueOf(exercises.size()));
                },
                error -> Log.e("GymmyBuddy", "Query failure", error)
        );
    }

    private void createNewExercise(String exerciseName, List<String> categoryName, List<String> targetMuscles, List<String> tools,
                                   int numSets, int numReps, int duration, String exercistCategoryId) {

        /* Create new Exercise object
        Exercise newExercise = Exercise.builder()
                .exerciseName(exerciseName)
                .categoryName(categoryName)
                .targetMuscles(targetMuscles)
                .tools(tools)
                .numSets(numSets)
                .numReps(numReps)
                .duration(duration)
                .build();
        */

        /*Push object to GraphQL API
        Amplify.API.mutate(ModelMutation.create(newExercise),
                response -> Log.i("Amplify", "Exercise with id: " + response.getData().getId()),
                error -> Log.e("Amplify", "Create failed", error)
        );
         */
    }

    /**
    private void getExercise(String exerciseName) {
        Amplify.API.query(
                ModelQuery.get(Exercise.class, exerciseName),
                response -> Log.i("HB", ((Exercise) response.getData()).getExerciseName()),
                error -> Log.e("HB", error.toString(), error)
        );
    }
     **/



    private void downloadFile(String key) {
        Amplify.Storage.downloadFile(key,
                new File(getApplicationContext().getFilesDir() + "/download.txt"),
                result -> Log.i("MyAmplifyApp", "Successfully downloaded: " + key),
                error -> Log.e("MyAmplifyApp", "Download failed", error)
        );
    }
}