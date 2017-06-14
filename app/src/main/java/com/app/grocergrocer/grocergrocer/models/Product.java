package com.app.grocergrocer.grocergrocer.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class Product implements Parcelable {

    private String productImage;
    private String productName;
    private String productMeasurement;
    private String productPrice;
    private String productOriginalPrice;
    private String productLessPrice;

    public Product(String productImage, String productName,
                   String productMeasurement, String productPrice,
                   String productOriginalPrice, String productLessPrice) {

        this.productImage = productImage;
        this.productName = productName;
        this.productMeasurement = productMeasurement;
        this.productPrice = productPrice;
        this.productOriginalPrice = productOriginalPrice;
        this.productLessPrice = productLessPrice;
    }

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

    public String getProductMeasurement() {
        return productMeasurement;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public String getProductLessPrice() {
        return productLessPrice;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productImage);
        dest.writeString(productName);
        dest.writeString(productMeasurement);
        dest.writeString(productPrice);
        dest.writeString(productOriginalPrice);
        dest.writeString(productLessPrice);
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