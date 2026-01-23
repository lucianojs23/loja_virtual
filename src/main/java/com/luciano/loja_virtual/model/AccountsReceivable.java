package com.luciano.loja_virtual.model;

import com.luciano.loja_virtual.enums.AccountsReceivableStatus;
import com.luciano.loja_virtual.enums.AddressType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accounts_receivable")
@SequenceGenerator(
        name = "seq_accounts_receivable",
        sequenceName = "seq_accounts_receivable",
        allocationSize = 1,
        initialValue = 1
)
public class AccountsReceivable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_accounts_receivable")
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private AccountsReceivableStatus status;

    private LocalDate paymentDueDate; //data do venciomento
    private LocalDate paymentDate; // Data do pagamento
    private BigDecimal totalAmount; //valor total
    private BigDecimal discountAmount;


    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(
            name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    value = ConstraintMode.CONSTRAINT,
                    name = "person_fk"
            )
    )
    private Person person;

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

    public AccountsReceivableStatus getStatus() {
        return status;
    }

    public void setStatus(AccountsReceivableStatus status) {
        this.status = status;
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
        AccountsReceivable that = (AccountsReceivable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
