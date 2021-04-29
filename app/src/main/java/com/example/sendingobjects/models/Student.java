package com.example.sendingobjects.models;

import java.io.Serializable;

public class Student implements Serializable {
    private String name,rollNo,phoneNo;
    private int gender;

    public Student(String name, String rollNo, String phoneNo,int gender) {
        this.name = name;
        this.rollNo = rollNo;
        this.phoneNo = phoneNo;
        this.gender=gender;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
