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
        @NamedQuery(name = "Get_All_Subject", query = "select s from Subject s"),
        @NamedQuery(name = "Get_Books_By_Author", query = "select s from Subject s where s.author = :author"),
        @NamedQuery(name = "Get_Book_Based_On_Author_And_Id", query = "select s from Subject s where s.author = :author and s.id = :id")
})
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
}
