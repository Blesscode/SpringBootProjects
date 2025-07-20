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
	List<InterviewerDtlsEntity> findByInterviewerUsername(String interviewerUsername);
    @Query("select interviewerAccountActive from InterviewerDtlsEntity where interviewerEmail=:email ")
	Boolean findByInterviewerAccountActiveByEmail(@Param("email")String email);
    @Query("select interviewerAccountActive from InterviewerDtlsEntity where interviewerUsername=:username ")
	Boolean findByInterviewerAccountActiveByUsername(@Param("username")String username);
	@Query("select activeToken from InterviewerDtlsEntity where interviewerEmail=:email ")
	String findByActiveToken(@Param("email")String email);

	@Query("Select interviewerPassword from InterviewerDtlsEntity where interviewerEmail=:email or interviewerUsername=:username")
	String findActivationPwd(@Param("email") String email,@Param("username")String username);
	
	@Query("Select activeToken from InterviewerDtlsEntity where interviewerEmail=:email")
	String getTokenByEmail(@Param("email") String email);

	//update pwd where email=email
	@Transactional
	@Modifying
	@Query("UPDATE InterviewerDtlsEntity SET interviewerPassword = :newPassword WHERE interviewerEmail = :email")
	void updatePasswordByEmail(@Param("newPassword") String newPassword, @Param("email") String email);

	
	@Transactional
	@Modifying
	@Query("UPDATE InterviewerDtlsEntity SET interviewerAccountActive = :status WHERE interviewerEmail = :email")
	void updateAccountStatus(@Param("status") Boolean status, @Param("email") String email);
	
	@Transactional
	@Modifying
	@Query("UPDATE InterviewerDtlsEntity SET activeToken = :token WHERE interviewerEmail = :email")
	void updateToken(@Param("token")String token, @Param("email") String email);
}
