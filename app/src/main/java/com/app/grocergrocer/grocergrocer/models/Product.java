package com.app.grocergrocer.grocergrocer.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String productImage;
    private String productName;

    public Product(String productImage, String productName) {
        this.productImage = productImage;
        this.productName = productName;
    }

    protected Product(Parcel in) {
        productImage = in.readString();
        productName = in.readString();
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productImage);
        dest.writeString(productName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}