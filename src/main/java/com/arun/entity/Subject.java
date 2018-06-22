package com.arun.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Adwiti on 6/20/2018.
 */
@Entity
@Getter
@Setter
@NamedQueries(value = {
        @NamedQuery(name = "Get_All_Subject", query = "select s from Subject s")
})
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
}
