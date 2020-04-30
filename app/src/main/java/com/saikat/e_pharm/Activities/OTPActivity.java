package com.saikat.e_pharm.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.saikat.e_pharm.Others.OTP;
import com.saikat.e_pharm.Others.OTPListener;
import com.saikat.e_pharm.R;

public class OTPActivity extends AppCompatActivity {

    EditText editTextOtp,editTextContact;
    Button btnVerify,btnGetOTP;
    private static final int CREDENTIAL_PICKER_REQUEST = 1;
    OTP otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        editTextOtp = findViewById(R.id.otpET);
        editTextContact = findViewById(R.id.contactEt);
        btnGetOTP = findViewById(R.id.btngetOtp);
        btnVerify = findViewById(R.id.btnVerify);
        otp = new OTP(this);

        otp.setOtpListener(new OTPListener() {
            @Override
            public void onOTPSendSuccess() {
                Toast.makeText(OTPActivity.this, "Otp send success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOTPSendFailure() {
                Toast.makeText(OTPActivity.this, "OTP send failure", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOtpReceived(String otp) {
                Toast.makeText(OTPActivity.this, "Otp Received " + otp, Toast.LENGTH_LONG).show();
                editTextOtp.setText(otp);
            }

            @Override
            public void onOtpTimeout() {
                Toast.makeText(OTPActivity.this, "Time out, please resend", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPhoneVerificationSuccess() {
                Toast.makeText(OTPActivity.this, "Phone verification success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPhoneVerificationFailure() {
                Toast.makeText(OTPActivity.this, "Phone verification failed", Toast.LENGTH_SHORT).show();

            }
        });
        try {
            getHintPhoneNumber();
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp.numberVerification(editTextContact.getText().toString());
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp.codeConfirmation(editTextOtp.getText().toString());
            }
        });



    }

//    public void numberVerification(View view) {
//        startActivity(new Intent(OTPActivity.this,MainActivity.class));
//    }

    public void getHintPhoneNumber() throws IntentSender.SendIntentException {
        HintRequest hintRequest = new HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build();
        PendingIntent intent = Credentials.getClient(this).getHintPickerIntent(hintRequest);
        startIntentSenderForResult(intent.getIntentSender(),
                CREDENTIAL_PICKER_REQUEST, null, 0, 0, 0);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                    Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                    // credential.getId();  <-- will need to process phone number string
        editTextContact.setText(credential.getId());

    }

}
