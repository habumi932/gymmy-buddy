package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.hangbui.gymmybuddy.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        Amplify.Auth.fetchAuthSession(
                result -> Log.i("AmplifyQuickstart", result.toString()),
                error -> Log.e("AmplifyQuickstart", error.toString())
        );
    }
}