package QaEssentialsTestNG.QaEssentialsTestNG;

import org.testng.annotations.Test;

import commonMethodsimpl.java.GeneralMethodsimpl;
import commonMethodsimpl.java.accidentMethodsimpl;
import commonMethodsimpl.java.driverMethodsimpl;
import commonMethodsimpl.java.fuelMethodsimpl;
import commonMethodsimpl.java.vehicleMethodsimpl;

public class VehicleFuel extends GeneralMethodsimpl{
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
	public void CreateNewVehicleRecord(){
		SelectVehiclesTab();
		AddRecord();
		vehicle.newvehiclforFuel("registrationno");
		save();
		/*		searchItemExists(0,2,"registrationno");
		deleteSearchItem();
	}
	
   @Test(priority=3)
   public void VerifyAgeOfVehicle(){
	   //vehicle.vehicleAgeForVehicleFuel();
   }
   
   @Test(priority=4)
   public void VerifyMOTOfVehicle(){
	   
   }
   
   
   @Test(priority=5)
   public void VerifyEmissionBandOfVehicle(){
	   
   }
   
   public void CreateNewFuelRecordForVehicleFuel(){
	   
   }
   */
   }
}
