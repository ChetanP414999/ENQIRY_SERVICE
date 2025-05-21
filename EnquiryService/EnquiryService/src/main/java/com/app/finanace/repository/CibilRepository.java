package com.app.finanace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.finanace.model.Cibil;

@Repository
public interface CibilRepository extends JpaRepository<Cibil, Integer>{

	public Cibil findByCibilId(int cibilId);
	
}
