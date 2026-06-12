package tests.Tests_academic_operations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;
import utils.Test_Data;

public class Course_Registration_Page_Test extends TestToMainPage {
    By Course_Registration  = By.xpath("//a[text()='Course Registration ']");

    @Test(
            groups = "smoke",
            dataProvider = "login_pass",
            dataProviderClass = Test_Data.class,
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void setup(String username, String password){
        super.login(username, password);
        DriverManager.driver.findElement(Course_Registration).click();
    }

    @Test(
            groups = "smoke",
            priority = 2
    )
    public void test_to_page(){

    }
}
