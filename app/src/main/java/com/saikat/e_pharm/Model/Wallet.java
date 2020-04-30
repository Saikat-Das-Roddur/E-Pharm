package com.saikat.e_pharm.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Wallet implements Parcelable {
    String _id;
    UserData userData;
    double totalExpenses;
    double previousExpenses;
    double currentExpenses;
    double remainCash;
    double promoCode;
    Boolean isActive;

    public Wallet(UserData userData, String _id, double totalExpenses, double previousExpenses, double currentExpenses, double remainCash) {
        this.userData = userData;
        this._id = _id;
        this.totalExpenses = totalExpenses;
        this.previousExpenses = previousExpenses;
        this.currentExpenses = currentExpenses;
        this.remainCash = remainCash;
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
        userData = (UserData) in.readValue(UserData.class.getClassLoader());
        _id = in.readString();
        totalExpenses = in.readDouble();
        previousExpenses = in.readDouble();
        currentExpenses = in.readDouble();
        remainCash = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userData);
        dest.writeString(_id);
        dest.writeDouble(totalExpenses);
        dest.writeDouble(previousExpenses);
        dest.writeDouble(currentExpenses);
        dest.writeDouble(remainCash);
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