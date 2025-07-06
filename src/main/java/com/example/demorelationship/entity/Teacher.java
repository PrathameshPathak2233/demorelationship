package com.example.demorelationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    // We need to form relationship many to many between course and Teacher
    // That is one Teacher can teach multiple course and vice versa --Same course can be taught by multiple teachers
    // We need to form x_Ref --By creating  table

    @ManyToMany(mappedBy = "teachers")
    private Set<Course> courseSet = new HashSet<>();


}
