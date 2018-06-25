# Relationship between different entities


Passport and Employee has one to one relationship

## Passport entity

    package com.arun.entity.relationship;
    
    import lombok.Getter;
    import lombok.Setter;
    
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    
    /**
     * Created by Adwiti on 6/24/2018.
     */
    @Getter
    @Setter
    @Entity
    public class Passport {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String number;
    }

## Employee Entity

    package com.arun.entity.relationship;
    
    import lombok.Getter;
    import lombok.Setter;
    
    import javax.persistence.*;
    
    /**
     * Created by Adwiti on 6/24/2018.
     */
    @Getter
    @Setter
    @Entity
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        @OneToOne
        private Passport passport;
    }

