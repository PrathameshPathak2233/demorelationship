package com.example.demorelationship.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity
public class Student {

    //id,
    // name
    // OnETOONe
    // Address address  ---join column --address_id
    // create //get //update
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")    // foreign key --address_id
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonManagedReference
    private List<Course> courseList = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonManagedReference
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonManagedReference
    private Set<EmailId> emailIdSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<EmailId> getEmailIdSet() {
        return emailIdSet;
    }

    public void setEmailIdSet(Set<EmailId> emailIdSet) {
        this.emailIdSet = emailIdSet;
    }

    public Student() {
    }

    public Student(Long id, String name, Address address, List<Course> courseList, Set<PhoneNumber> phoneNumbers, Set<EmailId> emailIdSet) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.courseList = courseList;
        this.phoneNumbers = phoneNumbers;
        this.emailIdSet = emailIdSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", courseList=" + courseList +
                ", phoneNumbers=" + phoneNumbers +
                ", emailIdSet=" + emailIdSet +
                '}';
    }
}
