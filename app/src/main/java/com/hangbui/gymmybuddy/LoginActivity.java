package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthSignInOptions;
import com.amplifyframework.auth.cognito.options.AuthFlowType;
import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.hangbui.gymmybuddy.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    //Listeners
    private View.OnClickListener text_signup_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener button_login_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //AWSCognitoAuthSignInOptions options = AWSCognitoAuthSignInOptions.builder().authFlowType(AuthFlowType.USER_PASSWORD_AUTH).build();
            Amplify.Auth.signIn(
                    binding.edittextUsername.getText().toString(),
                    binding.edittextPassword.getText().toString(),
                    //options,
                    result -> {
                        if(result.isSignInComplete()) {
                            Intent theIntent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(theIntent);
                        }
                        else{
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        Log.i("AuthQuickstart", result.isSignInComplete() ? "Sign in succeeded" : "Sign in not complete");
                    },
                    error -> {
                        Log.e("AuthQuickstart", error.toString());
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
            );
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textSignup.setOnClickListener(text_signup_onClickListener);
        binding.buttonLogin.setOnClickListener(button_login_onClickListener);

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