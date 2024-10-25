package utilities;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;

public class Context {

	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private ProgramPage programPage;
	

	public Context() {
		driverFactory = new DriverFactory();
		loginPage = new LoginPage(driverFactory.getDriver());
		programPage = new ProgramPage(driverFactory.getDriver());
	}

	public DriverFactory getDriverFactory() {
		return driverFactory;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public ProgramPage getProgramPage() {
		return programPage;
	}

	public void openBaseURL(String url) {
		getDriverFactory().getDriver().get(url); // Use WebDriver to open the URL
	}

}
