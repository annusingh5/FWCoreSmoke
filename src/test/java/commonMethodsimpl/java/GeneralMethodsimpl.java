package commonMethodsimpl.java;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import commonMethods.*;
import Utility.*;

public class GeneralMethodsimpl extends Base implements GeneralMethods {

	@Override
	public void login() {
		driver.get(Constant_value_usage.URL);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().frame("main");
		driver.findElement(By.id("username")).sendKeys("CHEVIN");
		driver.findElement(By.id("password")).sendKeys("ANNU:Anishka@123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("submit-button")).click();
	}

	@Override
	public void SelectVehiclesTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navtopLeft");
		driver.findElement(By.cssSelector("i.icon-truck")).click();
	}

	@Override
	public void SelectDriversTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navtopLeft");
		driver.findElement(By.cssSelector("i.icon-user")).click();		
	}


	@Override
	public void SelectReallocateDriver() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		driver.findElement(By.id("btnoptions")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frm_menu");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td/span")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Reallocation')]")).click();

	}

	@Override
	public void SelectAccidentsTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navtopLeft");
		driver.findElement(By.cssSelector("i.icon-ambulance")).click();
	}

	@Override
	public void SelectWorkOrdersTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		driver.findElement(By.xpath("//a[contains(text(),'Work Orders')]")).click();
	}

	@Override
	public void SelectFuelTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navtopLeft");
		driver.findElement(By.cssSelector("i.icon-tint")).click();

	}

	@Override
	public void SelectReportsTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		driver.findElement(By.xpath("//a[contains(text(),'Reports')]")).click();
	}
	
	@Override
	public void SelectMaintenanceTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navtopLeft");
		driver.findElement(By.cssSelector("i.icon-wrench")).click();
	}

	@Override
	public void AddRecord() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		driver.findElement(By.id("btnadd")).click();

	}

	@Override
	public void save() {
    	driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("buttonsave")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Override
	public void cancel() {
		driver.findElement(By.id("button1")).click();

	}

	@Override
	public void search() {
		driver.findElement(By.id("submitbutton_search")).click();

	}

	@Override
	public void deleteRecord() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.id("check0")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		driver.findElement(By.id("btndelete")).click();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().accept();
	}
	
	@Override
	public void selectUtilities() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navtopLeft");
		/* FW Core*/
		/*driver.findElement(By.xpath("/html/body/div/div[2]/nav/ul/li[10]/a/div/i")).click();*/
        driver.findElement(By.xpath(".//*[@id='nav-body']/nav/ul/li[11]/a/div/i")).click(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/nav/ul/li[11]/ul/li[9]/a/span"))).click();
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("topframe");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    String bodyText = driver.findElement(By.xpath("//*[@id='titlediv']/h3[contains(string(), 'Passwords')]")).getText();
	    Assert.assertEquals("Passwords",bodyText);
		}
	/*
	@Override
	public void SelectAccesslogTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navtopLeft");
		driver.findElement(By.cssSelector(".icon-circle-blank")).click();		
     }}
	*/
	@Override
	@Parameters({"expression","criteria","text"})
	public void searchItemExists(int expression,int criteria,String text)
	{
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		Select filter = new Select(driver.findElement(By.xpath("//*[@id='filtexp']")));
		filter.selectByIndex(expression);
		Select criteria1 = new Select(driver.findElement(By.xpath("//*[@id='filtcri']")));
		criteria1.selectByIndex(criteria);
		driver.findElement(By.xpath("//*[@id='filtval']")).sendKeys(text);
	    driver.findElement(By.xpath("//*[@id='submitbutton_search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String newHeader = driver.findElement(By.xpath("//*[@id='browse']/tbody/tr/td[1]/a[2]")).getText();
		Assert.assertTrue(text.equalsIgnoreCase(newHeader));
		driver.switchTo().defaultContent();
	}
	
	@Override
	@Parameters({"expression","criteria","text"})
	public void searchItemNotExists(int expression,int criteria,String text)
	{
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		Select filter = new Select(driver.findElement(By.xpath("//*[@id='filtexp']")));
		filter.selectByIndex(expression);
		Select criteria1 = new Select(driver.findElement(By.xpath("//*[@id='filtcri']")));
		criteria1.selectByIndex(criteria);
		driver.findElement(By.xpath("//*[@id='filtval']")).sendKeys(text);
	    driver.findElement(By.xpath("//*[@id='submitbutton_search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String newHeader = driver.findElement(By.xpath("//*[@id='form1']/p")).getText();
		Assert.assertTrue(newHeader.equalsIgnoreCase((Constant_value_usage.message)));
		driver.switchTo().defaultContent();
	}
	@Override
	public void deleteSearchItem(){
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("main");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check0']"))).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btndelete']/i"))).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		alert.accept();	
		driver.close();
		}
	@Override
	public void clear(){
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("main");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submitbutton_clearfilter']"))).click();
		String blank = driver.findElement(By.xpath("//*[@id='filtval']")).getText();
		Assert.assertEquals(blank,"");
		}
	
	@Override
	public void clickFirstFilter(){
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("main");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button_do_filter']/i[1]"))).click();
		driver.switchTo().activeElement();
		/*String filter = driver.findElement(By.xpath("//*[@id='ui-id-1']")).getText();
		System.out.println(filter);
		Assert.assertEquals(filter,Constant_value_usage.filter);*/
		
		}
	@Override
	public void closeCustomFilterWindow(){
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//*[@id='Button_Cancel']")).click();
	}
	
	@Override
	public void clickCustomFilter(){
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//*[@id='custom_filter']")).click();
		Select filter = new Select(driver.findElement(By.xpath("//*[@id='cmpFilterType_0']")));
		List<WebElement> value = filter.getAllSelectedOptions();
		String contains = value.get(0).getText();
		System.out.println(contains);
		Assert.assertEquals(contains.toLowerCase(),(Constant_value_usage.contains).toLowerCase());
	}
	
	}
	
	
