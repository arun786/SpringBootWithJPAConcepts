package com.arun.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Adwiti on 5/25/2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public CourseEntity(String name) {
        this.name = name;
    }
}
