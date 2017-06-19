package com.app.grocergrocer.grocergrocer.models;

public class Category {

    private String categoryImage;
    private String categoryName;

    public Category() {}

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

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryImage='" + categoryImage + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}