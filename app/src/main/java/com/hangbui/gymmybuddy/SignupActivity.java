package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.hangbui.gymmybuddy.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    public static final int FROM_SIGNUP_ACTIVITY = 1;
    public static final String EXTRA_USERNAME = "com.hangbui.gymmybuddy.EXTRA_USERNAME";

    //Listeners
    private View.OnClickListener button_signup_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = binding.editTextTextEmailAddress.getText().toString();
            String username = binding.edittextUsernameSignup.getText().toString();
            String password = binding.edittextPasswordSingup.getText().toString();

            AuthSignUpOptions options = AuthSignUpOptions.builder()
                    .userAttribute(AuthUserAttributeKey.email(), email)
                    .build();
            Amplify.Auth.signUp(username, password, options,
                    result -> {
                        Log.i("AuthQuickStart", "Result: " + result.toString());
                        Intent theIntent = new Intent(SignupActivity.this, ConfirmationActivity.class);
                        theIntent.putExtra(EXTRA_USERNAME, username);
                        startActivity(theIntent);
                    },
                    error -> {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Sign up failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
            );
        }
    };

    private View.OnClickListener text_login_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSignup.setOnClickListener(button_signup_onClickListener);
        binding.textBackLogin.setOnClickListener(text_login_onClickListener);

    }
}