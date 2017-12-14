package QaEssentialsTestNG.QaEssentialsTestNG;

import org.testng.annotations.Test;

import Utility.Constant_value_usage;
import commonMethodsimpl.java.GeneralMethodsimpl;
import commonMethodsimpl.java.accidentMethodsimpl;
import commonMethodsimpl.java.driverMethodsimpl;
import commonMethodsimpl.java.fuelMethodsimpl;
import commonMethodsimpl.java.passwordsMethodsimpl;
import commonMethodsimpl.java.vehicleMethodsimpl;
import cucumber.api.java.en.Then;

@Test
public class PasswordsUserLevels extends GeneralMethodsimpl{
public passwordsMethodsimpl passwords = new passwordsMethodsimpl();


	@Test(priority=1,description =D's)
	public void Login(){
		openURL();
		login();
	}
	
	@Test(priority=2)
	public void LaunchUtilities(){
	passwords.selectUtilities();
		
	}

   @Test(priority=3)
    public void CheckTemplates(){
	  passwords.CheckTemplates();
    	    }

    @Test(priority=4)
    public void CreateUser(){
    passwords.newUserSave(Constant_value_usage.newuser);
    	    }
    /*
       @Test(priority=5)
    public void NewUser(){
    	 openURL();
    passwords.loginNewUser(Constant_value_usage.newuser);
    	    }
       */
      @Test(priority=6)
    public void Clear(){
    	openURL();
    passwords.login();
    passwords.selectUtilities();
    searchItemExists(0,2,Constant_value_usage.newuser);
   passwords.deleteNewUser();
    deleteSearchItem();
    	    }
    
    @Test(priority=7)
    public void IncorrectLogin(){
    	openURL();
    passwords.incorrectLogin();
    	    }

    @Test(priority=8)
    
    public void RememberMeOptions(){
    	openURL();
    passwords.rememberMe("CHEVIN","ANNU:g00dgirl");
    passwords.logout();
    passwords.verifyLoginCredentials("CHEVIN","ANNU:g00dgirl");
    	    }
    	 @Test(priority=9)
   
	    public void UncheckRememberMeOptions(){
	    openURL();
	    passwords.login();
	    passwords.uncheckRememberme("CHEVIN","ANNU:g00dgirl");
	    passwords.logout();
	    passwords.verifyLoginCredentials("","");
	    	    }
  
}

	


	
	
	
	
	


