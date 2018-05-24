# SpringBootWithJPAConcepts


## Get Student Data for a particular Id

### Define Entity
    
        package com.arun.model;
        
        import lombok.Getter;
        import lombok.Setter;
        
        import javax.persistence.*;
        import java.util.Date;
        
        /**
         * Created by Adwiti on 5/16/2018.
         */
        @Getter
        @Setter
        @Entity
        @Table(name = "student")
        public class Student {
            @Id
            @GeneratedValue
            private int id;
            private String name;
            private String standard;
            private String location;
            @Column(name = "date_of_admission")
            private Date dateOfAdmission;
        }

### Define Repository


    package com.arun.repository;
    
    import com.arun.model.Student;
    
    /**
     * Created by Adwiti on 5/16/2018.
     */
    public interface StudentDao {
        Student getStudentById(int id);
    }


    package com.arun.repository;
    
    import com.arun.constants.Constants;
    import com.arun.exception.DataNotFoundException;
    import com.arun.model.Student;
    import org.springframework.stereotype.Repository;
    import org.springframework.transaction.annotation.Transactional;
    
    import javax.persistence.EntityManager;
    import javax.persistence.PersistenceContext;
    
    /**
     * Created by Adwiti on 5/16/2018.
     */
    
    @Repository
    @Transactional
    public class StudentDaoImpl implements StudentDao {
        /**
         * Connect to the database
         */
        @PersistenceContext
        EntityManager entityManager;
    
        @Override
        public Student getStudentById(int id) {
            Student student = entityManager.find(Student.class, id);
            if (null == student) {
                throw new DataNotFoundException(Constants.NO_DATA_NOT_FOUND);
            }
            return student;
        }
    }


### Service

    package com.arun.service;
    
    import com.arun.model.Student;
    
    /**
     * Created by Adwiti on 5/16/2018.
     */
    public interface StudentService {
        Student getStudentById(int id);
    }

    package com.arun.service;
    
    import com.arun.model.Student;
    import com.arun.repository.StudentDao;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    /**
     * Created by Adwiti on 5/16/2018.
     */
    
    @Service
    public class StudentServiceImpl implements StudentService {
        @Autowired
        private StudentDao studentDao;
    
        @Override
        public Student getStudentById(int id) {
            return studentDao.getStudentById(id);
        }
    }

### Controller

    package com.arun.controller;
    
    import com.arun.model.Student;
    import com.arun.service.StudentService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RestController;
    
    /**
     * Created by Adwiti on 5/16/2018.
     */
    @RestController
    public class StudentController {
        @Autowired
        private StudentService studentService;
    
        @GetMapping("/student/v1/students/{id}")
        public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Integer id) {
            Student studentById = studentService.getStudentById(id);
            ResponseEntity<Student> response = new ResponseEntity<Student>(studentById, HttpStatus.OK);
            return response;
        }
    }

## If we use JPA Repository for Get, we need to define the below

### dao Layer
    Steps 
    1. create an interface which extends JpaRepository
    2. Autowire it in DAO layer and call its method.
    
    Step 1
    package com.arun.repository;
    
    import com.arun.model.Student;
    import org.springframework.data.jpa.repository.JpaRepository;
    
    /**
     * Created by Adwiti on 5/17/2018.
     */
    public interface StudentRepository extends JpaRepository<Student, Integer> {
    }
    
    Step 2 : In StudentDaoImp layer
    
    @Autowired
    private StudentRepository studentRepository;
       
    @Override
    public Student getStudentByIdUsingJpaRepo(int id) {
    Optional<Student> byId = studentRepository.findById(id);
         if (byId.isPresent()) {
             return byId.get();
         } else {
             throw new DataNotFoundException(Constants.NO_DATA_NOT_FOUND);
         }
    }
    
## Get all the students using Entity manager

### dao layer

        @Override
        public List<Student> getAllStudents() {
            Query query = entityManager.createNamedQuery("Get_All_Students");
            return query.getResultList();
        }
  
## Get All Students using Jpa Repository

### dao Layer

        @Override
        public List<Student> getAllStudentsUsingJpaRepo() {
            return studentRepository.findAll();
        }
        
### Model will have named query

    package com.arun.model;
    
    import lombok.Getter;
    import lombok.Setter;
    
    import javax.persistence.*;
    import java.util.Date;
    
    /**
     * Created by Adwiti on 5/16/2018.
     */
    @Getter
    @Setter
    @Entity
    @Table(name = "student")
    @NamedQuery(query = "select s from Student s", name = "Get_All_Students")
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String standard;
        private String location;
        @Column(name = "date_of_admission")
        private Date dateOfAdmission;
    }

## Update a Student using JPA Repository

### DAO layer 

    @Override
    public Student updateStudentByJpa(Student student) {
            return studentRepository.save(student);
    }
    
## Update a student using Entity Manager

    @Override
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }