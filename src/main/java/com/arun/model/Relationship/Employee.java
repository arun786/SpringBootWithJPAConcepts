package com.arun.model.relationship;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Adwiti on 6/24/2018.
 */
@Getter
@Setter
public class Employee {
    private String name;
    @OneToOne
    private PassportRequest passportRequest;
}
