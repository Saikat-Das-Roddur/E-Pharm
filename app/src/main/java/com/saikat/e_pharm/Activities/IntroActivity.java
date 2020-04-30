package com.saikat.e_pharm.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;
import com.google.android.material.internal.TextDrawableHelper;
import com.saikat.e_pharm.R;

public class IntroActivity extends AppIntro {

    String color = "#5f27cd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSkipText("Skip");
        addSlide(AppIntroFragment.newInstance(getString(R.string.slide1_title),getString(R.string.slide1_Description),R.drawable.ic_currency_bdt_white_48dp,Color.parseColor(color)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.slide2_title),getString(R.string.slide2_Description),R.drawable.ic_bike_white_48dp,Color.parseColor(color)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.slide3_title),getString(R.string.slide3_Description),R.drawable.ic_map_marker_white_48dp,Color.parseColor(color)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.slide4_title),getString(R.string.slide4_Description),R.drawable.ic_dumbbell_white_48dp,Color.parseColor(color)));
    }



    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(IntroActivity.this,LogInActivity.class));
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(IntroActivity.this,LogInActivity.class));
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

}
