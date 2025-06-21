package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.todo.entity.TaskEntity;

import jakarta.transaction.Transactional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer>{

    @Modifying
    @Transactional
    @Query("UPDATE TaskEntity t SET t.taskData = :taskData WHERE t.id = :id")
    int updateTaskDataById(@Param("taskData") String taskData, @Param("id") Integer id);
}
