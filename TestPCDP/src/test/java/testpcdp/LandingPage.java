package testpcdp;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
* Verify landing page
* - heading text: Inspire the next
* - login text: Please log in using your Hitachicc credentials
* - Hitachi Consulting logo
* - PCDP logo
* - Forgot password link
* - Request for Access link
*/

public class LandingPage {
	public static void main(String[] args) throws IOException {
		//path to config and object repository files
		String configFile = System.getProperty("user.dir")+"//src//demo//config//config.properties";
		String objectRepo = System.getProperty("user.dir")+"//src//demo//config//object_repo.properties";
		
		//launch browser
//		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//enter url
//		driver.get(Utility.getProperty(configFile, "url"));
		driver.get(Utility.getProperty(configFile, "url"));
		System.out.println("Url entered");
		
		//read and print heading text: Inspire the next
		String headingText = Utility.getTextUsingXpath(driver, objectRepo, "headingtext_inspirethenext_xpath");
		System.out.println(headingText);
		
		//read and print login text - Please log in using your Hitachicc credentials
		String loginText = Utility.getTextUsingXpath(driver, objectRepo, "login_text_xpath");
		System.out.println(loginText);
		
		//text on forgot password link
		String forgotPwdLink = Utility.getTextUsingXpath(driver, objectRepo, "forgot_pwd_link_xpath");
		System.out.println(forgotPwdLink);
	
		//browser close
		driver.close();
	}

}
