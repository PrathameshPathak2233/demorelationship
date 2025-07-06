package com.example.demorelationship.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    // Separate --table --id, addLine1, addLine2, city, pincode

    @Id
    @GeneratedValue
    private Long id;  // primary key
    private String addressLine1;
    private String addressLine2;
    private String city;
    private Integer pinCode;

}
