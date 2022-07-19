
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {

    @Test
    public void doUserLogin() throws InterruptedException {
        Login login =new Login(driver);

        driver.get("http://automationpractice.com");
        Thread.sleep(3000);
        String username= login.doLogin("testuser4554@test.com","P@ssword123");
        Assert.assertTrue(username.contains("Test User"));


    }
}
