package com.todo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

//	@Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password")
//	List<UserEntity> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	//OR
	Optional<UserEntity> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email); // For validating uniqueness

	
}
