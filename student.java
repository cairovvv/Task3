package com.mycompany.main1;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private int yearLvl;
    private String course;
    private String bloodType;
    private String address;
    private String contact;

    public Student(int id, String firstName, String lastName, int age, String gender,
                   int yearLvl, String course, String bloodType, String address, String contact) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.yearLvl = yearLvl;
        this.course = course;
        this.bloodType = bloodType;
        this.address = address;
        this.contact = contact;
    }

    public int getID() { return id; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public int getAge() { return age; }

    public String getGender() { return gender; }

    public int getYearLvl() { return yearLvl; }

    public String getCourse() { return course; }

    public String getBloodtype() { return bloodType; }

    public String getAddress() { return address; }

    public String getContact() { return contact; }

    public void setAge(int age) {
        if(age > 0 && age < 150)
            this.age = age;
    }

    public void setContact(String contact) {
        if(contact.matches("\\d{11}"))
            this.contact = contact;
    }
}