package com.example.android.merifasal.ui.Shop;

public class ModelClass {

    int image;
    String text;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ModelClass(int image, String text) {
        this.image = image;
        this.text = text;
    }
}
