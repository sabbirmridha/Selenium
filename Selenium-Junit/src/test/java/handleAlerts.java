import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class handleAlerts {

    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions=new FirefoxOptions(); // making firefox option object from firefox class
        firefoxOptions.addArguments("--headed");// here there  object.method has called passing an argument called by headed
       // firefoxOptions.addArguments("--headless");
        driver=new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    // Test -1 :click on a alert button and accept the alert
   @Test
    public void handleAlertNow(){
        // Step 1 : go to the desired url
        driver.get("https://demoqa.com/alerts");
        // step 2 : click on the alert button
        driver.findElement(By.id("alertButton")).click();
        // step 3: accept the alert
        driver.switchTo().alert().accept(); // To accept the alert we will use the selenium alert handler
    }

    // Test -2 : Click on a  alert button and dismiss the alert and then make assertion for message - You selected Cancel
   //@Test
    public void handleAlertD(){
        // step 1: got to desired url
        driver.get("https://demoqa.com/alerts");
        // step 2: click on alert button
        driver.findElement(By.id("confirmButton")).click();
        // step 3: cancel the button using  selenium dismiss alert handler
        driver.switchTo().alert().dismiss();
        // step 4 : find the message id and store it in a variable
        String a =driver.findElement(By.id("confirmResult")).getText();
        // step 5 : Make a assertion of the message using the desired text
        Assert.assertTrue(a.contains("You selected Cancel"));


    }
    // Test 3 : click on alert button write for alert  input field and accept the alert
    //@Test
    public void handleAlertP(){
        // step 1: got to desired url
        driver.get("https://demoqa.com/alerts");
        // step 2: click on alert button
        driver.findElement(By.id("promtButton")).click();
        // step 3 : write text for input field
        driver.switchTo().alert().sendKeys("sabbir");
        // step 4 : wait for 50 seconds
        wait=new WebDriverWait(driver,Duration.ofSeconds(50));
        // step 5 : accept the alert
        driver.switchTo().alert().accept();
        // step 6 : get the element for your text input
        String p = driver.findElement(By.id("promptResult")).getText();
        // step 7 : Now make assertion for your input message
        Assert.assertTrue(p.contains("You entered sabbir"));

    }


    @After
    public void closeBrowser(){

       driver.quit();
    }




}
