package commonMethodsimpl.java;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;


import commonMethods.*;
import Utility.*;

public class tableFeaturessimpl extends Base implements tableFeatures {

	@Override
	public void login() {
		driver.get(Constant_value_usage.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().frame("main");
		driver.findElement(By.id("username")).sendKeys("CHEVIN");
		driver.findElement(By.id("password")).sendKeys("ANNU:g00dgirl");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("submit-button")).click();
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("topframe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String bodyText = driver.findElement(By.xpath("//*[@id='userinfo']/div")).getText();
		Assert.assertEquals("CHEVIN:ANNU", bodyText);
	}
	
	@Override
	public void vehicleCriteriaSearch(){
		String[] exp = {"REGISTRATION NUMBER", "VEHICLE TYPE", "FLEET NO", "ON-FLEET DATE", "TRACKER FITTED", "ODOMETER", "MAKE", "MODEL", "CO2 G/KM", "VEHICLE STATUS", "NEXT SERVICE DATE", "NEXT INSPECTION", "MOT DATE","COSTCENTRE","DRIVER NAME","MPG (UK)","DISTANCE PER MONTH","DISTANCE PER YEAR"}; 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement dropdown = driver.findElement(By.id("filtexp")) ; 
		Select se = new Select(dropdown);
		List<WebElement> options = se.getOptions();
		
		for(WebElement we:options)  
        { 
		for (int i=0; i<exp.length; i++){
             Assert.assertEquals(we.getText(),exp[i]);
            
         }
        }
		
	}
	
	@Override
	public void applyFilter(){
		driver.findElement(By.xpath("//*[@id='custom_filter_0']")).sendKeys(Keys.SHIFT,Constant_value_usage.registrationno);
	   	driver.findElement(By.xpath("//*[@id='Button_Custom_Filter']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		boolean imageOK = driver.findElement(By.cssSelector(".icon-ok.sub_icon")).isDisplayed();
		Assert.assertTrue(imageOK);
	}
	
	}
			    
			
			
