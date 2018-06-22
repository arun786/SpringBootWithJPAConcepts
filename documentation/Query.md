# Query

## @NamedQuery

    package com.arun.entity;
    
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

    @Override
    public List<Student> getAllStudents() {
        Query query = entityManager.createNamedQuery("Get_All_Students");
        return query.getResultList();
    }
    
    
    package com.arun.entity;
    
    import lombok.Getter;
    import lombok.Setter;
    
    import javax.persistence.*;
    
    /**
     * Created by Adwiti on 6/20/2018.
     */
    @Entity
    @Getter
    @Setter
    @NamedQueries(value = {
            @NamedQuery(name = "Get_All_Subject", query = "select s from Subject s")
    })
    public class Subject {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String author;
    }

Use entityManager to get all the rows from the database,
 
    package com.arun.repository;
    
    import com.arun.entity.Subject;
    import org.springframework.stereotype.Repository;
    
    import javax.persistence.EntityManager;
    import javax.persistence.PersistenceContext;
    import javax.persistence.Query;
    import java.util.List;
    
    /**
     * Created by Adwiti on 6/21/2018.
     */
    @Repository
    public class SubjectDaoImpl implements SubjectDao {
    
        @PersistenceContext
        private EntityManager entityManager;
    
        @Override
        public List<Subject> getAllStudents() {
            Query query = entityManager.createNamedQuery("Get_All_Subject", Subject.class);
            return query.getResultList();
        }
    }

Use Named Query to get all the books based on author

    @NamedQueries(value = {
            @NamedQuery(name = "Get_All_Subject", query = "select s from Subject s"),
            @NamedQuery(name = "Get_Books_By_Author", query = "select s from Subject s where s.author = :author")
    })
    
    this will defined on the entity
    
    @Override
    public List<Subject> getDetailsOfSubject(String authorName) {
        Query query = entityManager.createNamedQuery("Get_Books_By_Author", Subject.class);
        query.setParameter("author",authorName);
        return query.getResultList();
    }