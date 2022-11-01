package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Exercise;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.hangbui.gymmybuddy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Initialize Amplify API
        try {
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSS3StoragePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());

            Log.i("GymmyBuddy", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("GymmyBuddy", "Could not initialize Amplify", error);
        }

        binding.buttonExercises.setOnClickListener(button_exercises_clickListener);

    }

    private View.OnClickListener button_exercises_clickListener = new View.OnClickListener() {

        public void onClick(View v) {
            Intent theIntent = new Intent(MainActivity.this, ExercisesActivity.class);
            startActivity(theIntent);
        }

    };

}