package com.luciano.loja_virtual.model;

import com.luciano.loja_virtual.enums.AccountsReceivableStatus;
import com.luciano.loja_virtual.enums.PayableAccountsStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accounts_payable")
@SequenceGenerator(
        name = "seq_accounts_payable",
        sequenceName = "seq_accounts_payable",
        allocationSize = 1,
        initialValue = 1
)
public class PayableAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_accounts_payable")
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private PayableAccountsStatus status;

    private LocalDate paymentDueDate; //data do venciomento
    private LocalDate paymentDate; // Data do pagamento
    private BigDecimal totalAmount; //valor total
    private BigDecimal discountAmount;


    @ManyToOne
    @JoinColumn(
            name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    value = ConstraintMode.CONSTRAINT,
                    name = "person_fk"
            )
    )
    private Person person;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(
            name = "supplier_person_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    value = ConstraintMode.CONSTRAINT,
                    name = "supplier_person_fk"
            )
    )
    private Person supplierPerson; // pessoa fornecedora/ fornecedor

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(LocalDate paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PayableAccountsStatus getStatus() {
        return status;
    }

    public void setStatus(PayableAccountsStatus status) {
        this.status = status;
    }

    public Person getSupplierPerson() {
        return supplierPerson;
    }

    public void setSupplierPerson(Person supplierPerson) {
        this.supplierPerson = supplierPerson;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PayableAccount that = (PayableAccount) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
