package QaEssentialsTestNG.QaEssentialsTestNG;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

import commonMethodsimpl.java.GeneralMethodsimpl;
import commonMethodsimpl.java.accidentMethodsimpl;
import commonMethodsimpl.java.driverMethodsimpl;
import commonMethodsimpl.java.fuelMethodsimpl;
import commonMethodsimpl.java.vehicleMethodsimpl;

public class random extends GeneralMethodsimpl{
	public vehicleMethodsimpl vehicle = new vehicleMethodsimpl();
	public driverMethodsimpl Driver = new driverMethodsimpl();
	public fuelMethodsimpl fuel = new fuelMethodsimpl(); 
	public accidentMethodsimpl accident = new accidentMethodsimpl();
	
	@Test(priority=1)
	public void Login() throws ParseException{
		/*openURL();
		login();*/
		int Year = Calendar.getInstance().get(Calendar.YEAR);
	    int year= Year-1;
	    String a= "1/1/";
	    String registeredyear =a+year; 
	    Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date old = df.parse(registeredyear);
		long dateSubtract = today.getTime() - old.getTime();
		long time = 1000 * 60 * 60 * 24;
		long abc=(dateSubtract / time)+1;
        System.out.println(abc);
        float ad = (float) (abc/365.25);
        float ageOfVehicle = (float) ((int)(ad * 100 + .5) / 100.0);
        System.out.println(ageOfVehicle);
        
	}
}
