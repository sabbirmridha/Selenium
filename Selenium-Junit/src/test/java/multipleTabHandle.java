import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class multipleTabHandle {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions(); // making firefox option object from firefox class
        firefoxOptions.addArguments("--headed");// here there  object.method has called passing an argument called by headed
       // firefoxOptions.addArguments("--headless");
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
   @Test
    public void handleNewTab()  {
        // visit the site
        driver.get("https://demoqa.com/links");
        // get the id of Home : simpleLink & click on it & opens another tab
        driver.findElement(By.id("simpleLink")).click();
        // I will keep the two tabs in array list
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        // manual wait
        //Thread.sleep(15000);

        // switch to open tab
        driver.switchTo().window(w.get(1)); // new tab value is 1 and by default tab value is 0
        String title =driver.getTitle();
        System.out.println("New tab title: " + driver.getTitle()); // getting the current tab title

        wait=new WebDriverWait(driver,Duration.ofSeconds(50));
        WebElement imgElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/images/Toolsqa.jpg']")));
        Boolean status = imgElement.isDisplayed();
        Assert.assertEquals(true,status);
        driver.close(); // close will close the current tab
        driver.switchTo().window(w.get(0));  // Now i am moving the first tab that mean index 0

    }


}
