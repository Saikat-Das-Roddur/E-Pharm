package com.saikat.e_pharm.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Slider implements Parcelable {
    String _id;
    String imageTitle;
    String imageDescription;
    Boolean isActive;

    public Slider(String _id, String imageTitle, String imageDescription, Boolean isActive) {
        this._id = _id;
        this.imageTitle = imageTitle;
        this.imageDescription = imageDescription;
        this.isActive = isActive;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    protected Slider(Parcel in) {
        _id = in.readString();
        imageTitle = in.readString();
        imageDescription = in.readString();
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
        dest.writeString(imageTitle);
        dest.writeString(imageDescription);
        if (isActive == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isActive ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Slider> CREATOR = new Parcelable.Creator<Slider>() {
        @Override
        public Slider createFromParcel(Parcel in) {
            return new Slider(in);
        }

        @Override
        public Slider[] newArray(int size) {
            return new Slider[size];
        }
    };
}