package com.hashlama.hackathon.api.auth;

import java.util.Objects;

public class User {

    private String fullName;
    private String username;
    private String password;
    private String phoneNumber;
    private String city;
    private Boolean isIsolated;

    public User(String fullName, String username, String password, String phoneNumber, String city, Boolean isIsolated) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.isIsolated = isIsolated;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getIsolated() {
        return isIsolated;
    }

    public void setIsolated(Boolean isolated) {
        isIsolated = isolated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fullName, user.fullName) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(city, user.city) &&
                Objects.equals(isIsolated, user.isIsolated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, username, password, phoneNumber, city, isIsolated);
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", isIsolated=" + isIsolated +
                '}';
    }
}
