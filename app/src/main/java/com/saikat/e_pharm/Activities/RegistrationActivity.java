package com.saikat.e_pharm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.saikat.e_pharm.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
    public void goToLogIn(View view) {
        startActivity(new Intent(RegistrationActivity.this,LogInActivity.class));
        finish();
    }
}
