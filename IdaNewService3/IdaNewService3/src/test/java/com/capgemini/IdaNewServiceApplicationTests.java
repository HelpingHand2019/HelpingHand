/*package com.capgemini;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.constant.Constant;
import com.capgemini.controller.Servicecontroller;
import com.capgemini.dao.MobileAppDao;
import com.capgemini.dao.Webappdao;
import com.capgemini.dto.DeviceDetails;
import com.capgemini.dto.FeedbackDataDto;
import com.capgemini.dto.InsertGatewayDataDto;
import com.capgemini.dto.LoginDto;
import com.capgemini.dto.RetrieveVisitorsData;
import com.capgemini.dto.Tasol;
import com.capgemini.dto.UserWalkpath;
import com.capgemini.dto.VisitorsCount;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IdaNewServiceApplication.class)

public class IdaNewServiceApplicationTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(IdaNewServiceApplicationTests.class);

    @Autowired
    Webappdao webappdao;
    
    @Autowired
    MobileAppDao mobileAppDao;
    
    @Autowired
    Servicecontroller serviceController;
    
    @Test
    public void getAllUersP() {  
    	try{
    	String expected = Constant.TASOL;
    	List<Tasol> actual = serviceController.getAllUsers();
        Assert.assertEquals(expected, actual.get(Constant.ZERO).getUserID());
    	}
    	catch(Exception e)
    	{
    		LOGGER.error(Constant.ERROR,e);
    	}
    }
    
    @Test
    public void getAllUersN() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.MADHULIKA;
        List<Tasol> actual = serviceController.getAllUsers();
        Assert.assertNotEquals(expected, actual.get(Constant.ZERO).getUserID());
    }
    
    @Test
    public void getUsersDataP() throws MalformedURLException, IOException, JSONException{
        String expected = "madhulika/20.4/10.5/android";
        List<Tasol> actual = serviceController.getUsersData(Constant.MADHULIKA);
        String actualResult="";
        actualResult=actualResult.concat(actual.get(Constant.ZERO).getUserID()+"/").concat(actual.get(Constant.ZERO).getUserX()+"/").concat(actual.get(Constant.ZERO).getUserY()+"/").concat(actual.get(Constant.ZERO).getDeviceType());
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void getUsersDataN() throws MalformedURLException, IOException, JSONException{
        String expected = "madhulika/20.4/10.5/android";
        List<Tasol> actual = serviceController.getUsersData("abc");
        String actualResult="";
actualResult=actualResult.concat(actual.get(Constant.ZERO).getUserID()+"/").concat(actual.get(Constant.ZERO).getUserX()+"/").concat(actual.get(Constant.ZERO).getUserY()+"/").concat(actual.get(Constant.ZERO).getDeviceType());
        Assert.assertNotEquals(expected, actualResult);
    }
    
    @Test
    public void getDataByUsernameP() throws MalformedURLException, IOException, JSONException{
        String expected = "rajani/23/3432jdfj143j54312";
        List<Tasol> actual = serviceController.getDataByUsername("rajani");
        String actualResult="";
        actualResult=actualResult.concat(actual.get(Constant.ZERO).getUserID()+"/").concat(actual.get(Constant.ZERO).getFloorplanID()+"/").concat(actual.get(Constant.ZERO).getDeviceID());
        Assert.assertEquals(expected, actualResult);
    }
    
    @Test
    public void getDataByUsernameN() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.ANIKET;
        List<Tasol> actual = serviceController.getDataByUsername(Constant.MADHU);
        Assert.assertNotEquals(expected, actual.get(Constant.ZERO).getUserID());
    }
    
    @Test
    public void getAllDataP1() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.TASOL;
        List<Tasol> actual = serviceController.getAllData();
        Assert.assertEquals(expected, actual.get(Constant.ZERO).getUserID());
    }
    
    @Test
    public void getAllDataP2() throws MalformedURLException, IOException, JSONException{
        String expected = "madhulika/23/3432jdfjl43j543dfdsf";
        List<Tasol> actual = serviceController.getAllData();
        String actualResult = "";
        actualResult = actualResult.concat(actual.get(Constant.TWO).getUserID() + "/").concat(actual.get(Constant.TWO).getFloorplanID()+ "/").concat(actual.get(Constant.TWO).getDeviceID());
        Assert.assertEquals(expected, actualResult );
    }
    
    @Test
    public void getAllDataN1() throws MalformedURLException, IOException, JSONException{
        String expected = "abc";
        List<Tasol> actual = serviceController.getAllData();
        Assert.assertNotEquals(expected, actual.get(Constant.NINE).getUserID());
    }
    
    @Test
    public void getAllDataN2() throws MalformedURLException, IOException, JSONException{
        String expected = "madhulika/23/3432jdfjl43j543dfdsf";
        List<Tasol> actual = serviceController.getAllData();
        String actualResult = "";
        actualResult = actualResult.concat(actual.get(Constant.THREE).getUserID() + "/").concat(actual.get(Constant.THREE).getFloorplanID()+ "/").concat(actual.get(Constant.THREE).getDeviceID());
        Assert.assertNotEquals(expected, actualResult);
        
    }
    
    @Test
    public void getAllPoiP() throws MalformedURLException, IOException, JSONException{                        
        String expected = "madhu/2";
        List<Tasol> actual = serviceController.getAllPoi(Constant.MADHU);
        String actualResult="";
        actualResult=actualResult.concat(actual.get(Constant.ONE).getUserID()+"/").concat(actual.get(1).getPoi());
        Assert.assertEquals(expected, actualResult);
    }
    
    @Test
    public void getAllPoiN1() throws MalformedURLException, IOException, JSONException{                        
        String expected = "madhulika/2";
        List<Tasol> actual = serviceController.getAllPoi(Constant.MADHU);
        String actualResult="";
        actualResult=actualResult.concat(actual.get(Constant.ZERO).getUserID()+"/").concat(actual.get(Constant.ZERO).getPoi());
        Assert.assertNotEquals(expected, actualResult);
    }
    
    @Test
    public void getAllPoiN2() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.ANIKET;
        List<Tasol> actual = serviceController.getAllPoi(Constant.MADHU);
        Assert.assertNotEquals(expected, actual.get(Constant.ONE).getUserID());
    }
    
    @Test
    public void getAllPoiDataByuserP() throws MalformedURLException, IOException, JSONException{
        String expected1 = Constant.HULSI;
        String expected2 ="13";
        List<Tasol> actual = serviceController.getAllPoiDataByuser(Constant.HULSI, "13");
        Assert.assertEquals(expected1, actual.get(Constant.ZERO).getUserID());
        Assert.assertEquals(expected2, actual.get(Constant.ZERO).getPoi());
    }
    
    @Test
    public void getAllPoiDataByuserN() throws MalformedURLException, IOException, JSONException{
        String expected1 = Constant.ANIKET ;
        String expected2 ="14";
        List<Tasol> actual = serviceController.getAllPoiDataByuser(Constant.HULSI, "13");
        Assert.assertNotEquals(expected1, actual.get(Constant.ZERO).getUserID());
        Assert.assertNotEquals(expected2, actual.get(Constant.ZERO).getPoi());
    }
    
    @Test
    public void getVisitorsDataP() throws MalformedURLException, IOException, JSONException{
        String expected = "Partner/14-Jul-17/Catherine Kniker/PTC";
        List<RetrieveVisitorsData> actual = serviceController.getVisitorsData("Partner");
        String actualResult="";
        actualResult=actualResult.concat(actual.get(Constant.ZERO).getCategory()+"/").concat(actual.get(0).getVisitDate()+"/").concat(actual.get(0).getVisitorName()+"/").concat(actual.get(0).getServiceLine());
        Assert.assertEquals(expected, actualResult);
    }
    
    @Test
    public void getVisitorsDataN1() throws MalformedURLException, IOException, JSONException{
        String expected = "Customer";
        List<RetrieveVisitorsData> actual = serviceController.getVisitorsData("Leadership");
        Assert.assertNotEquals(expected, actual.get(Constant.ZERO).getCategory());
    }
    
    
    @Test
    public void getVisitorsDataN2() throws MalformedURLException, IOException, JSONException{
        String expected = "John Mullen/Partner";
        List<RetrieveVisitorsData> actual = serviceController.getVisitorsData("Leadership");
        String actualResult="";
        actualResult=actualResult.concat(actual.get(Constant.ONE).getVisitorName()+"/").concat(actual.get(Constant.ONE).getCategory());
        Assert.assertNotEquals(expected, actualResult);
    }

    @Test
    public void getTasolDataP() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.ANIKET;
        List<Tasol> actual = serviceController.getUserByPoi();
        Assert.assertEquals(expected, actual.get(Constant.ZERO).getUserID());
    }
    
    @Test
    public void getTasolDataN() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.HULSI;
        List<Tasol> actual = serviceController.getUserByPoi();
        Assert.assertNotEquals(expected, actual.get(Constant.SIX).getUserID());
    }
    
    @Test
    public void getDeviceDetailsP() throws MalformedURLException, IOException, JSONException{                
        String expected = "MiniBeacon_41299/Buzz Wall/1520405377";
        List<DeviceDetails> actual = serviceController.getDeviceDetails();
        String actualResult="";
 actualResult=actualResult.concat(actual.get(Constant.ZERO).getDeviceId()+"/").concat(actual.get(Constant.ZERO).getPoiName()+"/").concat(actual.get(Constant.ZERO).getCreatedAt());
        Assert.assertEquals(expected, actualResult);
    }
    
    @Test
    public void getDeviceDetailsN() throws MalformedURLException, IOException, JSONException{                
        String expected = "MiniBeacon";
        List<DeviceDetails> actual = serviceController.getDeviceDetails();
        String actualResult="";
actualResult=actualResult.concat(actual.get(Constant.ZERO).getDeviceId()+"/").concat(actual.get(Constant.ZERO).getPoiName()+"/").concat(actual.get(Constant.ZERO).getCreatedAt());
        Assert.assertNotEquals(expected, actualResult);
    }
    
    @Test
    public void getUserWalkpathP() throws MalformedURLException, IOException, JSONException{
        String expected = "tasol/33/20.4";
        List<UserWalkpath> actual = serviceController.getUserWalkpath(Constant.TASOL);
        String actualResult="";
actualResult=actualResult.concat(actual.get(Constant.ZERO).getUserID()+"/").concat(actual.get(Constant.ZERO).getFromPoi()+"/").concat(actual.get(Constant.ZERO).getFromUserx());
        Assert.assertEquals(expected, actualResult);
    }
    
    @Test
    public void getUserWalkpathN() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.ANIKET;
        List<UserWalkpath> actual = serviceController.getUserWalkpath(Constant.TASOL);
        String actualResult="";
        actualResult=actualResult.concat(actual.get(Constant.ONE).getUserID()+"/").concat(actual.get(Constant.ONE).getFromPoi()+"/").concat(actual.get(Constant.ONE).getFromUserx());
        Assert.assertNotEquals(expected, actualResult);
    }
    
    @Test
    public void postDeviceDetailsP() throws JSONException, IOException{
        String expected = Constant.SUCCESS;
        DeviceDetails deviceDetails = new DeviceDetails();
        deviceDetails.setDeviceId("255");
        deviceDetails.setDeviceName("SampleTest");
        deviceDetails.setPoiId("13");
        deviceDetails.setPoiName(Constant.BUZZ_WALL);
        deviceDetails.setCreatedAt("1520405377");
        deviceDetails.setUpdatedAt("1520405378");
        String actual = serviceController.postDeviceDetails(deviceDetails);
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void postDeviceDetailsN() throws JSONException, IOException{
        String expected = Constant.FAILURE;
        DeviceDetails deviceDetails = new DeviceDetails();
        deviceDetails.setDeviceId("25");
        deviceDetails.setDeviceName("SampleTest");
        deviceDetails.setPoiId("1");
        deviceDetails.setPoiName(Constant.BUZZ_WALL);
        deviceDetails.setCreatedAt("1520405377");
        deviceDetails.setUpdatedAt("1520405378");
        String actual = serviceController.postDeviceDetails(deviceDetails);
        Assert.assertNotEquals(expected, actual);
    }
    
    @Test
    public void loaddataP() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.SUCCESS;
        Tasol tasol = new Tasol();
        tasol.setUserID(Constant.TASOL);
        tasol.setFloorplanID("23");
        tasol.setDeviceID("3432jdfjl43j543dfdsf");
        tasol.setUserX("20.4");
        tasol.setUserY("10.5");
        tasol.setDeviceType("android");
        tasol.setUpdatedAt("112121142");
        tasol.setPoi("13");
        tasol.setPoiName("Buzz Area");
        tasol.setUsecase("predix lab");
        String actual = serviceController.loaddata(tasol);
        Assert.assertEquals(expected, actual);
    }
    
   @Test
    public void loaddataN() throws MalformedURLException, IOException, JSONException{
        String expected = Constant.FAILURE;
        Tasol tasol = new Tasol();
        tasol.setUserID(Constant.TASOL);
        tasol.setFloorplanID("23");
        tasol.setDeviceID("3432jdfjl43dfdsf");
        tasol.setUserX("20.4");
        tasol.setUserY("10.5");
        tasol.setDeviceType("android");
        tasol.setUpdatedAt("112121142");
        tasol.setPoi("14");
        tasol.setPoiName("connected");
        tasol.setUsecase("predix lab");
        String actual = serviceController.loaddata(tasol);
        Assert.assertNotEquals(expected, actual);
    }
      @Test
        public void loadFeedbackDataP() throws MalformedURLException, IOException, JSONException{
            String expected = Constant.SUCCESS;
            FeedbackDataDto feedbackdatadto = new FeedbackDataDto();
            feedbackdatadto.setUserName("madhu1");
            feedbackdatadto.setRateLab("5");
            feedbackdatadto.setSuggestions("good and useful application");
            feedbackdatadto.setApplicableSolution("Indoor Digital Assistance");
            feedbackdatadto.setLikeSolution("IDA");
            String actual = serviceController.loadFeedbackData(feedbackdatadto);
            Assert.assertEquals(expected, actual);
        }
      
     @Test
        public void loadFeedbackDataN() throws MalformedURLException, IOException, JSONException{
            String expected = Constant.FAILURE;
            FeedbackDataDto feedbackdatadto = new FeedbackDataDto();
            feedbackdatadto.setUserName("madhu");
            feedbackdatadto.setRateLab("5");
            feedbackdatadto.setSuggestions("good and useful application");
            feedbackdatadto.setApplicableSolution("Indoor Digital Assistance");
            feedbackdatadto.setLikeSolution("IDA");
            
            String actual = serviceController.loadFeedbackData(feedbackdatadto);
            Assert.assertNotEquals(expected, actual);
        }
        @Test
        public void loaddataP1() throws MalformedURLException, IOException, JSONException{
            String expected = Constant.SUCCESS;
            InsertGatewayDataDto insertgatewaydatadao=new InsertGatewayDataDto();
            insertgatewaydatadao.setMacAddress("insertgatewaydatadao");
            insertgatewaydatadao.setMajorId("1001");
            insertgatewaydatadao.setMinorId("501");
            insertgatewaydatadao.setIotId("123456");
            insertgatewaydatadao.setRssi("65");
            insertgatewaydatadao.setLocationName("Cafeteria");
            insertgatewaydatadao.setVisitorName("Uma");
            insertgatewaydatadao.setTimestamp("6436436436");
            insertgatewaydatadao.setDeviceType("ble");
            String actual = serviceController.loaddata(insertgatewaydatadao);
            Assert.assertEquals(expected, actual);
        }
     
      
        
        @Test
        public void loaddataN1() throws MalformedURLException, IOException, JSONException{
            String expected = Constant.FAILURE;
            InsertGatewayDataDto insertgatewaydatadao=new InsertGatewayDataDto();
            insertgatewaydatadao.setMacAddress("insertgatewaydatadao");
            insertgatewaydatadao.setMajorId("100");
            insertgatewaydatadao.setMinorId("501");
            insertgatewaydatadao.setIotId("12346");
            insertgatewaydatadao.setRssi("65");
            insertgatewaydatadao.setLocationName("Cafetea");
            insertgatewaydatadao.setVisitorName("Uma");
            insertgatewaydatadao.setTimestamp("6436436");
            insertgatewaydatadao.setDeviceType("ble");
            String actual = serviceController.loaddata(insertgatewaydatadao);
            Assert.assertNotEquals(expected, actual);
            
        }
        
        @Test
        public void getLoginDetailsP() throws MalformedURLException, IOException, JSONException{
            String expected = "invalid credentials";
            LoginDto logindto = new LoginDto();
            logindto.setUsername(Constant.PREDIX);
            logindto.setPasswd("uma");
           
            String actual = serviceController.getLoginDetails(logindto);
            Assert.assertEquals(expected, actual);
        }
        
        @Test
        public void getLoginDetailsN() throws MalformedURLException, IOException, JSONException{
            String expected = "Login Successfull";
            LoginDto logindto = new LoginDto();
            logindto.setUsername(Constant.PREDIX);
            logindto.setPasswd("uma");   
            String actual = serviceController.getLoginDetails(logindto);
            Assert.assertNotEquals(expected, actual);
        }
        
        @Test
        public void getVisitorsCountP() throws MalformedURLException, IOException, JSONException{
            String expected = "1";
            List<VisitorsCount> actual = serviceController.getVisitorsCount("Customer");
            Assert.assertEquals(expected, actual.get(0).getTotalVisitors());
        }
        
        @Test
        public void getVisitorsCountN() throws MalformedURLException, IOException, JSONException{
            String expected = "1";
            List<VisitorsCount> actual = serviceController.getVisitorsCount("partner");
            Assert.assertNotEquals(expected, actual.get(0).getTotalVisitors());
        }
        
        
}
*/