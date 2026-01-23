package com.luciano.loja_virtual.enums;

public enum AddressType {

    BILLING("Billing"),
    SHIPPING("Shipping");

    private final String description;

    AddressType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "description='" + description + '\'' +
                '}';
    }
}
