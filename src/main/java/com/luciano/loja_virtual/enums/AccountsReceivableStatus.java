package com.luciano.loja_virtual.enums;

public enum AccountsReceivableStatus {
    BILLING("To Pay"), // para pagar
    OVERDUE("Overdue"), // vencida
    OPEN("Open"), // em abetro
    PAID("Paid"); // paga


    private String description;

    private AccountsReceivableStatus(String description){
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