package com.peura.exercise;

public class PersonalInfo {
    private String firstName;
    private String lastName;
    private String pid;
    private String address;
    private int zipCode;
    private String city;
    private String nationality;
    private String language;

    public PersonalInfo() {}

    public PersonalInfo(String firstName, String lastName, String pid, String address, int zipCode, String city, String nationality, String language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.nationality = nationality;
        this.language = language;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
