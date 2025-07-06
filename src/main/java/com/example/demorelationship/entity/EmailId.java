package com.example.demorelationship.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class EmailId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mailId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    // Fees paid --mail send --please pay fees asap --


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public EmailId() {
    }

    public EmailId(Long id, String mailId, Student student) {
        this.id = id;
        this.mailId = mailId;
        this.student = student;
    }

    @Override
    public String toString() {
        return "EmailId{" +
                "id=" + id +
                ", mailId='" + mailId + '\'' +
                ", student=" + student +
                '}';
    }
}
