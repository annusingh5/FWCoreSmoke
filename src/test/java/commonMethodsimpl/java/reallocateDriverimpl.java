package commonMethodsimpl.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import commonMethods.*;
import Utility.*;

public class reallocateDriverimpl extends Base implements reallocateDriver {

	@Override
	public void selectDriver() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("driver_name_fw")).sendKeys("G");
		driver.findElement(By.id("cur_odometer_fw")).sendKeys("44");
		//driver.switchTo().window("frm_send");
		Thread.sleep(30000);
		driver.switchTo().window("valbrow");
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("frm_send");*/
		/*Thread.sleep(1000);*/
		driver.findElement(By.id("DRIVERS_FWvfiltval")).clear();
		driver.findElement(By.id("DRIVERS_FWvfiltval")).sendKeys("George");
		driver.findElement(By.id("DRIVERS_FWfilterbutton")).click();
		driver.findElement(By.xpath("//a[contains(text(),'George Johnathan Avery')]")).click();		
	}

	@Override
	public void reallocateDrivermandatoryFields() {
		driver.findElement(By.id("date_changed_fw")).clear();
		driver.findElement(By.id("date_changed_fw")).sendKeys("15/07/2017");
		driver.findElement(By.id("sdref:msgreplatevehicle:3")).click();
		driver.findElement(By.id("date_changed_fw")).clear();
		driver.findElement(By.id("date_changed_fw")).sendKeys("15/07/2017");		
	}

	@Override
	public void clearAllocation() {
		// TODO Auto-generated method stub
		
	}

}
