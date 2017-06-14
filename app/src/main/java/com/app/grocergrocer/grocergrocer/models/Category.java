package com.app.grocergrocer.grocergrocer.models;

public class Category {

    private String categoryImage;
    private String categoryName;

    public Category(String categoryImage, String categoryName) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
