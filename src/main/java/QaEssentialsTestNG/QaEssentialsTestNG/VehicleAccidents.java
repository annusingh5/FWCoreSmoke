/*Author: Kiranmai
  This class file is the For the execution of Vehicle Accidents Test Suite*/
package QaEssentialsTestNG.QaEssentialsTestNG;
import org.testng.annotations.Test;

import commonMethodsimpl.java.GeneralMethodsimpl;
import commonMethodsimpl.java.accidentMethodsimpl;
import commonMethodsimpl.java.driverMethodsimpl;
import commonMethodsimpl.java.fuelMethodsimpl;
import commonMethodsimpl.java.vehicleMethodsimpl;

@Test
public class VehicleAccidents extends GeneralMethodsimpl {

	public vehicleMethodsimpl vehicle = new vehicleMethodsimpl();
	public driverMethodsimpl Driver = new driverMethodsimpl();
	public fuelMethodsimpl fuel = new fuelMethodsimpl(); 
	public accidentMethodsimpl accident = new accidentMethodsimpl();
	
	@Test(priority=1)
	public void Login(){
		openURL();
		login();
	}
	
	@Test(priority=2)
	public void EnterAccidentRecordToVerifyRecordInteraction(){
		SelectAccidentsTab();
		AddRecord();
	}
	
	@Test(priority=3)	
	public void VerifyLinkedRecordsDisplay(){
		
	}
	
	
	
}
