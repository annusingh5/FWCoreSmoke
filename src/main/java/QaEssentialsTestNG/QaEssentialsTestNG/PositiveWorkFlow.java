/*Author: Kiranmai
  This class file is the For the execution of Positive work flow Test Suite*/

package QaEssentialsTestNG.QaEssentialsTestNG;

import org.testng.annotations.Test;

import commonMethodsimpl.java.GeneralMethodsimpl;
import commonMethodsimpl.java.accidentMethodsimpl;
import commonMethodsimpl.java.driverMethodsimpl;
import commonMethodsimpl.java.fuelMethodsimpl;
import commonMethodsimpl.java.vehicleMethodsimpl;


@Test
public class PositiveWorkFlow extends GeneralMethodsimpl{
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
	public void ViewVehicleTabAndSelectAddNewRecord(){
		SelectVehiclesTab();
		AddRecord();
	}
	
	@Test(priority=3)
	public void saveVehicleRecordWithoutAnyData(){
		save();
	}
	
	@Test(priority=4)
    public void EnterOnlyMandatoryFieldsForNewVehicleRecordAndSave(){
		vehicle.vehicleMandatoryFields();
		save();
	}
	
	@Test(priority=5)
	public void ReOpenTheRecentlyCreatedVehicleRecord(){
		vehicle.editVehicleRecord();
	}
	
	@Test(priority=6)
	public void EnterOptionalDetailsForVehicleRecordAndSave(){
		vehicle.vehicleOptionalFields();
		save();
		vehicle.deleteVehicleRecord();
	}
	
	@Test(priority=7)
	public void ViewDriverTabAndSelectAddNewRecord(){
		SelectDriversTab();
		AddRecord();
	}
	
	/*@Test(priority=8)
	public void saveDriverRecordWithoutAnyData(){
		save();
	}*/
	
	@Test(priority=9)
    public void EnterOnlyMandatoryFieldsForNewDriverRecordAndSave(){
		
		Driver.driverMandatoryFields();
		save();
		
	}
	
	@Test(priority=10)
	public void ReOpenTheRecentlyCreatedDriverRecord(){
		driver.navigate().refresh();
		SelectDriversTab();
		Driver.editDriverRecord();
		
	}
	
	@Test(priority=11)
	public void EnterOptionalDetailsForDriverRecordAndSave(){
		Driver.driverOptionalFields();
		save();
		Driver.deleteDriverRecord();
	}
	
	@Test(priority=12)
	public void ViewFuelTabAndSelectAddNewRecord(){
		SelectFuelTab();
		AddRecord();
	}
	
	@Test(priority=13)
	public void EnterOptionalFieldDetailsForFuelAndSave() {
	       fuel.fuelOptionalFields();
	       save();
		}

	@Test(priority=14)
		public void EnterMandatoryDetailsForFuelAndSave() {
	      fuel.fuelMandatoryFields();
	      save();
		}
		
	@Test(priority=15)
		public void DeleteFuelRecord(){
		   fuel.deleteFuelRecord();
		}
	
	@Test(priority=16)
	public void ViewAccidentRecordAndAddNewRecord(){
		SelectAccidentsTab();
		AddRecord();
	}
	
	@Test(priority=17)
	public void EnterMandatoryDetailsForAccidentAndSave() throws InterruptedException{
		accident.accidentMandatoryFields();
		save();
	}
	@Test(priority=18)
	public void EnteOptionalDetailsForAccidentAndSave() {
		accident.accidentOptionalFields();
		save();
	}
	
	/*@Test(priority=19)
	public void ViewMaintenanceTabAndSelectAddNewRecord(){
		select
	}*/

	/*public void ReopenTheAccidentRecord(){
		
	}*/
	
	
	
	
	
}
