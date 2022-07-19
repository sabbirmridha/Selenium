import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver ;
    @FindBy(className = "login")
    WebElement linklogin ;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "passwd")
    WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    WebElement btnSubmit;

    @FindBy(xpath = "//span[contains(text(),'Test User')]")
    WebElement lblUserName;

    public Login(WebDriver driver) // 'Login' is a constructor same as class name & passed a parameter
    {
        this.driver =driver; // accessing the driver as i have initialized above
        /*
        pagFactory is a class of selenium . initElements is a static method . We basically need 'pageFactory' to
        transfer data from one page to another page
         */
        PageFactory.initElements(driver, this);
    }
    public String doLogin(String email, String password) throws InterruptedException {

        linklogin.click();
        Thread.sleep(5000);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblUserName.getText();


    }

}


