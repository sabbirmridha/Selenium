import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class dropdownSelection {
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
    @Test
    public void selectDropdown(){
        driver.get("https://demoqa.com/select-menu");
        Select color= new Select(driver.findElement(By.id("oldSelectMenu"))); // here 'new Select' initiating a default constructor.
        color.selectByValue("1");

        /*
        Select cars=new Select(driver.findElement(By.id("cars")));
        if(cars.isMultiple()){

            cars.selectByValue("volvo");
            cars.selectByValue("saab");
            cars.selectByValue("opel");
            cars.selectByValue("audi");
        }

         */


    }
    @After
    public void closeBrowser(){
          driver.quit();
    }

}
