package com.luciano.loja_virtual.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "legal_entity")
public class LegalEntity extends Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String cnpj; // Brazilian Company Tax ID
    private String stateRegistration;
    private String municipalRegistration;
    private String tradeName; // nome fantasia
    private String corporateName; // razão social
    private String category;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getMunicipalRegistration() {
        return municipalRegistration;
    }

    public void setMunicipalRegistration(String municipalRegistration) {
        this.municipalRegistration = municipalRegistration;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
