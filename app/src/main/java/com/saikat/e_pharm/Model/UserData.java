package com.saikat.e_pharm.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserData implements Parcelable {
    String _id;
    String name;
    String email;
    String image;
    String contactNo;
    String password;
    String status;
    Boolean isChecked;

    public UserData() {
    }

    public UserData(String _id, String name, String email, String image, String contactNo, String password, Boolean isChecked) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.contactNo = contactNo;
        this.password = password;
        this.isChecked = isChecked;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }


    protected UserData(Parcel in) {
        _id = in.readString();
        name = in.readString();
        email = in.readString();
        image = in.readString();
        contactNo = in.readString();
        password = in.readString();
        byte isCheckedVal = in.readByte();
        isChecked = isCheckedVal == 0x02 ? null : isCheckedVal != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(image);
        dest.writeString(contactNo);
        dest.writeString(password);
        if (isChecked == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isChecked ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UserData> CREATOR = new Parcelable.Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };
}