package com.luciano.loja_virtual.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name = "access")
@SequenceGenerator(
        name = "seq_access",
        sequenceName = "seq_access",
        initialValue = 1,
        allocationSize = 1
)
public class Access implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_access")
    private Long id;

    @Column(nullable = false)
    private String authority; // e.g. ROLE_ADMIN, ROLE_MANAGER

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorityName() {
        return authority;
    }

    public void setAuthorityName(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Access access = (Access) o;
        return Objects.equals(id, access.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
