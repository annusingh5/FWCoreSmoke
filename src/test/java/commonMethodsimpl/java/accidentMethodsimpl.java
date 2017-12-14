package commonMethodsimpl.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import Utility.Base;
import commonMethods.accidentMethods;
import commonMethods.fuelMethods;
import commonMethods.vehicleMethods;

public class accidentMethodsimpl extends Base implements accidentMethods {
	public GeneralMethodsimpl General = new GeneralMethodsimpl();

	String AccCode;
	@Override
	public void accidentMandatoryFields() throws InterruptedException {
		Thread.sleep(200);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("accident_date_fw")).clear();

		driver.findElement(By.id("accident_time_fw")).clear();
		driver.findElement(By.id("accident_time_fw")).sendKeys("07:00");
	}

	@Override
	public void openNewlyCreatedAccidentRecord() {
		AccCode=driver.findElement(By.id("accident_code_fw")).getText();
		
	}
	@Override
	public void accidentOptionalFields() {
		//public statis AccidentCode = driver.findElement(By.id("accident_time_fw"));
		driver.findElement(By.id("vehicle_id_fw")).sendKeys("QA");
		driver.findElement(By.id("accident_status_fw")).sendKeys("REPORTED");
		driver.findElement(By.id("driver_name_fw")).sendKeys("QA Driver Details2");
		driver.findElement(By.id("injured_fw")).sendKeys("Yes");		
		
	}

	@Override
	public void editAccidentRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccidentRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAccidentRecordCode() {
		
		
	}

	
}