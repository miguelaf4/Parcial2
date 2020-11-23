package com.mayab.calidad.funcional;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class TestAppleLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\migue\\Documents\\Selenium\\driver\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://secure2.store.apple.com/mx/shop/sign_in?c=aHR0cHM6Ly93d3cuYXBwbGUuY29tL214L3wxYW9zNmFiMWI4OTdkOGJhOGEwYjI2MjgyNGZmNTRhYTFjYTExZWQ4MzA0YQ&r=SCDHYHP7CY4H9XK2H&s=aHR0cHM6Ly93d3cuYXBwbGUuY29tL214L3wxYW9zNmFiMWI4OTdkOGJhOGEwYjI2MjgyNGZmNTRhYTFjYTExZWQ4MzA0YQ");
    driver.findElement(By.xpath("//*[@id=\"recon-0-0\"]")).click();
    driver.findElement(By.name("appleId")).clear();
    driver.findElement(By.name("appleId")).sendKeys("miguelaf44@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"recon-0-1\"]")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.xpath("//*[@id=\"signInButtonId\"]")).click();
    assertEquals("El Apple ID o la contraseña se ingresó incorrectamente. Por favor, restablece la contraseña.  ", driver.findElement(By.xpath("//*[@id=\"signin-container\"]/div/div[2]/div[1]/div[1]/div")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

