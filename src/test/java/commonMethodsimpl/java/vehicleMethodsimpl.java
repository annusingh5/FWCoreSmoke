package commonMethodsimpl.java;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import Utility.Base;
import commonMethods.vehicleMethods;

public class vehicleMethodsimpl extends Base implements vehicleMethods {
	public GeneralMethodsimpl General = new GeneralMethodsimpl();

	@Override
	public void vehicleMandatoryFields() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("vehicle_id_fw")).sendKeys("Vehicle123");
		driver.findElement(By.id("fuel_type_fw")).sendKeys("Diesel");
		driver.findElement(By.id("sdref:basic_info_fw:3")).click();
		driver.findElement(By.id("p11d_fuel_type_fw")).sendKeys("Zero emission (E)");
		driver.findElement(By.id("co2gkm_fw")).sendKeys("3200");
		driver.findElement(By.id("engine_cc_fw")).sendKeys("180");
		driver.findElement(By.id("sdref:diary_fw:3")).click();
		driver.findElement(By.id("odometer_units_fw")).sendKeys("KM");
		driver.findElement(By.id("sdref:repairs_/_accidents:3")).click();
		driver.findElement(By.id("sdref:allocation_history:3")).click();
		driver.findElement(By.id("sdref:procurement:3")).click();
		driver.findElement(By.id("date_registered_fw")).clear();
		driver.findElement(By.id("date_registered_fw")).sendKeys("3/6/2015");
		driver.findElement(By.id("list_price_fw")).sendKeys("15203");
		driver.findElement(By.id("sdref:lease:3")).click();
		driver.findElement(By.id("supply_method_fw")).sendKeys("Purchase");

	}

	@Override
	public void vehicleOptionalFields() {
		//Summary page
		driver.findElement(By.id("location_code_fw")).sendKeys("QA Location Details");
		driver.findElement(By.id("vehicle_type_fw")).sendKeys("QA Vehicle Type");
		driver.findElement(By.id("vehicle_status_fw")).sendKeys("LIVE");
		driver.findElement(By.id("make_code_fw")).sendKeys("ASTON MARTIN");
		driver.findElement(By.id("company_code_fw")).sendKeys("QA Company Code Details");
		driver.findElement(By.id("costcentre_fw")).sendKeys("QA Costcentre Company");
		driver.findElement(By.id("driver_name_fw")).sendKeys("Michael A. D. Gibson");
		driver.findElement(By.id("sdref:basic_info_fw:3")).click();
		driver.findElement(By.id("gear_box_type_fw")).sendKeys("Automatic");
		driver.findElement(By.id("tax_type_fw")).sendKeys("Band D ALT Cars Reg'd after 01/03/2001(TC59)");
		driver.findElement(By.id("no_of_doors_fw")).sendKeys("2");
		driver.findElement(By.id("sdref:diary_fw:3")).click();
		driver.findElement(By.id("tax_renewal_location_fw")).sendKeys("LICENCE CENTRE");
		driver.findElement(By.id("sdref:repairs_/_accidents:3")).click();
		driver.findElement(By.id("sdref:allocation_history:3")).click();
		driver.findElement(By.id("sdref:procurement:3")).click();
		driver.findElement(By.id("registration_received_fw")).sendKeys("Yes");
		driver.findElement(By.id("vehicle_owner_fw")).sendKeys("Company");
		driver.findElement(By.id("sdref:lease:3")).click();
		driver.findElement(By.id("finance_supplier_fw")).sendKeys("INSURANCE COMPANY ONE");
		driver.findElement(By.id("lease_payment_method_fw")).sendKeys("Direct Debit");
		driver.findElement(By.id("sdref:disposal:3")).click();
		driver.findElement(By.id("sold_condition_fw")).sendKeys("CLEAN");
	}

	@Override
	public void editVehicleRecord() {
		driver.findElement(By.id("filtval")).sendKeys("Vehicle123");
		General.search();
		driver.findElement(By.id("check0")).click();
		driver.findElement(By.name("aEdit")).click();
	}

	@Override
	public void deleteVehicleRecord() {
		driver.findElement(By.id("filtval")).clear();
		driver.findElement(By.id("filtval")).sendKeys("Vehicle123");
		General.search();
		General.deleteRecord();
	}

	@Override
	public void selectVehicle() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("vehicle_id_fw")).sendKeys("G");
		driver.findElement(By.id("cur_odometer_fw")).sendKeys("44");
		//driver.switchTo().window("frm_send");
		Thread.sleep(30000);
		driver.switchTo().window("valbrow");
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("frm_send");*/
		/*Thread.sleep(1000);*/
		driver.findElement(By.id("VEHICLES_FWvfiltval")).clear();
		driver.findElement(By.id("VEHICLES_FWvfiltval")).sendKeys("ABC123D");
		driver.findElement(By.id("VEHICLES_FWfilterbutton")).click();
		driver.findElement(By.xpath("//a[contains(text(),'ABC123D')]")).click();		
		
	}

	@Override
	@Parameters({"registrationno"})
	public void newvehiclforFuel(String registrationno) {
		int Year = Calendar.getInstance().get(Calendar.YEAR);
	    int year= Year-1;
	    String a= "1/1/";
	    String registeredYear =a+year;
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("vehicle_id_fw")).sendKeys(registrationno);
		driver.findElement(By.id("make_code_fw")).sendKeys("BMW");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("model_code_fw"))).sendKeys("1 SERIES");
		driver.findElement(By.id("derivative_fw")).sendKeys("118D");
		driver.findElement(By.id("supply_method_fw")).sendKeys("P");
		driver.findElement(By.id("fuel_type_fw")).sendKeys("Diesel");
		driver.findElement(By.id("sdref:compliance_diary_fw:3")).click();
		driver.findElement(By.id("date_registered_fw")).clear();
		driver.findElement(By.id("date_registered_fw")).sendKeys(registeredYear);
		driver.findElement(By.id("sdref:procument:3")).click();
		driver.findElement(By.id("vehicle_status_fw")).sendKeys("LIVE");
		driver.findElement(By.id("list_price_fw")).clear();
		driver.findElement(By.id("list_price_fw")).sendKeys("100000");
	
		
	}
	
	@Override
	public void vehicleAgeForVehicleFuel() {
		int Year = Calendar.getInstance().get(Calendar.YEAR);
	    int year= Year-1;
	    String a= "1/1/";
	    String registeredyear =a+year; 
	    driver.findElement(By.id("filtval")).clear();
		driver.findElement(By.id("filtval")).sendKeys("VehicleFuel123");
		General.search();
		driver.findElement(By.id("check0")).click();
		driver.findElement(By.name("aEdit")).click();
		driver.findElement(By.id("sdref:diary_fw:3")).click();
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		
	    
		
	}

}