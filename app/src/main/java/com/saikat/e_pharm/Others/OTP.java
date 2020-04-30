package com.saikat.e_pharm.Others;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTP {

    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    private FirebaseAuth auth;
    private String verificationID;
    private Activity activity;
    private String TAG = getClass().getSimpleName();
    private OTPListener otpListener;

    public OTP(Activity activity) {
        this.activity = activity;
        auth = FirebaseAuth.getInstance();
    }

    public void numberVerification(String number){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60, TimeUnit.SECONDS,activity,new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                Toast.makeText(activity, "Verified", Toast.LENGTH_SHORT).show();
                signInWithPhoneAuthCredential(phoneAuthCredential);
                otpListener.onOTPSendSuccess();
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(activity, "Verification failed", Toast.LENGTH_SHORT).show();
                otpListener.onOTPSendFailure();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationID = s;
                Toast.makeText(activity, "Code sent successful", Toast.LENGTH_SHORT).show();
                otpListener.onOtpReceived(s);
            }
        });

    }
    public void codeConfirmation(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID,code);
        signInWithPhoneAuthCredential(credential);
    }

    public void setOtpListener(OTPListener otpListener) {
        this.otpListener = otpListener;
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            //Toast.makeText(activity, "Success signInWithPhoneAuthCredential", Toast.LENGTH_SHORT).show();
                            otpListener.onPhoneVerificationSuccess();
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                otpListener.onPhoneVerificationFailure();
                            }
                        }
                    }
                });
    }


}
