package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="interviewerdtls")
@Data
public class InterviewerDtlsEntity {
	@Id
	@Column(name="interviewerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer interviewerId;
	@Column(name="interviewerName")
	private String interviewerName;
	@Column(name="interviewerEmail", unique=true)
	private String interviewerEmail;
	@Column(name="interviewerUsername",unique = true)
	private String interviewerUsername;
	@Column(name="interviewerPhone" , unique = true)
	private Long interviewerPhone;
	@Column(name="interviewerPassword")
	private String interviewerPassword;
	@Column(name="interviewerAccountActive")
	private Boolean interviewerAccountActive;
	
}
