package org.example.test;


import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;

    public User() {
        this.id = UUID.randomUUID().toString(); // 自动生成唯一 ID
    }

    public User(String name, String email) {
        this();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
