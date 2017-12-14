package commonMethodsimpl.java;

import static org.testng.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Base;
import commonMethods.MaintenanceMethods;

public class MaintenanceMethodsimpl extends Base implements MaintenanceMethods{

	@Override
	public void ManitenanceMandatoryFields() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("accident_date_fw")).sendKeys("Accident - Reported");
		
	}
	
	@Override
	public void FindMaintenaceRecord()
	{
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("main");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='browse']/tbody/tr/td[1]/a[1]/i"))).click();
	}
	
   @Override
   public void EnterServiceDateDistance()
   {
	    driver.findElement(By.id("sdref:compliance_diary_fw:3")).click();
		driver.findElement(By.id("service_interval_weeks_fw")).clear();
		driver.findElement(By.id("service_interval_weeks_fw")).sendKeys("10");
		driver.findElement(By.id("service_interval_km_fw")).clear();
		driver.findElement(By.id("service_interval_km_fw")).sendKeys("10000");
		
   }
   @Override
   public void VerifyServiceDates()
   {
	   int Year = Calendar.getInstance().get(Calendar.YEAR);
	    int year= Year-1;
	    String a= "1/1/";
	    int value = Integer.parseInt(a) + year ;
			    
			   /* int number = Integer.parseInt(registeredYear);*/
			    Calendar c = new GregorianCalendar();
			    c.add(value, 300);
			    System.out.println(c);
			    System.out.println(value);
		}
	  /* driver.findElement(By.id("sdref:compliance_diary_fw:3")).click();
	   String bodyText = driver.findElement(By.xpath(".//*[@id='next_service_date_fw'][contains(string(), 'USER')]")).getText();
	   System.out.println(bodyText);
	   assertTrue(bodyText.contains("USER"));*/
   }
 

