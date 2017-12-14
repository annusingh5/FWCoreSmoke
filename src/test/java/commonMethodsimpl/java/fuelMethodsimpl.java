package commonMethodsimpl.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import Utility.Base;
import commonMethods.fuelMethods;
import commonMethods.vehicleMethods;

public class fuelMethodsimpl extends Base implements fuelMethods {
	public GeneralMethodsimpl General = new GeneralMethodsimpl();

	@Override
	public void fuelMandatoryFields() {
		driver.findElement(By.id("unit_of_measure_fw")).sendKeys("Gallons");
	}

	@Override
	public void fuelOptionalFields() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("vehicle_id_fw")).sendKeys("DEMO11");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.id("fuel_type_fw")).clear();
		driver.findElement(By.id("fuel_type_fw")).sendKeys("Oil - Engine");
		driver.findElement(By.id("transaction_date_fw")).clear();
		driver.findElement(By.id("transaction_date_fw")).sendKeys("3/2/2017");
		driver.findElement(By.id("driver_name_fw")).sendKeys("Michael A. D. Gibson");
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("driver_name_fw")).clear();
		driver.findElement(By.id("driver_name_fw")).sendKeys("Michael A. D. Gibson");
	}

	@Override
	public void deleteFuelRecord() {
		driver.findElement(By.id("filtval")).sendKeys("DEMO11");
		General.search();
		General.deleteRecord();
		
	}
	
	

}
