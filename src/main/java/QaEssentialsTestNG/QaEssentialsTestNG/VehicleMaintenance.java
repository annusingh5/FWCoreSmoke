/*Author: Kiranmai
  This class file is the For the execution of Positive work flow Test Suite*/

package QaEssentialsTestNG.QaEssentialsTestNG;

import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

import commonMethodsimpl.java.GeneralMethodsimpl;
import commonMethodsimpl.java.MaintenanceMethodsimpl;
import commonMethodsimpl.java.accidentMethodsimpl;
import commonMethodsimpl.java.driverMethodsimpl;
import commonMethodsimpl.java.fuelMethodsimpl;
import commonMethodsimpl.java.passwordsMethodsimpl;
import commonMethodsimpl.java.vehicleMethodsimpl;
import cucumber.api.java.en.Then;

@Test
public class VehicleMaintenance extends GeneralMethodsimpl{
public MaintenanceMethodsimpl maintenance = new MaintenanceMethodsimpl();
	
	@Test(priority=1)
	public void Login(){
		openURL();
		login();
	}
	
	@Test(priority=2)
	public void SelectMaintenaceVehicle()
	{
		maintenance.VerifyServiceDates();
		/*login();
		SelectVehiclesTab();
		searchItemExists(0,2,"registrationno");
		maintenance.MaintenanceRecord();
		save();*/
     }

	
}
