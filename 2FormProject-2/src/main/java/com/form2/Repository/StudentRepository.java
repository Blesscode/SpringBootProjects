package com.form2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.form2.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

}
