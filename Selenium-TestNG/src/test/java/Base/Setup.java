package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class Setup  {

    public static WebDriver driver; // 'WebDriver' class has initiated here and an object named by 'diver' has created
    @BeforeTest
    public void setUp() throws IOException {
        /*setProperty driver contains 2 parameter
        parameter1 : which driver i am using
        parameter2 : used driver's location
         */
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

        ChromeOptions ops = new ChromeOptions(); // help to use headless
        ops.addArguments("--headed");
        /*
        driver = new ChromeDriver(ops); --> this line represents polymorphism
        Here parent class is 'WebDriver' & i have made a child class called by 'chromeDriver' .
        The characteristics of WebDriver is common but ChromeDriver has some different characteristics .So
        when characteristics of 'ChromeDriver' override 'parentDriver' characteristics then  i need to initiate
        by child . This is called 'overriding'. The 'Ops' reflects Constructor of OOP.
        Ops has passed so that the line can execute before execute.
         */
        driver = new ChromeDriver(ops);

        driver.manage().window().maximize(); // it helps to maximize browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // applicable for all test cases
    }

    @AfterTest
    public void logout(){
        driver.close();
    }

}
