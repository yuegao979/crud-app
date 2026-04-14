package com.beaconfire.crud_app.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name", nullable = false)
    private String firstname;

    @Column(name="last_name", nullable = false)
    private String lastname;
}
