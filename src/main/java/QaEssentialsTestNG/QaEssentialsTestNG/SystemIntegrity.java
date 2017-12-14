/*Author: Kiranmai
	  This class file is the For the execution of System Integrity Test Suite*/
package QaEssentialsTestNG.QaEssentialsTestNG;
import org.testng.annotations.Test;

import commonMethodsimpl.java.GeneralMethodsimpl;
import commonMethodsimpl.java.HomePageimpl;
import commonMethodsimpl.java.accidentMethodsimpl;
import commonMethodsimpl.java.driverMethodsimpl;
import commonMethodsimpl.java.fuelMethodsimpl;
import commonMethodsimpl.java.vehicleMethodsimpl;
import cucumber.api.java.en.Then;

@Test
public class SystemIntegrity extends GeneralMethodsimpl{
		public HomePageimpl HomePage = new HomePageimpl();
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
		public void RefreshFleetstatusTool() throws InterruptedException{
			HomePage.RefreshFleetStatus();
			
		}
}
