package com.app.grocergrocer.grocergrocer.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String productImage;
    private String productName;
    private String productMeasurement;
    private String productPrice;
    private String productOriginalPrice;
    private String productLessPrice;
    private int productQuantity;

    public Product() {}

    public Product(String productImage, String productName, String productMeasurement,
                   String productPrice, String productOriginalPrice, String productLessPrice) {

        this.productImage = productImage;
        this.productName = productName;
        this.productMeasurement = productMeasurement;
        this.productPrice = productPrice;
        this.productOriginalPrice = productOriginalPrice;
        this.productLessPrice = productLessPrice;
        this.productQuantity = 1;
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

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getProductTotalPrice() {
        return String.format("%.2f", Double.parseDouble(productPrice) * productQuantity);
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductMeasurement(String productMeasurement) {
        this.productMeasurement = productMeasurement;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductOriginalPrice(String productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public void setProductLessPrice(String productLessPrice) {
        this.productLessPrice = productLessPrice;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
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