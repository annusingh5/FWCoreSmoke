package Utility;

 import org.apache.commons.mail.EmailException;
import org.apache.http.entity.SerializableEntity;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;


public class Base {

public static WebDriver driver = null;


//CALL WEB BROWSER AND OPEN WEBSITE
public static void openURL()
{

    try{

    System.setProperty("webdriver.chrome.driver", "C:/Users/annus/Downloads/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://fw2.fleetwave.com/test/FWCORE");
    }catch(Exception E)

    {
        E.printStackTrace();


    }
}

public void tearDown() {
	  driver.close();
	  driver.quit();
	  
	 }





 }