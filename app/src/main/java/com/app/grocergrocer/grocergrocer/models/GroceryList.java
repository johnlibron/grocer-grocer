package com.app.grocergrocer.grocergrocer.models;

public class GroceryList {

    private String listName;
    private String listDescription;
    private int totalProducts;
    private String listImage1;
    private String listImage2;
    private String listImage3;
    private String listImage4;

    public GroceryList() {}

    public GroceryList(String listName, String listDescription, int totalProducts,
                       String listImage1, String listImage2, String listImage3, String listImage4) {
        this.listName = listName;
        this.listDescription = listDescription;
        this.totalProducts = totalProducts;
        this.listImage1 = listImage1;
        this.listImage2 = listImage2;
        this.listImage3 = listImage3;
        this.listImage4 = listImage4;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }

    public String getTotalProducts() {
        if (totalProducts > 1) {
            return totalProducts + " products";
        } else if (totalProducts == 1) {
            return totalProducts + " product";
        } else {
            return "Empty";
        }
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public String getListImage1() {
        return (null != listImage1) ? listImage1 : "";
    }

    public void setListImage1(String listImage1) {
        this.listImage1 = listImage1;
    }

    public String getListImage2() {
        return (null != listImage2) ? listImage2 : "";
    }

    public void setListImage2(String listImage2) {
        this.listImage2 = listImage2;
    }

    public String getListImage3() {
        return (null != listImage3) ? listImage3 : "";
    }

    public void setListImage3(String listImage3) {
        this.listImage3 = listImage3;
    }

    public String getListImage4() {
        return (null != listImage4) ? listImage4 : "";
    }

    public void setListImage4(String listImage4) {
        this.listImage4 = listImage4;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "listName='" + listName + '\'' +
                ", listDescription='" + listDescription + '\'' +
                ", totalProducts=" + totalProducts +
                ", listImage1='" + listImage1 + '\'' +
                ", listImage2='" + listImage2 + '\'' +
                ", listImage3='" + listImage3 + '\'' +
                ", listImage4='" + listImage4 + '\'' +
                '}';
    }
}