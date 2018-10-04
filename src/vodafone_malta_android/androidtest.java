package vodafone_malta_android;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class androidtest {
	// create global variable

	private static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
	 // Create object of DesiredCapabilities class                             
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	// Specify the device name 
	capabilities.setCapability("deviceName", "buraknexus");
	
	// platform name
	capabilities.setCapability("platformName", "Android");
	
	// specify the application package   
	capabilities.setCapability("appPackage", "mt.com.vodafone.android.vodafoneapp");
	
	// specify the application activity                   
	capabilities.setCapability("appActivity", "mt.com.vodafone.android.vodafoneapp.MainActivity");
	
	// Start android driver I used 4727 port by default it will be 4723
	driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), capabilities);
	
	//wait for app to be opened
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	// Enter username and password
	driver.findElement(By.xpath("//android.widget.EditText[@text='Username']")).sendKeys("testqa2");
	driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys("Voda1234");
	
	// click on log in button  
	driver.findElement(By.xpath("//android.widget.Button[@text='Log in']")).click();
	
	//check Welcome to My Vodafone
	if(driver.findElement(By.xpath("//android.view.View[@text='Welcome to My Vodafone']")).isDisplayed() ) 
	{ 
        System.out.println("Test case 1 :'Welcome to My Vodafone' is visible on the landing screen");
	} 
	else 
	{ 
        System.out.println("Test execution error for case 1 :'Welcome to My Vodafone' is not visible");
	}
	// close the application
	
	driver.quit();
	 }
}
