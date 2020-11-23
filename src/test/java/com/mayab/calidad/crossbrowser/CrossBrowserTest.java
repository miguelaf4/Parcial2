package com.mayab.calidad.crossbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.net.URL;

public class CrossBrowserTest {
	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  


	 public static final String URL = "https://miguelarra:b5841814-2a1f-480d-9953-5a8d3aeeb921@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	 
	 public static void main(String[] args) throws Exception {
	 

		  DesiredCapabilities caps = DesiredCapabilities.firefox();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("platform", "Linux");
		    caps.setCapability("platform", "macOS 10.13");
		    caps.setCapability("version", "latest");
		    caps.setCapability("name", "Firefox");
		    caps.setCapability("extendedDebugging", "true");
		    caps.setCapability("buildNumber", "3.0");
		    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		    
		    driver.get("https://mern-crud.herokuapp.com/");
		    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button")).click();
		    driver.findElement(By.name("name")).clear();
		    driver.findElement(By.name("name")).sendKeys("X");
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("x@prueba.com");
		    driver.findElement(By.name("age")).clear();
		    driver.findElement(By.name("age")).sendKeys("30");
		    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=ui green right floated button]]
		    String expected = "Successfully added!";
			String gotMessage="";
			WebElement result = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
			gotMessage = result.getText();
			assertThat(expected,is(equalTo(gotMessage)));
			boolean finalResult = false;
			if(gotMessage.equals("Successfully added!")) {
				finalResult = true;
			}else {
				finalResult = false;
			}
			if (finalResult){
			      ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed");
			    }
			    else {
			      ((JavascriptExecutor)driver).executeScript("sauce:job-result=failed");
			    }
			driver.quit();
	 }
	    
	
	 
	

}
