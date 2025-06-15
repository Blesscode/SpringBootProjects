package com.form3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form3.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

}
