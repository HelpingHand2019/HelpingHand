package com.capgemini.controller;

import java.sql.Date;
import java.util.List;


import com.capgemini.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.dao.ITransactionDaoImpl;
import com.capgemini.dto.PatientDTO;
import com.capgemini.dto.TrackProgressDTO;
import com.capgemini.dto.HospitalDTO;


@RestController
public class Controller {

	
	
    @Autowired
    ITransactionDaoImpl transactionDao;


    @RequestMapping("/getAllTransactions")
    public List<TrackProgressDTO> getAllRequests(Model model) {
    	
        return transactionDao.getAllRequests();
    }

/*//   @RequestMapping(method=RequestMethod.PUT, value="/registerPatient")
//   @ResponseBody
//   public void savepatient(@RequestBody PatientDTO patient) {
//      transactionDao.savePatient(patient);	
//   }
*/   
    
    @RequestMapping(method=RequestMethod.PUT, value="/registerPatient")
    public void registerPatient(@RequestBody PatientDTO patient )
    {
    	transactionDao.savePatient(patient);
    	
    }
    
    
    
   @RequestMapping(method=RequestMethod.PUT, value="/registerHospital")
   public void saveHospital(@RequestBody HospitalDTO hospital) {
       transactionDao.saveHospital(hospital);
 
       	
       	
   }
   
   
  /* @RequestMapping("/create")
   public void create()
   {  AssetDTO assets = null;
   TransactionDTO transaction = null;
	   createAsset(assets);
	   createTransaction(transaction);
   }*/
   

   
   
    
    
    
    
    
    
    
    
    
    
}