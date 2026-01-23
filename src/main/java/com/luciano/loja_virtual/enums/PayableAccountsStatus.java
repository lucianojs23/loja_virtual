package com.luciano.loja_virtual.enums;

public enum PayableAccountsStatus {
    BILLING("To Pay"), // para pagar
    OVERDUE("Overdue"), // vencida
    OPEN("Open"), // em abetro
    PAID("Paid"), // paga
    NEGOTIATED("Negotiated");

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    private PayableAccountsStatus(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AccountsReceivableStatus{" +
                "description='" + this.description + '\'' +
                '}';
    }
}