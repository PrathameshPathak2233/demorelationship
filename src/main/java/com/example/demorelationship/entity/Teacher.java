package com.example.demorelationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


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

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public Teacher() {
    }

    public Teacher(Long id, String name, Set<Course> courseSet) {
        this.id = id;
        this.name = name;
        this.courseSet = courseSet;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseSet=" + courseSet +
                '}';
    }
}
