package MVNTest2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneTest {
	
	WebDriver driver;
	
	ExtentReports extent;
	
	@BeforeMethod
	public void configuration() {
		
		String reportPath = System.getProperty("user.dir")+"\\reports\\index.html";
		//Extent Report
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Omayo Test Report");
		reporter.config().setDocumentTitle("Omayo Test Report Title");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Operating System", "Windows 11");
		extent.setSystemInfo("Tested By", "Dipti Ranjan Nayak");
	}
	
	@Test
	public void mOne() {
		
		ExtentTest eTest = extent.createTest("Test One");
		
		//System.out.println("mOne Executed");
		
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
		eTest.info("Edge Browser Launched");
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
		
		eTest.info("Navigated To Omayo Home Page");
		
		//String actualText=driver.findElement(By.id("pah")).getText();
		//System.out.println(actualText);
		//eTest.fail("Test One Failed");//This is for failing the ExtentReport Test
		Assert.assertEquals(driver.findElement(By.id("pah")).getText(), "PracticeAutomationHere"); //expected and actual text
		
	} 
	@AfterMethod
	public void closure() {
		driver.close();
		extent.flush();
	} 
	

}
