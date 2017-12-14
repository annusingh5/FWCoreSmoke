package commonMethodsimpl.java;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import Utility.Base;
import commonMethods.driverMethods;
import commonMethods.vehicleMethods;

public class driverMethodsimpl extends Base implements driverMethods {
	public GeneralMethodsimpl General = new GeneralMethodsimpl();

	@Override
	public void driverMandatoryFields() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("first_name_fw")).sendKeys("Abc");
		driver.findElement(By.id("middle_name_fw")).sendKeys("Def");
		driver.findElement(By.id("last_name_fw")).sendKeys("Ghi");
		
		//driver.findElement(By.id("payroll_number_fw")).clear();
		driver.findElement(By.id("payroll_number_fw")).sendKeys("03456");
		driver.findElement(By.id("title_fw")).sendKeys("Mr");
		driver.findElement(By.id("date_of_birth_fw")).clear();
		driver.findElement(By.id("date_of_birth_fw")).sendKeys("4/2/1990");
		driver.findElement(By.id("sdref:fuel_cards:3")).click();
		driver.findElement(By.id("sdref:licence:3")).click();
		driver.findElement(By.id("sdref:duty_of_care:3")).click();
		driver.findElement(By.id("sdref:training:3")).click();	
		driver.findElement(By.id("sdref:allocations_&_notes:3")).click();
		
	}

	@Override
	public void driverOptionalFields() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("sex_fw")).sendKeys("Male");
		driver.findElement(By.id("company_code_fw")).sendKeys("QA Company Code Details");
		driver.findElement(By.id("costcentre_fw")).sendKeys("QA Costcentre Company");
		driver.findElement(By.id("driver_category_fw")).sendKeys("QA Driver Categories");
		driver.findElement(By.id("driver_role_fw")).sendKeys("QA Driver Role Details");
		driver.findElement(By.id("location_code_fw")).sendKeys("QA Location Details");
		driver.findElement(By.id("department_fw")).sendKeys("QA Department");
		driver.findElement(By.id("sdref:fuel_cards:3")).click();
		driver.findElement(By.id("sdref:licence:3")).click();
		driver.findElement(By.id("sdref:duty_of_care:3")).click();
		driver.findElement(By.id("last_medical_fw")).clear();
		driver.findElement(By.id("last_medical_fw")).sendKeys("3/2/2016");
		driver.findElement(By.id("sdref:training:3")).click();	
		driver.findElement(By.id("sdref:allocations_&_notes:3")).click();	
		
	}

	@Override
	public void editDriverRecord() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		//driver.findElement(By.id("filtexp")).clear();
		driver.findElement(By.id("filtexp")).sendKeys("Driver Name");
		driver.findElement(By.id("filtval")).sendKeys("Abc Def Ghi");
		General.search();
		driver.findElement(By.id("check0")).click();
		driver.findElement(By.name("aEdit")).click();
		
	}

	@Override
	public void deleteDriverRecord() {
		driver.findElement(By.id("filtexp")).clear();
		driver.findElement(By.id("filtexp")).sendKeys("Driver Name");
		driver.findElement(By.id("filtval")).sendKeys("Abc Def Ghi");
		General.search();
		General.deleteRecord();
		
	}
	
		
	
}
	