package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.InterviewerDtlsEntity;

import jakarta.transaction.Transactional;


public interface InterviewerDtlsRepo extends JpaRepository<InterviewerDtlsEntity, Integer> {

	//find interviewrs by name,email,pwd
	List<InterviewerDtlsEntity> findByInterviewerName(String interviewerName);
	List<InterviewerDtlsEntity> findByInterviewerEmail(String interviewerEmail);
	List<InterviewerDtlsEntity> findByInterviewerPassword(String interviewerPassword);
	@Query("select activeToken from InterviewerDtlsEntity where interviewerEmail=:email ")
	String findByActiveToken(@Param("email")String email);

	@Query("Select interviewerPassword from InterviewerDtlsEntity where interviewerEmail=:email or interviewerUsername=:username")
	String findActivationPwd(@Param("email") String email,@Param("username")String username);
	
	//update pwd where email=email
	@Transactional
	@Modifying
	@Query("UPDATE InterviewerDtlsEntity SET interviewerPassword = :newPassword WHERE interviewerEmail = :email")
	void updatePasswordByEmail(@Param("newPassword") String newPassword, @Param("email") String email);

}
