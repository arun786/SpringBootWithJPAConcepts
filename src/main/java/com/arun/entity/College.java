package com.arun.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Adwiti on 6/22/2018.
 */
@Entity
@Getter
@Setter
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int ranking;
    @Column(name = "create_time_stamp")
    private LocalDateTime createTimeStamp;
    @Column(name="update_time_stamp")
    private LocalDateTime updateTimeStamp;
}
