package com.saikat.e_pharm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.saikat.e_pharm.R;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //  Initialize SharedPreferences
//                SharedPreferences getPrefs = PreferenceManager
//                        .getDefaultSharedPreferences(getBaseContext());
//
//                //  Create a new boolean and preference and set it to true
//                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);
//
//                //  If the activity has never started before...
//                if (isFirstStart) {
//
//                    //  Launch app intro
//                    final Intent i = new Intent(LogInActivity.this, IntroActivity.class);
//                    runOnUiThread(new Runnable() {
//                        @Override public void run() {
//                            startActivity(i);
//                            finish();
//                        }
//                    });
//
//                    //  Make a new preferences editor
//                    SharedPreferences.Editor e = getPrefs.edit();
//
//                    //  Edit preference to make it false because we don't want this to run again
//                    e.putBoolean("firstStart", false);
//
//                    //  Apply changes
//                    e.apply();
//                }
//            }
//        });
//
//        // Start the thread
//        t.start();

    }

    public void goToRegister(View view) {
        startActivity(new Intent(LogInActivity.this,RegistrationActivity.class));
        finish();
    }


    public void goToMain(View view) {
        startActivity(new Intent(LogInActivity.this,MainActivity.class));
        finish();
    }
}
