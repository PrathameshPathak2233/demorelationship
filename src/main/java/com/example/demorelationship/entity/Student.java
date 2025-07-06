package com.example.demorelationship.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
