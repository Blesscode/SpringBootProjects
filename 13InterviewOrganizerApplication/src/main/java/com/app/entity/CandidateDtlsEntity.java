package com.app.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="candidatedtls")
@Data
public class CandidateDtlsEntity {


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "candidateId")
     private Integer candidateId;

     @Column(name = "candidateName")
     private String candidateName;

     @Column(name = "candidateEmail", unique = true)
     private String candidateEmail;

     @Column(name = "candidatePhone", unique = true)
     private String candidatePhone;

     @Column(name = "candidateRole")
     private String candidateRole;

     @Column(name = "candidateStatus")
     private String candidateStatus;

     @Column(name = "candidateJoinMode")
     private String candidateJoinMode;

     @CreationTimestamp
     @Column(name = "candidateInterviewDate")
     private LocalDate candidateInterviewDate;
     @UpdateTimestamp
     @Column(name = "candidateConfirmationDate")
     private LocalDate candidateConfirmationDate;
     
     @ManyToOne
     @JoinColumn(name="interviewerId")
     private InterviewerDtlsEntity interviewer;
}
