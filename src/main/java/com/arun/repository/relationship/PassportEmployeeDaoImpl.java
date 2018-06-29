package com.arun.repository.relationship;

import com.arun.entity.relationship.Employee;
import com.arun.entity.relationship.Passport;
import com.arun.model.EmployeePassport;
import com.arun.model.EmployeePassportResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Adwiti on 6/26/2018.
 */
@Repository
public class PassportEmployeeDaoImpl implements PassportEmployeeDao {
    @PersistenceContext
    EntityManager entityManager;

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
}
