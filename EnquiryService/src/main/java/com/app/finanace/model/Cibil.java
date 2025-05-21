package com.app.finanace.model;

import com.app.finanace.enums.CibilEnums;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cibil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cibilId;
	private int cibilScore;
	
	@Enumerated(EnumType.STRING)
	private CibilEnums cibilStatus;
	
	
	
	
	
	
}
