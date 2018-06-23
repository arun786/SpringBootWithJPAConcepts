# Query

# @NamedQuery

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

## Use entityManager to get all the rows from the database,
 
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

## Use Named Query to get all the books based on author

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
    
## Get books based on author and id

        @NamedQueries(value = {
                @NamedQuery(name = "Get_All_Subject", query = "select s from Subject s"),
                @NamedQuery(name = "Get_Books_By_Author", query = "select s from Subject s where s.author = :author"),
                @NamedQuery(name = "Get_Book_Based_On_Author_And_Id", query = "select s from Subject s where s.author = :author and s.id = :id")
        })
        
        @Override
        public Subject getDetailsOfSubjectBasedOnIdAndAuthor(String authorName, int id) {
            Query query = entityManager.createNamedQuery("Get_Book_Based_On_Author_And_Id", Subject.class);
            query.setParameter("author", authorName);
            query.setParameter("id", id);
            List resultList = query.getResultList();
            if (!resultList.isEmpty()) {
                return (Subject) resultList.get(0);
            }
            throw new DataNotFoundException("Data_Not_Found");
        }
        
# Create Native Query

## Get College based on the id
    
     @PersistenceContext
        private EntityManager entityManager;
    
        @Override
        public College getCollege(int id) {
            Query query = entityManager.createNativeQuery("select * from college c where c.id = ?", College.class);
            query.setParameter(1, id);
    
            List resultList = query.getResultList();
            if (!resultList.isEmpty()) {
                return (College) query.getResultList().get(0);
            }
            throw new DataNotFoundException("DATA_NOT_FOUND");
        }
        
## Get All Colleges based on the ranking

        @Override
        public List<College> getCollegeBasedOnRanking(int ranking) {
            Query query = entityManager.createNativeQuery("select * from college c where c.ranking > ?", College.class);
            query.setParameter(1, ranking);
            return query.getResultList();
        }