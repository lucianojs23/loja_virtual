package com.luciano.loja_virtual.model;

import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class User implements UserDetails {

    private static final long serialVerionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long id;

    private String login;
    private String password;
    private LocalDate currentPasswordDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "acess_user", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "acess_id"},
            name = "unique_acess_user"), joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", table = "user", unique = false,
            foreignKey = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT)), inverseJoinColumns = @JoinColumn(name = "acess_id", unique = false, referencedColumnName = "id", table = "acess", foreignKey = @ForeignKey(name = "acess_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Access> acess;

    /*Autoridades são os acessos, ou seja ROLE_ADMIN. ROLE_SECRETARIO*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.acess;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
