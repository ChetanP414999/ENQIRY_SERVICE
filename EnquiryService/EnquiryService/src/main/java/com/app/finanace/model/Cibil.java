package com.app.finanace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
public class Cibil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cibilId;
	private int cibilScore;
	
	@Enumerated(EnumType.STRING)
	private Enums cibilStatus;
	
	
	
	
	
	public int getCibilId() {
		return cibilId;
	}
	public void setCibilId(int cibilId) {
		this.cibilId = cibilId;
	}
	public int getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	public Enums getCibilStatus() {
		return cibilStatus;
	}
	public void setCibilStatus(Enums cibilStatus) {
		this.cibilStatus = cibilStatus;
	}
	
	
	
	
	
	
	
}
