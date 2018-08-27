package com.rafal.bank.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_roles",
        uniqueConstraints = @UniqueConstraint(
                columnNames = { "role", "username" }))
public class UserRole{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_role_id",
            unique = true, nullable = false)
    private Integer userRoleId;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public UserRole() {
    }

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return this.userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(user, userRole.user) &&
                Objects.equals(role, userRole.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, role);
    }

    @Override
    public String toString() {
        return role;
    }
}
