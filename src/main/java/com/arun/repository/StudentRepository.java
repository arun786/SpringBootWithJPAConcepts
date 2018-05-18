package com.arun.repository;

import com.arun.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adwiti on 5/17/2018.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
