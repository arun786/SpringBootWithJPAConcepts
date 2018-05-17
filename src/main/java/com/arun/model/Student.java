package com.arun.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Adwiti on 5/16/2018.
 */
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String standard;
    private String location;
    @Column(name = "date_of_admission")
    private Date dateOfAdmission;
}
