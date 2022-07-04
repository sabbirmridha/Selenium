import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyJunit {
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
   //@Test
   public  void getTitle(){

        driver.get("https://demoqa.com");
        System.out.println(driver.getTitle());
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("ToolsQA"));


    }

    /*
       public void checkIfElementExists(){
       driver.get("https://demoqa.com");
       boolean status=driver.findElement(By.className("banner-image")).isDisplayed();
       Assert.assertTrue(status);
   } */

    @Test
    public void checkagainIfElementExists() {

        driver.get("https://demoqa.com");
        wait=new WebDriverWait(driver,Duration.ofSeconds(50));
        boolean status =wait.until(ExpectedConditions.elementToBeClickable(By.className("banner-image"))).isDisplayed();
        Assert.assertTrue(status);
    }

}
