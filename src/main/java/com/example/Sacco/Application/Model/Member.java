package com.example.Sacco.Application.Model;

public class Member {
    private String id;
    private String name;
    private String phone;
    private String groupName;

    // Constructor
    public Member(String id, String name, String phone, String groupName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.groupName = groupName;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getGroupName() {
        return groupName;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Your ID is: " + id);
        System.out.println("Your Name is: " + name);
        System.out.println("Your Phone is: " + phone);
        System.out.println("Your Group Name is: " + groupName);
    }
}