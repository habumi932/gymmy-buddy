package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Category;
import com.amplifyframework.datastore.generated.model.Exercise;
import com.hangbui.gymmybuddy.databinding.ActivityExercisesBinding;

import java.util.Arrays;

public class ExercisesActivity extends AppCompatActivity {

    private ActivityExercisesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExercisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Initialize Amplify API
        try {
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());

            Log.i("GymmyBuddy", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("GymmyBuddy", "Could not initialize Amplify", error);
        }

        // Create new Exercise object
        Exercise newExercise = Exercise.builder()
                .exerciseName("Mountain climber")
                .categoryName("Abdominals")
                .targetMuscles(Arrays.asList(new String[]{"Abs"}))
                .tools(Arrays.asList(new String[]{""}))
                .numSets(8)
                .numReps(3)
                .duration(10)
                .exerciseCategoryId("Abdominals")
                .build();

        //Push object to GraphQL API
        Amplify.API.mutate(ModelMutation.create(newExercise),
                response -> Log.i("Amplify", "Exercise with id: " + response.getData().getId()),
                error -> Log.e("Amplify", "Create failed", error)
        );

        //Print all exercise names to log
        Amplify.API.query(
                ModelQuery.list(Exercise.class, Exercise.EXERCISE_NAME.contains("")),
                response -> {
                    for (Exercise exercise : response.getData()) {
                        if (exercise != null) {
                            Log.i("GymmyBuddy", exercise.getExerciseName());
                        }
                    }
                },
                error -> Log.e("GymmyBuddy", "Query failure", error)
        );

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
}