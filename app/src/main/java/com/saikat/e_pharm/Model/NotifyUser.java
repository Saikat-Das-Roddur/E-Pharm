package com.saikat.e_pharm.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class NotifyUser implements Parcelable {
    Boolean isActive;
    String title;
    String description;
    String _id;
    UserData userData;

    public NotifyUser() {
    }

    public NotifyUser(Boolean isActive, String title, String description, String _id, UserData userData) {
        this.isActive = isActive;
        this.title = title;
        this.description = description;
        this._id = _id;
        this.userData = userData;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    protected NotifyUser(Parcel in) {
        byte isActiveVal = in.readByte();
        isActive = isActiveVal == 0x02 ? null : isActiveVal != 0x00;
        title = in.readString();
        description = in.readString();
        _id = in.readString();
        userData = (UserData) in.readValue(UserData.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (isActive == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isActive ? 0x01 : 0x00));
        }
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(_id);
        dest.writeValue(userData);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<NotifyUser> CREATOR = new Parcelable.Creator<NotifyUser>() {
        @Override
        public NotifyUser createFromParcel(Parcel in) {
            return new NotifyUser(in);
        }

        @Override
        public NotifyUser[] newArray(int size) {
            return new NotifyUser[size];
        }
    };
}