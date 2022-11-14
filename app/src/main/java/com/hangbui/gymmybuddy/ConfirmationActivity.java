package com.hangbui.gymmybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.hangbui.gymmybuddy.databinding.ActivityConfirmationBinding;

public class ConfirmationActivity extends AppCompatActivity {

    private ActivityConfirmationBinding binding;

    //Listeners
    private View.OnClickListener button_confirm_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = getIntent();
            Amplify.Auth.confirmSignUp(
                    intent.getStringExtra(SignupActivity.EXTRA_USERNAME),
                    binding.edittextConfirmationNumber.getText().toString(),
                    result -> {
                        Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete");
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Sign up succeeded. Returning to login page.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        Intent theIntent = new Intent(ConfirmationActivity.this, LoginActivity.class);
                        startActivity(theIntent);
                    },
                    error -> {
                        Log.e("AuthQuickstart", error.toString());
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Invalid confirmation code", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
            );
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonConfirm.setOnClickListener(button_confirm_onClickListener);
    }
}