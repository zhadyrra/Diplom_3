package org.example.user;

public class UserSerialized {
    private String email;
    private String password;
    private String name;

    public UserSerialized() {
    }

    public UserSerialized(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserSerialized(String email, String password) {
        this.email = email;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
