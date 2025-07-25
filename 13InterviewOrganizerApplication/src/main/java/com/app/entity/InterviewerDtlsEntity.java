package com.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private boolean interviewerAccountActive; 
	@Column(name="activeToken")
	private String activeToken;//unique activation token
	
	@OneToMany(mappedBy = "interviewer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<CandidateDtlsEntity>candidatesInterviewed;
	
	
}
