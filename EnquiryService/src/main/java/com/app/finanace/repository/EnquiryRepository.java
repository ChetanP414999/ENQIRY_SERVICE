package com.app.finanace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.finanace.model.Enquiry;

import jakarta.transaction.Transactional;

@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry, Integer> {


public Enquiry findBycustomerId(int customerId);
	
public List<Enquiry> findByEnquiryStatus(String enquiryStatus);


//@Transactional
//@Modifying
//@Query(value = "update Enquiry set firstName=:fn where customerId=:id")
//public void updateFirstName(@Param("fn")String firstName,@Param("id") int customerId);

//@Transactional
//@Modifying
//@Query(value = "update Enquiry set lastName=:nm where customerId=:id")
//public void updateLastName(@Param("nm")String lastName,@Param("id")int customerId);

@Transactional
@Modifying
@Query(value = "update Enquiry set customerEmail=:em where customerId=:id")
public void updateEmail(@Param("em")String customerEmail,@Param("id")int customerId);

@Transactional
@Modifying
@Query(value = "update Enquiry set customerMobileNumber=:mn where customerId=:id")
public void updateMobileNo(@Param("mn")long customerMobileNumber,@Param("id")int customerId);










//
//@Query(value ="SELECT * FROM  Enquiry WHERE      firstName  LIKE %:value%  OR lastName LIKE %:value%  OR age LIKE %:value%  OR email LIKE %:value%   OR mobileNo  LIKE %:value%  OR pancardNo LIKE %:value% OR customerID  LIKE %:value% ",nativeQuery = true)    
//List<Enquiry> searchByAnyField(@Param("value") String value);
//



//@Query(value ="SELECT * FROM enquiry  WHERE firstName LIKE %?1% OR lastName LIKE %?1%  OR email LIKE %?1%   ",nativeQuery = true)
//List<Enquiry> searchByAnyField(@Param("keyword") String keyword);
//




//@Query(value = "SELECT * FROM enquiry WHERE first_name LIKE %?1% OR last_name LIKE %?1% OR email LIKE %?1% OR mobile_no LIKE %?1% OR pancard_no LIKE %?1% OR age LIKE %?1% OR customerid  LIKE %?1% " , nativeQuery = true)
//List<Enquiry> searchByAnyField(@Param("keyword") String keyword);



}
