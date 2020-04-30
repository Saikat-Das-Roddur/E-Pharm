package com.saikat.e_pharm.Others;

public interface OTPListener {
    void onOTPSendSuccess();
    void onOTPSendFailure();

    void onOtpReceived(String otp);
    void onOtpTimeout();

    void onPhoneVerificationSuccess();
    void onPhoneVerificationFailure();
}
