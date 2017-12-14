package commonMethodsimpl.java;

import static org.testng.Assert.assertTrue;

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

public class passwordsMethodsimpl extends Base implements passwordsMethods {
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
	public void selectUtilities() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navtopLeft");
		driver.findElement(By.xpath("/html/body/div/div[2]/nav/ul/li[10]/a/div/i")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-body']/nav/ul/li[10]/ul/li[8]/a/span"))).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String bodyText = driver.findElement(By.xpath("//*[@id='titlediv']/h3[contains(string(), 'USER')]")).getText();
		System.out.println(bodyText);
		assertTrue(bodyText.contains("USER"));
	}
	@Override
	public void CheckTemplates() {
	driver.switchTo().defaultContent();	
	driver.switchTo().frame("main");
	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='browse']/tbody/tr[4]/td[1]/a[1]/i"))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String bodyText = driver.findElement(By.xpath(".//*[@id='CELL0011']/label")).getText();
    Assert.assertEquals("PASSWORD", bodyText);
	}
	
	@Override
	@Parameters({"newuser"})
	public void newUserSave(String newuser){
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnadd']/i"))).click();
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("main");
		driver.findElement(By.id("user_id_fw")).clear();
		driver.findElement(By.id("user_id_fw")).sendKeys(newuser);
		driver.findElement(By.xpath("//*[@id='password_fw']")).clear();
		driver.findElement(By.xpath("//*[@id='password_fw']")).sendKeys(newuser);
		driver.findElement(By.xpath("//*[@id='user_name_fw']")).clear();
		driver.findElement(By.xpath("//*[@id='user_name_fw']")).sendKeys(newuser);
		WebElement changePWD = driver.findElement(By.id("password_can_change_fw"));
		Select permission=new Select(changePWD);
		permission.selectByIndex(1);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='buttonsave']"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		Select filter = new Select(driver.findElement(By.xpath("//*[@id='filtexp']")));
		filter.selectByIndex(0);
		Select criteria = new Select(driver.findElement(By.xpath("//*[@id='filtcri']")));
		criteria.selectByIndex(2);
		driver.findElement(By.xpath("//*[@id='filtval']")).sendKeys(newuser);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='submitbutton_search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String newHeader = driver.findElement(By.xpath("//*[@id='browse']/tbody/tr/td[1]/a[2]")).getText();
	    Assert.assertEquals(newuser, newHeader);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
	    driver.findElement(By.xpath("//*[@id='btnlogoff']/i")).click();
	    driver.close();
	}
	
	@Override
	public void logout(){
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
	    driver.findElement(By.xpath("//*[@id='btnlogoff']/i")).click();	
	    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
	    WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'/Test/script/images/fwlogo.png')]")));
	    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
	    Assert.assertTrue(ImagePresent);
	}
	
	@Override
	@Parameters({"newuser"})
	public void loginNewUser(String newuser) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().frame("main");
		driver.findElement(By.id("username")).sendKeys(newuser);
		driver.findElement(By.id("password")).sendKeys(newuser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("submit-button")).click();	
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("topframe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String bodyText = driver.findElement(By.xpath("//*[@id='userinfo']/div")).getText();
		Assert.assertTrue(bodyText.equalsIgnoreCase(newuser));
		String homePage = driver.findElement(By.xpath("//*[@id='titlediv']/h3")).getText();
	    Assert.assertEquals("HOME PAGE", homePage);
	    driver.switchTo().defaultContent();	
		driver.switchTo().frame("main");
		driver.findElement(By.xpath("//*[@id='FleetOptionsTool']/tbody/tr/td/table/tbody/tr[2]/td/a[1]")).click();
		driver.close();
	}
	/*
	@Override
	public void deleteNewUser(){
		driver.switchTo().defaultContent();	
		driver.switchTo().frame("main");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='check4']"))).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topframe");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btndelete']/i"))).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		alert.accept();	
		driver.close();
		}
	*/
	@Override
	public void incorrectLogin() {
		driver.get(Constant_value_usage.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().frame("main");
		driver.findElement(By.id("username")).sendKeys("CHEVIN11");
		driver.findElement(By.id("password")).sendKeys("ANNU:g0dgirl");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("submit-button")).click();
		Assert.assertEquals("FleetWave® - FWCORE v2.29",driver.getTitle());
		driver.close();
	    
	}

	@Override
	@Parameters({"username","password"})
	public void rememberMe(String username, String password) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().frame("main");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		if (driver.findElement(By.xpath("//*[@id='loginform']/div[5]/div[1]/label/span[1]")).isSelected() )
		{
		     driver.findElement(By.xpath("//*[@id='loginform']/div[5]/div[1]/label/span[1]")).click();
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginform']/div[5]/div[1]/label/span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("submit-button")).click();
	}
	
	@Override
	@Parameters({"username","password"})
	public void verifyLoginCredentials(String username, String password){
		WebElement pwd,uname ;
		String textInsideInputBox1,textInsideInputBox2;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		uname = driver.findElement(By.id("username"));
		textInsideInputBox1 = uname.getAttribute("value");
		Assert.assertEquals(username,textInsideInputBox1);
		pwd = driver.findElement(By.id("password"));
		textInsideInputBox2 = pwd.getAttribute("value");
		Assert.assertEquals(password,textInsideInputBox2);
		driver.close();
	}
	
	@Override
	@Parameters({"username","password"})
	public void uncheckRememberme(String username, String password){
		driver.get(Constant_value_usage.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.switchTo().frame("main");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		if (!driver.findElement(By.xpath("//*[@id='loginform']/div[5]/div[1]/label/span[1]")).isSelected() )
		{
		     driver.findElement(By.xpath("//*[@id='loginform']/div[5]/div[1]/label/span[1]")).click();
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginform']/div[5]/div[1]/label/span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("submit-button")).click();	
	}
	

	

}