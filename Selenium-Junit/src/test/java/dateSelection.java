import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class dateSelection {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions=new FirefoxOptions(); // making firefox option object from firefox class
        //firefoxOptions.addArguments("--headed");// here there  object.method has called passing an argument called by headed
        firefoxOptions.addArguments("--headless");
        driver=new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    /*
    Test scenario : After reaching the url make the date clear then make a input for date field and finally press on
    Enter button to confirm the date for the date picker
    */
    // Test for date picker
    @Test
    public void selectDate(){
        // step 1 : go to the url
        driver.get("https://demoqa.com/date-picker");
        // step 2 : clear the field
        driver.findElement(By.id("datePickerMonthYearInput")).clear();
        //step 3 : provide input for date field
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("07/08/2022");
        // step 4: press enter button for confirming the date
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.ENTER);



    }
    @After
    public void closeBrowser(){
      //  driver.quit();
    }



}
