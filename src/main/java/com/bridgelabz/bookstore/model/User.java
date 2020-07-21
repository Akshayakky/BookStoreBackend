package com.bridgelabz.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class User {
    public boolean active;

    @Id
    @GeneratedValue
    private long userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    public boolean isActive() {
        return true;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return (role != null) ? role : "user";
    }

    public void setRole(String role) {
        this.role = role;
    }
}
