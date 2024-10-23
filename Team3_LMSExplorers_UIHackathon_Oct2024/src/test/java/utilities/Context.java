package utilities;

import driverFactory.DriverFactory;
import pageObjects.LoginPage;

public class Context  {

	private DriverFactory driverFactory;
	private LoginPage loginPage;	
	
	public Context()
	{
		driverFactory = new DriverFactory();
		loginPage = new LoginPage(driverFactory.getDriver());
	}
	
	public DriverFactory getDriverFactory() {
		return driverFactory;
	}
	
	
	public LoginPage getLoginPage() {
		return loginPage;
	}
	
  public void openBaseURL(String url) {
	  getDriverFactory().getDriver().get(url);  // Use WebDriver to open the URL
}

}
