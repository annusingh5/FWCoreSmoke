package QaEssentialsTestNG.QaEssentialsTestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Utility.Constant_value_usage;
import commonMethodsimpl.java.GeneralMethodsimpl;
import commonMethodsimpl.java.sendEmailimpl;
import commonMethodsimpl.java.tableFeaturessimpl;

@Test
public class TableFeatures extends GeneralMethodsimpl{
	public sendEmailimpl email = new sendEmailimpl();
	public tableFeaturessimpl tableFeatures = new tableFeaturessimpl();
	
	@Test(priority=1,description = "SI1.1")
	public void Login(){
		openURL();
		login();
		SelectVehiclesTab();
		}
	
	@Test(priority=2,description ="TF1.1,TF1.2,TF1.3")
	public void Search(){
		tableFeatures.vehicleCriteriaSearch();
		searchItemExists(1,0,Constant_value_usage.newVehicle);
		clear();
		
	}

   @Test(priority=3,description = "TF1.4")
	public void NoResultSearch(){
		tableFeatures.vehicleCriteriaSearch();
		searchItemNotExists(1,0,"@#");
		clear();
		
	}
	
	@Test(priority=3,description= "TF2.3,TF2.4")
	public void OpenFilterWindowAndClose(){
		clickFirstFilter();
		clickCustomFilter();
		closeCustomFilterWindow();
	}
	
	@Test(priority=4,description="TF2.5")

	public void ApplyFilter(){
		
		clickFirstFilter();
		clickCustomFilter();
		tableFeatures.applyFilter();
	}
	/*
	@AfterTest
	public void CleanUp(){
		email.email();
	}*/
	}
	


