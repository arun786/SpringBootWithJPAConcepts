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
@NamedQuery(query = "select s from Student s", name = "Get_All_Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String standard;
    private String location;
    @Column(name = "date_of_admission")
    private Date dateOfAdmission;
}
