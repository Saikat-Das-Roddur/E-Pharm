package com.saikat.e_pharm.Model;

public class SliderImages {
    String _id;
    String imageTitle;
    String imageDescription;
    Boolean isActive;

    public SliderImages(String _id, String imageTitle, String imageDescription, Boolean isActive) {
        this._id = _id;
        this.imageTitle = imageTitle;
        this.imageDescription = imageDescription;
        this.isActive = isActive;
    }
}
