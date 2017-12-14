package commonMethods;

public interface passwordsMethods {

	public void selectUtilities();
	
	public void incorrectLogin();
	
	public void CheckTemplates();
	
	public void deleteNewUser();

	public void logout();

	void verifyLoginCredentials(String username, String password);

	void uncheckRememberme(String username, String password);

	void newUserSave(String newuser);

	void loginNewUser(String newuser);

	public void login();
}