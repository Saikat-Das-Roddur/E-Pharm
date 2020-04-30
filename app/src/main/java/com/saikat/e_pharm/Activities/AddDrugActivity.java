package com.saikat.e_pharm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.saikat.e_pharm.R;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

public class AddDrugActivity extends AppCompatActivity implements IPickResult {

    ImageView imageViewPrescription;
    RelativeLayout relativeLayoutImage,relativeLayoutType,relativeLayoutChooseImage;
    LinearLayout linearLayoutAddDrug;
    ImageButton imageButtonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drug);
        imageViewPrescription = findViewById(R.id.prescriptionIv);
        relativeLayoutImage = findViewById(R.id.prescImgLayout);
        relativeLayoutType = findViewById(R.id.typeLayout);
        relativeLayoutChooseImage = findViewById(R.id.chooseImageLayout);
        linearLayoutAddDrug = findViewById(R.id.addDrugLayout);
        imageViewPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickImageDialog.build(new PickSetup()).show((AddDrugActivity.this).getSupportFragmentManager());
            }
        });
    }

    public void uploadPrescription(View view) {
    }

    @Override
    public void onPickResult(PickResult r) {

    }

    public void goToMain(View view) {
       startActivity(new Intent(AddDrugActivity.this,MainActivity.class));
       finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AddDrugActivity.this,MainActivity.class));
        finish();
    }

    public void addMedicineByType(View view) {
        relativeLayoutType.setVisibility(View.GONE);
        relativeLayoutImage.setVisibility(View.GONE);
        relativeLayoutChooseImage.setVisibility(View.GONE);
        linearLayoutAddDrug.setVisibility(View.VISIBLE);
    }

    public void addMedicineFromGallery(View view) {
        relativeLayoutType.setVisibility(View.GONE);
        relativeLayoutImage.setVisibility(View.GONE);
        relativeLayoutChooseImage.setVisibility(View.VISIBLE);
        linearLayoutAddDrug.setVisibility(View.GONE);
    }

    public void onAddField(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.add_drug_field_layout,null);
        linearLayoutAddDrug.addView(rowView,linearLayoutAddDrug.getChildCount()-1);
    }

    public void onDeleteField(View view) {
        linearLayoutAddDrug.removeView((View) view.getParent());
    }


}
