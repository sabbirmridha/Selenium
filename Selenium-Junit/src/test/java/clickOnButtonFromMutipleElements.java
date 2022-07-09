import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class clickOnButtonFromMutipleElements {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions=new FirefoxOptions(); // making firefox option object from firefox class
        firefoxOptions.addArguments("--headed");// here there  object.method has called passing an argument called by headed
        //firefoxOptions.addArguments("--headless");
        driver=new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(30));



    }
    // To do a double click on a button -Double Click Me button
    //@Test
    public void clickOnMultipleButton(){
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtnElement = driver.findElement(By.id("doubleClickBtn"));
        Actions actions =new Actions(driver);
        actions.doubleClick(doubleClickBtnElement).perform();
        String text1= driver.findElement(By.id("doubleClickMessage")).getText();

        Assert.assertTrue(text1.contains("You have done a double click"));


    }

    // To do a right click on a button -Right Click Me button
    //@Test
    public void rightClickOnButton(){
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtnElement = driver.findElement(By.id("rightClickBtn"));
        Actions actions =new Actions(driver);
        actions.contextClick(doubleClickBtnElement).perform();
        String text2= driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertTrue(text2.contains("You have done a right click"));

    }

    // Solutions for multiple elements- it basically need when name , tagname and attribute are same
    @Test
    public void clickIfMultipleButton(){
        driver.get("https://demoqa.com/buttons");
        List<WebElement> buttonElement = driver.findElements(By.tagName("button"));  // as 3 button's tag name is button so we are taking in a list
        //List<WebElement> buttonElement = driver.findElements(By.cssSelector("[type =button]")); //if i wan t usee css selector
        Actions actions =new Actions(driver);
        actions.doubleClick(buttonElement.get(1)).perform();
        actions.contextClick(buttonElement.get(2)).perform();
        actions.click(buttonElement.get(3)).perform();



    }
    @After
    public void closeBrowser(){
        driver.quit();
    }



}
