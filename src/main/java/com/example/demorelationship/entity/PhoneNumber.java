package com.example.demorelationship.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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



}
