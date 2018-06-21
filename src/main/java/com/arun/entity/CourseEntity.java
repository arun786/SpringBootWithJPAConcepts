package com.arun.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @UpdateTimestamp
    @Column(name = "last_updated_timestamp")
    private LocalDateTime lastUpdatedTimeStamp;
    @CreationTimestamp
    @Column(name = "create_timestamp")
    private LocalDateTime createTimeStamp;

    public CourseEntity(String name) {
        this.name = name;
    }
}
