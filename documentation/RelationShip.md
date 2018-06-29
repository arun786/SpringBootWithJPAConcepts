# Relationship between different entities


## Passport and Employee has one to one relationship

### Passport entity

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

### Employee Entity

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

# Create Employee Passport relationship

    @Override
    @Transactional
    public void createPassportEmployeeRelation(EmployeePassport employeePassport) {
        Query query = entityManager.createNativeQuery("insert into passport(number) values(?)");
        query.setParameter(1, employeePassport.getPassportNumber());
        int numberOfRows = query.executeUpdate();
        if (numberOfRows > 0) {
            Query selectQuery = entityManager.createNativeQuery("select id from passport where number = ?");
            selectQuery.setParameter(1, employeePassport.getPassportNumber());
            Integer id = (Integer) selectQuery.getResultList().get(0);
            Query insertQuery = entityManager.createNativeQuery("insert into employee(name,passport_id)values(?,?)");
            insertQuery.setParameter(1, employeePassport.getEmployeeName());
            insertQuery.setParameter(2, id);
            insertQuery.executeUpdate();
        }
    }

# We can also use Entity to persist 

    @Override
    @Transactional
    public void createPassportEmployeeRelationWithEntity(EmployeePassport employeePassport) {
        Passport passport = new Passport();
        passport.setNumber(employeePassport.getPassportNumber());
        entityManager.persist(passport);
    
        Employee employee = new Employee();
        employee.setName(employeePassport.getEmployeeName());
        employee.setPassport(passport);
        entityManager.persist(employee);
    }
    
 # lazy loading 
 
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
        @OneToOne(fetch = FetchType.LAZY)
        private Passport passport;
    }

    @Override
    @Transactional //@Transactional is required only when Passport is lazily loaded
    public EmployeePassportResponse getEmployeePassportDetails(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        EmployeePassportResponse employeePassportResponse = new EmployeePassportResponse();
        employeePassportResponse.setEmployeeId(employee.getId());
        employeePassportResponse.setEmployeeName(employee.getName());
        employeePassportResponse.setPassportId(employee.getPassport().getId());
        employeePassportResponse.setPassportNumber(employee.getPassport().getNumber());
        return employeePassportResponse;
    }