package utilities;

import driverFactory.DriverFactory;
import pageObjects.LoginPage;
import pageObjects.Program;

public class Context  {

	private DriverFactory driverFactory;
	private LoginPage loginPage;	
	private Program program;	
	
	public Context()
	{
		driverFactory = new DriverFactory();
		loginPage = new LoginPage(driverFactory.getDriver());
		program = new Program(driverFactory.getDriver());
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

	public Program getProgram() {
		return program;
	}

}
