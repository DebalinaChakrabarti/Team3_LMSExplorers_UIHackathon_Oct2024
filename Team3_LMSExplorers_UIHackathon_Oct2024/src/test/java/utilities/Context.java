package utilities;

import driverFactory.DriverFactory;
import pageObjects.AddNewClass;
import pageObjects.AddNewClassPopup;
import pageObjects.Batch;
import pageObjects.BatchPage;
import pageObjects.BatchPageValidations;
import pageObjects.ClassPageValidation;
import pageObjects.ClassPg;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.Program;
import pageObjects.ProgramPage;

public class Context  {

	private DriverFactory driverFactory;
	private LoginPage loginPage;	
	private DashboardPage dashboardPage;
	private ProgramPage programPage;
	private Program program;	
	private Batch batch;	
	private BatchPage batchPage;
	private BatchPageValidations batchPageval;
	private LogoutPage logoutPage;	
	private ClassPg classPage;	
	private ClassPageValidation classPageValidation;
	private AddNewClass addNewClass;
	private AddNewClassPopup addNewClassPopup;
	
	public Context()
	{
		driverFactory = new DriverFactory();
		loginPage = new LoginPage(driverFactory.getDriver());
		dashboardPage = new DashboardPage(driverFactory.getDriver());
		programPage = new ProgramPage(driverFactory.getDriver());
		program = new Program(driverFactory.getDriver());
		batch = new Batch(driverFactory.getDriver());
		batchPage = new BatchPage(driverFactory.getDriver());
		batchPageval = new BatchPageValidations(driverFactory.getDriver());
		logoutPage = new LogoutPage(driverFactory.getDriver());
		classPage = new ClassPg(driverFactory.getDriver());
		classPageValidation = new ClassPageValidation(driverFactory.getDriver());
		addNewClass = new AddNewClass(driverFactory.getDriver());
		addNewClassPopup= new AddNewClassPopup(driverFactory.getDriver());
		
	}
	
	public DriverFactory getDriverFactory() {
		return driverFactory;
	}
	
	
	public LoginPage getLoginPage() {
		return loginPage;
	}
	public DashboardPage getDashboardPage() {
		return dashboardPage;
	}	
	public ProgramPage getProgramPage() {
		return programPage;
	}

	public void openBaseURL(String url) {
	  getDriverFactory().getDriver().get(url);  // Use WebDriver to open the URL
	}

	public Program getProgram() {
		return program;
	}
	public Batch getBatch() {
		return batch;
	}
	public BatchPage getBatchPage() {
		return batchPage;
	}
	public BatchPageValidations getBatchPageValidation() {
		return batchPageval;
	}
	public ClassPg getClassPg() {
		return classPage;
	}
	public LogoutPage getLogoutPage() {
		return logoutPage;
	}
	public ClassPageValidation getClassPageValidation() {
		return classPageValidation;
	}
	public AddNewClass getAddNewClass() {
		return addNewClass;
	}
	public AddNewClassPopup getAddNewClassPopup() {
		return addNewClassPopup;
	}
}
