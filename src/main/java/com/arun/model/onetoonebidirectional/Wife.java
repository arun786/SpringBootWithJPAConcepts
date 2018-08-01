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
public class Wife {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String age;

    public Wife(String name, String age) {
        this.name = name;
        this.age = age;
    }

    /**
     * if we want to make Husband as the owning side, then we need to mention
     * mapped by in the non owning side
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "wife")
    private Husband husband;
}
