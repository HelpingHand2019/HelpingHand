package com.capgemini.dao;

import com.capgemini.filter.CorsFilter;

import java.sql.Date;
import java.util.List;

import com.capgemini.dto.PatientDTO;
import com.capgemini.dto.TrackProgressDTO;
import com.capgemini.dto.HospitalDTO;

public interface ITransactionDao {
	 
	/*public static final String SQL_SELECT_QUERY = "select * from patientrecord";
	@Query(SQL_SELECT_QUERY)
	public List<PatientDTO> viewAllPatients();
	
	public static final String SQL_INSERT_QUERY= "insert into patientrecord values(?1,?2,?3,?4,?5,?6,?7) where patientid=?8" ;
	@Query(SQL_INSERT_QUERY)
	public PatientDTO updatePatient(PatientDTO patientDTO, int patientId );
	*/
 
	
	
	/*//Update
	public TransactionDTO search(TransactionDTO  transactions);
*/
	
	//Get All Transaction
	public List<TrackProgressDTO> getAllRequests();

	public void savePatient(PatientDTO patient);
    public void saveHospital(HospitalDTO hospital);
	

}

