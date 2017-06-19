package com.app.grocergrocer.grocergrocer.models;

public class DeliveryAddress {

    private String name;
    private String completeAddress;
    private String province;
    private String city;
    private String barangay;
    private String mobileNo;
    private String addressSpecificInstructions;

    public DeliveryAddress() {}

    public DeliveryAddress(String name, String completeAddress, String province, String city,
                           String barangay, String mobileNo, String addressSpecificInstructions) {
        this.name = name;
        this.completeAddress = completeAddress;
        this.province = province;
        this.city = city;
        this.barangay = barangay;
        this.mobileNo = mobileNo;
        this.addressSpecificInstructions = addressSpecificInstructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddressSpecificInstructions() {
        return addressSpecificInstructions;
    }

    public void setAddressSpecificInstructions(String addressSpecificInstructions) {
        this.addressSpecificInstructions = addressSpecificInstructions;
    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "name='" + name + '\'' +
                ", completeAddress='" + completeAddress + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", barangay='" + barangay + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", addressSpecificInstructions='" + addressSpecificInstructions + '\'' +
                '}';
    }
}