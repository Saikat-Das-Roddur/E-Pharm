package com.saikat.e_pharm.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.saikat.e_pharm.Model.UserData;

public class Wallet implements Parcelable {
    String _id;
    UserData userData;
    double totalExpenses;
    double previousExpenses;
    double currentExpenses;
    double remainCash;
    double promoCode;
    Boolean isActive;

    public Wallet() {
    }

    public Wallet(UserData userData, String _id, double totalExpenses, double previousExpenses, double currentExpenses, double remainCash, double promoCode, Boolean isActive) {
        this.userData = userData;
        this._id = _id;
        this.totalExpenses = totalExpenses;
        this.previousExpenses = previousExpenses;
        this.currentExpenses = currentExpenses;
        this.remainCash = remainCash;
        this.promoCode = promoCode;
        this.isActive = isActive;
    }

    public double getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(double promoCode) {
        this.promoCode = promoCode;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getPreviousExpenses() {
        return previousExpenses;
    }

    public void setPreviousExpenses(double previousExpenses) {
        this.previousExpenses = previousExpenses;
    }

    public double getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(double currentExpenses) {
        this.currentExpenses = currentExpenses;
    }

    public double getRemainCash() {
        return remainCash;
    }

    public void setRemainCash(double remainCash) {
        this.remainCash = remainCash;
    }


    protected Wallet(Parcel in) {
        _id = in.readString();
        userData = (UserData) in.readValue(UserData.class.getClassLoader());
        totalExpenses = in.readDouble();
        previousExpenses = in.readDouble();
        currentExpenses = in.readDouble();
        remainCash = in.readDouble();
        promoCode = in.readDouble();
        byte isActiveVal = in.readByte();
        isActive = isActiveVal == 0x02 ? null : isActiveVal != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeValue(userData);
        dest.writeDouble(totalExpenses);
        dest.writeDouble(previousExpenses);
        dest.writeDouble(currentExpenses);
        dest.writeDouble(remainCash);
        dest.writeDouble(promoCode);
        if (isActive == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isActive ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Wallet> CREATOR = new Parcelable.Creator<Wallet>() {
        @Override
        public Wallet createFromParcel(Parcel in) {
            return new Wallet(in);
        }

        @Override
        public Wallet[] newArray(int size) {
            return new Wallet[size];
        }
    };
}