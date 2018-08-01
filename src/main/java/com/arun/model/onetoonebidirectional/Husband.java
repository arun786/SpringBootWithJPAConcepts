package com.arun.model.onetoonebidirectional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Adwiti on 6/29/2018.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Husband {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String age;

    @OneToOne(fetch = FetchType.LAZY)
    private Wife wife;

    public Husband(String name, String age, Wife wife) {
        this.name = name;
        this.age = age;
        this.wife = wife;
    }
}
