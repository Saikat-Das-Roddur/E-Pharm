package com.saikat.e_pharm.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {
    String _id;
    String name;
    String description;
    String image;
    double price;
    double previousPrice;
    double newPrice;
    double discount;
    Boolean isActive;

    public Products(String _id,String name, Boolean isActive, String description, String image, double price, double previousPrice, double newPrice, double discount) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.previousPrice = previousPrice;
        this.newPrice = newPrice;
        this.discount = discount;
        this.isActive = isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(double previousPrice) {
        this.previousPrice = previousPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    protected Products(Parcel in) {
        _id = in.readString();
        name = in.readString();
        description = in.readString();
        image = in.readString();
        price = in.readDouble();
        previousPrice = in.readDouble();
        newPrice = in.readDouble();
        discount = in.readDouble();
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
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(image);
        dest.writeDouble(price);
        dest.writeDouble(previousPrice);
        dest.writeDouble(newPrice);
        dest.writeDouble(discount);
        if (isActive == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isActive ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Products> CREATOR = new Parcelable.Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };
}