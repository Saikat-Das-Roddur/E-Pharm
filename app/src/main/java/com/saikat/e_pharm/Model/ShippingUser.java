package com.saikat.e_pharm.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShippingUser implements Parcelable {
    UserData userData;
    String name;
    String contactNo;
    String address;
    String _id;
    Boolean isActive;

    public ShippingUser() {
    }

    public ShippingUser(UserData userData, String _id, String name, String contactNo, String address) {
        this.userData = userData;
        this._id = _id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    protected ShippingUser(Parcel in) {
        userData = (UserData) in.readValue(UserData.class.getClassLoader());
        name = in.readString();
        contactNo = in.readString();
        address = in.readString();
        _id = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userData);
        dest.writeString(name);
        dest.writeString(contactNo);
        dest.writeString(address);
        dest.writeString(_id);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ShippingUser> CREATOR = new Parcelable.Creator<ShippingUser>() {
        @Override
        public ShippingUser createFromParcel(Parcel in) {
            return new ShippingUser(in);
        }

        @Override
        public ShippingUser[] newArray(int size) {
            return new ShippingUser[size];
        }
    };
}