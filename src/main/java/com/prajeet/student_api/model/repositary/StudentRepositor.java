package com.prajeet.student_api.model.repositary;

import com.prajeet.student_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepositor extends JpaRepository<Student, Integer> {
}

//Extends JpaRepository → gives ready-made CRUD methods