package com.arun.entity.relationship;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Adwiti on 6/24/2018.
 */
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne
    private Passport passport;
}
