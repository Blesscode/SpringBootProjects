package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="joinmodeoptionsdtls")
@Data
public class JoinModeOptionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="joinModeId")
	private Integer joinModeId;
	@Column(name="joinModeName")
	private String joinModeName;
}
