package com.capgemini.dao;
import com.capgemini.filter.CorsFilter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dto.PatientDTO;
import com.capgemini.dto.TrackProgressDTO;
import com.capgemini.dto.HospitalDTO;

@Repository
@Transactional

public class ITransactionDaoImpl implements ITransactionDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	Connection con = null;
   
    PreparedStatement ps = null;

	

	
	@Override
	public List<TrackProgressDTO> getAllRequests() {
		// TODO Auto-generated method stub
		String query = "select * from request";
		List<TrackProgressDTO> tlist = new ArrayList<TrackProgressDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		try{
			con = jdbcTemplate.getDataSource().getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				TrackProgressDTO records = new TrackProgressDTO();
				records.setRequestTo(rs.getLong("requestto"));
				records.setRequestFrom(rs.getLong("requestfrom"));
				records.setInProgress(rs.getBoolean("inprogress"));			
				records.setIscompleted(rs.getBoolean("iscompleted"));
				records.setAppointmentDate(rs.getString("appointmentdate"));
				tlist.add(records);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tlist;
	}



	@Override
	public void saveHospital(HospitalDTO hospital) {



        String query = "INSERT INTO hospitals(hospitalid,hospitalname, hospitalemail, hospitalphonenumber,hospitaladdress, registrationdate) VALUES (?, ?, ?, ?,?,?)";


        Connection con = null;
		PreparedStatement ps = null;
		
		
		try{
			
			con = jdbcTemplate.getDataSource().getConnection();
			
			ps = con.prepareStatement(query);
		  ps.setString(1, hospital.getHospitalId());
          ps.setString(2, hospital.getHospitalName());
          ps.setString(3, hospital.getHospitalEmail());
          ps.setString(4, hospital.getHospitalPhoneNumber());
          ps.setString(5, hospital.getHospitalAddress());
          ps.setString(6, hospital.getRegistrationDate());
        

          ps.executeUpdate();
          ps.close();

          System.out.println("transactions with following details was saved in DB: " + hospital.toString());

      } catch (SQLException e) {
          //e.printStackTrace();
          throw new RuntimeException(e);
      }
		
	}
	 
	@Override
	public void savePatient(PatientDTO patient) {



        String query = "INSERT INTO patients(patientid, patientname, patientage, patientemail, patientphonenumber, patientaddress, patientdisease) VALUES (?, ?, ?, ?,?,?,?)";


        Connection con = null;
		PreparedStatement ps = null;
		
		
		try{
			
			con = jdbcTemplate.getDataSource().getConnection();
			
			ps = con.prepareStatement(query);
		  ps.setString(1, patient.getPatientId());
          ps.setString(2, patient.getPatientName());
          ps.setLong(3, patient.getPatientAge());
          ps.setString(4, patient.getPatientEmail());
          ps.setString(5, patient.getPatientPhoneNumber());
          ps.setString(6, patient.getPatientAddress());
          ps.setString(7, patient.getPatientDisease());
        

          ps.executeUpdate();
          ps.close();

          System.out.println("transactions with following details was saved in DB: " + patient.toString());

      } catch (SQLException e) {
          //e.printStackTrace();
          throw new RuntimeException(e);
      }
	}
	
	}

	
	


