package com.example.demorelationship.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue
    private Long id ;

    private  Long mobileNumber;

    @ManyToOne
    @JoinColumn(name="student_id")
    @JsonBackReference       // why we hav used annotation ---
    private Student student ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public PhoneNumber() {
    }

    public PhoneNumber(Long id, Long mobileNumber, Student student) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.student = student;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", mobileNumber=" + mobileNumber +
                ", student=" + student +
                '}';
    }
}
