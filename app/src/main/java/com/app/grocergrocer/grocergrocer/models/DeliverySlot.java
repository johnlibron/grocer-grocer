package com.app.grocergrocer.grocergrocer.models;

public class DeliverySlot {

    private String slot;

    public DeliverySlot() {}

    public DeliverySlot(String slot) {
        this.slot = slot;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "DeliverySlot{" +
                "slot='" + slot + '\'' +
                '}';
    }
}