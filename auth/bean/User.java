package com.example.auth.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId") // Make sure this is exactly "userId" as per your SQL
    private Integer userID;

    @Column(name="username", length = 50)
    private String username;

    @Column(name="password", length = 255)
    private String password;

    @Column(name="email", length = 100, unique = true) // Added unique = true
    private String email;

    @Column(name="role", nullable = false)
    private String role;

    // Default Constructor (Required by Hibernate)
    public User() {}

    // Parameterized Constructor (Used by Controller)
    public User(Integer userID, String username, String password, String email, String role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public Integer getUserID() { return userID; }
    public void setUserID(Integer userID) { this.userID = userID; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}