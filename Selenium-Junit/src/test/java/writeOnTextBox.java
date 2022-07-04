import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class writeOnTextBox{
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions=new FirefoxOptions(); // making firefox option object from firefox class
       // firefoxOptions.addArguments("--headed");// here there  object.method has called passing an argument called by headed
        firefoxOptions.addArguments("--headless");
        driver=new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }


    @Test
    public void writeonTextBox1() {
        // Scenario : Fill up form and click on Submit button
        // step 1 : go to the url
        driver.get("https://demoqa.com/elements");
        // step 2 : click on 'text box'
        driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
        wait=new WebDriverWait(driver,Duration.ofSeconds(50));
        // Step 3 : Give input in Full Name field
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='userName']"))).sendKeys("Sabbir");
        // Step 4: Give  input for Email Field
        driver.findElement(By.id("userEmail")).sendKeys("testuser1@grr.la");
        // step 5 : Give  input for present addess
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("testArea , H-34 ,R-45,0123");
        //Step 6 : Give input for parmanent address
        driver.findElement(By.id("permanentAddress")).sendKeys("testArea , Dakka");

        wait=new WebDriverWait(driver,Duration.ofSeconds(50));

        // step 7 : Click on Submit button
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);

        /*
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        driver.findElement(By.xpath("(//*[@id])[52]")).click();
        //driver.findElement(By.id("submit")).click();
        String text = driver.findElement(By.cssSelector("[id =name]")).getText();
        Assert.assertTrue(text.contains("Sabbir")); */


    }
    @After
    public void finishTest(){
      // driver.close();
    }

}










